package com.oracle.servlet.patient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/patient/addAppointmentServlet")
public class AddAppointmentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pDepartmentFirstId=req.getParameter("departmentFirstId");
        String pDepartmentSecondId=req.getParameter("departmentSecondId");
        String pPatientId=req.getParameter("patientId");
        String pDoctorId=req.getParameter("doctorId");

        Integer DepartmentFirstId=null;
        Integer DepartmentSecondId=null;
        Integer PatientId=null;
        Integer DoctorId=null;

        if(pDepartmentFirstId!=null&&!pDepartmentFirstId.equals("")){
            DepartmentFirstId=Integer.parseInt(pDepartmentFirstId);
        }
        if(pDepartmentSecondId!=null&&!pDepartmentSecondId.equals("")){
            DepartmentSecondId=Integer.parseInt(pDepartmentSecondId);
        }
        if(pPatientId!=null&&!pPatientId.equals("")){
            PatientId=Integer.parseInt(pPatientId);
        }
        if(pDoctorId!=null&&!pDoctorId.equals("")){
            DoctorId=Integer.parseInt(pDoctorId);
        }



    }
}
