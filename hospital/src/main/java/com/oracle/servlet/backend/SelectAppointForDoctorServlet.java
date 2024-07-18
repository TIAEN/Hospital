package com.oracle.servlet.backend;

import com.oracle.pojo.Appointment;
import com.oracle.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/backend/selectAppointForDoctorServlet")
public class SelectAppointForDoctorServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pJobNumber=req.getParameter("jobNumber");
        Integer jobNumber=null;
        if(pJobNumber!=null&&!pJobNumber.equals("")){
            jobNumber=Integer.parseInt(pJobNumber);
        }

        AppointmentService appointmentService=new AppointmentServiceimpl();
        DoctorService doctorService=new DoctorServiceImpl();
        PatientService patientService=new PatientServiceImpl();

        Integer id=doctorService.getDoctorByJobNumber(pJobNumber).getDoctorId();
        List<Appointment> appointmentList=appointmentService.getAllOrderByDoctorId(id);

        System.out.println(appointmentList+"============================");

        for (Appointment appointment:appointmentList) {
            //System.out.println();
            appointment.setDoctorName(doctorService.findDoctorNameById(appointment.getDoctorId()));
            appointment.setPatientName(patientService.selectPatientNameById(appointment.getPatientId()));
            System.out.println(appointment);
        }



        req.setAttribute("appointmentList", appointmentList);
        req.getRequestDispatcher("/admin/doctor/appointList.jsp").forward(req, resp);

    }
}
