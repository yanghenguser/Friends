<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>创意合伙人</title>
		<link rel="shortcut icon" href="img/logoshortcut.png">
		<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="css/basic.css"/>
</head>
<body>
	<header id="header">
				<div id="main">
					
				
			<div class="sec-header">
				<h2 class="none">创意合伙人</h2>
				<nav class="nav-head">
					<h2 class="none">网站导航</h2>
					<ul>
						<li class="logo" style="width: 300px; height:60px;"></li>
						<li style="width: 90px;"><a href="../Friends" class="active" ><i class="main"></i>首页</a></li>
						<li><a href="../Friends/cooperation" class="left-border" ><i class="companel"></i>合伙人</a></li>
						<li><a href="../Friends/classical" class="left-border" ><i class="show"></i>创意贴</a></li>
						<li><a href="../Friends/about" class="left-border"><i  class="about"></i>关于我们</a></li>
					</ul>
				</nav>
			</div>
			
			<div class="header_member">
					<a href="javascript:void(0)" id="reg_a">注册</a> 
					<a href="javascript:void(0)" id="member"><i class="userimg"></i>用户</a> 
					| 
					<a href="javascript:void(0)" id="login_a">登录</a>
					<a href="javascript:void(0)" id="logout">退出</a>
			</div>
			</div>
		</header>
		<div id="main_body">
	
			<div id="myCarousel" class="carousel slide">
			    <!-- 轮播（Carousel）指标 -->
			    <ol class="carousel-indicators">
			        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			        <li data-target="#myCarousel" data-slide-to="1"></li>
			        <li data-target="#myCarousel" data-slide-to="2"></li>
			    </ol>   
			    <!-- 轮播（Carousel）项目 -->
			    <div class="carousel-inner">
			        <div class="item active" align:center>
			            <img src="img/slide1.png" alt="First slide">
			        </div>
			        <div class="item" style="text-align:center">
			            <img src="img/slide2.png" alt="Second slide">
			        </div>
			        <div class="item">
			            <img src="img/slide3.png" alt="Third slide">
			        </div>
			    </div>
			    <!-- 轮播（Carousel）导航 -->
			    <a class="carousel-control left" href="#myCarousel" 
			        data-slide="prev">&lsaquo;
			    </a>
			    <a class="carousel-control right" href="#myCarousel" 
			        data-slide="next">&rsaquo;
			    </a>
			</div>
			<!--<p>
				有时候，也许在行走的某一瞬间，你的脑海里突然迸发出数不尽的灵感，这些新颖而独特的想法催促着你快点去实现他们，但此时的你却苦于技术尚浅，还未学精而无法
			去实现你的想法而感到苦恼，要是有个大牛带着我就好了...
			</p>
			
			<p>
				有时候，你已经学会了许多的技术，却没有一个真正的有创意的项目值得你去动手，感觉一昧的模仿别人已存在的东西实在是无趣的很，此时也许你会想，要是有个智多
			星帮我出想法该有多好...
			</p>-->
			<div id="wall">
				<h2 class="walltitle">吐槽墙</h2>
				<p class="walltext">
					这是一面可以让你吐槽的墙哦~,上到工作上的烦恼，下到生活上的压力，都可以在这里拿出来让大家开心开心。</p>
				<p class="walltext">当然了，对我们的意见也可以在这里提出来，我们会好好看的哟，恩，好好看！
				</p>
				
				 <div class="speak">
					
				</div>
			
			<ul class="notes" >
				<!-- 动态加载 -->
			</ul>

		</div>
		
		<div id="more">
			加载更多...
		</div>
			
		</div>
		
		
		<div class="modal fade"  style="display:none" id="reg" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
						<h4 class="modal-title" id="myModalLabel">
							用户注册
						</h4>
					</div>
					<div class="modal-body">
						<form id="regform" action="checkReg">	
						<ol class="reg_error"></ol>
						<label class="text-position" for="user">用户名：</label><input type="text" name="user" id="user" required="required"  /><span class="star">*</span><br />
						<label class="text-position" for="password">密码：</label><input type="password" name="password" id="password" value="" required="required" /><span class="star">*</span><br />
						<label class="text-position" for="repasswd">重复密码：</label><input type="password" name="repasswd" id="repasswd" value="" required="required" /><span class="star">*</span>
						<label class="text-position" for="QQ">QQ：</label><input type="text" name="QQ" id="QQ" value=""/>
						
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">退出
						</button>
						<button type="button" id="register" class="btn btn-primary">
							注册
						</button>
					</div>
				</div><!-- /.modal-content -->
			</div><!-- /.modal -->
		</div>
		
		<div class="modal fade" style="display:none" id="login" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
						<h4 class="modal-title" id="myModalLabel">
							用户登录
						</h4>
					</div>
					<div class="modal-body">
						<form id="loginform" action="checkLogin">	
						<ol class="login_error"></ol>
						<label class="text-position" for="user">用户名：</label><input type="text" name="user" id="user" required="required"  /><span class="star">*</span><br />
						<label class="text-position" for="password">密码：</label><input type="password" name="password" id="password" value="" required="required" /><span class="star">*</span><br />
						
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">退出
						</button>
						<button type="button" id="loginbutton" class="btn btn-primary">
							登录
						</button>
					</div>
				</div><!-- /.modal-content -->
			</div><!-- /.modal -->
		</div>
		
			<div class="modal fade" id="loading" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			
					<div class="modal-body">			
						数据交互中...
					</div>
			
			</div>
			<div class="modal fade" style="display:none" id="speaks" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
						<h4 class="modal-title" id="myModalLabel">
							吐吐吐吐吐吐吐吐吐槽大法
						</h4>
					</div>
					<div class="modal-body">
						<div class="alert alert-danger" style="margin:0;">请不要多于60个字</div>			
						<textarea name="Notes" id="Notes" wrap="soft" draggable="false"></textarea><br />
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">闪人
						</button>
						<button type="button" id="tucao" class="btn btn-primary">
							吐一个
						</button>
					</div>
				</div><!-- /.modal-content -->
			</div><!-- /.modal -->
		</div>
			
		<footer id="footer">
			<div class="bottom">
				
					<p>合作邮箱:<a href="###">1565845039@qq.com</a> 咨询QQ：1565845039<img src="img/pic1.gif" alt="pic" class="imgposition" /> </p>
			</div>
		</footer>
	

	<script type="text/javascript" src="js/jquery-3.2.0.min.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/jquery.cookie.js"></script>
	<script type="text/javascript" src="js/jquery.form.js"></script>
	<!-- <script type="text/javascript" src="js/jquery.ui.js"></script> -->
	<!--  <script type="text/javascript" src="js/jquery.validate.js"></script>-->
	<script type="text/javascript" src="js/basic.js"></script>
	
	<script type="text/javascript" src="js/index.js"></script>
</body>
</html>