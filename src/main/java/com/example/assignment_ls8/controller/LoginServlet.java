package com.example.assignment_ls8.controller;

import com.example.assignment_ls8.common.Constant;
import com.example.assignment_ls8.model.ClientModel;
import com.example.assignment_ls8.pojo.Client;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    ClientModel clientModel = new ClientModel();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("Email");
        String password = request.getParameter("Password");
        Client client = clientModel.getClient(email, password);

        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(600);
        if(client != null){
            session.setAttribute(Constant.SESSION_FULLNAME_CLIENT, client.getFullName());
            session.setAttribute(Constant.SESSION_EMAIL_CLIENT, client.getEmail());
            session.setAttribute(Constant.SESSION_PASSWORD_CLIENT, client.getPassword());
            session.setAttribute(Constant.MESSAGE_IN_JSP, Constant.SESSION_SUCCESS_LOGIN);
//            response.sendRedirect(request.getContextPath() + "/show");
        } else{
            session.setAttribute(Constant.MESSAGE_IN_JSP, Constant.SESSION_FAILED_LOGIN);
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
    }
}
