<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="front.jsp"%>

<fieldset class="layui-elem-field" style="margin:60px;">
    <legend>发送信息</legend>

    <form class="layui-form" action="/sendmessage" method="post">

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label" style="margin-left:40px;">发送目标</label>
                <div class="layui-input-inline">
                    <select name="users" lay-verify="required" lay-search="">
                        <c:forEach var="item" items="${array}" varStatus="status">
                            <option value="${item.id}" selected>员工编号：${item.id} - ${item.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>


        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label" style="margin-left:40px;">发送内容</label>
                <div class="layui-input-block" style="margin-left:150px;width:400px">
                    <textarea placeholder="限定长度150词" class="layui-textarea" name="content"></textarea>
                </div>
            </div>
        </div>



        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">发送</button>
            </div>
        </div>

    </form>

</fieldset>

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
