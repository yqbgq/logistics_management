<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/11
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="front.jsp"%>
<fieldset class="layui-elem-field layui-field-title" style="margin:40px;width:90%">
    <legend>待审核列表</legend>
</fieldset>

<table class="layui-table" lay-even="" lay-skin="row" style="margin:40px;width:90%">

    <thead>
    <tr>
        <th>员工id</th>
        <th>员工姓名</th>
        <th>员工性别</th>
        <th>部门</th>
        <th>岗位</th>
        <th>联系电话</th>
        <th>联系邮箱</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="item" items="${list}" varStatus="status">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.sex}</td>
            <td>${item.department}</td>
            <td>${item.job}</td>
            <td>${item.phone}</td>
            <td>${item.email}</td>
            <td><button type="button" class="layui-btn" onclick="window.location.href = '/approve/${item.id}'"><i class="layui-icon"></i></button></td>
        </tr>
    </c:forEach>

    </tbody>
</table>

<script>
    layui.use(['element', 'layer'], function(){
        var element = layui.element;
        var layer = layui.layer;

        //监听折叠
        element.on('collapse(test)', function(data){
            layer.msg('展开状态：'+ data.show);
        });
    });
</script>
<%@include file="rear.jsp"%>
