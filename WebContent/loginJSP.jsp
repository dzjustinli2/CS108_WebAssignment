<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<title>Login</title>
</head>

<body>

<div class="container-fluid app">
	<div class="row">
		<div class="col-md-8 col-md-offset-2">
		
	<h1 class="text-center"><%= request.getAttribute("title") %></h1>
	<p class="text-center"><%= request.getAttribute("message") %></p>
	<br>
	<form class="form-horizontal" action="login" method="post">
		<div class="form-group">
			<label for="login-email" class="col-sm-3 control-label">Email:</label>
			<div class="col-sm-6">
		    <input name="username" class="form-control">
		  </div>
		</div>
		
		<div class="form-group">
			<label for="login-password" class="col-sm-3 control-label">Password:</label>
			<div class="col-sm-6">
		    <input type="password" name="password" class="form-control">
		  </div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-offset-3 col-sm-6">
		    <button type="submit" class="btn btn-success">Login</button>
		  </div>
		</div>
	</form> 

		</div>
	</div>
</div>

</body>

</html>