package com.oracle.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oracle.mapper.DepartmentMapper;
import com.oracle.pojo.Department;
import com.oracle.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class DepartmentServiceimpl implements DepartmentService {
    @Override
    public List<Department> findRootDepartment() {
        SqlSession sqlSession = DBUtils.createDbUtils().getSQLSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        List<Department> departmentList = departmentMapper.selectDepartment();
        sqlSession.close();
        return departmentList;
    }

    @Override
    public void addDepartment(Department department) {
        SqlSession sqlSession = DBUtils.createDbUtils().getSQLSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        departmentMapper.insertDepartment(department);
        System.out.println("11111111111111111111111" + department);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteDepartmentFirst(Integer id){
        SqlSession sqlSession = DBUtils.createDbUtils().getSQLSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        System.out.println("////////////222////////////////////"+id);
        departmentMapper.deleteDepartmentFirst(id);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public PageInfo<Department> list(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        SqlSession sqlSession = DBUtils.createDbUtils().getSQLSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        List<Department> departmentList=departmentMapper.selectDepartmentAll();
        sqlSession.close();
        return new PageInfo<Department>(departmentList);
    }
}
