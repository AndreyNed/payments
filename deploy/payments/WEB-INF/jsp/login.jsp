<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment system - login</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="wrapper">
		<div class="header">
			<div class="main_menu_box">
				<ol class="main_menu">
					<li class="main_menu_item"><a href="MainServlet?command=login">home</a></li>
					<li class="main_menu_item"><a href="#">system</a></li>
					<li class="main_menu_item"><a href="#">login</a></li>
					<li class="main_menu_item"><a href="#">about</a></li>
				</ol>
			</div>
		</div>
		<!-- <div class="aside">
			
		</div> -->
		<div class="main_region">
			<div class="login_box">
				<div class="login_header">
					<span>Enter your login and password</span>
				</div>
				<div class="login_body">
					<form action="MainServlet" method="post">
						<div class="login_item">
							<label for="login_login">
								Login
							</label>
							<input id="login_login" type="text"     name="login" />
						</div>
						<div class="login_item">
							<label for="login_pass">
								Password
							</label>
							<input id="login_pass" type="password" name="pass" />
						</div>
						<div class="login_item">
							<input type="submit"   value="login" />
						</div>
						<input type="hidden"   name="command" value="authorize"/>
					</form>
				</div>
			</div>
			
		</div>
		<div class="footer">
			
		</div>
	</div>
</body>
</html>