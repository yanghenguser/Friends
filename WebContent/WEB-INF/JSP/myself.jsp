<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>创意合伙人</title>
        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css"/>
        <link rel="shortcut icon" href="img/logoshortcut.png">
        <link rel="stylesheet" type="text/css" href="css/basic.css"/>
        <link rel = "stylesheet" type = "text/css" href = "css/myself.css  " />
        <link href="http://fonts.googleapis.com/css?family=Reenie+Beanie:regular" rel="stylesheet" type="text/css">
            
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
                        <li><a href="../Friends/classical" class="left-border" ><i class="show"></i>精品帖子</a></li>
                        <li><a href="../Friends/about" class="left-border"><i  class="about"></i>关于我们</a></li>
                    </ul>
                </nav>
            </div>
            
            <div class="header_member">
                    <a href="javascript:void(0)" id="reg_a">注册</a> 
                    <a href="javascript:void(0)" id="member">用户</a> 
                    | 
                    <a href="javascript:void(0)" id="login_a">登录</a>
                    <a href="javascript:void(0)" id="logout">退出</a>
            </div>
        </div>
    </header>
        <br />
        <br />

    <div class = "content">
    
    
	    <div class = "left_nav">
	            <p class = "my-picture">
	                <img src = "../Friends/img/boy-5.png"/>
	                <span class = "name">
	                    King
	                </span>
	            </p>
	            <ul class="nav nav-pills nav-stacked">
	                <li class="active"><a href="javascript:void(0)">基本信息</a></li>
	                <li><a href="javascript:void(0)">发表的帖子</a></li>
	                <li><a href="javascript:void(0)">评论的帖子</a></li>
	                <li><a href="javascript:void(0)">赞过的帖子</a></li>
	                <li><a href="javascript:void(0)">踩过的帖子</a></li>
	            </ul>      
	            
	    </div>
      
        
        <div class = "right_body ">
            <ul class = "body_tab">
                <li class = "tab_text">基本信息</li>
            </ul>
            
            <div class = "body_content">
                <p>
                    <span class = "myname">姓名:</span>
                    <span class = "name" ></span>
                </p>
                
                <p>
                    <span class = "mysex">性别:</span>
                    <span class = "sex" ></span>
                </p>
                
                <p>
                    <span class = "myQQ">QQ:</span>
                    <span class = "QQ" ></span>
                </p>
                <p>
                   <span class = "myremark">个人说明:</span>
                   <textarea rows="5" cols="13" readonly = "readonly" class = "remark"></textarea>
                </p>
            </div>
            
            <div class = "body_content hide">
<!--                 <h4><i class="userimg"></i>yangh发表于2017年4月</h4>
	            <h3>一个关于合作的帖子</h3>
	            <div class="editor">
			                下面接着写。
			                由于之前一直觉得easyX不支持png，用起来不够方便。因此经过最近的思考，采取了一种基于easyX和CxImage图形库的混合方式。主要是使用了CxImage的png支持能力。
			                下面是基本素材：
			                背景图：
	            </div>
	            <div class="bottom">
	                <span class="comment">0条评论</span>
	                <span class="up">收起</span>
	            </div>
	            <hr noshade="noshade" size="1" />   -->
            </div>
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
       
        <!-- 悬浮在右中心的发帖刷新以及返回顶部等功能按钮 -->
        <div class="izl-rmenu">
            <a class="cart"><div class="pic"></div></a>   
            <a href="javascript:void(0)" class="btn_top" style="display: block;"></a>
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
    <script type = "text/javascript" src = "js/myself.js"></script>
    <script type="text/javascript" src="js/index.js"></script>
</body>
</html>