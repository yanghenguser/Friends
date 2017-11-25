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
		<link rel="stylesheet" type="text/css" href="css/about.css"/>
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
						<li style="width: 90px;"><a href="../Friends" class="" ><i class="main"></i>首页</a></li>
						<li><a href="../Friends/cooperation" class="left-border" ><i class="companel"></i>合伙人</a></li>
						<li><a href="../Friends/classical" class="left-border" ><i class="show"></i>创意贴</a></li>
						<li><a href="../Friends/about" class="left-border active"><i  class="about"></i>关于我们</a></li>
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
<body>

	<div id="main_body">
			<div class="list about">
			<section>
			<h3>关于我们</h3>
			<p>"创意合伙人"开发团队于2017年4月10日组成，网站1.0版本于4月25日正式开通（时间好短对不对？我也觉得-_-）。</p>
			<p>  灵感与科技的完美结合一直以来都是科技工作者的不懈追求，但在生活中往往不尽如人意，技术和创意不能够相得益彰，反而互相牵制的现象比比皆是，导致现在的大多数作品或产品都千篇一律，乏善可陈。</p>
			<p>所以为了解决这一尴尬的局面，我们团队开发了“创意合伙人”这个神奇的网站。在这里，你不仅可以将自己想到的好的创意发表在“合伙人”界面中，来寻找合伙人实现自己的创意想法。
			还可以借助别人的创意来开拓自己的思维，若是对别人的创意感兴趣，当然可以联系贴主加入他的创意团队。</p>
			<p>若是对网站有任何疑问或是浏览上的不愉快，欢迎联系我们，联系方式自己找哦。</p>
		</section>
		<br/>
		<section>
			<h3>联系我们</h3>
			<address>
				<ul>
					<li>&nbsp;&nbsp;&nbsp;地址：江西省南昌市丰和南大道696号(南昌航空大学)</li>
					<li>yangh：15879703547</li>
					<li>&nbsp;Peter： 15797738906</li>
					<li>&nbsp;&nbsp;邮箱：2354345263@qq.com</li>
				</ul>
			</address>
		</section>
			</div>
	
		</div>
		<!-- 孤独 -->


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