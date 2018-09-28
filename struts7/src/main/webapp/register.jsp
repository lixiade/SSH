<%--
  Created by IntelliJ IDEA.
  User: fengf
  Date: 2018/9/28
  Time: 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title><s:text name="register.page"/></title>
</head>
<body>
<h2>
    <s:text name="register.title"/>
</h2>
<s:form action="register" method="POST">
    <s:textfield name="user.name" key="username"/>
    <s:password name="user.password" key="password"/>
    <s:password name="user.repassword" key="repassword"/>
    <s:submit key="submit"/>
</s:form>
</body>
</html>
