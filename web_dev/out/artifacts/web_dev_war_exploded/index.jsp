<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/14
  Time: 1:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
    <title>Login and Registration</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Login and Registration Form with HTML5 and CSS3"/>
    <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class"/>
    <meta name="author" content="Codrops"/>
    <link rel="shortcut icon" href="../favicon.ico">
    <link rel="stylesheet" type="text/css" href="css/demo.css"/>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <link rel="stylesheet" type="text/css" href="css/animate-custom.css"/>


    <!-- location for #toRegister -->
    <script type="text/javascript">
        window.onload = function () {
            var location_id = '${location}';
            if (location_id !== '') {
                document.getElementById(location_id).click();
            }
        }
    </script>

</head>
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
        <h1 style=color:rgba(5,4,7,0.952)>Expert for Waste</h1>
        <h2 style=color:rgba(5,4,7,0.952)>Make It Easier</h2>
        <nav class="codrops-demos">
            <span style=color:rgba(29,44,65,1)>Click <strong>"Join us"</strong> to sign up</span>
            <a href="residentLoginServlet" class="current-demo">User</a>
            <a href="driverLoginServlet">Driver</a>
            <a href="managerLoginServlet">Manager</a>
        </nav>
    </header>
    <section>
        <div id="container_demo">
            <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
            <a class="hiddenanchor" id="toregister"></a>
            <a class="hiddenanchor" id="tologin"></a>
            <div id="wrapper">
                <div id="login" class="animate form">
                    <form action="residentLoginServlet" autocomplete="on" method="POST">
                        <h1>Log in</h1>
                        <p>
                            <label for="username" class="uname" data-icon="u"> Your email or username </label>
                            <input id="username" name="email" required="required" type="text"
                                   placeholder="myusername or mymail@mail.com"/>
                        </p>
                        <p>
                            <label for="password" class="youpasswd" data-icon="p"> Your password </label>
                            <input id="password" name="password" required="required" type="password"
                                   placeholder="eg. X8df!90EO"/>
                        </p>
                        <p class="keeplogin">
                            <input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping"/>
                            <label for="loginkeeping">Keep me logged in</label>
                        </p>
                        <%
                            String msg = (String) request.getAttribute("msg");
                        %>
                        <p class="login button">
                            <font color="red"><%=msg == null ? "" : msg%>
                            </font>
                            <input type="submit" value="Login"/>
                        </p>
                        <p class="change_link">
                            Not a member yet ?
                            <a href="#toregister" id="jumpRegister" class="to_register">Join us</a>
                        </p>
                    </form>
                </div>
                <!-- get register message -->
                <%
                    String registerMsg = (String) request.getAttribute("registerMsg");
                    HttpSession sess = request.getSession(false);
                    String userName = null;
                    String email = null;
                    String password = null;
                    String password_confirm= null;
                    String address = null;
                    String longitude = null;
                    String latitude = null;
                    String binVolume = null;

                    if(sess!=null){
                        userName = (String) sess.getAttribute("userName");
                        email = (String) sess.getAttribute("email");
                        password = (String) sess.getAttribute("password");
                        password_confirm = (String) sess.getAttribute("password_conform");
                        address = (String) sess.getAttribute("address");
                        longitude = (String) sess.getAttribute("longitude");
                        latitude = (String) sess.getAttribute("latitude");
                        binVolume = (String) sess.getAttribute("binVolume");
                    }
                %>
                <div id="register" class="animate form">
                    <form action="residentRegisterServlet" autocomplete="on" method="POST">
                        <h1> Sign up </h1>
                        <font color="red"><%=registerMsg == null ? "" : registerMsg%>
                        </font>
                        <p>
                            <label for="usernamesignup" class="uname" data-icon="u">Your username</label>
                            <%
                                if(userName==null){
                                    out.print("<input id=\"usernamesignup\" name=\"usernamesignup\" required=\"required\" type=\"text\" placeholder=\"mysuperusername690\"/>");
                                }
                                else{
                                    System.out.println("has username");
                                    out.print("<input id='usernamesignup' name='usernamesignup' required='required' type='text' value='"+ userName +"'/>");
                                }
                            %>
                        </p>
                        <p>
                            <label for="emailsignup" class="youmail" data-icon="e"> Your email</label>

                            <%
                                if(email==null){
                                    out.print("<input id=\"emailsignup\" name=\"emailsignup\" required=\"required\" type=\"email\" placeholder=\"mysupermail@mail.com\"/>");
                                }
                                else{
                                    out.print("<input id='emailsignup' name='emailsignup' required='required' type='email' placeholder='mysupermail@mail.com' value='"+ email +"'/>");
                                }
                            %>
                        </p>
                        <p>
                            <label for="passwordsignup" class="youpasswd" data-icon="p">Your password </label>

                            <%
                                if(password==null){
                                    out.print("<input id='passwordsignup' name='passwordsignup' required='required' type='password' placeholder='eg. X8df!90EO'/>");
                                }
                                else {
                                    out.print("<input id='passwordsignup' name='passwordsignup' required='required' type='password' placeholder='eg. X8df!90EO' value='"+ password +"'/>");
                                }
                            %>

                        </p>
                        <p>
                            <label for="passwordsignup_confirm" class="youpasswd" data-icon="p">Please confirm your password </label>

                            <%
                                if(password_confirm==null){
                                    out.print("<input id='passwordsignup_confirm' name='passwordsignup_confirm' required='required' type='password' placeholder='eg. X8df!90EO'/>");
                                }
                                else {
                                    out.print("<input id='passwordsignup_confirm' name='passwordsignup_confirm' required='required' type='password' placeholder='eg. X8df!90EO' value='" + password_confirm + "'/>");
                                }
                            %>
                        </p>
                        <p>
                            <label for="address" class="iconfont" &#xe604;>Home Adress</label>

                            <%
                                if(address==null){
                                    out.print("<input id='address' name='address' required='required' type='text' placeholder='eg. X1 Liverpool One'/>");
                                }
                                else {
                                    out.print("<input id='address' name='address' required='required' type='text' placeholder='eg. X1 Liverpool One' value='"+ address +"'/>");
                                }
                            %>

                        </p>
                        <p>
                            <label for="longitude" class="iconfont" &#xe604;>Home Logitude</label>
                            <%
                                if (longitude==null){
                                    out.print("<input id='longitude' name='longitude' required='required' type='text' placeholder='eg.2.9'/>");
                                }
                                else {
                                    out.print("<input id='longitude' name='longitude' required='required' type='text' placeholder='eg.2.9' value='"+ longitude +"'/>");
                                }
                            %>

                        </p>
                        <p>
                            <label for="latitude" class="iconfont" &#xe604;>Home Latitude</label>
                            <%
                                if (latitude==null){
                                    out.print("<input id='latitude' name='latitude' required='required' type='text' placeholder='eg.53.4'/>");
                                }
                                else {
                                    out.print("<input id='latitude' name='latitude' required='required' type='text' placeholder='eg.53.4' value='" + latitude + "'/>");
                                }
                            %>
                        </p>
                        <p>
                            <label for="bin" class="iconfont" &#xe604;>bin Volumn</label>
                            <%
                                if (binVolume == null){
                                    out.print("<input id='bin' name='binVolume' required='required' type='text' placeholder='eg. 30'/>");
                                }
                                else {
                                    out.print("<input id='bin' name='binVolume' required='required' type='text' placeholder='eg. 30' value='"+ binVolume +"'/>");
                                }
                            %>
                        </p>
                        <p class="signin button">
                            <input type="submit" value="Sign up"/>
                        </p>
                        <p class="change_link">
                            Already a member ?
                            <a href="#tologin" class="to_register"> Go and log in </a>
                        </p>
                    </form>
                </div>

            </div>
        </div>
    </section>
</div>
</body>
</html>

</html>
