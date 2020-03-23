<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- 还要修改表单的动作以及表单的提交方法 -->
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>登录注册</title>
  <link rel="stylesheet" href="./layui/css/layui.css">
</head>
<body class="layui-layout-body">


<fieldset class="layui-elem-field" style="width:25%;margin-left:37%;margin-top:15%;">
  <legend >   登录</legend>
  <div class="layui-field-box">
    <form class="layui-form layui-form-pane"  method="post">
		<div class="layui-form-item">
			<label class="layui-form-label">用户名</label>
			<div class="layui-input-inline">
				<input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
			</div>
		</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label">密码</label>
			<div class="layui-input-inline">
				<input type="password" name="password" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
			</div>
		</div>
  
		<div class="layui-form-item">
			<button class="layui-btn" lay-filter="demo1" onclick="javascript:this.form.action='logcheck';">登录</button>
            <button class="layui-btn" lay-filter="demo2" onclick="javascript:this.form.action='registerin';">注册</button>
		</div>
	</form>
  </div>
</fieldset>


</body>
</html>