package com.xiaomi.example.domain.service.impl;

import com.google.gson.Gson;
import com.xiaomi.example.domain.dal.repository.UserRepository;
import com.xiaomi.example.domain.pojo.User;
import com.xiaomi.example.domain.service.UserService;
import com.xiaomi.example.domain.utils.SecurityUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by mi on 2017/3/21.
 */
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository userRepository;

    public boolean login(String userName, String password) {
        User user = userRepository.loadByUserName(userName);
        if(user != null && SecurityUtils.md5AndBase64Validate(password, user.getPassword())) {
            return true;
        } else{
            Gson gson = new Gson();
            return false;
        }
    }

    public boolean register(User user) {
        String password = user.getPassword();
        user.setPassword(SecurityUtils.md5AndBase64Encrypt(password));
        if(userRepository.insertUser(user)) {
            //register a user success and send message to queue

            return true;
        } else {
            return false;
        }
    }

    public boolean modifyInfo(User user){

        return true;
    }

    public User getUserByName(String userName) {
        return null;
    }

    public List getUserListPaging(int nowPage, Long pageSize) {
        return userRepository.getUserListPaging(nowPage-1, pageSize);
    }
}
