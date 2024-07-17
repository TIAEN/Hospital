package com.oracle.servlet.patient;

import com.oracle.pojo.BookAppointment;
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


        DepartmentService departmentService=new DepartmentServiceimpl();
        DoctorService doctorService=new DoctorServiceImpl();
        PatientService patientService=new PatientServiceimpl();


        Doctor doctor=doctorService.findDoctorById(DoctorId);
        Department departmentFirst=departmentService.findDepartmentById(DepartmentFirstId);
        Department departmentSecond=departmentService.findDepartmentById(DepartmentSecondId);
        Patients patients=patientService.selectPatientById(PatientId);

        System.out.println(doctor+" "+departmentFirst+" "+departmentSecond+" "+patients+"/////////////////////");
        req.setAttribute("departmentFirstName",departmentFirst.getDepartmentName());
        req.setAttribute("departmentSecondName",departmentSecond.getDepartmentName());
        req.setAttribute("patientName",patients.getPatientName());
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

            //System.out.println(pdate+"::::::::::::::::::"+date);
            timeSlots.put(date,bookAppointment.getBookNumber());
        }


        req.setAttribute("timeSlots", timeSlots);

        req.getRequestDispatcher("/public/patient/addAppointmentVerify.jsp").forward(req, resp);

    }


    private Map<String, Integer> getTimeSlots() {
        Map<String, Integer> timeSlots = new HashMap<>();
        for (int hour = 0; hour < 24; hour++) {
            for (int minute = 0; minute < 60; minute += 15) {
                String time = String.format("%02d:%02d", hour, minute);
                timeSlots.put(time, 3); // 初始化每个时间段剩余3人
            }
        }
        return timeSlots;
    }
}
