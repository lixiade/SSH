<%--
  Created by IntelliJ IDEA.
  User: fengf
  Date: 2018/11/7
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <s:iterator value="adminList" var="admin">
        <tr>
            <td><s:property value="#admin.id"/></td>
            <td><s:property value="#admin.username"/></td>
            <td><s:property value="#admin.password"/></td>
            <td><a href="edit?id=<s:property value="#admin.id"/>">edit</a></td>
            <td><a href="delete?id=<s:property value="#admin.id"/>">delete</a></td>
        </tr>
    </s:iterator>
</table>
<a href="addAdmin.jsp">addAdmin</a>
</body>
</html>
