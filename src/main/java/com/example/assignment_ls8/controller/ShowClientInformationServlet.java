package com.example.assignment_ls8.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/show")
public class ShowClientInformationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("showclient.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("Logout").equals("Logout")) {
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }
}
