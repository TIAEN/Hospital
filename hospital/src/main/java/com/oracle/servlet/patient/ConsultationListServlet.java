package com.oracle.servlet.patient;

import com.oracle.pojo.Patients;
import com.oracle.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/patient/consultationListServlet")
public class ConsultationListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String patientName=req.getParameter("patientName");
        ConsultationService consultationService=new ConsultationServiceImpl();
        PatientService patientService=new PatientServiceimpl();

        Patients patients=patientService.selectPatientByName(patientName);
        Integer patientId=patients.getPatientId();

        req.setAttribute("consultationList",consultationService.getConsultationsByPatientId(patientId));
        req.getRequestDispatcher("/public/patient/root_consultation.jsp").forward(req, resp);
    }




}
