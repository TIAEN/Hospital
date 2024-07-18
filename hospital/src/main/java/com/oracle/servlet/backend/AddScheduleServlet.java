package com.oracle.servlet.backend;

import com.oracle.pojo.Schedule;
import com.oracle.service.ScheduleService;
import com.oracle.service.ScheduleServiceImpl;
import com.oracle.utils.DateUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/backend/addScheduleServlet")
public class AddScheduleServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Integer scheduleId = Integer.parseInt(req.getParameter("scheduleId"));
        Integer doctorId = Integer.parseInt(req.getParameter("doctorId"));
        Integer isAvailable = Integer.parseInt(req.getParameter("isAvailable"));

        String strDate = req.getParameter("date");
        Date date = DateUtils.convertToDateLocal(strDate);
        ScheduleService scheduleService = new ScheduleServiceImpl();
        Integer departmentId = scheduleService.selectDepartmentIdByDoctorId(doctorId);
        String departmentName = scheduleService.selectDepartmentNameByDepartmentId(departmentId);
        String doctorName = scheduleService.selectDoctorNameByDoctorId(doctorId);
        String yisheng = "医生";
        String remarks = doctorName + yisheng + departmentName;



        Schedule newSchedule = new Schedule();
        newSchedule.setScheduleId(scheduleId);
        newSchedule.setDoctorId(doctorId);
        newSchedule.setDepartmentId(departmentId);
        newSchedule.setIsAvailable(isAvailable);
        newSchedule.setDate(date);
        newSchedule.setRemarks(remarks);
        scheduleService.addSchedule(newSchedule);
        resp.sendRedirect(req.getContextPath()+"/backend/rootScheduleServlet");

    }
}
