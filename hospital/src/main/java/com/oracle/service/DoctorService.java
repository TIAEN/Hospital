package com.oracle.service;

import com.github.pagehelper.PageInfo;
import com.oracle.pojo.Doctor;

public interface DoctorService {

    boolean login(Doctor doctor);

    void encryption(Integer id);    //通过ID对用户的密码进行加密

    Integer getCurrentMaxJobNumber();

    void addDoctor(Doctor doctor);

    PageInfo<Doctor> findDoctorListByDepartmentId(Integer pageNum, Integer pageSize, Integer pId);//找到一个科室下的医生

    Doctor findDoctorById(Integer id);

    String findDoctorNameById(Integer id);
}
