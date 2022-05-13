<%@ page import="com.example.assignment_ls8.common.Constant" %><%--
  Created by IntelliJ IDEA.
  User: macmie
  Date: 13/05/2022
  Time: 04:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!-- Created By CodingNepal -->
<html lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
    <title>Login and Registration Form in HTML | CodingNepal</title>
    <link rel="stylesheet" href="showclient.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<div class="wrapper">
    <div class="title-text">
        <div class="title login">
            Hello There!
        </div>
    </div>
    <div class="form-container">
        <div class="slide-controls">
            <input type="radio" name="slide" id="login" checked>
            <label for="login" class="slide login">Client Information</label>
            <div class="slider-tab"></div>
        </div>
        <div class="form-inner">
            <form action="" method="post" class="login">
                <div class="slide login">
                    Name: <%= session.getAttribute(Constant.SESSION_FULLNAME_CLIENT)%>
                </div>
                <div class="slide login">
                    Email: <%= session.getAttribute(Constant.SESSION_EMAIL_CLIENT)%>
                </div>
                <div class="slide login">
                    Password: <%= session.getAttribute(Constant.SESSION_PASSWORD_CLIENT)%>
                </div>

                <div class="field btn">
                    <div class="btn-layer"></div>
                    <input type="submit" name="Logout" value="Logout">
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
