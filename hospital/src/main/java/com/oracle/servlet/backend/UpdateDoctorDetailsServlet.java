package com.oracle.servlet.backend;

import com.oracle.pojo.Doctor;
import com.oracle.service.DoctorService;
import com.oracle.service.DoctorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/backend/updateDoctorDetailsServlet")
@MultipartConfig
public class UpdateDoctorDetailsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part=req.getPart("image");
        Doctor doctor=new Doctor();
        if(part.getSize()>0){
            String fileName=part.getSubmittedFileName();
            String suffix=fileName.substring(fileName.lastIndexOf("."));
            String newFileName= UUID.randomUUID().toString().replaceAll("-","")+suffix;
            part.write("D://testupload//"+newFileName);
            doctor.setAvatar(newFileName);
        }
        String jobNumber =req.getParameter("jobNumber");
        String phone=req.getParameter("phone");
        String email=req.getParameter("email");
        String introduction=req.getParameter("introduction");
        doctor.setJobNumber(jobNumber);
        doctor.setPhone(phone);
        doctor.setEmail(email);
        doctor.setIntroduction(introduction);

        DoctorService doctorService=new DoctorServiceImpl();
        doctorService.modifyDoctor(doctor);
        resp.sendRedirect(req.getContextPath()+"/backend/doctorListServlet");
    }
}
