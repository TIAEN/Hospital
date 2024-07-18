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

@WebServlet("/backend/newUpdateScheduleServlet")
public class NewUpdateScheduleServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Integer scheduleId = Integer.parseInt(req.getParameter("scheduleId"));
        Integer doctorId = Integer.parseInt(req.getParameter("doctorId"));
        Integer departmentId = Integer.parseInt(req.getParameter("departmentId"));
        Integer isAvailable = Integer.parseInt(req.getParameter("isAvailable"));
        Integer visitCount = Integer.parseInt(req.getParameter("visitCount"));
        String remarks = req.getParameter("remarks");
        String strDate = req.getParameter("date");
        Date date = DateUtils.convertToDateLocal(strDate);
        Schedule newSchedule = new Schedule();
        newSchedule.setScheduleId(scheduleId);
        newSchedule.setDoctorId(doctorId);
        newSchedule.setDepartmentId(departmentId);
        newSchedule.setIsAvailable(isAvailable);
        newSchedule.setVisitCount(visitCount);
        newSchedule.setDate(date);
        newSchedule.setRemarks(remarks);
        ScheduleService scheduleService = new ScheduleServiceImpl();
        scheduleService.updateScheduleByScheduleId(newSchedule);
        resp.sendRedirect(req.getContextPath()+"/backend/rootScheduleServlet");
    }
}
