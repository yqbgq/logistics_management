<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="front.jsp"%>

<fieldset class="layui-elem-field layui-field-title" style="margin:20px;width:90%">
        <legend>最新通知</legend>
</fieldset>
<div class="layui-collapse" style="margin:20px;width:90%">

        <c:forEach var="item" items="${notices}" varStatus="status">
            <div class="layui-colla-item">
                <h2 class="layui-colla-title">抄送：${item.getDepartmentName()}&nbsp&nbsp&nbsp来自：${item.getFromuser()}</h2>
                <div class="layui-colla-content">
                   ${item.getContent()}
                </div>
            </div>
        </c:forEach>


</div>

<div style="float:left;width:45%;">
        <fieldset class="layui-elem-field layui-field-title" style="width:90%;margin:20px;">
                <legend>待办事项</legend>
        </fieldset>
        <ul class="layui-timeline" style="width:90%;margin:20px; ">

                <c:forEach var="item" items="${todolist}" varStatus="status">
                        <li class="layui-timeline-item">
                                <i class="layui-icon layui-timeline-axis"></i>
                                <div class="layui-timeline-content layui-text">
                                        <div class="layui-timeline-title">截止日期：${item.time}  ${item.content}</div>
                                </div>
                        </li>

                </c:forEach>

        </ul>
</div>


<div style="float:left;width:45%;">
        <fieldset class="layui-elem-field layui-field-title" style="margin:20px;width:90%;">
                <legend>最近消息</legend>
        </fieldset>
        <div class="layui-collapse" style="margin:20px;width:90%;">

                <c:forEach var="item" items="${messages}" varStatus="status">
                        <div class="layui-colla-item">
                                <h2 class="layui-colla-title">来自用户：${item.getFromuser()} </h2>
                                <div class="layui-colla-content">
                                        ${item.getMessage()}
                                </div>
                        </div>
                </c:forEach>

        </div>
</div>
<%@include file="rear.jsp"%>