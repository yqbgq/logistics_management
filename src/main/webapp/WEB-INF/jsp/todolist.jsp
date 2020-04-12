<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="front.jsp"%>




<div style="margin:20px;width:90%;">
<fieldset class="layui-elem-field layui-field-title" >
    <legend>代办填写</legend>
</fieldset>

<form class="layui-form" action="/submittodolist" method="POST">


    <div class="layui-form-item">

        <div class="layui-inline">
            <label class="layui-form-label">截止日期</label>
            <div class="layui-input-inline">
                <input type="text" name="date" id="date" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
            </div>
        </div>

    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">代办内容</label>
        <div class="layui-input-block">
            <textarea placeholder="请输入内容，字数不多于200字" class="layui-textarea" name="content"></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
        </div>
    </div>
</form>
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

</body>
</html>