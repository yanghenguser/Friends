$(function(){
	
	$('.textarea').htmlarea();
	
	$.ajax({
		url:'../Friends/getmsgdata',
		type:'GET',
		success:
			function(response, stutas, xhr) {
				for(var i=0 ;i<response.length;i++)
				{
					
					var message=response[i].msgbody;
					if(message.length >= 200){
						message = message.substring(0,198)+'<a class = "showall" href="javascript:void(0)"> .....展开全部</a>';
					}
					
					var date = new Date(response[i].msgdate) ;
					var year = date.getFullYear() ;
					var month = date.getMonth() +1;
					var day = date.getDate() ;
					var hour = date.getHours() ;
					var minute = date.getMinutes() ;

					var msgdate = year + '-' + month + '-' + day +'&nbsp;&nbsp;'+ hour +':'+ minute; 
					if($.cookie('user')){
						$.ajax({
							url:"../Friends/getIsSupported",
							data:{
								msgid:response[i].msgid,
								username:$.cookie('user'),
							},
							async: false,
							success:function(data1){
								if(data1==1){
									$('.content').append(
											'<div class="article"><h4><i class="userimg"></i><span>'+response[i].msguser+"</span>&nbsp;&nbsp;&nbsp;"+msgdate+'<h4>'
											+'<h3>'+response[i].msgtitle+'</h3>'
											+'<div class = "editor">'+message+'</div>'
											+'<div class="bottom"><span class="comment pinlun">'+response[i].commentnum+'条评论</span>'
											+'<span class="comment supmsg"><i class="zan-active"></i>'+response[i].likenum+'</span>'
											+'<span class="comment losmsg"><i class="cai"></i>'+response[i].dislikenum+'</span>'
											+'<div class = "contact"><img class ="img_qq" src = "../Friends/img/qq.png" title = "联系贴主"></img>联系此人</div>'
											+'<div class="load"></div>'
											+'<div class="comment_list"> </div><hr noshade="noshade" size="1" />'
									) ;
								}
								else if(data1==-1){
									$('.content').append(
											'<div class="article"><h4><i class="userimg"></i><span>'+response[i].msguser+"</span>&nbsp;&nbsp;&nbsp;"+msgdate+'<h4>'
											+'<h3>'+response[i].msgtitle+'</h3>'
											+'<div class = "editor">'+message+'</div>'
											+'<div class="bottom"><span class="comment pinlun">'+response[i].commentnum+'条评论</span>'
											+'<span class="comment supmsg"><i class="zan"></i>'+response[i].likenum+'</span>'
											+'<span class="comment losmsg"><i class="cai-active"></i>'+response[i].dislikenum+'</span>'
											+'<div class = "contact"><img class ="img_qq" src = "../Friends/img/qq.png" title = "联系贴主"></img>联系此人</div>'
											+'<div class="load"></div>'
											+'<div class="comment_list"> </div><hr noshade="noshade" size="1" />'
									) ;
								}
								else{
									$('.content').append(
											'<div class="article"><h4><i class="userimg"></i><span>'+response[i].msguser+"</span>&nbsp;&nbsp;&nbsp;"+msgdate+'<h4>'
											+'<h3>'+response[i].msgtitle+'</h3>'
											+'<div class = "editor">'+message+'</div>'
											+'<div class="bottom"><span class="comment pinlun">'+response[i].commentnum+'条评论</span>'
											+'<span class="comment supmsg"><i class="zan"></i>'+response[i].likenum+'</span>'
											+'<span class="comment losmsg"><i class="cai"></i>'+response[i].dislikenum+'</span>'
											+'<div class = "contact"><img class ="img_qq" src = "../Friends/img/qq.png" title = "联系贴主"></img>联系此人</div>'
											+'<div class="load"></div>'
											+'<div class="comment_list"> </div><hr noshade="noshade" size="1" />'
									) ;
								}
								
							

							}
					
						});
					}
					
				}
				
				/*联系此人开始*/
				$.each($('.article'),function(index,value){
					$(this).on('click','.contact',function(){
						var username = $(this).parent().parent().find('h4 span').text() ;
						$.ajax({
							url:"../Friends/getqqnumber",
							type:"GET",
							data:{
								name:username
							},
							success:function(response){
								location.href ="tencent://message/?Menu=yes&uin="+response+"& Service=300&sigT=45a1e5847943b64c6ff3990f8a9e644d2b31356cb0b4ac6b24663a3c8dd0f8aa12a595b1714f9d45";
								
							},
							error:function(){
								alert("error");
							}
							
						});
					});					
				});
				/*联系此人结束*/
				
				$.each($('.article'),function(index,value){
					$(this).on('click','.showall',function(){
						var msg = response[index].msgbody + "<a class = 'hidemsg'  href='javascript:void(0)'> .....收起</a>";
						$(this).parent().html(msg);
					});
					$(this).on('click','.hidemsg',function(){
						var msg = response[index].msgbody.substring(0,198) + "<a class = 'showall'  href='javascript:void(0)'> .....展开全部</a>";
						$(this).parent().html(msg);
					});
				});
				

				
				$.each($('.article'),function(index,value){
					
					$(this).on('click','.supmsg',function(){
						if($.cookie('user')){
							$.ajax({
								url:'../Friends/supportmsg',
								data:{
									msgid:response[index].msgid,
									likenum:response[index].likenum,
									username:$.cookie('user')
								},
								success:function(data){
									if(data==-1){
										
									}else{
										$('.supmsg').eq(index).html('<i class="zan-active">></i>'+data);
									}	 
								}
							});
						}
						else{
							$('#loading').html('请先登录后在操作...');
							$('#loading').css({
								background:'#fff',
								width:'200px'
							});
							$('#loading').modal('show');
							setTimeout(function(){
								$('#loading').modal('hide');
								$('#loading').html('数据交互中...');
								$('#login').modal('show');
							},1000);
						}
						
					});
				});
				
				$.each($('.article'),function(index,value){
					
					$(this).on('click','.losmsg',function(){
						if($.cookie('user')){
							$.ajax({
								url:'../Friends/losmsg',
								data:{
									msgid:response[index].msgid,
									dislikenum:response[index].dislikenum,
									username:$.cookie('user')
								},
								success:function(data){
									if(data==-1){
										
									}else{
										$('.losmsg').eq(index).html('<i class="cai-active"></i>'+data);
									}	 
								}
							});
						}
						else{
							$('#loading').html('请先登录后在操作...');
							$('#loading').css({
								background:'#fff',
								width:'200px'
							});
							$('#loading').modal('show');
							setTimeout(function(){
								$('#loading').modal('hide');
								$('#loading').html('数据交互中...');
								$('#login').modal('show');
							},1000);
						}
						
					});
				});
				
				$.each($('.article'),function(index,value){
					$(this).on('click','.pinlun',function(){
						
					if($.cookie('user')){
						
						if(	$('.comment_list:eq('+index+')').is(':hidden')){
							$('.load').eq(index).show();
							setTimeout(function(){
								$('.load').eq(index).hide();
								$('.comment_list:eq('+index+')').slideDown();
							},700);
							
							$.ajax({
								url:"../Friends/getcomment",
								data:{
									msgid:response[index].msgid,
								},
								dataType:"json",
								success:function(data2){
									var comments="";
									for(var i=data2.length-1;i>=0;--i){
										comments+='<dl><dt>'+data2[i].username+'：<span>'+data2[i].comment+'</span></dt>';
									}
									comments+='<dl><dt><input type="text" id="commenttext" name="comment" /><button class="btn btn-primary" id="subcomment">评论</button></dt></dl></div>'
									$('.comment_list:eq('+index+')').prepend(comments);
									
								}
							});
							
						}else{
							$('.comment_list:eq('+index+')').slideUp();
							$('.comment_list dl').remove();
						}
					}else{
						$('#loading').html('请先登录后在操作...');
						$('#loading').css({
							background:'#fff',
							width:'200px'
						});
						$('#loading').modal('show');
						setTimeout(function(){
							$('#loading').modal('hide');
							$('#loading').html('数据交互中...');
							$('#login').modal('show');
						},1000);
					}
						
						
						
						
					});
				});
				

				
				$.each($('.article'),function(index,value){
					$(this).on('click','#subcomment',function(){
						$.ajax({
							url:"../Friends/subcomment",
							data:{
								msgid:response[index].msgid,
								username:$.cookie('user'),
								comment:$(this).parent().find('#commenttext').val()	
							},
							success:function(data){
								
								var comment='<dl><dt>'+$.cookie('user')+'：<span>'+$('.comment_list').eq(index).find('#commenttext').val()+'</span></dt>';
								$('.comment_list:eq('+index+')').prepend(comment);
								$('.comment_list').eq(index).find('#commenttext').val('');
								$('.pinlun').eq(index).html(data+'条评论');
							}
						});
					});
				});
								
		},
	});
	
	
	
	$('.consult').click(function(){
		if($.cookie('user')){
			$('#sendmsg').modal('show');
		}else{
			$('#loading').html('请先登录后在操作...');
			$('#loading').css({
				background:'#fff',
				width:'200px'
			});
			$('#loading').modal('show');
			setTimeout(function(){
				$('#loading').modal('hide');
				$('#loading').html('数据交互中...');
				$('#login').modal('show');
			},1000);
			
		}	
		
	});
	$('#sendmsgbutton').bind('click',function(){
		$.ajax({
			url: "../Friends/postmsg",
			data:{
				msgtitle:$('#sendmsg input').val(),
				msgbody:$('.textarea').val(),
				username:$.cookie('user'),
			},
			success:function(data){
				window.location.href='/Friends/cooperation'
			}
		});
	});
	
	$('.reload').bind('click',function(){
		window.location.href='/Friends/cooperation'
	});
	
	$('.share').bind('click',function(){
		 /*var shareqqzonestring='http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?summary='+"title"+'&url='+"http//:www.baidu.com";  
		 window.open(shareqqzonestring,'newwindow','height=400,width=400,top=100,left=100'); */ 
		var _width=400;
		var _height=400;
		
		var _shareUrl = 'http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?';
	    _shareUrl += 'url=' + encodeURIComponent("http://dnabw43275.java.cdnjsp.org/");   //参数url设置分享的内容链接|默认当前页location
	    _shareUrl += '&showcount=' + 1;      //参数showcount是否显示分享总数,显示：'1'，不显示：'0'，默认不显示
	    _shareUrl += '&desc=' + encodeURIComponent('分享的描述');    //参数desc设置分享的描述，可选参数
	    _shareUrl += '&summary=' + encodeURIComponent('分享摘要');    //参数summary设置分享摘要，可选参数
	    _shareUrl += '&title=' + encodeURIComponent("hello");    //参数title设置分享标题，可选参数
	    _shareUrl += '&site=' + encodeURIComponent('');   //参数site设置分享来源，可选参数
	    _shareUrl += '&pics=' + encodeURIComponent('');   //参数pics设置分享图片的路径，多张图片以＂|＂隔开，可选参数
	    window.open(_shareUrl,'_blank','width='+_width+',height='+_height+',top='+(screen.height-_height)/2+',left='+(screen.width-_width)/2+',toolbar=no,menubar=no,scrollbars=no,resizable=1,location=no,status=0');
	});
	
	
});