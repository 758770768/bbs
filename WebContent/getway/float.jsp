<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
#float {
	position: fixed;
	right: 0px;
	top: 50%;
}

#float>div {
	display: flex;
	flex-direction: column;
	align-items: flex-start;
}
</style>

<div id="float">
	<div id="flex">
		<button class="btn btn-info btn-lg" data-toggle='modal'
			data-target="#newTheme">发帖</button>
		<button class="btn btn-info btn-lg" data-toggle='modal'
			data-target="#replyModal">回贴</button>
		<button class="btn btn-info btn-lg" data-toggle='modal'
			data-target="#newBclass">板块</button>
	</div>
</div>

<script>
	$(function() {
		/* 查询所有板块 */
		$.ajax({
					url : "${pageContext.request.contextPath}/bclassServlet?method=selectAll",
					dataType : "json",
					success : function(data) {
						//console.log(data);
						$.each(data.rows, function(i, n) {
							$("#newTheme select").append(
									function(i, h) {
										if("${bclass.classId}"==n.classId){
										return "<option value='"+n.classId+"' selected>"
												+ n.className + "</option>";
										}else{
										return "<option value='"+n.classId+"'>"
												+ n.className + "</option>";
										}
									})
						});
					}

				});
		
		/* 回复模态框绑定事件 */
		$("[class=modal-footer] button:contains('回贴')")
				.on(
						"click",
						function() {
							if ("${user.userName}" == "") {
								$("#login").modal("show");
								return;
							}
							;
							var reply = $("[class='modal-body'] textarea")
									.val();
							$("[class='modal-body'] textarea").val("");
							$
									.ajax({
										url : "${pageContext.request.contextPath}/replyServlet?method=replyTheme&tid=${theme.themeId}",
										data : {
											replyBody : reply
										},
										dataType : "json",
										success : function(data) {
											/* 回复成功重新查询回复数据 */
											window.location.reload();
										}
									});
						});

		/* 确定发帖绑定事件 */
		$(".modal-footer button:contains('确定发帖')").on("click", function() {
              //alert(1230);
               if("${user}"==""){
            	   $("#login").modal("show");
            	   return;
               };
              $.ajax({
            	  url:"${pageContext.request.contextPath}/themeServlet?method=newTheme",
            		data: $("#newTheme form").serialize(),
            		success:function(data){
            			location.reload();
            		}
            	  
              });              
		});
		
		/* 确定板块绑定事件 */
		$(".modal-footer button:contains('确定板块')").on("click", function() {
              //alert("${user}");
               if("${user}"==""){
            	   $("#login").modal("show");
            	   return;
               };
              var fd= new FormData($("#newBclass form")[0]);
              $.ajax({
            	  url:"${pageContext.request.contextPath}/bclassServlet?method=newBclass",
            		data:fd ,
            		type:"post",
            		processData:false,
            		contentType:false,
            		success:function(data){
            			location.reload();
            			//alert(123);
            		}
            	  
              });              
		});

	});
</script>



<!-- 回复莫泰框 -->
<div class="modal fade" id="replyModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document" style="width: 300px">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<textarea rows="10" cols="40" style="width: 100%; height: 100%"
					id="replyText"></textarea>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">取消回复</button>
				<button type="button" class="btn btn-primary" data-dismiss="modal">回贴</button>
			</div>
		</div>
	</div>
</div>


<!-- 发帖模态框-->
<div class="modal fade" id="newTheme" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">添加新帖</h4>
			</div>
			<div class="modal-body">
				<!-- 发帖表单 -->
				<form class="form-horizontal">
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">帖子标题</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="inputEmail3"
								placeholder="Email" name="themeTitle">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">帖子内容</label>
						<div class="col-sm-10" >
							<textarea type="password" class="form-control" id="inputPassword3"
								placeholder="Password" name="themeBody"> </textarea>
						</div>
					</div>
                   <!-- 板块 -->
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">帖子板块</label>
						<div class="col-sm-10" >
							<select   class="form-control" id="inputPassword3"
								  name="classId"> </select>
						</div>
					</div>

				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">取消发帖</button>
				<button type="button" class="btn btn-primary" data-dismiss="modal">确定发帖</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>


<!-- 新建板块模态框-->
<div class="modal fade" id="newBclass" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">添加新板块</h4>
			</div>
			<div class="modal-body">
				<!-- 板块表单 -->
				<form class="form-horizontal">
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">板块名</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="inputEmail3"
								placeholder="Email" name="className">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">板块介绍</label>
						<div class="col-sm-10" >
							<textarea type="password" class="form-control" id="inputPassword3"
								placeholder="Password" name="classMsg"> </textarea>
						</div>
					</div>
                    <!--  板块图片上传  -->
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">板块图片</label>
						<div class="col-sm-10" >
							<input type="file" class="form-control" id="inputPassword3"
								placeholder="Password" name="classPicture"> </input>
						</div>
					</div>
     
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">取消板块</button>
				<button type="button" class="btn btn-primary" data-dismiss="modal">确定板块</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->
