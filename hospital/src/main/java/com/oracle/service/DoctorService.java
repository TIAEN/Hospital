package com.oracle.service;

import com.oracle.pojo.Doctor;

public interface DoctorService {

    boolean login(Doctor doctor);

    void encryption(Integer id);    //通过ID对用户的密码进行加密

    Integer getCurrentMaxJobNumber();

    void addDoctor(Doctor doctor);
}
