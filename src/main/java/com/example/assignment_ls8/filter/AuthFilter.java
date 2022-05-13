package com.example.assignment_ls8.filter;

import com.example.assignment_ls8.common.Constant;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class AuthFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest requestHttp = (HttpServletRequest) request;
        HttpServletResponse responseHttp = (HttpServletResponse) response;
        HttpSession session = requestHttp.getSession();
        if (!requestHttp.getServletPath().startsWith("/login")) {
            // if link does not contain /login
            if ((session.getAttribute(Constant.MESSAGE_IN_JSP) != null) &&
                    (session.getAttribute(Constant.MESSAGE_IN_JSP).equals(Constant.SESSION_SUCCESS_LOGIN))) {
                chain.doFilter(requestHttp, responseHttp);
            } else {
                responseHttp.sendRedirect(requestHttp.getContextPath() + "/login");
            }
        } else {
//            chain.doFilter(requestHttp, responseHttp);
            // if link contains /login
            if (session.getAttribute(Constant.MESSAGE_IN_JSP) != null) {
                if (session.getAttribute(Constant.MESSAGE_IN_JSP).equals(Constant.SESSION_SUCCESS_LOGIN)) {
                    System.out.println("Passed Filter!");
                    responseHttp.sendRedirect(requestHttp.getContextPath() + "/show");
                }
            } else {
                chain.doFilter(requestHttp, responseHttp);
            }
        }
    }
}
