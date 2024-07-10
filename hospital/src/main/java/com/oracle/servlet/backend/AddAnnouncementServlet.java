package com.oracle.servlet.backend;

import com.oracle.pojo.Announcement;
import com.oracle.service.AnnouncementService;
import com.oracle.service.AnnouncementServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/backend/addAnnouncementServlet")
public class AddAnnouncementServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String spid=req.getParameter("pid");
        String title=req.getParameter("announcementTitle");
        Integer pid=null;
        String content=req.getParameter("announcementContent");
        String creator=req.getParameter("announcementCreator");
        if(spid!=null&&!spid.equals("")){
            pid=Integer.parseInt(spid);
        }
        Announcement announcement=new Announcement();

        announcement.setAnnouncementContent(content);
        announcement.setAnnouncementCreator(creator);
        announcement.setAnnouncementId(pid);
        announcement.setAnnouncementTitle(title);
        announcement.setAnnouncementCreateTime(new Date());

        AnnouncementService announcementService=new AnnouncementServiceimpl();
        announcementService.addAnnouncement(announcement);
        //System.out.println("==========------------------"+announcement);
        resp.sendRedirect(req.getContextPath()+"/backend/rootAnnouncementServlet");

    }
}
