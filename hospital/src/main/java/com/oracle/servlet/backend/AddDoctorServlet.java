package com.oracle.servlet.backend;

import com.oracle.pojo.Doctor;
import com.oracle.service.DoctorService;
import com.oracle.service.DoctorServiceImpl;
import com.oracle.utils.DBUtils;
import com.oracle.utils.DateUtils;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

@WebServlet("/backend/addDoctorServlet")
public class AddDoctorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String jobNumber=req.getParameter("jobNumber");
        String strentryDate=req.getParameter("entryDate");
        Date entryDate=null;
        try {
            entryDate=DateUtils.convertToDate(strentryDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Integer dId=Integer.parseInt(req.getParameter("departmentId"));
        Integer pId=Integer.parseInt(req.getParameter("professionalTitle"));

        Doctor doctor=new Doctor();
        doctor.setJobNumber(jobNumber);
        doctor.setDepartmentId(dId);

        String defaultPassword="123456";
        String password= DigestUtils.md5Hex(defaultPassword);

        doctor.setPassword(password);
        doctor.setProfessionalTitleId(pId);
        doctor.setName(name);

        doctor.setEntryDate(entryDate);
        DoctorService doctorService=new DoctorServiceImpl();
        doctorService.addDoctor(doctor);

        resp.sendRedirect(req.getContextPath()+"/backend/rootDepartmentServlet");

    }
}
