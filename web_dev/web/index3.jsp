<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/17
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
    <title>Login and Registration</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
    <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
    <meta name="author" content="Codrops" />
    <link rel="shortcut icon" href="../favicon.ico">
    <link rel="stylesheet" type="text/css" href="css/demo.css" />
    <link rel="stylesheet" type="text/css" href="css/style3.css" />
    <link rel="stylesheet" type="text/css" href="css/animate-custom.css" />
<body>
<div class="container">
    <!-- Codrops top bar -->
    <div class="codrops-top">
        <a href="">
            <strong>&laquo; </strong>Home Page
        </a>
        <span class="right">
                    <a>
                        <strong>Welcome to use this system</strong>
                    </a>
                </span>
        <div class="clr"></div>
    </div><!--/ Codrops top bar -->
    <header>
        <h1 style = color:rgba(5,4,7,0.952)>Expert for Waste</h1>
        <h2 style = color:rgba(5,4,7,0.952)>Make It Easier</h2>
        <nav class="codrops-demos">
            <span style=color:rgba(29,44,65,1)>Click <strong>"Join us"</strong> to sign up</span>
            <a href="residentLoginServlet">User</a>
            <a href="driverLoginServlet">Driver</a>
            <a href="managerLoginServlet" class="current-demo">Manager</a>
        </nav>
    </header>
    <section>
        <div id="container_demo" >
            <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->

            <div id="wrapper">
                <div id="login" class="animate form">
                    <form  action="managerLoginServlet" autocomplete="on" method="POST">
                        <h1>Log in</h1>
                        <p>
                            <label for="username" class="uname" data-icon="u" > Your StaffNo </label>
                            <input id="username" name="staffNo" required="required" type="text" placeholder="myusername or mymail@mail.com"/>
                        </p>
                        <p>
                            <label for="password" class="youpasswd" data-icon="p"> Your password </label>
                            <input id="password" name="password" required="required" type="password" placeholder="eg. X8df!90EO" />
                        </p>
                        <p class="keeplogin">
                            <input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping" />
                            <label for="loginkeeping">Keep me logged in</label>
                        </p>
                        <%
                            String msg = (String) request.getAttribute("msg");
                        %>
                        <p class="login button">
                            <font color="red" > <%=msg==null?"":msg%> </font>
                            <input type="submit" value="Login" />
                        </p>
                    </form>
                </div>
</body>
</html>
