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
        <legend>仓库列表</legend>
    </fieldset>

    <div class="layui-card">

        <c:forEach var="item" items="${warehouses}" varStatus="status">
        <a href="/warehousedetail/${item.id}">
            <div class="layui-card-body" style="width:40%;float:left;background-color:#FFFAFA;margin-left:3%;margin-right:3%;margin-bottom:3%;">
                <div class="layui-card-header">
                    <i class="layui-icon layui-icon-component" style="font-size: 18px; color: #1E9FFF;float:left;"></i>
                    <p> &nbsp;&nbsp; ${item.id} - ${item.pos} - ${item.name}</p>
                </div>
                <div class="layui-progress" lay-showPercent="yes" style="width:70%;margin-left:5%;">
                    <div class="layui-progress-bar layui-bg-red" lay-percent="${(item.size / item.capacity) * 100}%"></div>
                </div>
                <div style="width:70%;margin-left:5%;margin-top:3%;">
                    总容量 ： ${item.capacity} &nbsp;&nbsp; 剩余容量 ： ${item.size} &nbsp;&nbsp;
                </div>
            </div>
        </a>
        </c:forEach>

    </div>

</div>

<script src="./layui/layui.all.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script src="./layui/jquery.js" charset="utf-8"></script>

<script>
    layui.use(['form', 'layedit', 'laydate'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate;
        //日期
        laydate.render({
            elem: '#date'
        });
        laydate.render({
            elem: '#date1'
        });


    });
</script>


<div class="layui-footer">
    <!-- 底部固定区域 -->
    鸣谢：LayUI
</div>
</div>

</body>
</html>