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
        <legend>订单收款</legend>
    </fieldset>

    <div class="layui-card">


        <c:forEach var="item" items="${pays}" varStatus="status">
            <div class="layui-card-body" style="width:30%;float:left;background-color:#FFFAFA;margin-left:3%;margin-right:3%;margin-bottom:3%;">
                <div class="layui-card-header">
                    <i class="layui-icon layui-icon-cart-simple" style="font-size: 18px; color: #1E9FFF;float:left;"></i>
                    <p> &nbsp;&nbsp; 订单编号 ： ${item.id}<span class="layui-badge" style="float:right;margin-top:2%;">${item.company}</span></p>
                </div>

                <div class="layui-card-body">
                    <form class="layui-form" name="form" action="/payordercheck/${item.id}" method="post">
                    货物类型 ： ${item.type}<br/>
                    目的地点 ： ${item.endPos}<br/>
                    联系人 ： ${companies.get(item.company).person}<br/>
                    联系电话 ： ${companies.get(item.company).phone}<br/>
                    公司地址 ： ${companies.get(item.company).address}<br/>
                    订单总价 ： ${item.price}元<br/>
                        <input style="display:none" value="${item.price}" name="total">
                        <div class="layui-form-item">
                            <select name="methodId" lay-verify="required" lay-search="">
                                <option value="0">选择支付方式 </option>
                                <c:forEach var="method" items="${methods}" >
                                    <option value="${method.id}"> ${method.method}-${method.account}-余额-${method.balance}</option>
                                </c:forEach>
                            </select>
                            <div class="layui-input-block"style="margin-left:0px;">
                                <button type="submit" class="layui-btn" style="height:25px;line-height: 25px;margin-top:5px;" >收款</button>
                            </div>
                        </div>
                    </form>
                </div>

            </div>
        </c:forEach>
    </div>
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
