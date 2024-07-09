package com.oracle.servlet.backend;

import com.oracle.pojo.Department;
import com.oracle.service.DepartmentService;
import com.oracle.service.DepartmentServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/backend/addDepartmentServlet")
public class AddDepartmentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String spid=req.getParameter("pid");
        String deptName=req.getParameter("departmentName");
        Integer pid=null;
        String deptDesc=req.getParameter("departmentDesc");
        if(spid!=null && !"".equals(spid)){
            pid=Integer.parseInt(spid);
        }
        Department department=new Department();
        department.setDepartmentName(deptName);
        department.setDepartmentPid(pid);
        department.setDepartmentDescription(deptDesc);
        if(pid==null){
            department.setDepartmentLevel(1);
        }
        else{
            department.setDepartmentLevel(pid);
        }
        DepartmentService departmentService=new DepartmentServiceimpl();
        departmentService.addDepartment(department);

        resp.sendRedirect(req.getContextPath()+"/backend/rootDepartmentServlet");
    }
}
