package com.oracle.servlet.backend;

import com.oracle.pojo.Consultation;
import com.oracle.utils.DateUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

@WebServlet("/backend/addConsultationServlet")
public class AddConsultationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer patient_id = Integer.valueOf(req.getParameter("patientId"));
        Integer doctor_id = Integer.valueOf(req.getParameter("doctorId"));
        String consultation_time = req.getParameter("consultationTime");
        Date consultationTime = null;
        try {
            consultationTime = DateUtils.convertToDate(consultation_time);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Integer is_hospital_registered = Integer.valueOf(req.getParameter("isHospitalRegistered"));
        Integer is_hospitalized = Integer.valueOf(req.getParameter("isHospitalized"));
        String medical_advice_case = req.getParameter("medicalAdviceCase");

        Consultation consultation = new Consultation();
        consultation.setPatientId(patient_id);
        consultation.setDoctorId(doctor_id);
        consultation.setConsultationTime(consultationTime);
        consultation.setIsHospitalRegistered(is_hospital_registered);
        consultation.setIsHospitalized(is_hospitalized);
        consultation.setMedicalAdviceCase(medical_advice_case);

        resp.sendRedirect(req.getContextPath()+"/public/patient/consultationlist.jsp");
        //test
    }
}
