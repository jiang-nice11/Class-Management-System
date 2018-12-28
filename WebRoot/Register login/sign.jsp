<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>班课管理系统</title>
    <script type="text/javascript">
    	function loadName(){
    		if(document.getElementById("account-name").value==""){
    			document.getElementById("myName").innerHTML = "用户名不能为空！";
    		}else{
    			document.getElementById("myName").innerHTML = "";
    		}
    	}
    </script>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">

  </head>
  
  <body>
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <h3 class="text-info text-right">
                    	登&emsp;&emsp;&emsp;录&emsp;&emsp;&emsp;
                </h3>
                <div class="row clearfix">
                    <div class="col-md-8 column">
                    </div>
                    <div class="col-md-4 column">
                        <form action="SignCheck" method="POST">
                            <div class="form-group">
                                 <label for="exampleInputEmail1">User name</label><input type="text" name="account_name" class="form-control" id="account-name" placeholder="User name" onblur="loadName()"/>
                            	<dir id="myName"></dir>
                            </div>
                            <div class="form-group">
                                 <label for="exampleInputPassword1">Password</label><input type="password" name = "user_password" class="form-control" id="user-pwd" placeholder="Password"/>
                            </div>

                            <input type="radio" name="mode" id="red" value="teacher">教师
                            <input type="radio" name="mode" id="blue" value="student">学生


                            <div class="checkbox">
                                 <label><input type="checkbox" />Check me out</label>
                            </div> <button type="submit" class="btn btn-default" style="width:49%">登录</button>
                                   <button type="reset" class="btn btn-default" style="width:49%">重置</button>
                                   <h3>&emsp;&emsp;&emsp;没有账号?&nbsp;快去<a href="Register login/register.jsp" >注册</a></h3>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
  </body>
</html>
