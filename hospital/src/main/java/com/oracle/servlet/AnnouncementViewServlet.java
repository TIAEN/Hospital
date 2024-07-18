package com.oracle.servlet;

import com.github.pagehelper.PageInfo;
import com.oracle.pojo.Announcement;
import com.oracle.service.AnnouncementService;
import com.oracle.service.AnnouncementServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/announcementViewServlet")
public class AnnouncementViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String patientId=req.getParameter("patientId");
        String jobNumber=req.getParameter("jobNumber");

        AnnouncementService announcementService=new AnnouncementServiceimpl();

        List<Announcement> announcementList=announcementService.selectFiveByDate();

        req.setAttribute("patientId",patientId);

        req.setAttribute("jobNumber",jobNumber);

        req.setAttribute("announcementList",announcementList);

        req.getRequestDispatcher("/announcementView.jsp").forward(req, resp);
    }
}
