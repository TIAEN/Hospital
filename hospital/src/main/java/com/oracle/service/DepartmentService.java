package com.oracle.service;

import com.github.pagehelper.PageInfo;
import com.oracle.pojo.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> findRootDepartment();

    void addDepartment(Department department);
    //声明方法
    List<Department> findRootDepartmentList();      //返回所有一级科室

    PageInfo<Department> findDepartmentListFirst(int pageNum, int pageSize);//分页找到所有的一级科室

    PageInfo<Department> findDepartmentListSecond(int pageNum, int pageSize,int pId);

    void deleteDepartmentFirst(Integer id);

    Department findDepartmentById(Integer id);
    Integer countSidById(Integer id);               //通过id来找到这个科室，返回它的子科室的数目

    void deleteById(Integer id);                    //通过id来找到这个科室，并且删除它

    Department findRootDepartment(Integer id);      //通过id来找到这个科室，并且返回它

    //分页展示科室数据
    //返回的List是不包含分页的信息的

    //做返回类型的封装，PageInfo<T> 里面有分页后的数据信息和页码信息
    //封装一个分页对象返回，尽量不要把后台的mybatis对象进行返回
    PageInfo<Department> list(Integer pageNum,Integer pageSize);                //对List进行封装

    List<Department> findDepartmentByPid(Integer pid);      //返回这个一级科室下的全部二级科室
}
