package com.oracle.servlet.backend;

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

@WebServlet("/backend/doctorListServlet")
public class DoctorListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sPageNum=req.getParameter("pageNum");
        Integer pageNum=1;
        Integer pageSize=3;
        String name=req.getParameter("name");
        Integer pid=null;
        if(sPageNum!=null && !"".equals(sPageNum)){
            pageNum=Integer.parseInt(sPageNum);
        }
        String sPid=req.getParameter("pid");
        if(sPid!=null && !"0".equals(sPid)){
            pid=Integer.parseInt(sPid);
        }

        DoctorService doctorService=new DoctorServiceImpl();
        PageInfo<Doctor> pageInfo= doctorService.doctorSearch(pageNum,pageSize,name,pid);
        req.setAttribute("pageInfo",pageInfo);
        req.setAttribute("name",name);
        req.setAttribute("pid",pid);
        req.getRequestDispatcher("/admin/doctor/list.jsp").forward(req,resp);
    }
}
