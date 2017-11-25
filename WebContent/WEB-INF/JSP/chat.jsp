<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	if(application.getAttribute("mywords").equals(null)){
		application.setAttribute("mywords","Start");
	}
	if(request.getParameter("mywords")!=null){
		String mywords=request.getParameter("mywords");
		mywords=(String)application.getAttribute("mywords")+"<br />"+mywords;
		application.setAttribute("mywords", mywords);
		out.print((String)application.getAttribute("mywords"));
	}
%>
<form action="chat.jsp">
	<input type="text" size="30" name="mywords" value="hello" />
	<input type="submit" name ="submit" value="提交"/>	
</form>

</body>
</html>