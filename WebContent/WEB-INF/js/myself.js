$(function(){
	$('.nav li ').click(function(){
		
		$('.article').remove();
		
		var tab_text = ['基本信息','发表的帖子','评论的帖子','赞过的帖子','踩过的帖子']
		$('.nav li ').removeClass("active") ;
		$(this).addClass("active") ;
		var index = $('.nav li').index($(this)) ;
		$('.body_content').parent().find(".body_tab .tab_text").text(tab_text[index]) ;
		$('.body_content').addClass("hide") ;
		

		
		if(index >= 1)
		{
			$('.body_content:eq(1)').removeClass("hide") ;
			$('.body_content:eq(1)').text("");
			if(index == 1){
				mymsg() ;
			}
			else if(index == 2){
				commentedmsg() ;
			}
		}
			
		else{
			$('.body_content:eq(0)').removeClass("hide") ;

		}
						

	});
	
});

function mymsg(){
	$.ajax({
		url:'../Friends/mymsg',
		type:'GET',
		data:{
			name:$.cookie('user')
		},
		success:
			function(response, stutas, xhr) {
				for(var i=0 ;i<response.length;i++)
				{
					var date = new Date(response[i].msgdate) ;
					var year = date.getFullYear() ;
					var month = date.getMonth() +1;
					var day = date.getDate() ;
					var msgdate = year + '年' + month + '月' + day +'日' ; 
					$('div.body_content').append(
							'<div class="article"><h4>'+$.cookie('user')+"--"+msgdate+'<h4>'
							+'<h3>'+response[i].msgtitle+'</h3>'
							+'<div class = "editor">'+response[i].msgbody+'</div>'
							+'<div class="bottom"><span class="comment">'+response[i].commentnum+'条评论</span>'
							+'<span class="comment">'+response[i].likenum+'赞</span>'
							+'<span class="comment">'+response[i].dislikenum+'踩</span>'
							+'<span class="up">收起</span>'
							+'<hr noshade="noshade" size="1" /><div class="comment_list"></div></div>'
					) ;

				}
								
		},
		error:
			function(){

		}
	});
}


function commentedmsg(){
	$.ajax({
		url:'../Friends/commentedmsg',
		type:'GET',
		data:{
			name:$.cookie('user')
		},
		success:
			function(response, stutas, xhr) {
				for(var i=0 ;i<response.length;i++)
				{
					var date = new Date(response[i].msgdate) ;
					var year = date.getFullYear() ;
					var month = date.getMonth() +1;
					var day = date.getDate() ;
					var msgdate = year + '年' + month + '月' + day +'日' ; 
					$('div.body_content').append(
							'<div class="article"><h4>'+$.cookie('user')+"--"+msgdate+'<h4>'
							+'<h3>'+response[i].msgtitle+'</h3>'
							+'<div class = "editor">'+response[i].msgbody+'</div>'
							+'<div class="bottom"><span class="comment">'+response[i].commentnum+'条评论</span>'
							+'<span class="comment">'+response[i].likenum+'赞</span>'
							+'<span class="comment">'+response[i].dislikenum+'踩</span>'
							+'<span class="up">收起</span>'
							+'<hr noshade="noshade" size="1" /><div class="comment_list"></div></div>'
					) ;

				}
								
		},
		error:
			function(){

		}
	});
}



$(function(){
	$.ajax({
		url:"../Friends/baseinfo" ,
		type:'GET',
		data:{
			name:$.cookie('user') 
		},
		success:
			function(response){
				$('.name').text(response[0].username) ;
				$('.sex').text(response[0].usersex) ;
				$('.QQ').text(response[0].userqq) ;
				$('.remark').text(response[0].userremark);
			},
		error:
			function(){
				alert("shibai") ;
		}
		
	});
});



