<%@ page import="com.example.assignment_ls8.common.Constant" %><%--
  Created by IntelliJ IDEA.
  User: macmie
  Date: 13/05/2022
  Time: 03:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!-- Created By CodingNepal -->
<html lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
    <title>Login and Registration Form in HTML</title>
    <link rel="stylesheet" href="login.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<div class="wrapper">
    <div class="title-text">
        <div class="title login">
            Login Form
        </div>
        <div class="title signup">
            Signup Form
        </div>
    </div>
    <div class="form-container">
        <div class="slide-controls">
            <input type="radio" name="slide" id="login" checked>
            <input type="radio" name="slide" id="signup">
            <label for="login" class="slide login">Login</label>
            <label for="signup" class="slide signup">Signup</label>
            <div class="slider-tab"></div>
        </div>
        <div class="form-inner">
            <form action="" method="post" class="get">
                <div class="field">
                    <input type="text" placeholder="Email Address" name="Email" required>
                </div>
                <div class="field">
                    <input type="password" placeholder="Password" name="Password" required>
                </div>
                <div class="pass-link">
                    <%
                        String message = "";
                        if(request.getAttribute(Constant.MESSAGE_IN_JSP) != null){
                            message = (String) request.getAttribute(Constant.MESSAGE_IN_JSP);
                        }
                    %>
                    <a><%= message%></a>
                </div>
                <div class="field btn">
                    <div class="btn-layer"></div>
                    <input type="submit" value="Login">
                </div>
<%--                <div class="signup-link">--%>
<%--                    Not a member? <a href="">Signup now</a>--%>
<%--                </div>--%>
            </form>
            <form action="#" class="signup">
                <div class="field">
                    <input type="text" placeholder="Email Address" required>
                </div>
                <div class="field">
                    <input type="password" placeholder="Password" required>
                </div>
                <div class="field">
                    <input type="password" placeholder="Confirm password" required>
                </div>
                <div class="field btn">
                    <div class="btn-layer"></div>
                    <input type="submit" value="Signup">
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    const loginText = document.querySelector(".title-text .login");
    const loginForm = document.querySelector("form.login");
    const loginBtn = document.querySelector("label.login");
    const signupBtn = document.querySelector("label.signup");
    const signupLink = document.querySelector("form .signup-link a");
    signupBtn.onclick = (()=>{
        loginForm.style.marginLeft = "-50%";
        loginText.style.marginLeft = "-50%";
    });
    loginBtn.onclick = (()=>{
        loginForm.style.marginLeft = "0%";
        loginText.style.marginLeft = "0%";
    });
    signupLink.onclick = (()=>{
        signupBtn.click();
        return false;
    });
</script>
</body>
</html>
