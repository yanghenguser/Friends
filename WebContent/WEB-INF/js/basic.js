$(function(){
	var data="";
	$.ajax({
		url:"../Friends/getnotes",
		datatype:"json",
		success:function(data){
			
			data=data;
			var index=data.length>6?data.length-6:0;
			var notes="";
			for(var i=data.length-1;i>=index;i--){
				if($.cookie('user')){
					$.ajax({
						url:"../Friends/getIsdot",
						data:{
							noteid:data[i].noteid,
							username:$.cookie('user'),
						},
						async: false,
						success:function(data1){
							if(data1==1){
								notes+='<li><a class="notebox" href="javascript:void(0)"> <h2>'+data[i].username+'</h2><p>'+data[i].note.substring(0,60)+'</p><span class="support"><i class="zan-active"></i>('+data[i].likenum+')</span><span class="loose"><i class="cai"></i>('+data[i].dislikenum+')</span></a></li>';
							}
								
							else if(data1==-1) //待会加上cai-active
								notes+='<li><a class="notebox" href="javascript:void(0)"> <h2>'+data[i].username+'</h2><p>'+data[i].note.substring(0,60)+'</p><span class="support"><i class="zan"></i>('+data[i].likenum+')</span><span class="loose"><i class="cai-active"></i>('+data[i].dislikenum+')</span></a></li>';
							else
								notes+='<li><a class="notebox" href="javascript:void(0)"> <h2>'+data[i].username+'</h2><p>'+data[i].note.substring(0,60)+'</p><span class="support"><i class="zan"></i>('+data[i].likenum+')</span><span class="loose"><i class="cai"></i>('+data[i].dislikenum+')</span></a></li>';
						}
					});
					
				}
				else
					notes+='<li><a class="notebox" href="javascript:void(0)"> <h2>'+data[i].username+'</h2><p>'+data[i].note.substring(0,60)+'</p><span class="support"><i class="zan"></i>('+data[i].likenum+')</span><span class="loose"><i class="cai"></i>('+data[i].dislikenum+')</span></a></li>';
			
				
			}
			
			$('.notes').append(notes);
			if(index==0){
				$('#more').html('已经到底了...').css({
					background:'#ddd',
					color:'#fff',
				}).unbind('click');
			}
			
			$('#more').click(function(){
				var notes="";
				for(var i=data.length-7;i>=0;i--){
					
					if($.cookie('user')){
						$.ajax({
							url:"../Friends/getIsdot",
							data:{
								noteid:data[i].noteid,
								username:$.cookie('user'),
							},
							async:false,
							cache :false,
							success:function(data1){
								if(data1==1){
									notes+='<li><a class="notebox" href="javascript:void(0)"> <h2>'+data[i].username+'</h2><p>'+data[i].note.substring(0,60)+'</p><span class="support"><i class="zan-active"></i>('+data[i].likenum+')</span><span class="loose"><i class="cai"></i>('+data[i].dislikenum+')</span></a></li>';
								}
									
								else if(data1==-1) //待会加上cai-active
									notes+='<li><a class="notebox" href="javascript:void(0)"> <h2>'+data[i].username+'</h2><p>'+data[i].note.substring(0,60)+'</p><span class="support"><i class="zan"></i>('+data[i].likenum+')</span><span class="loose"><i class="cai-active"></i>('+data[i].dislikenum+')</span></a></li>';
								else
									notes+='<li><a class="notebox" href="javascript:void(0)"> <h2>'+data[i].username+'</h2><p>'+data[i].note.substring(0,60)+'</p><span class="support"><i class="zan"></i>('+data[i].likenum+')</span><span class="loose"><i class="cai"></i>('+data[i].dislikenum+')</span></a></li>';
							}
						});
						
					}
					else
						notes+='<li><a class="notebox" href="javascript:void(0)"> <h2>'+data[i].username+'</h2><p>'+data[i].note.substring(0,60)+'</p><span class="support"><i class="zan"></i>('+data[i].likenum+')</span><span class="loose"><i class="cai"></i>('+data[i].dislikenum+')</span></a></li>';	
			
			}
			
			$('.notes').append(notes);
			$('#more').html('已经到底了...');
			$('#more').css({
				background:'#ddd',
				color:'#fff',
			}).unbind('click');
			
			$.each($('.notebox'),function(index,value){
				$(this).on('click','.support',function(){
					$.ajax({
						url:'../Friends/supportnote',
						data:{
							noteid:data[data.length-index-1].noteid,
							likenum:data[data.length-index-1].likenum,
							user:$.cookie('user')
						},
						success:function(data){
							if(data==-1){
								
							}else{
								$('.support').eq(index).html('<i class="zan-active"></i>('+data+')');
							}
							 
						}
					});
				});
				
				$(this).on('click','.loose',function(){
					$.ajax({
						url:'../Friends/dislikenote',
						data:{
							noteid:data[data.length-index-1].noteid,
							dislikenum:data[data.length-index-1].dislikenum,
							user:$.cookie('user')
						},
						success:function(data){
							if(data==-1){
								
							}else{
								$('.loose').eq(index).html('<i class="cai-active"></i>('+data+')');
							}
							 
						}
					});
				});
			});
			});
			
			/*检查该登录用户是否为某个note点过赞*/
			/*考虑可以放在初始化时的for循环里面嵌套一个ajax来完成判断的功能*/
			/*
			if($.cookie('user')){
				$.ajax({
					url:"../Friends/getIsdot"
				});
			}
			*/

			
			$.each($('.notebox'),function(index,value){
				$(this).on('click','.support',function(){
					$.ajax({
						url:'../Friends/supportnote',
						data:{
							noteid:data[data.length-index-1].noteid,
							likenum:data[data.length-index-1].likenum,
							user:$.cookie('user')
						},
						success:function(data){
							if(data==-1){
								
							}else{
								$('.support').eq(index).html('<i class="zan-active"></i>('+data+')');
							}
							 
						}
					});
				});
				
				$(this).on('click','.loose',function(){
					$.ajax({
						url:'../Friends/dislikenote',
						data:{
							noteid:data[data.length-index-1].noteid,
							dislikenum:data[data.length-index-1].dislikenum,
							user:$.cookie('user')
						},
						success:function(data){
							if(data==-1){
								
							}else{
								$('.loose').eq(index).html('<i class="cai-active"></i>('+data+')');
							}
							 
						}
					});
				});
			});
		}
	});
	
	$('.speak').click(function(){
		if($.cookie('user')){
			$('#speaks').modal('show');
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
	$('#tucao').bind('click',function(){
		$.ajax({
			url:"../Friends/tucao",
			data:{
				user:$.cookie('user')+':',
				note:$('#Notes').val(),
			},
			success:function(data){
				window.location.href='/Friends/'
			}
		});
	});
	});