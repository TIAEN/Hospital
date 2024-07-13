package com.oracle.service;


import com.github.pagehelper.PageInfo;
import com.oracle.pojo.Department;
import org.junit.Test;

import java.util.List;

public class DepartmentServiceTest {

    @Test
    public void testDepartmentPage(){
        /*
        DepartmentService departmentService=new DepartmentServiceImpl();
        List<Department> departmentList=departmentService.List(1,3);
        System.out.println(departmentList);
        */
        DepartmentService departmentService=new DepartmentServiceImpl();
        PageInfo<Department> pageInfo=departmentService.pageList(7,3);
        System.out.println("总条数:"+pageInfo.getTotal()+" 总页数:"+pageInfo.getPages());
        System.out.println("分页后的数据"+pageInfo.getList());
        List<Department> departmentList=pageInfo.getList();
        departmentList.stream().forEach(System.out::println);
    }
}
