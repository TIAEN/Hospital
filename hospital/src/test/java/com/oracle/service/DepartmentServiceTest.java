package com.oracle.service;

import com.github.pagehelper.PageInfo;
import com.oracle.pojo.Department;
import org.junit.Test;

public class DepartmentServiceTest {
    @Test
    public void testDepartmentPage(){
        DepartmentService departmentService=new DepartmentServiceImpl();
        PageInfo<Department> PageInfo=departmentService.list(1,3);
        System.out.println("sum:"+PageInfo.getTotal()+"pageSum:"+PageInfo.getPages());
        System.out.println("fenyehoudeshuju"+PageInfo);
    }
}
