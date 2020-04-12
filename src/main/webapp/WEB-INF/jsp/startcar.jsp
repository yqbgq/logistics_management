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

<div style="float:left;margin:30px;width:100%;">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
        <legend>待发出车辆</legend>
    </fieldset>

    <table class="layui-table" lay-even="" lay-skin="row" >
        <colgroup>
            <col width="120">
            <col width="100">
            <col width="120">
            <col width="120">
            <col width="150">
            <col width="120">
            <col width="400">
            <col width="200">
        </colgroup>
        <thead>
        <tr>
            <th style="text-align:center;margin:auto">车辆牌照</th>
            <th style="text-align:center;margin:auto">车辆类型</th>
            <th style="text-align:center;margin:auto">车长（米）</th>
            <th style="text-align:center;margin:auto">剩余空间（立方）</th>
            <th style="text-align:center;margin:auto">离港日期</th>
            <th style="text-align:center;margin:auto">当前位置</th>
            <th style="text-align:center;margin:auto">计划详情</th>
            <th style="text-align:center;margin:auto">选择</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${cars}" varStatus="status">
            <c:if test="${item.id!=-1}">
                <tr>
                    <td style="text-align:center;margin:auto">${item.number}</td>
                    <td style="text-align:center;margin:auto">${item.type}</td>
                    <td style="text-align:center;margin:auto">${item.length}</td>
                    <td style="text-align:center;margin:auto">${item.size}</td>
                    <td style="text-align:center;margin:auto">${item.awaydate}</td>
                    <td style="text-align:center;margin:auto">${item.currents}</td>
                    <td style="text-align:center;margin:auto">${item.tags}</td>
                    <form action="/startcarcheck/${item.id}" method="post">
                        <td style="text-align:center;margin:auto"><button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">发出</button></td>
                    </form>
                </tr>
            </c:if>
        </c:forEach>
        </tbody>
    </table>


</div>



<script src="./layui/layui.all.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script src="./layui/jquery.js" charset="utf-8"></script>

<script>
    function addInput(formName,name, value) {
        var tempInput = document.createElement("input");
        tempInput.name = name;
        tempInput.value = value;
        return tempInput;
    }
</script>

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
