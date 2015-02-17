<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<title><%= session.getAttribute("username") %></title>
</head>
<body>
	<h1 class="text-center">Welcome <%= upperTokens((String)session.getAttribute("username")) %></h1>
	<form class="form-horizontal text-center" action="logout" method="post">
		<button type="submit" class="btn btn-danger">Logout</button>
	</form>
</body>
</html>

<%! 
String upperCase(String str){
	if(str == null || str.equals("")) return "";
	str = str.toLowerCase();
	char[] chars = str.toCharArray();
	//This assumes ascii
	chars[0] =(char)(chars[0] + ('A' - 'a'));
	String name = "";
	for(int i = 0; i < chars.length; i++){
		name = name + chars[i];
	}
	return name;
}

String upperTokens(String str){
	if(str == null || str.equals("")) return "";
	String[] userName = str.split(" ");
	String name = "";
	for(int i = 0; i < userName.length; i++){
		name = name + " " + upperCase(userName[i]);
	}
	return name.trim();
}
%>