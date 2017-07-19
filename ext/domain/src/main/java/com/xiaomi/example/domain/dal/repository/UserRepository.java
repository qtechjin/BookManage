package com.xiaomi.example.domain.dal.repository;

import com.xiaomi.example.domain.pojo.User;

import java.util.List;

/**
 * Created by mi on 2017/3/23.
 */
public interface UserRepository {
    public User loadByUserName(String userName);

    public boolean insertUser(User user);

    public void updateByUserName(User user);

    public User getUserByName(String userName);

    public List getUserListPaging(int nowPage, Long pageSize);
}
