package com.oracle.servlet.backend;

import com.oracle.service.ConsultationService;
import com.oracle.service.ConsultationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/backend/addConsultationViewServlet")
public class AddConsultationViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ConsultationService consultationService=new ConsultationServiceImpl();
        Integer currentMaxConsultationId=consultationService.getCurrentMaxConsultationId();
        currentMaxConsultationId+=1;
        req.setAttribute("consultationId",currentMaxConsultationId);

        /*PatientService patientService = new PatientServiceimpl();
        Integer currentMaxPatientId=patientService.getCurrentMaxPatientId();
        currentMaxPatientId+=1;
        req.setAttribute("patientId",currentMaxPatientId);*/

        req.getRequestDispatcher("/admin/doctor/addConsultation.jsp").forward(req,resp);

    }
}
