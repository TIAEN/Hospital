package com.oracle.servlet.backend;

import com.alibaba.fastjson.JSONObject;
import com.oracle.pojo.Department;
import com.oracle.service.DepartmentService;
import com.oracle.service.DepartmentServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/backend/loadTwoDepartmentServlet")
public class LoadTwoDepartmentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应头
        resp.setContentType("application/json");
        //设置相应编码格式
        resp.setCharacterEncoding("utf-8");
        Integer rootId=Integer.parseInt(req.getParameter("rootId"));
        //根据这个RootId查询科室
        DepartmentService departmentService=new DepartmentServiceimpl();
        List<Department> departmentList=departmentService.findDepartmentByPid(rootId);
        //这里是异步操作，所以没有转发和重定向
        //xhr
        //把集合数据转为json
        String jsonData= JSONObject.toJSONString(departmentList);
        //再把JSON数据响应回前端去
        resp.getWriter().println(jsonData);
        resp.getWriter().flush();
        resp.getWriter().close();
    }
}
