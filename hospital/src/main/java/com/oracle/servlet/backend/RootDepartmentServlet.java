package com.oracle.servlet.backend;

import com.oracle.service.DepartmentService;
import com.oracle.service.DepartmentServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/backend/rootDepartmentServlet")
public class RootDepartmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DepartmentService departmentService=new DepartmentServiceimpl();
        req.setAttribute("rootDepartmentList",departmentService.findRootDepartment());
        req.getRequestDispatcher("/admin/department/root_department.jsp").forward(req, resp);

    }
}
