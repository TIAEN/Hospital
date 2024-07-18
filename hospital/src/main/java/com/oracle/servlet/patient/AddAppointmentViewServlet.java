package com.oracle.servlet.patient;

import com.github.pagehelper.PageInfo;
import com.oracle.pojo.Department;
import com.oracle.service.DepartmentService;
import com.oracle.service.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/patient/addAppointmentViewServlet")
public class AddAppointmentViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //调用业务代码
        //设置一下默认页的数据

        String strPageNum=req.getParameter("pageNum");
        String patientId=req.getParameter("pid");

        //初始页面默认为1
        Integer pageNum=1;
        //初始条数默认为5
        Integer pageSize=3;

        //判断是否能够获取得到page页的信息
        if(strPageNum!=null&&!"".equals(strPageNum)){
            pageNum=Integer.parseInt(strPageNum);
        }



        DepartmentService departmentService=new DepartmentServiceImpl();
        PageInfo<Department> pageInfo=departmentService.findDepartmentListFirst(pageNum,pageSize);

        //System.out.println("////////////////////"+pageInfo);
        req.setAttribute("departmentList",pageInfo.getList());
        req.setAttribute("pageInfo",pageInfo);
        //req.getRequestDispatcher("/public/patient/addAppointmentViewFirst.jsp").forward(req,resp);
        //System.out.println("////////////////////"+pageInfo.getList());

        System.out.println("////////////////////"+patientId);
        req.setAttribute("patientId", patientId);
        req.getRequestDispatcher("/public/patient/addAppointmentViewFirst.jsp").forward(req, resp);
    }
}
