package com.oracle.service;

import com.oracle.pojo.Doctor;
import com.oracle.utils.DateUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

public class TestDoctorService {

    @Test
    public void testAddDoctor(){

        Doctor doctor=new Doctor();
        doctor.setDoctorId(null);
        doctor.setEntryDate(new Date());
        doctor.setName("嘿嘿嘿嘿嘿");
        doctor.setPassword("12345");
        doctor.setProfessionalTitleId(2);
        doctor.setPhone("234567");
        doctor.setAvatar("abc.op");
        doctor.setEmail("jdgsgd@fddd.com");
        doctor.setJobNumber("87t6");
        doctor.setRegistrationFee(new BigDecimal(2546352));
        doctor.setDepartmentId(2);
        doctor.setIntroduction("thyfdg");

        DoctorService doctorService=new DoctorServiceImpl();
        doctorService.addDoctor(doctor);



    }
}
