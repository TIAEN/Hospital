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

@WebServlet("/backend/departmentListSecondServlet")
public class DepartmentListSecondServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //调用业务代码
        //设置一下默认页的数据
        String strPageNum=req.getParameter("pageNum");
        String pid=req.getParameter("id");
        //初始页面默认为1
        Integer pageNum=1;
        //初始条数默认为5
        Integer pageSize=5;
        Integer id=null;
        //判断是否能够获取得到page页的信息
        if(strPageNum!=null&&!"".equals(strPageNum)){
            pageNum=Integer.parseInt(strPageNum);
        }

        if(pid!=null&&!"".equals(pid)){
            id=Integer.parseInt(pid);
        }


        DepartmentService departmentService=new DepartmentServiceimpl();
        PageInfo<Department> pageInfo=departmentService.findDepartmentListSecond(pageNum,pageSize,id);
        req.setAttribute("departmentFirstId",id);
        req.setAttribute("departmentList",pageInfo.getList());
        req.setAttribute("pageInfo",pageInfo);
        req.getRequestDispatcher("/public/patient/addAppointmentViewFirst.jsp").forward(req,resp);
    }
}
