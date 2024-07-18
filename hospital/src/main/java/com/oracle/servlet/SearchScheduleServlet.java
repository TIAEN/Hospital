package com.oracle.servlet;

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


@WebServlet("/searchScheduleServlet")
public class SearchScheduleServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Schedule schedule = new Schedule();
        schedule.setDoctorId(null);
        schedule.setIsAvailable(null);


        String strDoctorId = req.getParameter("doctorId");
        String strIsAvailable = req.getParameter("isAvailable");

        if (strDoctorId!=null&&!"".equals(strDoctorId)){
            schedule.setDoctorId(Integer.valueOf(strDoctorId));
        }
        if (strIsAvailable!=null&&!"".equals(strIsAvailable)){
            schedule.setIsAvailable(Integer.valueOf(strIsAvailable));
        }

        ScheduleService scheduleService = new ScheduleServiceImpl();
        List<Schedule> scheduleList = scheduleService.selectSomeSchedule(schedule);


        req.setAttribute("searchList",scheduleList);
        req.getRequestDispatcher("/searchSchedule.jsp").forward(req,resp);

    }
}
