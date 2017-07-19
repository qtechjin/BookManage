package com.xiaomi.example.domain.dal.dao;

import com.xiaomi.example.domain.dal.dataobject.UserDO;

import java.util.List;

public interface UserDAO {

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table tb_user
     *
     * @ibatorgenerated Tue Feb 28 18:27:05 CST 2017
     */
    int deleteByPrimaryKey(Integer userId);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table tb_user
     *
     * @ibatorgenerated Tue Feb 28 18:27:05 CST 2017
     */
    Integer insert(UserDO record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table tb_user
     *
     * @ibatorgenerated Tue Feb 28 18:27:05 CST 2017
     */
    Integer insertSelective(UserDO record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table tb_user
     *
     * @ibatorgenerated Tue Feb 28 18:27:05 CST 2017
     */
    UserDO selectByPrimaryKey(Integer userId);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table tb_user
     *
     * @ibatorgenerated Tue Feb 28 18:27:05 CST 2017
     */
    int updateByPrimaryKeySelective(UserDO record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table tb_user
     *
     * @ibatorgenerated Tue Feb 28 18:27:05 CST 2017
     */
    int updateByPrimaryKey(UserDO record);

    List selectByUserNames(List userNames);

    Long insertBatch(List users);

    UserDO selectByUserName(String userName);

    UserDO selectByNameAndEmail(String userName, String email);

    List loadUsersByPaging(Long startNo, Long pageSize);
}