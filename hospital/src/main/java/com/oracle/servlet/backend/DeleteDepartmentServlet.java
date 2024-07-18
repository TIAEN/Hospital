package com.oracle.servlet.backend;

import com.alibaba.fastjson.JSONObject;
import com.oracle.service.DepartmentService;
import com.oracle.service.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/backend/deleteDepartmentServlet")
public class DeleteDepartmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pid = req.getParameter("id");

        Integer id = Integer.parseInt(pid);
        System.out.println("////////////////////////////////"+id);
        DepartmentService departmentService=new DepartmentServiceImpl();
        departmentService.deleteDepartmentFirst(id);


        String json= JSONObject.toJSONString(1);
        resp.getWriter().println(json);
        resp.getWriter().flush();
        resp.getWriter().close();
    }
}
