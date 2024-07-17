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

@WebServlet("/backend/addHospitalizationServlet")
public class AddHospitalizationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phone=req.getParameter("patientPhone");
        String patientName = req.getParameter("patientName");
        String roomNumber = req.getParameter("roomNumber");
        Float cost = Float.parseFloat(req.getParameter("cost"));
        Hospitalization hospitalization=new Hospitalization();
        hospitalization.setPatientPhone(phone);
        hospitalization.setRoomNumber(roomNumber);
        hospitalization.setPatientName(patientName);
        hospitalization.setCost(cost);
        HospitalizationService hospitalizationService=new HospitalizationServiceImpl();
        hospitalizationService.insertHospitalization(hospitalization);
        Patient patient=new Patient();
        patient.setPhone(phone);

        PatientService patientService=new PatientServiceImpl();
        patientService.setArranged1(patient);

        resp.sendRedirect(req.getContextPath()+"/backend/hospitalizationListServlet");
    }
}
