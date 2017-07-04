package com.xiaomi.example.convert;

import com.xiaomi.example.dal.dataobject.UserDO;
import com.xiaomi.example.pojo.User;

/**
 * Created by mi on 2017/3/23.
 */
public class UserConvert {
    public static User convert(UserDO userDO){
        if (userDO == null) {
            return null;
        }
        User user = new User();
        user.setUserId(userDO.getUserId());
        user.setUserName(userDO.getUserName());
        user.setEmail(userDO.getEmail());
        user.setGender(userDO.getGender());
        user.setPassword(userDO.getPassword());
        return user;
    }

    public static UserDO convert(User user){
        if (user == null) {
            return null;
        }
        UserDO userDO = new UserDO();
        userDO.setUserId(user.getUserId());
        userDO.setUserName(user.getUserName());
        userDO.setEmail(user.getEmail());
        userDO.setGender(user.getGender());
        userDO.setPassword(user.getPassword());
        return userDO;
    }
}
