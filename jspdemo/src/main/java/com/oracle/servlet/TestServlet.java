package com.oracle.servlet;

import com.oracle.pojo.Books;
import com.oracle.service.BooksService;
import org.apache.ibatis.annotations.Param;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/testServlet")
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BooksService booksService=new BooksService();
        List<Books> booksList=booksService.findAll();
        req.setAttribute("booksList", booksList);
        req.getRequestDispatcher("/Book.jsp").forward(req, resp);
    }





}
