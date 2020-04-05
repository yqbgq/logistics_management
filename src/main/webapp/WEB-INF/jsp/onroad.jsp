<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/10
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>

<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="front.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div style="margin:auto;width:80%;">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>在途订单</legend>
    </fieldset>

    <div class="layui-card">

        <c:forEach var="item" items="${orders}" varStatus="status">
        <div class="layui-card-body" style="width:40%;float:left;background-color:#FFFAFA;margin-left:3%;margin-right:3%;margin-bottom:3%;">

            <div class="layui-card-header">
                <i class="layui-icon layui-icon-form" style="font-size: 18px; color: #1E9FFF;float:left;"></i>
                <p> &nbsp;&nbsp; 订单编号 ： ${item.id}<span class="layui-badge" style="float:right;margin-top:2%;">${item.company}</span></p>
            </div>

            <div class="layui-card-body">
                货物类型 ： ${item.type}<br/>
                目的地点 ： ${item.endPos}<br/>
                货物体积 ： ${item.volume} 方<br/>
                截止日期 ： ${item.endDate}<br/>
            </div>

        </div>
        </c:forEach>

    </div>
</div>


<%@include file="rear.jsp"%>