package com.oracle.mapper;

import com.oracle.pojo.Admin;
import com.oracle.pojo.Doctor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DoctorMapper {

    String selectMaxJobNumber();

    Doctor selectDoctorByJobNumber(String jobNumber);

    Integer selectCountByJobNumber(String jobNumber);

    Doctor selectDoctorById(Integer id);

    void updateDoctor(Doctor doctor);

    List<Doctor> selectDoctorSearch(@Param("name") String name,@Param("pid")Integer pid);

    void insertIntoDoctor(Doctor doctor);

    void updateDoctorPassword(@Param("password") String password, @Param("id") Integer id);

    //添加处 用于查询所有的医生
    List<Doctor> selectDoctorAll();
}
