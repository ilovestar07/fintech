<%@ page contentType="text/html; charset=UTF-8"%>
<%
response.setHeader("Cache-Control", "no-store"); //HTTP 1.1 
response.setHeader("Pragma", "no-cache"); //HTTP 1.0
response.setDateHeader("Expires", 0); //保证每次对页面的访问都是最新的
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>控制台 - Bootstrap后台管理系统模版Ace下载</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<%@ include file="/system/logon/ace/public.jsp" %>

		<script type="text/javascript" >
			var XMLHttpReq = false;
			//创建XMLHttpRequest对象
			function createXMLHttpRequest() {
				if (window.XMLHttpRequest) { //Mozilla 浏览器
					XMLHttpReq = new XMLHttpRequest();
					if (XMLHttpReq.overrideMimeType) { //设置MiME类别 
						//有些版本的浏览器(如IE7会,IE6不会)在处理服务器返回的未包含XML mime-type头部信息的内容时会报错，因此，要确保返回的内容包含text/xml信息。 
						XMLHttpReq.overrideMimeType("text/xml");
					}
		
				} else if (window.ActiveXObject) { // IE浏览器
					try {
						XMLHttpReq = new ActiveXObject("Msxml2.XMLHTTP");
					} catch (e) {
						try {
							XMLHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
							XMLHttpReq.overrideMimeType('text/xml');
						} catch (e) {
							XMLHttpReq = new XMLHttpRequest();
						}
					}
				}
			}
			//发送请求函数
			function sendRequest(url) {
				createXMLHttpRequest();
				XMLHttpReq.open("GET",
						url + "&refresh=" + new Date().getMilliseconds(), true);
				XMLHttpReq.onreadystatechange = processResponse;//指定响应函数
				XMLHttpReq.send(null); // 发送请求
			}
		
			// 处理返回信息函数
			function processResponse() {
				if (XMLHttpReq.readyState == 4) { // 判断对象状态
					if (XMLHttpReq.status == 200) { // 信息已经成功返回，开始处理信息
						var data = XMLHttpReq.responseXML;
						var msg = data.getElementsByTagName("msg")[0].firstChild.data;
						var flag = data.getElementsByTagName("flag")[0].firstChild.data;
						if (flag == "1") {
							document.logonForm.subTransCode.value = "logon";
							logonForm.submit();
						} else {
							alert(msg);
							return;
						}
					} else { //页面不正常
						window.alert("用户信息校验失败!");
						document.logonForm.user_code.focus();
					}
				}
			}
		</script>
		<script type="text/javascript" >
			function doSubmit() {
				if ($("#user_code").val() == "") {
					alert("用户名不能为空!");
					logonForm.user_code.focus()
					return;
				}
				if ($("#password").val() == "") {
					alert("密码不能为空!");
					logonForm.password.focus()
					return;
				}
				createXMLHttpRequest();
				var url = "logon.do?subTransCode=chk&useType=chk&user_code="
						+$("#user_code").val()+"&password="
						+$("#password").val();
				sendRequest(url);
			}
		</script>
	</head>
	<body class="login-layout" onload="" style="background: silver;">
		<div class="login-container" >
			<div class="center">
				<h1>
					<i class="icon-leaf green"></i>
					<span class="red">Ace</span>
					<span class="white">Application</span>
				</h1>
				<h4 class="blue">&copy; Company Name</h4>
			</div>

			<div class="space-6"></div>

			<div class="position-relative">
				<div id="login-box" class="login-box visible">
					<div class="widget-body">
						<div class="widget-main">
							<h4 class="header blue lighter bigger">
								<i class="icon-coffee green"></i>
								Please Enter Your Information
							</h4>

							<div class="space-6"></div>

							<form name="logonForm" method="post" action="logon.do">
								<input type="hidden" name="subTransCode" value="logon">
								<fieldset>
									<label class="block clearfix">
										<span class="block input-icon input-icon-right">
											<input type="text" class="form-control" placeholder="Username" id="user_code" name="user_code"/>
											<i class="icon-user"></i>
										</span>
									</label>
	
									<label class="block clearfix">
										<span class="block input-icon input-icon-right">
											<input type="password" class="form-control" placeholder="Password" id="password" name="password"/>
											<i class="icon-lock"></i>
										</span>
									</label>
	
									<div class="space"></div>
	
									<div class="clearfix">
										<label class="inline">
											<input type="checkbox" class="ace" />
											<span class="lbl"> Remember Me</span>
										</label>
		
										<button onclick="doSubmit();" type="button" class="width-35 pull-right btn btn-sm btn-primary">
											<i class="icon-key"></i>
											Login
										</button>
									</div>
	
									<div class="space-4"></div>
								</fieldset>
							</form>
						</div><!-- /widget-main -->
					</div><!-- /widget-body -->
				</div><!-- /login-box -->
			</div>
		</div>
	</body>
</html>