$(function(){
	
	
	
	$('#member,#logout').hide();
	
	$('#reg_a').bind('click',function(){  //注册按钮单击事件
		$('#reg').modal('show');
		$('#reg input[name=user]').focus();
	});
	if($.cookie('user')){              //判断当前页面的user cookies是否存在，
		$('#member , #logout').show();
		$('#reg_a , #login_a').hide();
		$('#member').html('<i class="userimg"></i>'+$.cookie('user'));
	}else{
		$('#member , #logout').hide();
		$('#reg_a , #login_a').show();
	}
	
	$('#logout').click(function(){
		$.ajax({
			url:'../Friends/logout',
			data: {
				user:$.cookie('user'),
			},
			success:function(){
				
			},
		});	
		$.removeCookie('user');
		window.location.href='/Friends/'
	});
	
	$('#register').click(function(){
		
		$.ajax({
			url: '../Friends/checkReg',
			type:'GET',
			data:$('#regform').serialize(),
			success: function(data){
				if(data.state=='true'){
					$.cookie('user',$('#reg #user').val());
					$('#reg').modal('hide');
			//		$('#loading').css('background','white url(../img/success.gif) no-repeat 0px center');
				//	$('#loading').html('注册成功...');
					$('#member').html('<i class="userimg"></i>'+$.cookie('user'));
					
					setTimeout(function(){
				//		$('#loading').modal('hide');
						$('#reg_a,#login_a').hide();
						$('#member,#logout').show();
						window.location.href='/Friends/cooperation'
					},1000);
				}else if(data.state=='pass'){
					$('.reg_error').html('两个密码必须一致！');
				}
				else if(data.state=="QQ"){
					$('.reg_error').html('请输入正确的QQ号 ！');
				}
				else if(data.state=="short"){
					$('.reg_error').html('密码长度不得小于6位！');
				}
				else{
					$('.reg_error').html('账号重名，请重新输入用户名！');
				}
			},
			
		});
	});
	$('#login_a').click(function(){
		$('#login').modal('show');
	});
	$('#loginbutton').click(function(){
		$.ajax({
			url: '../Friends/checkLogin',
			type:'GET',
			data:$('#loginform').serialize(),
			success: function(data){
				if(data.state=='true'){
					$.cookie('user',$('#login #user').val());
					$('#login').modal('hide');
					$('#member').html('<i class="userimg"></i>'+$.cookie('user'));
					
					setTimeout(function(){
				//		$('#loading').modal('hide');
						$('#reg_a,#login_a').hide();
						$('#member,#logout').show();
						$('.login_error').html('');
						window.location.href=window.location.href;
					},500);
				}
				else{
					$('.login_error').html('用户名或密码错误！');
				}
			},
			
		});
	});
	
	/*返回顶部*/
	 $(".btn_top").hide();
		$(".btn_top").bind("click",function(){
			$('html, body').animate({scrollTop: 0},300);return false;
		});
		$(window).bind('scroll resize',function(){
			if($(window).scrollTop()<=300){
				$(".btn_top").hide();
			}else{
				$(".btn_top").show();
			}
		});
		
		$('#member').on('click',function(){
	        location.href = "myself";

		});
	
});

