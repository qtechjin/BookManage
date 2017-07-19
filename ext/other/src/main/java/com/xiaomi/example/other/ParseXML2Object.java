package com.xiaomi.example.other;

import com.alibaba.fastjson.JSON;
import com.xiaomi.example.other.model.ColumnDetail;
import com.xiaomi.example.other.model.Lines;
import com.xiaomi.example.other.model.Task;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liujin on 2017/7/13.
 */
public class ParseXML2Object {


    /*解析xml文件*/

    public static void main(String[] args) {
        String filePath = "ext/other/src/main/resources/META-INF/xml_template/";
        String xsdFilePath = filePath + "meta.xsd";
        String xmlFilePath =filePath + "bhxt_task.xml";
        File taskFile = new File(xmlFilePath);

        //首先校验外部xml文件
        if( !validate(xmlFilePath, xsdFilePath) ) {
            System.out.println("校验xml文件失败，请检查xml文件的正确性,path:" + xmlFilePath);
            return;
        }

        SAXReader reader = new SAXReader();
        Task task = new Task();
        try {
            Document document = reader.read(taskFile);
            Element root = document.getRootElement();
            List list = root.elements();
            Element ruleElem = root.element("ruleId");
            task.setRuleId(Integer.valueOf(ruleElem.getTextTrim()));
            task.setOrgCode(Integer.valueOf(root.element("orgCode").getTextTrim()));
            List<com.xiaomi.example.other.model.File> fileList = new ArrayList<>();
            //解析fileList
            List<Element> fileElemList = root.element("fileList").elements();
            for(Element elem : fileElemList) {
                if(elem.getName().equals("file") && !elem.getTextTrim().isEmpty()){
                    //根据file的值获得文件路径，解析每个file
                    String fileName = elem.getTextTrim() + ".xml";
                    //首先校验file文件
                    if( !validate(filePath + fileName, xsdFilePath) ) {
                        System.out.println("校验xml文件失败，请检查xml文件的正确性,path:" + fileName);
                        continue;
                    }
                    com.xiaomi.example.other.model.File fileElem = getFileElem(filePath + fileName);
                    if(fileElem != null) {
                        fileList.add(fileElem);
                    }
                }
            }
            task.setFileList(fileList);


            System.out.println(JSON.toJSON(task));

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    /*校验xml文件*/
    private static boolean validate(String xmlFilePath, String xsdFilePath) {
        File xsdFile =new File(xsdFilePath);

        try {

            Source xmlFile = new StreamSource(new File(xmlFilePath));
            SchemaFactory schemaFactory = SchemaFactory
                    .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(xsdFile);
            Validator validator = schema.newValidator();
            try {
                validator.validate(xmlFile);
                System.out.println(xmlFile.getSystemId() + " is valid");
            } catch (SAXException e) {
                System.out.println(xmlFile.getSystemId() + " is NOT valid");
                System.out.println("Reason: " + e.getLocalizedMessage());
                return false;
            }
        } catch (Exception e1) {
            System.out.println(e1);
            return false;
        }
        System.out.println("校验完毕");
        return true;
    }
    /*
    * 获得file子节点的数据
    * */
    private static com.xiaomi.example.other.model.File getFileElem(String file) {
        com.xiaomi.example.other.model.File fileObj = new com.xiaomi.example.other.model.File();

        SAXReader reader = new SAXReader();

        try {
            Document docFile = reader.read(new File(file));
            Element fileElem = docFile.getRootElement();


            //解析tradecodes
            List<String> tradeCodes = new ArrayList<>();
            Element tradeCodesElem = fileElem.element("tradeCodes");
            List<Element> tradeCodeList = tradeCodesElem.elements();
            for (Element tradeCode : tradeCodeList) {
                if(tradeCode.getName().equals("tradeCode") && !tradeCode.getTextTrim().isEmpty()) {
                    tradeCodes.add(tradeCode.getTextTrim());
                }
            }
            fileObj.setTradeCodes(tradeCodes);
            //解析orgCodes
            List<String> orgCodes = new ArrayList<>();
            Element orgCodesElem = fileElem.element("orgCodes");
            List<Element> orgCodeList = orgCodesElem.elements();
            for (Element orgCode : orgCodeList) {
                if(orgCode.getName().equals("orgCode") && !orgCode.getTextTrim().isEmpty()) {
                    orgCodes.add(orgCode.getTextTrim());
                }
            }
            fileObj.setOrgCodes(orgCodes);
            //解析 是否加密

            try {
                fileObj.setType(Integer.valueOf(fileElem.element("type").getTextTrim()));
                fileObj.setEncrypt(Boolean.valueOf(fileElem.element("encrypt").getTextTrim()));
                fileObj.setFileName(fileElem.element("fileName").getTextTrim());
                fileObj.setRuleId(Integer.valueOf(fileElem.element("ruleId").getTextTrim()));
                fileObj.setSplitChar(fileElem.element("splitChar").getTextTrim().charAt(0));
                fileObj.setSource(Integer.valueOf(fileElem.element("source").getTextTrim()));
            } catch (NumberFormatException e) {
                e.printStackTrace();
                throw new NumberFormatException("xml文件的file节点格式不正确");
            }

            //解析lines,lines有两个子节点
            Element lines = fileElem.element("lines");
            Element headersElem = lines.element("headers");
            Element contentsElem = lines.element("contents");
            Lines linesObj = fileObj.getLines();
            List<String> headersObj = getHeaders(headersElem);
            List<ColumnDetail> contentsObj = getContents(contentsElem);

            linesObj.setHeaders(headersObj);
            linesObj.setContents(contentsObj);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return fileObj;
    }
    /*
    * 获得headers子节点的数据
    * */
    private static List<String> getHeaders(Element headersElem) {
        List<String> headersObj = new ArrayList<>();
        List<Element> columnNameList = headersElem.elements();
        for ( Element columnNameElem : columnNameList){
            if(columnNameElem.getName().equals("columnName") && !columnNameElem.getTextTrim().isEmpty()) {
                headersObj.add(columnNameElem.getTextTrim());
            }
        }
        return headersObj;
    }
    /*
    * 获得contents子节点的数据
    * */
    private static List<ColumnDetail> getContents(Element contentsElem) {
        List<ColumnDetail> contentsObj = new ArrayList<>();
        List<Element> columnDetailList = contentsElem.elements();
        for(Element columnDetail : columnDetailList) {
            ColumnDetail columnDetailObj = new ColumnDetail();

            try {
                String columnFormat = columnDetail.element("columnFormat").getTextTrim();
                String columnCheckMethod =columnDetail.element("columnCheckMethod").getTextTrim();
                String dataMask =columnDetail.element("dataMask").getTextTrim();
                columnDetailObj.setColumnTag(columnDetail.element("columnTag").getTextTrim());
                if(columnFormat != null && !columnFormat.isEmpty()) {
                    columnDetailObj.setColumnFormat(Integer.valueOf(columnFormat));
                }
                if(columnCheckMethod != null && !columnCheckMethod.isEmpty()) {
                    columnDetailObj.setColumnCheckMethod(Integer.valueOf(columnCheckMethod));
                }
                if(dataMask != null && !dataMask.isEmpty() ) {
                    columnDetailObj.setDataMask( Boolean.valueOf(dataMask));
                }

            } catch (NumberFormatException e) {
                e.printStackTrace();
                throw new NumberFormatException("xml文件的contents节点格式不正确");
            }
            contentsObj.add(columnDetailObj);
        }
        return contentsObj;
    }


    public static void main1(String[] args) {
        //首先解析总的xml文件，获得里面的每个xml文件再遍历

        /*File file = new File("ext/other/src/main/resources/META-INF/xml_template/all_catagory.xml");
        DocumentBuilder db = null;
        DocumentBuilderFactory dbf = null;

        try {
            dbf = DocumentBuilderFactory.newInstance();
            db = dbf.newDocumentBuilder();

            Document dt = db.parse(file);

            Element element = dt.getDocumentElement();
            System.out.println(element.getNodeName());
            NodeList childNode = element.getChildNodes();

            List<TypeObject> list = new ArrayList<>();

            for (int i = 0; i< childNode.getLength(); i++){
                Node node1 = childNode.item(i);
                if(node1.getNodeName().equals("source")) {
                    String fileName = node1.getTextContent();
                    //获得了子节点
                    System.out.println("解析"+fileName+"文件");
                    File fileTemplate = new File("ext/other/src/main/resources/META-INF/xml_template/" + fileName);
                    Document docTemplate = db.parse(fileTemplate);
                    element = docTemplate.getDocumentElement();
                    NodeList nodeList = element.getChildNodes();
                    //根据文件名获取对应的Object类型
                    TypeObject typeObject = new TypeObject();
                    typeObject.setType(fileName.substring(0, fileName.indexOf(".")));
                    System.out.println(typeObject.getType());
                    //设置该文件类型是否需要加密
                    typeObject.setIsEncrypt(false);
                    List listAttr = new ArrayList();
                    for(int j = 0; j< nodeList.getLength(); j++) {
                        Node child = nodeList.item(j);
                        if(child.getNodeName().equals("node")) {
                            //这时是每一个属性
                            System.out.println("name:" +child.getAttributes().getNamedItem("name").getNodeValue()
                                + "\n" + "type:" + child.getAttributes().getNamedItem("type").getNodeValue()
                                + "\n" + "length:" + child.getAttributes().getNamedItem("length").getNodeValue()
                                + "\n" + "format:" + child.getAttributes().getNamedItem("format").getNodeValue()
                                + "\n" + "need:" + child.getAttributes().getNamedItem("need").getNodeValue()
                                + "\n" + "remark:" + child.getAttributes().getNamedItem("remark").getNodeValue()
                            );
                            Map<String, String> map = new HashMap();
                            map.put("name", child.getAttributes().getNamedItem("name").getNodeValue());
                            map.put("type", child.getAttributes().getNamedItem("type").getNodeValue());
                            map.put("length", child.getAttributes().getNamedItem("length").getNodeValue());
                            map.put("format", child.getAttributes().getNamedItem("format").getNodeValue());
                            map.put("need", child.getAttributes().getNamedItem("need").getNodeValue());
                            map.put("remark", child.getAttributes().getNamedItem("remark").getNodeValue());
                            listAttr.add(map);
                        }


                    }
                    typeObject.setAttributes(listAttr);
                    list.add(typeObject);

                }
            }
            System.out.println(JSON.toJSON(list));

            //测试使用这个liist

            for(TypeObject to : list) {
                if(to.getType().equals("loan_repay_contract_detail")) {
                    System.out.println(to.getIsEncrypt());
                    System.out.println(JSON.toJSON(to.getAttributes()));
                }
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }


}
