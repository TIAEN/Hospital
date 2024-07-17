package com.oracle.servlet.backend;

import com.oracle.pojo.Doctor;
import com.oracle.pojo.SessionIdentify;
import com.oracle.service.DoctorService;
import com.oracle.service.DoctorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/backend/currentDoctorInfoServlet")
public class GetCurrentDoctorInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       /*
        HttpSession session= req.getSession();
        SessionIdentify<Doctor> sessionIdentify=(SessionIdentify) session.getAttribute("manager");
        //Doctor t= sessionIdentity.getT();
        Doctor doctor = new Doctor();
        Doctor t= (Doctor)session.getAttribute("doctor");
        DoctorService doctorService=new DoctorServiceImpl();

        */
        DoctorService doctorService=new DoctorServiceImpl();
        String jobNumber=req.getParameter("jobNumber");
        Doctor doctor=doctorService.getDoctorByJobNumber(jobNumber);

        req.setAttribute("doctor",doctor);
        req.getRequestDispatcher("/admin/doctor/doctorDetails.jsp").forward(req,resp);
    }
}
