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
	<table id="tabBclass"></table>
	<script type="text/javascript">
		$(function() {

			$("#tabBclass")
					.bootstrapTable(
							{

								classes : 'table table-hover',
								sortClass : undefined,
								locale : undefined,
								height : "100%",
								undefinedText : '-',
								sortName : undefined,
								sortOrder : 'asc',
								sortStable : true,
								striped : true,
								columns : [
								           {
								        	   field:"classId",
								        	   title:"编号"
								           }, 
								           {
								        	   field:"className",
								        	   title:"板块名"
								           }, 
								           {
								        	   field:"moderatorName",
								        	   title:"版主"
								           }, 
								           {
								        	   field:"moderatorId",
								        	   title:"版主编号"
								           }, 
								           {
								        	   field:"themeCount",
								        	   title:"帖子点击数量"
								           }, 
								           {
								        	   field:"signCount",
								        	   title:"置顶数量"
								           }, 
								           
								           {
								        	   field:"classPicture",
								        	   title:"头衔",
								        	   formatter:function(a){
								        		   return "<img src='"+a+"'/>";
								        	   }
								           }, 
								           
								           ],
								data : [],
								totalField : 'total',
								dataField : 'rows',
								method : 'get',
								url : "${pageContext.request.contextPath}/bclassServlet?method=selectAll",
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
								showHeader : false,
								showFooter : false,
								showColumns : true,
								showPaginationSwitch : false,
								showRefresh : true,
								showToggle : true,
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
								clickToSelect : true,
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
								onClickCell : function(field, value, row,
										$element) {
									return false;
								},
								onDblClickCell : function(field, value, row,
										$element) {
									return false;
								},
								onClickRow : function(item, $element) {
									return false;
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
								onColumnSwitch : function(field, checked) {
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
								onExpandRow : function(index, row, $detail) {
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

</body>
</html>