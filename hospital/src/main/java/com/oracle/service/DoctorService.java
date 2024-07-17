package com.oracle.service;

import com.github.pagehelper.PageInfo;
import com.oracle.pojo.Doctor;

public interface DoctorService {

    Integer getCurrentMaxJobNumber();

    boolean login(Doctor doctor);

    Doctor getDoctorById(Integer doctor_id);

    void modifyDoctor(Doctor doctor);

    PageInfo<Doctor> doctorSearch(Integer pageNum, Integer pageSize, String name, Integer pid);

    Doctor getDoctorByJobNumber(String jobNumber);

    PageInfo<Doctor> list(Integer pageNum, Integer pageSize);

    void encryption(Integer id);    //通过ID对用户的密码进行加密

    void addDoctor(Doctor doctor);
}
