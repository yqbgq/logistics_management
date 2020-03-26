<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="front.jsp"%>

<div style="width:80%;margin:20px;text-align:center;margin:auto">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
        <legend>车辆列表</legend>
    </fieldset>

    <table class="layui-table" lay-even="" lay-skin="row" >
        <colgroup>
            <col width="150">
            <col width="150">
            <col width="150">
            <col width="150">
            <col width="200">
            <col>
        </colgroup>
        <thead>
        <tr>
            <th style="text-align:center;margin:auto">车辆编号</th>
            <th style="text-align:center;margin:auto">车辆牌照</th>
            <th style="text-align:center;margin:auto">司机</th>
            <th style="text-align:center;margin:auto">联系电话</th>
            <th style="text-align:center;margin:auto">详细</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${carList}" varStatus="status">
            <tr>
                <td>${item.id}</td>
                <td>${item.number}</td>
                <td>${item.driver}</td>
                <td>${item.phone}</td>
                <td><button type="button" class="layui-btn" onclick="window.location.href = '/cardetail/${item.id}'"><i class="layui-icon">查看详情</i></button></td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<%@include file="rear.jsp"%>
