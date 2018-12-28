<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>班课管理系统</title>
<script type="text/javascript">
	function loadXMLDoc() {
		var xmlhttp;
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				//服务器的返回数据，通过XHR对象的responseText属性获得
				document.getElementById("myDiv").innerHTML = xmlhttp.responseText;
			}
		}
		var name = request.getParameter("name");
		xmlhttp.open("post", "signCheck.jsp?name=" + name, true);
		xmlhttp.send();
	}
</script>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<body>
	<h5>
		已有账号？前往<a href="Register login/sign.jsp">登录</a>
	</h5>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<h3 class="text-info text-center">注&emsp;&emsp;&emsp;册</h3>
				<div class="row clearfix">
					<div class="col-md-4 column"></div>
					<div class="col-md-4 column">
						<form action="RegisterServlet" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1">用户名：</label><input type="text"
									name="account_name" class="form-control" id="account-name"
									placeholder="手机号或电子邮箱" onblur="loadXMLDoc()" />
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">密&emsp;码：</label><input
									type="password" name="user_password" class="form-control"
									id="user-pwd" placeholder="8-16位数字和字母" />
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">学&emsp;号：</label><input
									type="text" name="sno" class="form-control" placeholder="学号" />
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">性&emsp;别：</label> <input
									type="radio" name="sex" value="男" />男&emsp;&emsp;&emsp; <input
									type="radio" name="sex" value="女" />女
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">专&emsp;业：</label><input
									type="text" name="major" class="form-control"
									placeholder="major" />
							</div>
							<div class="checkbox">
								<label><input type="checkbox" />Check me out</label>
							</div>
							<button type="submit" class="btn btn-default" style="width:49%">注册</button>
							<button type="reset" class="btn btn-default" style="width:49%">重置</button>
						</form>
					</div>
					<div class="col-md-4 column"></div>
				</div>
			</div>
		</div>
	</div>
	<dir id="myDiv"></dir>
</body>
</html>
