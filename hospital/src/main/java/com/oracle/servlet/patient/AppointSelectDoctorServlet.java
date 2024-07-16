package com.oracle.servlet.patient;

import com.github.pagehelper.PageInfo;
import com.oracle.pojo.Doctor;
import com.oracle.service.DoctorService;
import com.oracle.service.DoctorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/patient/appointSelectDoctorServlet")
public class AppointSelectDoctorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //调用业务代码
        //设置一下默认页的数据
        String strPageNum=req.getParameter("pageNum");
        String pDepartmentFirstId=req.getParameter("departmentFirstId");
        String pDepartmentSecondId=req.getParameter("departmentSecondId");
        String pPatientId=req.getParameter("patientId");
        //初始页面默认为1
        Integer pageNum=1;
        //初始条数默认为5
        Integer pageSize=5;
        Integer departmentFirstId=null;
        Integer departmentSecondId=null;
        Integer patientId=null;
        //判断是否能够获取得到page页的信息
        if(strPageNum!=null&&!"".equals(strPageNum)){
            pageNum=Integer.parseInt(strPageNum);
        }

        if(pDepartmentFirstId!=null&&!"".equals(pDepartmentFirstId)){
            departmentFirstId=Integer.parseInt(pDepartmentFirstId);
        }
        if(pDepartmentSecondId!=null&&!"".equals(pDepartmentSecondId)){
            departmentSecondId=Integer.parseInt(pDepartmentSecondId);
        }
        if(pPatientId!=null&&!"".equals(pPatientId)){
            patientId=Integer.parseInt(pPatientId);
        }

        DoctorService doctorService=new DoctorServiceImpl();
        PageInfo<Doctor> pageInfo=doctorService.findDoctorListByDepartmentId(pageNum,pageSize,departmentSecondId);
        req.setAttribute("doctorList",pageInfo.getList());
        req.setAttribute("pageInfo",pageInfo);
        req.setAttribute("departmentFirstId",departmentFirstId);
        req.setAttribute("departmentSecondId",departmentSecondId);
        req.setAttribute("patientId",patientId);
        req.getRequestDispatcher("/public/patient/addAppointmentViewDoctor.jsp").forward(req, resp);






    }
}
