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
	justify-content: space-around;
}

table  td{
  border: none !important;
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
		<div id="cl" class="row">
			<h2 class="text-info">板块:${bclass.className}</h2>
			<h2 class="text-info">版主:${bclass.moderatorName}</h2>
			<h2 class="text-info">帖子数量:${bclass.themeCount}</h2>
			<h2 class="text-info">精华帖:${bclass.signCount}</h2>
		</div>
		<div class="row">
			<div class="col-md-12">
				<table id="themeTable"></table>
			</div>
			<script type="text/javascript">
				$(function() {
					/* $.ajax({
						url:"${pageContext.request.contextPath}/themeServlet?method=selectAll",
						dataType:"json",
						success:function(data){
							alert(data);
						}
					}); */

					/* 查询帖子 */
					$("#themeTable")
							.bootstrapTable(
									{

										classes : 'table',
										sortClass : undefined,
										locale : undefined,
										height : undefined,
										undefinedText : '-',
										sortName : undefined,
										sortOrder : 'asc',
										sortStable : false,
										striped : false,
										columns : [
										      {
										    	  field:"themeTitle",
										    	  title:"帖子",
										    	  align:"center",
										    	  formatter:function(va,row){
										    		  return  "<h4 class='text-info'>"+va+"</h4>";
										    	  }
										      },
										      {
										    	  field:"userName",
										    	  title:"版主",
										    	  align:"center",
										    	  
										      },
										      {
										    	  field:"className",
										    	  title:"板块名",
										    	  align:"center"
										      },
										      {
										    	  field:"themeIsTop",
										    	  title:"是否置顶",
										    	  align:"center",
										    	  formatter:function(e){
										    		if(e=="1"){
										    			return "置顶";
										    		}
										    		return "普通";
										    	  }
										      },
										      {
										    	  field:"themeSign",
										    	  title:"是否精华",
										    	  align:"center",
										    	  formatter:function(e){
											    		if(e=="1"){
											    			return "精华";
											    		}
											    		return "普通";
											    	  }
										    	  
										      },
										      {
										    	  field:"themeTime",
										    	  title:"帖子时间",
										    	  align:"center"
										      },{
										    	  field:"themeViewCount",
										    	  title:"点击量",
										    	  align:"center"
										      }
										       
										      ],
										data : [],
										totalField : 'total',
										dataField : 'rows',
										method : 'get',
										url : "${pageContext.request.contextPath}/themeServlet?method=selectAllByBclassId&bid=${bclass.classId}",
										ajax : undefined,
										cache : false,
										contentType : 'application/json',
										dataType : 'json',
										ajaxOptions : {},
										queryParams : function(params) {
											return params;
										},
										queryParamsType : 'limit', // undefined
										responseHandler : function(res) {
											return res;
										},
										pagination : true,
										onlyInfoPagination : false,
										paginationLoop : true,
										sidePagination : 'server', // client or server
										totalRows : 0, // server side need to set
										pageNumber : 1,
										pageSize : 10,
										pageList : [ 10, 25, 50, 100 ],
										paginationHAlign : 'right', //right, left
										paginationVAlign : 'bottom', //bottom, top, both
										paginationDetailHAlign : 'left', //right, left
										paginationPreText : '&lsaquo;',
										paginationNextText : '&rsaquo;',
										search : true,
										searchOnEnterKey : false,
										strictSearch : false,
										searchAlign : 'right',
										selectItemName : 'btSelectItem',
										showHeader : true,
										showFooter : false,
										showColumns : false,
										showPaginationSwitch : false,
										showRefresh : false,
										showToggle : false,
										buttonsAlign : 'right',
										smartDisplay : true,
										escape : false,
										minimumCountColumns : 1,
										idField : undefined,
										uniqueId : undefined,
										cardView : false,
										detailView : false,
										detailFormatter : function(index, row) {
											return '';
										},
										trimOnSearch : true,
										clickToSelect : false,
										singleSelect : false,
										toolbar : undefined,
										toolbarAlign : 'left',
										checkboxHeader : true,
										sortable : true,
										silentSort : true,
										maintainSelected : false,
										searchTimeOut : 500,
										searchText : '',
										iconSize : undefined,
										buttonsClass : 'default',
										iconsPrefix : 'glyphicon', // glyphicon of fa (font awesome)
										icons : {
											paginationSwitchDown : 'glyphicon-collapse-down icon-chevron-down',
											paginationSwitchUp : 'glyphicon-collapse-up icon-chevron-up',
											refresh : 'glyphicon-refresh icon-refresh',
											toggle : 'glyphicon-list-alt icon-list-alt',
											columns : 'glyphicon-th icon-th',
											detailOpen : 'glyphicon-plus icon-plus',
											detailClose : 'glyphicon-minus icon-minus'
										},

										customSearch : $.noop,

										customSort : $.noop,

										rowStyle : function(row, index) {
											return {};
										},

										rowAttributes : function(row, index) {
											return {};
										},

										footerStyle : function(row, index) {
											return {};
										},

										onAll : function(name, args) {
											return false;
										},
										onClickCell : function(field, value,
												row, $element) {
											return false;
										},
										onDblClickCell : function(field, value,
												row, $element) {
											return false;
										},
										onClickRow : function(item, $element) {
											location.href="${pageContext.request.contextPath}/themeServlet?method=selectWithId&tid="+item.themeId;
										},
										onDblClickRow : function(item, $element) {
											return false;
										},
										onSort : function(name, order) {
											return false;
										},
										onCheck : function(row) {
											return false;
										},
										onUncheck : function(row) {
											return false;
										},
										onCheckAll : function(rows) {
											return false;
										},
										onUncheckAll : function(rows) {
											return false;
										},
										onCheckSome : function(rows) {
											return false;
										},
										onUncheckSome : function(rows) {
											return false;
										},
										onLoadSuccess : function(data) {
											return false;
										},
										onLoadError : function(status) {
											return false;
										},
										onColumnSwitch : function(field,
												checked) {
											return false;
										},
										onPageChange : function(number, size) {
											return false;
										},
										onSearch : function(text) {
											return false;
										},
										onToggle : function(cardView) {
											return false;
										},
										onPreBody : function(data) {
											return false;
										},
										onPostBody : function() {
											return false;
										},
										onPostHeader : function() {
											return false;
										},
										onExpandRow : function(index, row,
												$detail) {
											return false;
										},
										onCollapseRow : function(index, row) {
											return false;
										},
										onRefreshOptions : function(options) {
											return false;
										},
										onRefresh : function(params) {
											return false;
										},
										onResetView : function() {
											return false;
										}

									});
				});
			</script>
		</div>
		
		<!-- 浮动窗口发帖以及回复 -->
		<jsp:include page="float.jsp"></jsp:include>
	</div>
</body>
</html>