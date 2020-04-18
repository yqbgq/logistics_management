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

    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>仓库列表</legend>
    </fieldset>

    <div class="layui-card">
        <c:forEach var="item" items="${companies}" varStatus="status">
            <div class="layui-card-body" style="width:30%;float:left;background-color:#FFFAFA;margin-left:3%;margin-right:3%;margin-bottom:3%;">
                <div class="layui-card-header">
                    <i class="layui-icon layui-icon-form" style="font-size: 18px; color: #1E9FFF;float:left;"></i>
                    <p> &nbsp;&nbsp; 公司名 ： ${item.name}<span class="layui-badge" style="float:right;margin-top:2%;"># ${item.id}</span></p>
                </div>
                <div class="layui-card-body">
                    联系人 ： ${item.person}<br/>
                    联系邮箱 ： ${item.email} <br/>
                    联系电话 ： ${item.phone} <br/>
                    公司地址 ： ${item.address} <br/>
                    额外描述 ： ${item.description}<br/>
                </div>
            </div>
        </c:forEach>
    </div>

</div>

<script src="./layui/layui.all.js" charset="utf-8"></script>
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