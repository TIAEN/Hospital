package com.oracle.servlet.patient;

import com.oracle.pojo.BookAppointment;
import com.oracle.pojo.Department;
import com.oracle.pojo.Doctor;
import com.oracle.pojo.Patients;
import com.oracle.service.*;
import com.oracle.utils.DateUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


//确认界面
@WebServlet("/patient/addAppointmentVerifyServlet")
public class AddAppointmentVerifyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pDepartmentFirstId = req.getParameter("departmentFirstId");
        String pDepartmentSecondId = req.getParameter("departmentSecondId");
        String pPatientId = req.getParameter("patientId");
        String pDoctorId = req.getParameter("doctorId");
        String pFee = req.getParameter("fee");

        //System.out.println(pDoctorId+")))))))))))))))))))))");
        Integer DepartmentFirstId = null;
        Integer DepartmentSecondId = null;
        Integer PatientId = null;
        Integer DoctorId = null;
        BigDecimal Fee = null;

        if (pDepartmentFirstId != null && !pDepartmentFirstId.equals("")) {
            DepartmentFirstId = Integer.parseInt(pDepartmentFirstId);
        }
        if (pDepartmentSecondId != null && !pDepartmentSecondId.equals("")) {
            DepartmentSecondId = Integer.parseInt(pDepartmentSecondId);
        }
        if (pPatientId != null && !pPatientId.equals("")) {
            PatientId = Integer.parseInt(pPatientId);
        }
        if (pDoctorId != null && !pDoctorId.equals("")) {
            DoctorId = Integer.parseInt(pDoctorId);
        }
        if (pFee != null && !pFee.equals("")) {
            Fee = BigDecimal.valueOf(Double.parseDouble(pFee));
        }


        //System.out.println(DoctorId+" "+PatientId+" "+DepartmentFirstId+" "+DepartmentSecondId+"//////////////");


        DepartmentService departmentService = new DepartmentServiceimpl();
        DoctorService doctorService = new DoctorServiceImpl();
        PatientService patientService = new PatientServiceimpl();


        Doctor doctor = doctorService.findDoctorById(DoctorId);
        Department departmentFirst = departmentService.findDepartmentById(DepartmentFirstId);
        Department departmentSecond = departmentService.findDepartmentById(DepartmentSecondId);
        Patients patients = patientService.selectPatientById(PatientId);

        System.out.println(doctor + " " + departmentFirst + " " + departmentSecond + " " + patients + "/////////////////////");
        req.setAttribute("departmentFirstName", departmentFirst.getDepartmentName());
        req.setAttribute("departmentSecondName", departmentSecond.getDepartmentName());
        req.setAttribute("patientName", patients.getPatientName());
        req.setAttribute("doctorName", doctor.getName());

        req.setAttribute("departmentFirstId", DepartmentFirstId);
        req.setAttribute("departmentSecondId", DepartmentSecondId);
        req.setAttribute("patientId", PatientId);
        req.setAttribute("doctorId", DoctorId);
        req.setAttribute("fee", Fee);


        // 设置初始人数
        int initialSlots = 3;
        // 获取当前日期
        LocalDate currentDate = LocalDate.now();

        for (int i = 0; i < 5; i++) {
            LocalDate date = currentDate.plusDays(i);
            generateTimeSlotsForFiveDays(date, initialSlots);
        }
        List<TimeSlot> timeSlotsFromBackend = generateTimeSlotsForFiveDays(currentDate, initialSlots);
        System.out.println("______________________________________");
        for (TimeSlot slot : timeSlotsFromBackend) {
            System.out.println(slot);
        }

        //Map<String, Integer> timeSlots = null;



        BookAppointmentService bookAppointmentService = new BookAppointmentServiceimpl();
        List<BookAppointment> bookAppointmentList = bookAppointmentService.getBookAppointmentAll();


        req.setAttribute("timeSlotsFromBackend", timeSlotsFromBackend);

        req.getRequestDispatcher("/public/patient/addAppointmentVerify.jsp").forward(req, resp);

    }

    public static List<TimeSlot> generateTimeSlotsForFiveDays(LocalDate startDate, int initialSlots) {
        List<TimeSlot> timeSlots = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        BookAppointmentService bookAppointmentService = new BookAppointmentServiceimpl();

        for (int day = 0; day < 5; day++) {
            LocalDate currentDate = startDate.plusDays(day);
            LocalTime startTimeAM = LocalTime.of(8, 0);
            LocalTime endTimeAM = LocalTime.of(12, 0);
            LocalTime startTimePM = LocalTime.of(14, 0);
            LocalTime endTimePM = LocalTime.of(18, 0);

            // Generate AM time slots
            LocalTime currentTime = startTimeAM;
            while (currentTime.isBefore(endTimeAM)) {
                String formattedTime = currentDate.atTime(currentTime).format(formatter);
                System.out.println(formattedTime);
                Date date= DateUtils.convertToDateLocal(formattedTime);

                if(bookAppointmentService.isExistBookAppointmentByDate(date))
                {
                    timeSlots.add(new TimeSlot(formattedTime,bookAppointmentService.getBookAppointmentByDate(date).getBookNumber()));
                }
                else {
                    timeSlots.add(new TimeSlot(formattedTime, initialSlots));
                }

                currentTime = currentTime.plusMinutes(15);
            }

            // Generate PM time slots
            currentTime = startTimePM;
            while (currentTime.isBefore(endTimePM)) {
                String formattedTime = currentDate.atTime(currentTime).format(formatter);
                Date date= DateUtils.convertToDateLocal(formattedTime);
                if(bookAppointmentService.isExistBookAppointmentByDate(date)){
                    timeSlots.add(new TimeSlot(formattedTime,bookAppointmentService.getBookAppointmentByDate(date).getBookNumber()));
                }
                else {
                    timeSlots.add(new TimeSlot(formattedTime, initialSlots));
                }
                currentTime = currentTime.plusMinutes(15);
            }
        }

        return timeSlots;
    }
}
    class TimeSlot {
        private String dateTime;
        private int remainingSlots;

        public TimeSlot(String dateTime, int remainingSlots) {
            this.dateTime = dateTime;
            this.remainingSlots = remainingSlots;
        }

        @Override
        public String toString() {
            return dateTime + " - 剩余" + remainingSlots + "人";
        }
    }
