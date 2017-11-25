<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
  <tr>
    <td>Message</td>
    <td><input type="text" id="message"></td>
  </tr>
  <tr>
    <td>Name</td>
    <td><input type="text" id="othername"></td>
  </tr>
  <tr>
    <td><input id="sendbutton" type="button" value="send" onClick="click"  disabled="true">
      </input></td>
  </tr>
</table>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/socket.js"></script>
</body>
</html>