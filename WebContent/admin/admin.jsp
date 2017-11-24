<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
</head>
<body>
<!--  当前页面标识-->
  <input type="hidden" value="admin"/>
  <script type="text/javascript">
          
          if("${user.authRange}"!=1){
        	  location.href="${pageContext.request.contextPath}/index.jsp";
          }
  
  </script>
	<div class="container">
		<div class="row">
		 <jsp:include page="header.jsp"></jsp:include>
		</div>
		<div class="row">
			<ul class="nav nav-pills nav-justified">
				<li><a href="#" data-toggle="tab" data-target="#user">用户管理</a></li>
				<li><a href="#" data-toggle="tab" data-target="#bclass">板块管理</a></li>
				<li><a href="#" data-toggle="tab" data-target="#theme">主题管理</a></li>
			</ul>

			<div class="tab-content">
				<div class="tab-pane" id="user"><jsp:include page="user.jsp" /></div>
				<div class="tab-pane" id="bclass"><jsp:include
						page="bclass.jsp" /></div>
				<div class="tab-pane" id="theme"><jsp:include page="theme.jsp" /></div>
			</div>
		</div>
	</div>


</body>
</html>