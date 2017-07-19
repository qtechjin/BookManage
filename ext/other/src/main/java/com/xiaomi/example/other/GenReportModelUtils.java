package com.xiaomi.example.other;

/**
 * 根据xml文件返回Task对象.
 */
public class GenReportModelUtils {

    /*private static final Logger LOGGER = LoggerFactory.getLogger(GenReportModelUtils.class);

    public static void main(String[] args) {
        ReportTask task = getReportModel("bhxt_task.xml");
        Gson gson = new Gson();

        if(task != null ) {
            System.out.println(gson.toJson(task));
            LOGGER.info("解析xml文件，获得task:" + gson.toJson(task));
        } else {
            LOGGER.error("ddd");
        }

    }

    *//*
    * 根据task传入相应的task model文件
    * *//*
    public static ReportTask getReportModel(String taskFileName) {
        //todo:根据classpath来获得文件路径
        String filePath = "src/main/resources/reportModel/";
        String xsdFilePath = filePath + "meta.xsd";
        String xmlFilePath =filePath + taskFileName;
        File taskFile = new File(xmlFilePath);

        //首先校验外部xml文件
        if( !validate(xmlFilePath, xsdFilePath) ) {
            LOGGER.error("校验xml文件失败，请检查xml文件的正确性,path:{}" , xmlFilePath);
            return null;
        }

        SAXReader reader = new SAXReader();
        ReportTask task = new ReportTask();

        try {
            Document document = reader.read(taskFile);
            Element root = document.getRootElement();
            Element ruleElem = root.element("ruleId");
            task.setRuleId(Integer.valueOf(ruleElem.getTextTrim()));
            task.setOrgCode(Integer.valueOf(root.element("orgCode").getTextTrim()));
            List<ReportFile> fileList = new ArrayList<>();
            //解析fileList
            List<Element> fileElemList = root.element("fileList").elements();
            for(Element elem : fileElemList) {
                if(elem.getName().equals("file") && !elem.getTextTrim().isEmpty()){
                    //根据file的值获得文件路径，解析每个file
                    String fileName = elem.getTextTrim() + ".xml";
                    ReportFile fileElem = getFileElem(filePath + fileName, xsdFilePath);
                    if(fileElem != null) {
                        fileList.add(fileElem);
                    } else {
                        return null;
                    }
                    //todo:如果是null  直接返回null?
                }
            }
            task.setReportFileList(fileList);

        } catch (Exception e) {
            LOGGER.error("在解析文件时出现错误:{}", e);
            return null;

        }
        return task;

    }

    *//*校验xml文件*//*
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
                LOGGER.info("{} is valid", xmlFile.getSystemId());
            } catch (SAXException e) {
                LOGGER.error("{} is NOT valid,Reason: {}", xmlFile.getSystemId(), e.getLocalizedMessage());
                return false;
            }
        } catch (Exception e1) {
            LOGGER.error("验证xml文件出现异常:", e1);
            return false;
        }
        return true;
    }

    *//*
    * 获得file子节点的数据
    * *//*
    private static ReportFile getFileElem(String xmlFilePath, String xsdFilePath) {

        //首先校验file文件
        if( !validate(xmlFilePath, xsdFilePath) ) {
            LOGGER.warn("校验xml文件失败，请检查xml文件的正确性,path:{}" + xmlFilePath);
            //todo:如果某一个filelist中的file格式出现问题是返回null还是返回其余的，如果这个file没有找到
            //也就是在task中配置了，但是没没有这个file
            return null;
        }

        ReportFile fileObj = new ReportFile();

        SAXReader reader = new SAXReader();

        try {
            Document docFile = reader.read(new File(xmlFilePath));
            Element fileElem = docFile.getRootElement();

            //tradeCodes，如果是不存在的tradecode，就不添加
            List<TradeCode> tradeCodes = new ArrayList<>();
            Element tradeCodesElem = fileElem.element("tradeCodes");
            List<Element> tradeCodeList = tradeCodesElem.elements();
            for (Element tradeCode : tradeCodeList) {
                if(tradeCode.getName().equals("tradeCode") && !tradeCode.getTextTrim().isEmpty()) {
                    TradeCode code = TradeCode.getByValue(Integer.valueOf(tradeCode.getTextTrim()));
                    if(code != null) {
                        tradeCodes.add(code);
                    }
                }
            }
            fileObj.setTradeCodes(tradeCodes);
            //解析orgCodes
            List<Organization> orgCodes = new ArrayList<>();
            Element orgCodesElem = fileElem.element("orgCodes");
            List<Element> orgCodeList = orgCodesElem.elements();
            for (Element orgCode : orgCodeList) {
                if(orgCode.getName().equals("orgCode") && !orgCode.getTextTrim().isEmpty()) {
                    Organization code = Organization.get(Integer.valueOf(orgCode.getTextTrim()));
                    if(code != null) {
                        orgCodes.add(code);
                    }
                }
            }
            fileObj.setOrgCodes(orgCodes);
            //解析 是否加密
            fileObj.setType(Integer.valueOf(fileElem.element("type").getTextTrim()));
            fileObj.setEncrypt(Boolean.valueOf(fileElem.element("encrypt").getTextTrim()));
            fileObj.setFileName(fileElem.element("fileName").getTextTrim());
            fileObj.setRuleId(Integer.valueOf(fileElem.element("ruleId").getTextTrim()));
            fileObj.setSplitChar(fileElem.element("splitChar").getTextTrim().charAt(0));
            fileObj.setSource(Integer.valueOf(fileElem.element("source").getTextTrim()));

            //headersElem,contentsElem两个子节点
            Element headersElem = fileElem.element("headers");
            Element contentsElem = fileElem.element("contents");
            List<String> headersObj = getHeaders(headersElem);
            List<ColumnDetail> contentsObj = getContents(contentsElem);

            fileObj.setHeaders(headersObj);
            fileObj.setContents(contentsObj);

        } catch (Exception e) {
            LOGGER.error("解析文件:{},出现异常:{}.", xmlFilePath, e);
            throw new NumberFormatException(xmlFilePath + "解析过程出现错误,错误原因:" + e.getMessage());
        }

        return fileObj;
    }
    *//*
        * 获得headers子节点的数据
        * *//*
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
    *//*
    * 获得contents子节点的数据
    * *//*
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
    }*/

}
