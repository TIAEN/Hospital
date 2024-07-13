package com.oracle.service;

import com.oracle.pojo.Admin;

public interface AdminService {

    boolean login(Admin admin);     //进行登录

    void encryption(Integer id);    //通过ID对用户的密码进行加密
}
