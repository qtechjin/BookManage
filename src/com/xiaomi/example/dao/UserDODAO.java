package com.xiaomi.example.dao;

import com.xiaomi.example.pojo.UserDO;
import com.xiaomi.example.pojo.UserDOExample;
import com.xiaomi.example.pojo.UserDOKey;

import java.util.List;

public interface UserDODAO {
    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table tb_user
     *
     * @ibatorgenerated Thu Mar 23 10:22:06 CST 2017
     */
    int countByExample(UserDOExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table tb_user
     *
     * @ibatorgenerated Thu Mar 23 10:22:06 CST 2017
     */
    int deleteByExample(UserDOExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table tb_user
     *
     * @ibatorgenerated Thu Mar 23 10:22:06 CST 2017
     */
    int deleteByPrimaryKey(UserDOKey key);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table tb_user
     *
     * @ibatorgenerated Thu Mar 23 10:22:06 CST 2017
     */
    Integer insert(UserDO record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table tb_user
     *
     * @ibatorgenerated Thu Mar 23 10:22:06 CST 2017
     */
    Integer insertSelective(UserDO record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table tb_user
     *
     * @ibatorgenerated Thu Mar 23 10:22:06 CST 2017
     */
    List selectByExample(UserDOExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table tb_user
     *
     * @ibatorgenerated Thu Mar 23 10:22:06 CST 2017
     */
    UserDO selectByPrimaryKey(UserDOKey key);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table tb_user
     *
     * @ibatorgenerated Thu Mar 23 10:22:06 CST 2017
     */
    int updateByExampleSelective(UserDO record, UserDOExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table tb_user
     *
     * @ibatorgenerated Thu Mar 23 10:22:06 CST 2017
     */
    int updateByExample(UserDO record, UserDOExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table tb_user
     *
     * @ibatorgenerated Thu Mar 23 10:22:06 CST 2017
     */
    int updateByPrimaryKeySelective(UserDO record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table tb_user
     *
     * @ibatorgenerated Thu Mar 23 10:22:06 CST 2017
     */
    int updateByPrimaryKey(UserDO record);
}