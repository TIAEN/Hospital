package com.oracle.servlet.patient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/patient/appointCheckNumberByTimeServlet")
public class AppointCheckNumberByTimeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, Integer> timeSlots = getTimeSlots();
        req.setAttribute("timeSlots", timeSlots);
        req.getRequestDispatcher("/public/patient/addAppointmentVerify.jsp").forward(req, resp);

    }
    private Map<String, Integer> getTimeSlots() {
        Map<String, Integer> timeSlots = new HashMap<>();
        for (int hour = 0; hour < 24; hour++) {
            for (int minute = 0; minute < 60; minute += 15) {
                String time = String.format("%02d:%02d", hour, minute);
                timeSlots.put(time, 5); // 初始化每个时间段剩余5人
            }
        }
        return timeSlots;
    }
}
