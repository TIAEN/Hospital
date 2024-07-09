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

@WebServlet("/backend/departmentListServlet")
public class DepartmentListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strPageNum=req.getParameter("pageNum");
        Integer pageNum=1;
        Integer pageSize=3;

        if(strPageNum!=null && !strPageNum.equals("")){
            pageNum=Integer.parseInt(strPageNum);
        }


        DepartmentService departmentService=new DepartmentServiceimpl();
        PageInfo<Department> pageInfo=departmentService.list(pageNum,pageSize);
        req.setAttribute("departmentList",pageInfo.getList());
        req.setAttribute("pageInfo",pageInfo);
        req.getRequestDispatcher("/admin/department/list.jsp").forward(req,resp);
    }
}
