package com.oracle.servlet.backend;

import com.github.pagehelper.PageInfo;
import com.oracle.pojo.Department;
import com.oracle.service.DepartmentService;
import com.oracle.service.DepartmentServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/backend/departmentListFirstServlet")//返回所有的一级科室并分页
public class DepartmentListFirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //调用业务代码
        //设置一下默认页的数据
        String strPageNum=req.getParameter("pageNum");
        //初始页面默认为1
        Integer pageNum=1;
        //初始条数默认为5
        Integer pageSize=5;

        //判断是否能够获取得到page页的信息
        if(strPageNum!=null&&!"".equals(strPageNum)){
            pageNum=Integer.parseInt(strPageNum);
        }



        DepartmentService departmentService=new DepartmentServiceimpl();
        PageInfo<Department> pageInfo=departmentService.findDepartmentListFirst(pageNum,pageSize);
        req.setAttribute("departmentList",pageInfo.getList());
        req.setAttribute("pageInfo",pageInfo);
        req.getRequestDispatcher("/public/patient/addAppointmentViewFirst.jsp").forward(req,resp);
    }
}
