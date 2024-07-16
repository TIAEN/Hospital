package com.oracle.servlet.patient;

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
import java.util.List;

@WebServlet("/patient/addAppointmentViewSecondServlet")
public class AddAppointmentViewSecondServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sdepartmentFirstId = req.getParameter("departmentFirstId");

        String patientId = req.getParameter("patientId");
        //调用业务代码
        //设置一下默认页的数据
        String strPageNum=req.getParameter("pageNum");

        //初始页面默认为1
        Integer pageNum=1;

        //初始条数默认为5
        Integer pageSize=3;

        Integer id=null;

        Integer departmentFirstId=null;


        //判断是否能够获取得到page页的信息
        if(strPageNum!=null&&!"".equals(strPageNum)){
            pageNum=Integer.parseInt(strPageNum);
        }

        if(patientId!=null&&!"".equals(patientId)){
            id=Integer.parseInt(patientId);
        }

        if (sdepartmentFirstId == null || sdepartmentFirstId.equals("")) {}
        else{
            departmentFirstId=Integer.parseInt(sdepartmentFirstId);
        }

        //System.out.println("222222222222222"+departmentFirstId+"'''''''''"+id);

        DepartmentService departmentService=new DepartmentServiceimpl();
        PageInfo<Department> pageInfo=departmentService.findDepartmentListSecond(pageNum,pageSize,id);
        List<Department> departmentList=departmentService.findDepartmentByPid(departmentFirstId);

        req.setAttribute("departmentList",pageInfo.getList());
        req.setAttribute("pageInfo",pageInfo);
        req.setAttribute("departmentFirstId", departmentFirstId);
        req.setAttribute("departmentList", departmentList);
        req.setAttribute("patientId", id);
        req.getRequestDispatcher("/public/patient/addAppointmentViewSecond.jsp").forward(req, resp);

    }
}
