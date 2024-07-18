package com.oracle.servlet.backend;

import com.oracle.pojo.Schedule;
import com.oracle.service.ScheduleService;
import com.oracle.service.ScheduleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/backend/deleteScheduleViewServlet")
public class DeleteScheduleViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ScheduleService scheduleService = new ScheduleServiceImpl();
        Integer scheduleId = Integer.parseInt(req.getParameter("scheduleId"));
        Schedule schedule = scheduleService.selectOneScheduleByScheduleId(scheduleId);
        req.setAttribute("schedule",schedule);
        req.getRequestDispatcher("/admin/schedule/deleteSchedule.jsp").forward(req,resp);
    }
}
