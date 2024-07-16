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
import java.util.ArrayList;
import java.util.List;


//处理科室删除
@WebServlet("/backend/dropDepartmentViewServlet")
public class DropDepartmentViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strId=req.getParameter("pid");
        Integer pid=null;
        if(strId!=null&&!"".equals(strId)){
            pid=Integer.parseInt(strId);
        }

        DepartmentService departmentService=new DepartmentServiceimpl();
        Integer count=departmentService.countSidById(pid);
        if(count==0){
            System.out.println("OK进来了");
            departmentService.deleteById(pid);
            req.getRequestDispatcher("/admin/department/delete.jsp").forward(req,resp);
        }
        else{
            System.out.println("应该不会吧？");
            req.getRequestDispatcher("/admin/department/dropFail.jsp").forward(req,resp);
        }

    }
}
