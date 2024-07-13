package com.oracle.mapper;

import com.oracle.pojo.Admin;
import com.oracle.pojo.Department;
import com.oracle.pojo.Doctor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DoctorMapper {

    Doctor selectDoctorByJobNumber(String jobNumber);

    Integer selectCountByJobNumber(String jobNumber);

    void updateDoctorPassword(@Param("password") String password, @Param("id") Integer id);

    Doctor selectDoctorById(Integer id);

    String selectMaxJobNumber();

    void insertIntoDoctor(Doctor doctor);

    //添加处 用于查询所有的医生
    List<Doctor> selectDoctorAll();
}
