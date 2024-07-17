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
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//确认界面
@WebServlet("/patient/addAppointmentVerifyServlet")
public class AddAppointmentVerifyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pDepartmentFirstId=req.getParameter("departmentFirstId");
        String pDepartmentSecondId=req.getParameter("departmentSecondId");
        String pPatientId=req.getParameter("patientId");
        String pDoctorId=req.getParameter("doctorId");
        //System.out.println(pDoctorId+")))))))))))))))))))))");
        Integer DepartmentFirstId=null;
        Integer DepartmentSecondId=null;
        Integer PatientId=null;
        Integer DoctorId=null;

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



        Map<String, Integer> timeSlots = getTimeSlots();


        BookAppointmentService bookAppointmentService=new BookAppointmentServiceimpl();
        List<BookAppointment> bookAppointmentList=bookAppointmentService.getBookAppointmentAll();
        for(BookAppointment bookAppointment:bookAppointmentList){
            String date=bookAppointment.getAppointmentDate().toString();
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
