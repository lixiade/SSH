<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="cap.service.HelloWorld" %><%--
  Created by IntelliJ IDEA.
  User: fengf
  Date: 2018/10/12
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>spring IoC</title>
</head>
<body>
<%
    ServletContext servletContext = request.getSession().getServletContext();
    ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
    HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
%>
<%=helloWorld.sayHi("fengkun")%>
</body>
</html>
