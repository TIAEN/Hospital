package com.oracle.mapper;

import com.oracle.pojo.Department;

import java.util.List;

public interface DepartmentMapper {
    List<Department> selectDepartment();
    void insertDepartment(Department department);
    List<Department> selectDepartmentAll();
    void deleteDepartmentFirst(int id);
}
