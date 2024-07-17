package com.oracle.servlet.backend;

import com.oracle.pojo.Hospitalization;
import com.oracle.pojo.Patient;
import com.oracle.service.HospitalizationService;
import com.oracle.service.HospitalizationServiceImpl;
import com.oracle.service.PatientService;
import com.oracle.service.PatientServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/backend/hospitalizationDischargeServlet")
public class HospitalizationDischargeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phone=req.getParameter("phone");
        HospitalizationService hospitalizationService=new HospitalizationServiceImpl();
        Hospitalization hospitalization=new Hospitalization();
        hospitalization.setPatientPhone(phone);
        hospitalizationService.discharge(hospitalization);

        PatientService patientService=new PatientServiceImpl();
        Patient patient=new Patient();
        patient=patientService.selectPatientByPhone(phone);
        patientService.setArranged0(patient);
        resp.sendRedirect(req.getContextPath()+"/backend/hospitalizationListServlet");

    }
}
