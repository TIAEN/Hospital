package com.oracle.servlet.backend;

import com.oracle.service.DepartmentService;
import com.oracle.service.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//一级科室列表
@WebServlet("/backend/rootDepartmentServlet")
public class RootDepartmentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DepartmentService departmentService=new DepartmentServiceImpl();
        req.setAttribute("rootDepartmentList",departmentService.findRootDepartmentList());
        req.getRequestDispatcher("/admin/department/root_department.jsp").forward(req, resp);
    }
}
