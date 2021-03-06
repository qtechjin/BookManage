package com.xiaomi.example.domain.dal.dao.impl;

import com.xiaomi.example.domain.dal.dao.BookDAO;
import com.xiaomi.example.domain.dal.dataobject.BookDO;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class BookDAOImpl extends SqlMapClientDaoSupport implements BookDAO {

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table tb_bookinfo
     *
     * @ibatorgenerated Tue Feb 28 16:46:40 CST 2017
     */
    public BookDAOImpl() {
        super();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table tb_bookinfo
     *
     * @ibatorgenerated Tue Feb 28 16:46:40 CST 2017
     */
    public int deleteByPrimaryKey(String bookIsbn) {
        BookDO key = new BookDO();
        key.setBookIsbn(bookIsbn);
        int rows = getSqlMapClientTemplate().delete("tb_bookinfo_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table tb_bookinfo
     *
     * @ibatorgenerated Tue Feb 28 16:46:40 CST 2017
     */
    public String insert(BookDO record) {
        Object newKey = getSqlMapClientTemplate().insert("tb_bookinfo_insert", record);
        return (String) newKey;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table tb_bookinfo
     *
     * @ibatorgenerated Tue Feb 28 16:46:40 CST 2017
     */
    public String insertSelective(BookDO record) {
        Object newKey = getSqlMapClientTemplate().insert("tb_bookinfo_insertSelective", record);
        return (String) newKey;
    }


    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table tb_bookinfo
     *
     * @ibatorgenerated Tue Feb 28 16:46:40 CST 2017
     */
    public BookDO selectByPrimaryKey(String bookIsbn) {
        BookDO key = new BookDO();
        key.setBookIsbn(bookIsbn);
        BookDO record = (BookDO) getSqlMapClientTemplate().queryForObject("tb_bookinfo_selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table tb_bookinfo
     *
     * @ibatorgenerated Tue Feb 28 16:46:40 CST 2017
     */
    public int updateByPrimaryKeySelective(BookDO record) {
        int rows = getSqlMapClientTemplate().update("tb_bookinfo_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table tb_bookinfo
     *
     * @ibatorgenerated Tue Feb 28 16:46:40 CST 2017
     */
    public int updateByPrimaryKey(BookDO record) {
        int rows = getSqlMapClientTemplate().update("tb_bookinfo_updateByPrimaryKey", record);
        return rows;
    }

}