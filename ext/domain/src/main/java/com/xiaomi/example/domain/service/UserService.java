package com.xiaomi.example.domain.service;

import com.xiaomi.example.domain.pojo.User;

import javax.jws.WebService;
import java.util.List;

/**
 * Created by mi on 2017/3/21.
 */
@WebService(endpointInterface = "com.xiaomi.example.domain.service.UserService", targetNamespace = "http://impl.service.example.xiaomi.com")
public interface UserService {
    public boolean login(String userName, String password);

    public boolean register(User user);

    public boolean modifyInfo(User user);

    public User getUserByName(String userName);

    public List getUserListPaging(int startId, Long pageSize);
}
