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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/backend/addScheduleViewServlet")
public class AddScheduleViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ScheduleService scheduleService = new ScheduleServiceImpl();
        Integer maxScheduleId = scheduleService.selectMaxScheduleId();
        List<Schedule> scheduleList = new ArrayList<Schedule>();
        List<Integer> doctorIdList = scheduleService.selectDoctorIdList();
        int i = 0;
        for (Integer doctorId : doctorIdList){
            String doctorName = scheduleService.selectDoctorNameByDoctorId(doctorId);
            Integer departmentId = scheduleService.selectDepartmentIdByDoctorId(doctorId);
            String departmentName = scheduleService.selectDepartmentNameByDepartmentId(departmentId);
            Schedule schedule = new Schedule();
            schedule.setDoctorId(doctorId);
            schedule.setDepartmentId(departmentId);
            schedule.setRemarks(doctorName + "医生" + departmentName);
            scheduleList.add(i,schedule);
            i = i + 1;
        }
        req.setAttribute("scheduleList",scheduleList);
        req.setAttribute("scheduleId",maxScheduleId + 1);
        req.getRequestDispatcher("/admin/schedule/addSchedule.jsp").forward(req,resp);


    }
}
