package com.oracle.servlet.backend;

import com.alibaba.fastjson.JSONObject;
import com.oracle.service.AnnouncementService;
import com.oracle.service.AnnouncementServiceimpl;
import com.oracle.service.DepartmentService;
import com.oracle.service.DepartmentServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/backend/deleteAnnouncementServlet")
public class DeleteAnnouncementServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pid = req.getParameter("id");

        Integer id = Integer.parseInt(pid);
        //System.out.println("////////////////////////////////"+id);
        AnnouncementService announcementService = new AnnouncementServiceimpl();
        announcementService.deleteAnnouncement(id);
        DepartmentService departmentService=new DepartmentServiceimpl();
        departmentService.deleteDepartmentFirst(id);


        String json= JSONObject.toJSONString(1);
        resp.getWriter().println(json);
        resp.getWriter().flush();
        resp.getWriter().close();
    }
}
