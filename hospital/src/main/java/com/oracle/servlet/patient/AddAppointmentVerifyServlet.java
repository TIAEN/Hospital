package com.oracle.servlet.patient;

import com.oracle.pojo.Department;
import com.oracle.pojo.Doctor;
import com.oracle.pojo.Patients;
import com.oracle.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/patient/addAppointmentVerifyServlet")
public class AddAppointmentVerifyServlet extends HttpServlet {
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

        DepartmentService departmentService=new DepartmentServiceimpl();
        DoctorService doctorService=new DoctorServiceImpl();
        PatientService patientService=new PatientServiceimpl();

        Doctor doctor=doctorService.findDoctorById(DoctorId);
        Department departmentFirst=departmentService.findDepartmentById(DepartmentFirstId);
        Department departmentSecond=departmentService.findDepartmentById(DepartmentSecondId);
        Patients patients=patientService.selectPatientById(PatientId);

        req.setAttribute("departmentFirstName",departmentFirst.getDepartmentName());
        req.setAttribute("departmentSecondName",departmentSecond.getDepartmentName());
        req.setAttribute("patientFirstName",patients.getPatientName());
        req.setAttribute("patientSecondName",patients.getPatientName());

        req.getRequestDispatcher("/patient/addAppointmentVerify.jsp").forward(req, resp);

    }


}
