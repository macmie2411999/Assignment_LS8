package com.example.assignment_ls8.filter;

import com.example.assignment_ls8.common.Constant;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.example.assignment_ls8.common.Constant.SESSION_SUCCESS_LOGIN;

@WebFilter("/login")
public class AuthFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(request, response);
        HttpServletRequest requestHttp = (HttpServletRequest) request;
        HttpServletResponse responseHttp = (HttpServletResponse) response;

        HttpSession session = requestHttp.getSession();
        if(session.getAttribute(Constant.MESSAGE_IN_JSP).equals(Constant.SESSION_SUCCESS_LOGIN)){
            responseHttp.sendRedirect(requestHttp.getContextPath() + "/show");
        } else{
            chain.doFilter(requestHttp, responseHttp);
        }

    }
}
