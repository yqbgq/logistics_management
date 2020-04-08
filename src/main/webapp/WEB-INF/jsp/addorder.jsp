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
        <legend>新建订单</legend>
    </fieldset>

    <form class="layui-form" action="/addordercheck" method="post">

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">委托单位</label>
                <div class="layui-input-inline">
                    <select name="company" lay-verify="required" lay-search="">
                        <option value="0"></option>
                        <c:forEach var="item" items="${companies}" varStatus="status">
                        <option value="${item.name}">${item.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>


        <div class="layui-form-item">

            <div class="layui-inline">
                <label class="layui-form-label">起始站点</label>
                <div class="layui-input-inline">
                    <select name="fromware" id="selectbox" lay-filter="select1">
                        <option value="0"> </option>
                        <option value="1">自定义地点</option>
                        <option value="2">从仓库</option>
                    </select>
                </div>
            </div>

            <div class="layui-inline" id="startFrom1" style="display:none">
                <label class="layui-form-label">自定义地点</label>
                <div class="layui-input-inline">
                    <input type="text" name="start" autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-inline" id="startFrom2" style="display:none">
                <label class="layui-form-label">仓库地点</label>
                <div class="layui-input-inline">
                    <select name="start" lay-filter="select1">
                        <option value="0"> </option>
                        <c:forEach var="item" items="${warehouses}" varStatus="status">
                        <option value="${item.name}">${item.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>

        <div class="layui-form-item">

            <div class="layui-inline">
                <label class="layui-form-label">目的地点</label>
                <div class="layui-input-inline">
                    <select name="toware" id="selectbox2" lay-filter="select2">
                        <option value="0"> </option>
                        <option value="1">自定义地点</option>
                        <option value="2">从仓库</option>
                    </select>
                </div>
            </div>

            <div class="layui-inline" id="toFrom1" style="display:none">
                <label class="layui-form-label">自定义地点</label>
                <div class="layui-input-inline">
                    <input type="text" name="end" autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-inline" id="toFrom2" style="display:none">
                <label class="layui-form-label">仓库地点</label>
                <div class="layui-input-inline">
                    <input type="text" name="end" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">货物类型</label>
                <div class="layui-input-inline">
                    <input type="text" name="type" lay-verify="required" autocomplete="off" class="layui-input" >
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">总立方</label>
                <div class="layui-input-inline">
                    <input type="text" name="volume" lay-verify="required" autocomplete="off" class="layui-input" >
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">重量（吨）</label>
                <div class="layui-input-inline">
                    <input type="text" name="weight" lay-verify="required" autocomplete="off" class="layui-input" >
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">截止日期</label>
                <div class="layui-input-inline">
                    <input type="text" name="endtime" id="date" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input" >
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">计重方式</label>
                <div class="layui-input-inline">
                    <select name="method" lay-verify="required" lay-search="">
                        <option value="0"></option>
                        <option value="1">按照立方</option>
                        <option value="2">按照重量</option>
                    </select>
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label">单价</label>
                <div class="layui-input-inline">
                    <input type="text" name="price" lay-verify="required" autocomplete="off" class="layui-input" >
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">其他费用</label>
                <div class="layui-input-inline">
                    <input type="text" name="otherfee" lay-verify="required" autocomplete="off" class="layui-input" >
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">额外描述</label>
                <div class="layui-input-inline">
                    <textarea placeholder="请输入内容，最多300字" class="layui-textarea" name="tags" style="width:800px"></textarea>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>

    </form>

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
        form.on('select(select1)', function(data){
            if(data.value=="1"){
                $("#startFrom2").hide();
                $("#startFrom1").show();

            }else{
                $("#startFrom1").hide();
                $("#startFrom2").show();
            }
        });

        form.on('select(select2)', function(data){
            if(data.value=="1"){
                $("#toFrom2").hide();
                $("#toFrom1").show();

            }else{
                $("#toFrom1").hide();
                $("#toFrom2").show();
            }
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
