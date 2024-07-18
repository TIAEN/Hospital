package com.oracle.servlet.backend;

import com.github.pagehelper.PageInfo;
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

@WebServlet("/backend/rootScheduleServlet")
public class RootScheduleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String strPageNum=req.getParameter("pageNum");
        Integer pageNum=1;      //默认页数
        Integer pageSize=5;

        //判断是否能够获取得到page页的信息
        if(strPageNum!=null&&!"".equals(strPageNum)){
            pageNum=Integer.parseInt(strPageNum);
        }
        ScheduleService scheduleService = new ScheduleServiceImpl();
        List<Schedule> scheduleList=scheduleService.findScheduleAll();
        Integer totalNum=scheduleList.size();

        for (Schedule schedule : scheduleList) {//根据预约表来修改排班内每个医生的预约数量

            schedule.setVisitCount(scheduleService.selectPatientCountByDoctorId(schedule.getDoctorId()));
            scheduleService.updateScheduleByScheduleId(schedule);
        }


        PageInfo<Schedule> pageInfo=scheduleService.list(pageNum,pageSize);

        req.setAttribute("scheduleList",scheduleList);
        req.setAttribute("totalNum",totalNum);
        req.setAttribute("rootScheduleList",pageInfo.getList());
        req.setAttribute("pageInfo",pageInfo);

        req.getRequestDispatcher("/admin/schedule/root_schedule.jsp").forward(req,resp);
    }
}
