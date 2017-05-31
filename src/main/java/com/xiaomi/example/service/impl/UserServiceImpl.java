package com.xiaomi.example.service.impl;

import com.google.gson.Gson;
import com.xiaomi.example.dal.repository.UserRepository;
import com.xiaomi.example.pojo.User;
import com.xiaomi.example.service.UserService;
import com.xiaomi.example.utils.SecurityUtils;

import javax.annotation.Resource;

/**
 * Created by mi on 2017/3/21.
 */
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository userRepository;

    public boolean login(String userName, String password) {
        System.out.println(userName + "正在登录...");
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
            return true;
        } else {
            return false;
        }
    }

    public boolean modifyInfo(User user){

        return true;
    }
}
