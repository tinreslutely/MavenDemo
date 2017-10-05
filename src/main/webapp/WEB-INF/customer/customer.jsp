<%--
  Created by IntelliJ IDEA.
  User: lixiaoyi
  Date: 2017/9/29
  Time: 下午10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="BASE" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>客户管理</title>
</head>
<body>
    <h1>客户列表</h1>
    <table>
        <tr>客户名称</tr>
        <tr>联系人</tr>
        <tr>电话号码</tr>
        <tr>邮箱地址</tr>
        <tr>操作</tr>
    </table>
    <c:forEach var="customer" items="${customerList}">
        <tr>
            <td>${customer.name}</td>
            <td>${customer.contract}</td>
            <td>${customer.telephone}</td>
            <td>${customer.email}</td>
            <td>
                <a href="${BASE}/customer_edit?id=${customer.id}">编辑</a>
                <a href="${BASE}/customer_delete?id=${customer.id}">删除</a>

            </td>
        </tr>
    </c:forEach>
</body>
</html>
