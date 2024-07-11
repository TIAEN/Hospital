package com.oracle.service;

import com.github.pagehelper.PageInfo;
import com.oracle.pojo.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> findRootDepartment();
    void addDepartment(Department department);
    void deleteDepartmentFirst(Integer id);
    PageInfo<Department> list(Integer pageNum, Integer pageSize);
    Department findDepartmentById(Integer id);
}
