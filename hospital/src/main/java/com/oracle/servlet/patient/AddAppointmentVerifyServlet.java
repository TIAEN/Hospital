package com.oracle.servlet.patient;

import com.oracle.pojo.BookAppointment;
import com.oracle.pojo.Department;
import com.oracle.pojo.Doctor;
import com.oracle.pojo.Patient;
import com.oracle.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


//确认界面
@WebServlet("/patient/addAppointmentVerifyServlet")
public class AddAppointmentVerifyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pDepartmentFirstId=req.getParameter("departmentFirstId");
        String pDepartmentSecondId=req.getParameter("departmentSecondId");
        String pPatientId=req.getParameter("patientId");
        String pDoctorId=req.getParameter("doctorId");
        String pFee=req.getParameter("fee");
        //System.out.println(pDoctorId+")))))))))))))))))))))");
        Integer DepartmentFirstId=null;
        Integer DepartmentSecondId=null;
        Integer PatientId=null;
        Integer DoctorId=null;
        BigDecimal Fee=null;

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
        if(pFee!=null&&!pFee.equals("")){
            Fee=BigDecimal.valueOf(Double.parseDouble(pFee));
        }

        //System.out.println(DoctorId+" "+PatientId+" "+DepartmentFirstId+" "+DepartmentSecondId+"//////////////");


        DepartmentService departmentService=new DepartmentServiceImpl();
        DoctorService doctorService=new DoctorServiceImpl();
        PatientService patientService=new PatientServiceImpl();


        Doctor doctor=doctorService.getDoctorById(DoctorId);
        Department departmentFirst=departmentService.findDepartmentById(DepartmentFirstId);
        Department departmentSecond=departmentService.findDepartmentById(DepartmentSecondId);
        Patient patients=patientService.findPatientByPatientId(PatientId);

        System.out.println(doctor+" "+departmentFirst+" "+departmentSecond+" "+patients+"/////////////////////");
        req.setAttribute("departmentFirstName",departmentFirst.getDepartmentName());
        req.setAttribute("departmentSecondName",departmentSecond.getDepartmentName());
        req.setAttribute("patientName",patients.getName());
        req.setAttribute("doctorName",doctor.getName());

        req.setAttribute("departmentFirstId",DepartmentFirstId);
        req.setAttribute("departmentSecondId",DepartmentSecondId);
        req.setAttribute("patientId",PatientId);
        req.setAttribute("doctorId",DoctorId);
        req.setAttribute("fee",Fee);



        Map<String, Integer> timeSlots = getTimeSlots();


        BookAppointmentService bookAppointmentService=new BookAppointmentServiceimpl();
        List<BookAppointment> bookAppointmentList=bookAppointmentService.getBookAppointmentAll();
        SimpleDateFormat inputFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
        SimpleDateFormat outputFormat = new SimpleDateFormat("HH:mm");

        for(BookAppointment bookAppointment:bookAppointmentList){
            String pdate=bookAppointment.getAppointmentDate().toString();
            Date sdate=null;
            String date=null;
            try {
                sdate = inputFormat.parse(pdate);;
                date = outputFormat.format(sdate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            timeSlots.put(date,bookAppointment.getBookNumber());
        }


        req.setAttribute("timeSlots", timeSlots);

        req.getRequestDispatcher("/public/patient/addAppointmentVerify.jsp").forward(req, resp);

    }


    private Map<String, Integer> getTimeSlots() {
        Map<String, Integer> timeSlots = new HashMap<>();

        // Generate time slots from 8:00 AM to 11:30 AM
        for (int hour = 8; hour <= 11; hour++) {
            for (int minute = 0; minute < 60; minute += 30) {
                String time = String.format("%02d:%02d", hour, minute);
                timeSlots.put(time, 5); // Initialize each time slot with 3 available slots
            }
        }

        // Generate time slots from 2:00 PM to 5:50 PM
        for (int hour = 14; hour <= 17; hour++) {
            for (int minute = 0; minute < 60; minute += 30) {
                String time = String.format("%02d:%02d", hour, minute);
                timeSlots.put(time, 5); // Initialize each time slot with 3 available slots
            }
        }

        return timeSlots;
    }
}
