package com.oracle.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oracle.mapper.DepartmentMapper;
import com.oracle.pojo.Department;
import com.oracle.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {

    @Override
    public void addDepartment(Department department) {
        SqlSession sqlSession = DBUtils.createDbUtils().getSQLSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        departmentMapper.insertDepartment(department);
        sqlSession.commit(true);
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

    @Override
    public void deleteDepartmentFirst(Integer id){
        SqlSession sqlSession = DBUtils.createDbUtils().getSQLSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        System.out.println("////////////222////////////////////"+id);
        departmentMapper.deleteDepartmentFirst(id);
        sqlSession.commit(true);
        sqlSession.close();
    }

    @Override
    public List<Department> findRootDepartmentList() {
        //在编写正式项目时 注意连接使用完成后要关闭
        SqlSession sqlSession=DBUtils.createDbUtils().getSQLSession();
        DepartmentMapper departmentMapper=sqlSession.getMapper(DepartmentMapper.class);
        List<Department> departmentList=departmentMapper.selectRootDepartment();
        sqlSession.commit(true);
        sqlSession.close();
        return departmentList;
    }

    @Override
    public List<Department> findDepartmentByPid(Integer pid) {
        SqlSession sqlSession=DBUtils.createDbUtils().getSQLSession();
        DepartmentMapper departmentMapper=sqlSession.getMapper(DepartmentMapper.class);
        List<Department> departmentList=departmentMapper.selectDepartmentByPid(pid);
        sqlSession.close();
        return departmentList;
    }

    @Override
    public Integer countSidById(Integer id) {
        SqlSession sqlSession=DBUtils.createDbUtils().getSQLSession();
        DepartmentMapper departmentMapper=sqlSession.getMapper(DepartmentMapper.class);
        Integer count=departmentMapper.selectCountSidById(id);
        sqlSession.commit(true);
        sqlSession.close();
        return count;
    }

    @Override
    public void deleteById(Integer id) {
        SqlSession sqlSession=DBUtils.createDbUtils().getSQLSession();
        DepartmentMapper departmentMapper=sqlSession.getMapper(DepartmentMapper.class);
        departmentMapper.deleteByDepartmentId(id);
        sqlSession.commit(true);
        sqlSession.close();
    }

    @Override
    public Department findRootDepartment(Integer id) {
        SqlSession sqlSession=DBUtils.createDbUtils().getSQLSession();
        DepartmentMapper departmentMapper=sqlSession.getMapper(DepartmentMapper.class);
        Department department=departmentMapper.selectRootDepartmentById(id);
        sqlSession.commit(true);
        sqlSession.close();
        return department;
    }

    @Override
    public List<Department> List(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        SqlSession sqlSession=DBUtils.createDbUtils().getSQLSession();
        DepartmentMapper departmentMapper=sqlSession.getMapper(DepartmentMapper.class);
        List<Department> departmentList=departmentMapper.selectDepartmentAll();
        sqlSession.close();
        return departmentList;
    }

    @Override
    public Department findDepartmentById(Integer id) {
        SqlSession sqlSession = DBUtils.createDbUtils().getSQLSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        Department department=departmentMapper.selectDepartmentById(id);
        sqlSession.close();
        return department;
    }

    @Override
    public List<Department> findRootDepartment() {
        SqlSession sqlSession = DBUtils.createDbUtils().getSQLSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        List<Department> departmentList = departmentMapper.selectDepartment();
        sqlSession.close();
        return departmentList;
    }


}
