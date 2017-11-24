<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 
</head>
<body>
	<div class="container">

		<!-- 首页显示header-->
		<div class="row">
			<div class="col-md-12">
				<jsp:include page="header.jsp"></jsp:include>
			</div>
		</div>
		
			<!-- 主题内容 -->
		<div class="row">
		</div>
			<!-- 首页显示footer -->
			<div class="row">
				<div class="col-md-12"></div>
			</div>
			
	</div>
		<script type="text/javascript">
			/* 查询板块 */
			$
					.ajax({
						url : "${pageContext.request.contextPath}/bclassServlet?method=selectAll",
						dataType:"json",
						success : function(data) {
							//alert(data);
							$.each(data.rows,function(i,n){
							//	alert(n.classPicture);
							$("[class='row']:eq(1)")
									.append(
											"<div class='col-md-4'><div class='thumbnail'><a href='${pageContext.request.contextPath}/bclassServlet?method=selectBclassById&bid="+n.classId+"'><img src='"+n.classPicture+"'/></a>"
											+" <div class='caption text-info text-center'><h4 class='text-info'>版主:"+n.moderatorName+"</h4><h5 class='text-success'><span>板块标题:"+n.className+"</span>"+
											"</h5><h6 class='text-info'>帖子数量:"+n.themeCount+"||精华帖:"+n.signCount+"</h6></div></div></div>");
							})
						}
					});
		</script>
		
		<!-- 浮动窗口发帖以及回复 -->
		<%@include file="float.jsp"%>
</body>
</html>