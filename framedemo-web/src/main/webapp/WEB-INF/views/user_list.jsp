<%--
  Created by allan
  User: allan
  Date: 2015/7/8
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page errorPage="user_list.jsp" contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
<table>
    <tr>
        <th>
            用户名
        </th>
        <th>
            添加时间
        </th>
    </tr>
    <tbody>
    <c:forEach items="${pageInfo.getContent()}" var="userBean">
        <tr>
            <td>${userBean.firstName+" "+userBean.lastName}</td>
            <td><fmt:formatDate value="${userBean.addTime}" type="both"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
