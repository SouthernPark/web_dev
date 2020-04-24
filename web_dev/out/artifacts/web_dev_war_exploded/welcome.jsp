<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/13
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>

<h1>欢迎登录系统12341234</h1>

<%
    HttpSession sess = request.getSession();
    String staffNo = (String) sess.getAttribute("staffNo");
%>

<h1> staffNo<%=staffNo%> </h1>

</body>
</html>
