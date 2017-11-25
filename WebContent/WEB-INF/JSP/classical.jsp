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
        <link rel="stylesheet" type="text/css" href="style/jHtmlArea.css"/>
        <link rel="stylesheet" type="text/css" href="css/classical.css"/>    
</head>
<body>
        
            <header id="header">
                <div id="main">
                    
                
            <div class="sec-header">
                <h2 class="none">创意合伙人</h2>
                <nav class="nav-head">
                    <h2 class="none">网站导航</h2>
                    <ul>
                        <li class="logo" style="width:300px; height:60px;"></li>
                        <li style="width: 90px;"><a href="../Friends" class="" ><i class="main"></i>首页</a></li>
                        <li><a href="../Friends/cooperation" class="left-border" ><i class="companel"></i>合伙人</a></li>
                        <li><a href="../Friends/classical" class="left-border active" ><i class="show"></i>创意贴</a></li>
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
<!--              <h4>Pengjian发表于2017年4月</h4>
            <h3>门锁革命</h3>
            <div class="editor">
		            我的室内门锁点子特点是极大方便开启门，使用者只要随手就可以打开门，不在需要拧的动作。面世后会被广大消费者喜欢认可。自认为将是锁业的划时代的一次革命。成本也不多，不需要更换太多设备。想与制锁企业合作探讨研发意向。
            </div>
            <div class="bottom">
                <span class="comment">64条评论</span>
                <span class="comment">256个赞</span>
                <span class="comment">16个踩</span>
                <span class="up">收起</span>
            </div>
                <hr noshade="noshade" size="1" />  
                <div class="comment_list"></div> -->
            
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

                <div class="modal fade" style="display:none" id="sendmsg" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            &times;
                        </button>
                        <h4 class="modal-title" id="myModalLabel">
                            发布消息
                        </h4>
                    </div>
                    <div class="modal-body">
                        <form id="loginform" action="checkLogin">   
                        <label>标题:</label>
                        <input type="text" class="texttitle" name="title" placeholder="请输入标题" />
                        <label>请输入正文:</label>
                        <textarea class="textarea"></textarea>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">退出
                        </button>
                        <button type="button" id="sendmsgbutton" class="btn btn-primary">
                            发布
                        </button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal -->
        </div>
        
        
        <!-- 悬浮在右中心的发帖刷新以及返回顶部等功能按钮 -->
        <div class="izl-rmenu">
<!--        <a class="consult"><div class="send"></div></a> -->
            <a class="reload"><div class="reloadd"></div></a>    
            <a class="share"><div class="shared"></div></a>   
               
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
    <script type="text/javascript" src="scripts/jHtmlArea-0.8.js"></script>
    
    <script type="text/javascript" src="js/index.js"></script>
    <script type="text/javascript" src="js/classical.js"></script>
</body>
</html>