package com.oracle.service;

import org.junit.Test;

public class ProfessionalTitleServiceTest {

    @Test
    public void testGetCurrentMaxJobNumber(){
        DoctorService doctorService=new DoctorServiceImpl();
        Integer currentMaxJobNumber=doctorService.getCurrentMaxJobNumber();
        System.out.println(currentMaxJobNumber);
    }
}
