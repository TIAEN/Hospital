package com.oracle.servlet.backend;

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

@WebServlet("/backend/announcementListServlet")
public class AnnouncementListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String strPageNum=req.getParameter("pageNum");
        Integer pageNum=1;
        Integer pageSize=3;
        if(strPageNum!=null && !strPageNum.equals("")){
            pageNum=Integer.parseInt(strPageNum);
        }


        AnnouncementService announcementService=new AnnouncementServiceimpl();
        PageInfo<Announcement> pageInfo=announcementService.list(pageNum,pageSize);
        req.setAttribute("pageInfo",pageInfo);
        req.setAttribute("announcementList",announcementService.findAllAnnouncement());
        req.getRequestDispatcher("/admin/announcement/list.jsp").forward(req, resp);

    }
}
