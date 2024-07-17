package com.oracle.servlet.patient;

import com.oracle.pojo.Consultation;
import com.oracle.pojo.Doctor;
import com.oracle.pojo.Patient;
import com.oracle.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/patient/rootAddConsultationServlet")

public class RootAddConsultationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ConsultationService consultationService=new ConsultationServiceImpl();
        String strPatientId=req.getParameter("patientId");
        Integer patientId=null;

        if(strPatientId!=null && !"".equals(strPatientId)){
            patientId=Integer.parseInt(strPatientId);
        }

        req.setAttribute("patientId",patientId);
        List<Consultation> testList=consultationService.getConsultationsByPatientId(patientId);
        DoctorService doctorService=new DoctorServiceImpl();
        DepartmentService departmentService=new DepartmentServiceImpl();

        for (int i = 0; i <testList.size() ; i++) {
            Integer doctorId=testList.get(i).getDoctorId();
            Doctor doctor =doctorService.getDoctorById(doctorId);
            Integer departmentId=doctor.getDepartmentId();
            String departmentName=departmentService.findDepartmentById(departmentId).getDepartmentName();
            testList.get(i).setDepartmentName(departmentName);
            String doctorName=doctor.getName();
            testList.get(i).setDoctorName(doctorName);
        }


        req.setAttribute("rootConsultationList",testList);
        req.getRequestDispatcher("/public/patient/root_consultation.jsp").forward(req, resp);
    }
}
