package com.xiaomi.example.dal.repository.impl;

import com.xiaomi.example.convert.UserConvert;
import com.xiaomi.example.dal.dao.UserDAO;
import com.xiaomi.example.dal.dataobject.UserDO;
import com.xiaomi.example.dal.repository.UserRepository;
import com.xiaomi.example.pojo.User;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by mi on 2017/3/23.
 */
public class DefaultUserRepository implements UserRepository {
    @Resource
    private UserDAO userDAO;

    Logger logger = Logger.getLogger("DAO");

    public User loadByUserName(String userName) {
        return UserConvert.convert( userDAO.selectByUserName(userName) );
    }

    public boolean insertUser(User user){
        if(userDAO.insert(UserConvert.convert(user)) != 0 ) {
            return true;
        } else {
            return false;
        }
    }

    public User loadByUserId(int userId){
        return UserConvert.convert(userDAO.selectByPrimaryKey(userId));
    }

    public void updateByUserName(User user) {

    }

    public User getUserByName(String userName) {
        return UserConvert.convert(userDAO.selectByUserName(userName));
    }

    public List<User> getUserListPaging(int nowPage, Long pageSize) {
        Long startNum = pageSize * nowPage;

        List<UserDO> list = userDAO.loadUsersByPaging(startNum, pageSize);
        logger.info("By " +startNum + "-" + pageSize + "get user:" + list);
        List<User> listUser = new ArrayList<User>();
        for(UserDO userDO : list){
            listUser.add(UserConvert.convert(userDO));
        }
        return listUser;
    }
}
