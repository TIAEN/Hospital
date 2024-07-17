package com.oracle.servlet.patient;

import com.alibaba.fastjson.JSONObject;
import com.oracle.pojo.Appointment;
import com.oracle.service.AppointmentService;
import com.oracle.service.AppointmentServiceimpl;
import com.oracle.service.BookAppointmentService;
import com.oracle.service.BookAppointmentServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/patient/cancelAppointmentServlet")
public class CancelAppointmentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String appointmentId=req.getParameter("appointmentId");
        String sPatientId=req.getParameter("patientId");

        Integer id=null;
        Integer patientId=null;

        if(appointmentId!=null &&!appointmentId.equals("")){
            id=Integer.parseInt(appointmentId);
        }
        if(patientId!=null &&!patientId.equals("")){
            patientId=Integer.parseInt(sPatientId);
        }

        AppointmentService appointmentService=new AppointmentServiceimpl();
        BookAppointmentService bookAppointmentService=new BookAppointmentServiceimpl();


        bookAppointmentService.updateBookAppointmentAdd(appointmentService.getAppointmentById(id).getAppointmentDate());
        appointmentService.cancelAppointment(id);
        List<Appointment> appointmentList=appointmentService.appointmentListByPatientId(patientId);

        String json = JSONObject.toJSONString(appointmentList);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);

    }
}
