<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap-table.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.0.0.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/bootstrap-table.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/bootstrap-table-zh-CN.js"></script>
<style type="text/css">
 .row:HOVER {
	background-color: #CEFFCE !important;
} 

/* *{
 background-color: #CEFFCE !important;
} */

#header {
	display: flex;
	background:
		url("${pageContext.request.contextPath}/images/getway/header.jpg")
		no-repeat fixed;
	background-size: cover;
	height: 100px;
	justify-content: flex-end;
	align-items: flex-end;
}

.a {
	width: 60px;
	height: 40px;
}

#header a {
	text-decoration: none;
	color: white;
}

#time{
      position: fixed;
      bottom:0px;
	  right: 0px;
	  
}
</style>

<script type="text/javascript">

	$(function() {
		//alert(location.pathname);
		console.log(location);
		//console.log(location);
		/* 判断用户是否登录当前页是否为后台页面 */
		$(".pageTest").removeClass("btn btn-danger btn-lg");
        if("${user.authRange}"==1){
		if(location.pathname.indexOf("admin")>=0){
			 $(".pageTest")[0].href+="getway/home.jsp";
			 $(".pageTest").html("<h2>前台页面</h2>");
		 }else{
			 $(".pageTest")[0].href+="admin/admin.jsp";
			 $(".pageTest").html("<h2>后台页面</h2>");
		 }
		$(".pageTest").addClass("btn btn-danger btn-lg");
        }
		/*当前时间 */
			window.setInterval(function() {
				$("#time").empty();
				var timer = new Date().toLocaleString();
				$("#time").append("<h2 class='text-success'>"+timer+"</h2>");
			}, 1000);
		
		
      var a=[0,0,0];
		/* 注册按钮绑定事件 */
		$("button:contains('注册')")
				.on(
						"click",
						function() {
							$("#register").modal("show");
							$("#register [name='userName']").off();
							/* 验证用户名是否可用  */
							$("#register [name='userName']")
									.on(
											"blur",
											function() {
										    $("#register [name='userName']").siblings('span').remove();
											var userName=	$("#register [name='userName']").val();
											var reg=/^[a-z0-9A-Z]{5,10}$/g;	
											//alert(userName);
											if(!reg.test(userName)) return;
												a[0]=1;
											//alert(a);
												//alert(123); 
												$
														.ajax({
															url : "${pageContext.request.contextPath}/userServlet?method=selectWithUserName&userName="
																	+userName,
															success : function(data) {
																var msg = "<span class='text-info'>用户名可用</span>";
																if (data == 'error') {
																	msg = "<span class='text-danger'>用户名不可用</span>";
																}
																$(
																		"#register [name='userName']")
																		.after(
																				function() {
																					return msg;
																				});
															}
														});
											});
						});

		/* 用户登录 */
		$("button:contains('确认登录')")
				.on(
						"click",
						function() {
							$
									.ajax({
										url : "${pageContext.request.contextPath}/userServlet?method=login",
										data : $("#loginForm").serialize(),
										success : function(data) {
											// alert(data);
											if (data != 'ok') {
												alert(data);
												return;
											}
											window.location.reload();
										}
									});
						});

		$("button:contains('注册')").on("click", function() {

		});

	});
</script>

<div id="header">
	<c:if test="${empty user}">
		<button class="btn btn-info btn-large a">登录</button>
		<button class="btn btn-info btn-large a">注册</button>
	</c:if>
		<a href="${pageContext.request.contextPath}/" class="pageTest"></a>
	<c:if test="${!empty user}">
		<a href="#" class="btn btn-info btn-large"><h2>${user.userName}</h2></a>
		<a href="javascript:void(0)" class="btn btn-info btn-large"><h2>注销</h2></a>
	</c:if>
	
	<script type="text/javascript">
	

		$("button:contains('登录')").on("click", function() {
			$("#login").modal("show");
		});
		$("h2:contains('注销')")
				.on(
						"click",
						function() {
							$
									.ajax({
										url : "${pageContext.request.contextPath}/userServlet?method=logout",
										success : function(data) {
											window.location.reload();
										}
									});
						});
	</script>
</div>

<!--登录模态框  -->
<div class="modal fade" id="login" tabindex="-1" role="dialog">
	<div class="modal-dialog" style="width: 300px; height: 300px"
		role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title text-center text-success">登录模态框</h4>
			</div>
			<div class="modal-body">

				<!-- 登录表单 -->
				<form class="form-horizontal" id="loginForm">
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-4 control-label">姓名
							:</label>
						<div class="col-sm-8">
							<input type="email" class="form-control" name="userName"
								placeholder="Email">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">密码:</label>
						<div class="col-sm-8">
							<input type="password" class="form-control" name="password"
								placeholder="Password">
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">退出</button>
				<button type="button" class="btn btn-primary" data-dismiss="modal">确认登录</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>

<!--注册模态框  -->
<div class="modal fade" id="register" tabindex="-1" role="dialog">
	<div class="modal-dialog" 
		role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title text-center text-success">注册模态框</h4>
			</div>
			<div class="modal-body">

				<!-- 登录表单 -->
				<form class="form-horizontal">
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-4 control-label">姓名
							:</label>
						<div class="col-sm-8">
							<input type="email" class="form-control" id="qwer"
								name="userName" placeholder="Email">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">密码:</label>
						<div class="col-sm-8">
							<input type="password" class="form-control" name="password"
								placeholder="Password">
						</div>
					</div>

					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">密码:</label>
						<div class="col-sm-8">
							<input type="password" class="form-control" name="repassword"
								placeholder="Password">
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">退出</button>
				<button type="button" class="btn btn-primary" data-dismiss="modal">确认注册</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->
 <div id='time'></div>