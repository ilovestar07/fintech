<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<body>
	<div class="navbar navbar-default" id="navbar">
		<div class="navbar-container" id="navbar-container">
			<div class="navbar-header pull-left">
				<a class="navbar-brand">
					<small>
						<i class="icon-leaf"></i>
						ACE后台管理系统
					</small>
				</a><!-- /.brand -->
			</div><!-- /.navbar-header -->
			
			<div class="navbar-header pull-right" role="navigation">
				<ul class="nav ace-nav">
					<li class="grey">
						<a data-toggle="dropdown" class="dropdown-toggle" href="#">
							<i class="icon-tasks"></i>
							<span class="badge badge-grey">4</span>
						</a>

						<ul class="pull-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
							<li class="dropdown-header">
								<i class="icon-ok"></i>
								还有4个任务完成
							</li>

							<li>
								<a href="#">
									查看任务详情
									<i class="icon-arrow-right"></i>
								</a>
							</li>
						</ul>
					</li>

					<li class="purple">
						<a data-toggle="dropdown" class="dropdown-toggle" href="#">
							<i class="icon-bell-alt icon-animated-bell"></i>
							<span class="badge badge-important">8</span>
						</a>

						<ul class="pull-right dropdown-navbar navbar-pink dropdown-menu dropdown-caret dropdown-close">
							<li class="dropdown-header">
								<i class="icon-warning-sign"></i>
								8条通知
							</li>

							<li>
								<a href="#">
									查看所有通知
									<i class="icon-arrow-right"></i>
								</a>
							</li>
						</ul>
					</li>

					<li class="green">
						<a data-toggle="dropdown" class="dropdown-toggle" href="#">
							<i class="icon-envelope icon-animated-vertical"></i>
							<span class="badge badge-success">5</span>
						</a>

						<ul class="pull-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
							<li class="dropdown-header">
								<i class="icon-envelope-alt"></i>
								5条消息
							</li>

							<li>
								<a href="inbox.html">
									查看所有消息
									<i class="icon-arrow-right"></i>
								</a>
							</li>
						</ul>
					</li>

					<li class="light-blue">
						<a data-toggle="dropdown" href="#" class="dropdown-toggle">
							<img class="nav-user-photo" />
							<span class="user-info">
								<small>欢迎光临,</small>
								Jason
							</span>

							<i class="icon-caret-down"></i>
						</a>

						<ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
							<li>
								<a href="#">
									<i class="icon-cog"></i>
									设置
								</a>
							</li>

							<li>
								<a href="#">
									<i class="icon-user"></i>
									个人资料
								</a>
							</li>

							<li class="divider"></li>

							<li>
								<a href="#">
									<i class="icon-off"></i>
									退出
								</a>
							</li>
						</ul>
					</li>
				</ul><!-- /.ace-nav -->
			</div><!-- /.navbar-header -->
		</div><!-- /.container -->
	</div>
</body>
</html>