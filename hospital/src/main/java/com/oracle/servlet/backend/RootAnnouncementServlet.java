package com.oracle.servlet.backend;

import com.oracle.service.AnnouncementService;
import com.oracle.service.AnnouncementServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/backend/rootAnnouncementServlet")
public class RootAnnouncementServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AnnouncementService announcementService=new AnnouncementServiceimpl();

        req.setAttribute("rootAnnouncementList",announcementService.findAllAnnouncement());

        //System.out.println("_____---------------------"+announcementService.findAllAnnouncement());
        req.getRequestDispatcher("/admin/announcement/root_announcement.jsp").forward(req, resp);

    }
}
