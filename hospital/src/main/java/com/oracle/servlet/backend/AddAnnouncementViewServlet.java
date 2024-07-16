package com.oracle.servlet.backend;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/backend/addAnnouncementViewServlet")
public class AddAnnouncementViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pid = req.getParameter("pid");
        req.setAttribute("pid", pid);
        req.getRequestDispatcher("/admin/announcement/add.jsp").forward(req, resp);
    }
}
