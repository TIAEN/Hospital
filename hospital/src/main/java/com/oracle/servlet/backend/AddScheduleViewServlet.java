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
import java.util.List;

@WebServlet("/backend/addScheduleViewServlet")
public class AddScheduleViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ScheduleService scheduleService = new ScheduleServiceImpl();
        Integer maxScheduleId = scheduleService.selectMaxScheduleId();
        List<Schedule> scheduleList = scheduleService.findScheduleAll();
        req.setAttribute("scheduleList",scheduleList);
        req.setAttribute("scheduleId",maxScheduleId + 1);
        req.getRequestDispatcher("/admin/schedule/addSchedule.jsp").forward(req,resp);


    }
}
