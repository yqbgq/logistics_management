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

        <div style="margin:30px;width:25%;float:left">

            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                <legend>订单时间线</legend>
            </fieldset>

            <ul class="layui-timeline">

                <c:forEach var="item" items="${details}" varStatus="status">
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis"></i>
                    <div class="layui-timeline-content layui-text">
                        <h3 class="layui-timeline-title">${item.title}</h3>
                        <p>
                            ${item.content}
                        </p>
                    </div>
                </li>
                </c:forEach>

            </ul>


        </div>

        <div style="width:65%;float:left;margin:30px">
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
                <legend>订单详情</legend>
            </fieldset>

            <form class="layui-form" action="/orderchecks" method="post">

                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">订单编号</label>
                        <div class="layui-input-inline">
                            <input type="text" name="id" lay-verify="required" autocomplete="off" class="layui-input"  value="${order.id}"  readonly>
                        </div>
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">委托单位</label>
                        <div class="layui-input-inline">
                            <input type="text" name="company" lay-verify="required" autocomplete="off" class="layui-input"  value="${order.company}"  readonly>
                        </div>
                    </div>
                </div>

                <div class="layui-form-item">

                    <div class="layui-inline"  >
                        <label class="layui-form-label">起始站点</label>
                        <div class="layui-input-inline">
                            <input type="text" name="start" lay-verify="required" autocomplete="off" class="layui-input" value="${order.startPos}" readonly>
                        </div>
                    </div>

                    <div class="layui-inline"  >
                        <label class="layui-form-label">目的站点</label>
                        <div class="layui-input-inline">
                            <input type="text" name="end" lay-verify="required" autocomplete="off" class="layui-input" value="${order.endPos}" readonly>
                        </div>
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">货物类型</label>
                        <div class="layui-input-inline">
                            <input type="text" name="type" lay-verify="required" autocomplete="off" class="layui-input" value="${order.type}" readonly>
                        </div>
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">总立方</label>
                        <div class="layui-input-inline">
                            <input type="text" name="volume" lay-verify="required" autocomplete="off" class="layui-input" value="${order.volume}" readonly>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">重量（吨）</label>
                        <div class="layui-input-inline">
                            <input type="text" name="weight" lay-verify="required" autocomplete="off" class="layui-input" value="${order.weight}" readonly>
                        </div>
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">下单日期</label>
                        <div class="layui-input-inline">
                            <input type="text" name="opendate"  lay-verify="date"  autocomplete="off" class="layui-input" value="${order.openDate}" readonly>
                        </div>
                    </div>

                    <div class="layui-inline">
                        <label class="layui-form-label">截止日期</label>
                        <div class="layui-input-inline">
                            <input type="text" name="endtime" lay-verify="date" autocomplete="off" class="layui-input" value="${order.endDate}" readonly>
                        </div>
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">计重方式</label>
                        <div class="layui-input-inline">
                            <input type="text" name="method" lay-verify="required" autocomplete="off" class="layui-input" value="${method}" readonly>
                        </div>
                    </div>

                    <div class="layui-inline">
                        <label class="layui-form-label">单价</label>
                        <div class="layui-input-inline">
                            <input type="text" name="price" lay-verify="required" autocomplete="off" class="layui-input" value="${order.price}" readonly>
                        </div>
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-inline" >
                        <label class="layui-form-label">额外描述</label>
                        <div class="layui-input-inline">
                            <input type="text" name="tags" lay-verify="required" autocomplete="off" class="layui-input" style="width:600px;height:200px" value="${order.tags}" readonly>
                        </div>
                    </div>
                </div>


            </form>

        </div>



        <script src="../layui/layui.all.js" charset="utf-8"></script>
        <!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
        <script src="../layui/jquery.js" charset="utf-8"></script>

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
