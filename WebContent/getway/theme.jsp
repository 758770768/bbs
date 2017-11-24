<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 
<style type="text/css">
#cl {
	display: flex;
	justify-content: space-between;
}

table  td {
	border: none !important;
}

div[class="col-md-8 text-center"]{
  margin-top: 60px;
}

 

</style>
</head>
<body>
	<div class="container">
		<!-- 页头 -->
		<div class="row">
			<%@include file="header.jsp"%>
		</div>
		<!--body  -->
		<div id="cl" class="row panel panel-default">
			<h2 class="text-info">主题:${theme.themeTitle}</h2>
			<h2 class="text-info">发铁人:${theme.userName}</h2>
			<h2 class="text-info">
				是否精华:
				<c:if test="${theme.themeSign eq 1}">精华</c:if>
				<c:if test="${theme.themeSign ne 1}">普通</c:if>
			</h2>
			<h2 class="text-info">
				是否置顶:
				<c:if test="${theme.themeIsTop ne 1}">普通</c:if>
				<c:if test="${theme.themeIsTop eq 1}">置顶</c:if>
			</h2>
			<h2 class="text-info">所属板块:${theme.className}</h2>
		</div>
		<div class="row panel panel-default">
			<!--  用户部分-->
			<div class="col-md-2" id="userPicture">

				<!--    用户区 -->
			</div>
			<!-- 帖子内容-->
			<div class="col-md-10 panel panel-defalut">
				<h3 class="text-center page-header">${theme.themeBody}</h3>
			</div>
		</div>

		<script type="text/javascript">
	
		/* 查询回复贴数据方法 */
		function findData(){
		$.ajax({
					url : "${pageContext.request.contextPath}/replyServlet?method=selectAllWithUserPicture&tid=${theme.themeId}",
					dataType : "json",
					success : function(data) {
						//alert(data[0].userPicture);
						$.each(
										data,
										function(i, n) {
											$("div[class*='row']")
													.last()
													.after(
															"<div class='row panel panel-default'><div class='col-md-2'><img src='"+n.userPicture+"'/><span class='text-info'>#"
																	+ (i + 1)
																	+ "楼</span><span class='text-info'><br>"
																	+ n.replyTime
																	+ "</span><br><span class='text-danger'>"+n.userName+"</span></div><div class='col-md-8 text-center'><h4 class='text-success'>"
																	+ n.replyBody
																	+ "</h4></div><div class='col-md-2 text-right'><button class='btn btn-primary' onclick='delReply("+n.replyId+")'>删除</button></div></div>");
										});
					}
				});
		};
		/*删除回复贴方法  */
		  function delReply(rid){
			location.href= "${pageContext.request.contextPath}/themeServlet?method=selectWithId&rid={theme.themeId}";
		}
			$(function() {
				/* 页面加载完成查询回复贴数据 */
				findData();
				
				/* 查询user数据 */
				$
						.ajax({
							url : "${pageContext.request.contextPath}/userServlet?method=selectWithId&uid=${theme.userId}",
							dataType : "json",
							success : function(data) {
								$("#userPicture").prepend(
										"<img  src='"+data.userPicture+"'/>");
							}
						});
			
				

				

			});
		</script>
<!-- 浮动窗口发帖以及回复 -->
		<%@include file="float.jsp"%>

	</div>
</body>
</html>