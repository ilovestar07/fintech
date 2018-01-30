<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title></title>
		<%@ include file="/system/logon/ace/public.jsp" %>
	</head>

	<body style="background:#fff">
		<div class="page-content">
			<div class="page-header">
				<h1>用户管理</h1>
			</div><!-- /.page-header -->
        	<div class="row">
            	<div class="col-xs-12">
                	<!-- PAGE CONTENT BEGINS -->
	                <div class="row">
	                    <div class="col-sm-12">
	                        <form class="form-inline query_ipt">
	                            <div class="row row_item">
	                                <div class="col-sm-12">
	                                    <div class="col-sm-3">
	                                        <span class="form_til">用户代码</span>
	                                        <input type="text" class=" input-sm" id="" placeholder="请输入用户代码">
	                                    </div>
	                                    <div class="col-sm-3">
	                                        <span class="form_til">用户名称</span>
	                                        <input type="text" class=" input-sm" id="" placeholder="请输入用户名称">
	                                    </div>
	                                    <div class="col-sm-3">
	                                        <span class="form_til">性别</span>
	                                        <select class="form-control" name="state" style="width: 80px;">
												<option value="AL">男</option>
												<option value="AK">女</option>
											</select>
	                                    </div>
	                                    <div class="col-sm-3">
	                                        <span class="form_til">日期</span>
	                                    </div>
	                                </div>
	                                <div class="col-sm-2">
	                                    <button style="vertical-align: bottom;" type="submit"
	                                            class="btn btn-default btn-sm">查询
	                                    </button>
	                                </div>
	                            </div>
	                        </form>
	                    </div>

                    	<div class="col-xs-12">
	                        <h3 class="header smaller lighter blue"></h3>
	                        <table id="grid-table"></table>
	                        <div id="grid-pager"></div>
                    	</div>
                	</div>
                	<!-- PAGE CONTENT ENDS -->
            	</div><!-- /.col -->
        	</div><!-- /.row -->
   		</div><!-- /.page-content -->
	</body>
</html>
