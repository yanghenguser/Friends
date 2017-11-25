<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<%@page isELIgnored="false" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
	<meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
</head>  
 <script type="text/javascript" src="js/jquery-3.2.0.min.js"></script> 
  <script type="text/javascript" src="js/jquery.form.js"></script> 
 
<body>  
    <table>  
          
        <tr>  
            <td colspan="2">  
                <form id="formPhoto" enctype="multipart/form-data">  
                    <table>  
                        <tr>  
                            <td>选择文件:<input type="file" name="file" id="image_input"></td>  
                            <td><input type="button" value="上传" id="upLoadImg"/></td>  
                        </tr>  
                    </table>  
                </form>  
            </td>  
        </tr>  
          
        <tr>  
            <td colspan="2">  
                <div id="imgDiv">
                <!-- <img src="touxiang/girl.png" /> -->
                </div>  
            </td>  
        </tr>  
    </table>
    
    <script type="text/javascript"> 
$(function(){
	$('#upLoadImg').click(function(){
		 var imagePath = $("#image_input").val();  
		    if (imagePath == "") {  
		        alert("please upload image file");  
		        return false;  
		    }  
		    var strExtension = imagePath.substr(imagePath.lastIndexOf('.') + 1);  
		    if (strExtension != 'jpg' && strExtension != 'gif'  
		            && strExtension != 'png' && strExtension != 'bmp') {  
		        alert("please upload file that is a image");  
		        return false;  
		    }  
		    $("#formPhoto").ajaxSubmit({  
		        type : 'POST',  
		        url : 'uploadPhoto',  
		        success : function(data) {  
		            alert("上传成功");  
		            $("#imgDiv").empty();  
		            $("#imgDiv").html('<img src="touxiang/'+data+'"/>');
		            $("#imgDiv").show();  
		        },  
		        error : function() {  
		            alert("上传失败，请检查网络后重试");  
		        }  
		    });  
		  
	});
});

</script> 
<!-- <script type="text/javascript">  
$(function(){
	$('#upLoadImg').click(function(){
		var imagePath = $("#image_input").val();  
	    if (imagePath == "") {  
	        alert("please upload image file");  
	        return false;  
	    }  
	    var strExtension = imagePath.substr(imagePath.lastIndexOf('.') + 1);  
	    if (strExtension != 'jpg' && strExtension != 'gif'  
	            && strExtension != 'png' && strExtension != 'bmp') {  
	        alert("please upload file that is a image");  
	        return false;  
	    }  
	    $.ajax({
	    	url:"../Friends/uploadPhoto",
	    	type:"POST",
	    	data:{
	    		file:$('#image_input').val(),
	    	},
	    	success:function(data){

	    		 alert("上传成功");  
	             $("#imgDiv").empty();  
	            $("#imgDiv").html('<img src="F:\\java_code\\picture\\'+data+'"/>');//</span><span style="color:#000099;">配置的虚拟路径加上文件名直接显示在div中</span>  
	             $("#imgDiv").show();  
	    	}
	    });
	});  
});

</script>   -->

</body>  
</html> 