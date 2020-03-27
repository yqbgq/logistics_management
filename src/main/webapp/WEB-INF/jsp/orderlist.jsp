<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="front.jsp"%>



<fieldset class="layui-elem-field layui-field-title" style="margin:40px;width:90%">
    <legend>待审核订单</legend>
</fieldset>

<table class="layui-table" lay-even="" lay-skin="row" style="margin:40px;width:90%">

    <thead>
    <tr>
        <th style="text-align:center;margin:auto">订单ID</th>
        <th style="text-align:center;margin:auto">委托方</th>
        <th style="text-align:center;margin:auto">起始地点</th>
        <th style="text-align:center;margin:auto">目的地点</th>
        <th style="text-align:center;margin:auto">货物类型</th>
        <th style="text-align:center;margin:auto">截止日期</th>
        <th style="text-align:center;margin:auto">详细信息</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="item" items="${orders}" varStatus="status">
    <tr>
        <td style="text-align:center;margin:auto">${item.id}</td>
        <td style="text-align:center;margin:auto">${item.company}</td>
        <td style="text-align:center;margin:auto">${item.startPos}</td>
        <td style="text-align:center;margin:auto">${item.endPos}</td>
        <td style="text-align:center;margin:auto">${item.type}</td>
        <td style="text-align:center;margin:auto">${item.endDate}</td>
        <td style="text-align:center;margin:auto"><button type="button" class="layui-btn" onclick="window.location.href = '/ordercheck/${item.id}'"><i class="layui-icon"></i></button></td>
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