<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Payments - registration</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="wrapper">
		<div class="header">
			<div class="main_menu_box">
				<ol class="main_menu">
					<li class="main_menu_item"><a href="MainServlet?command=home">home</a></li>
					<li class="main_menu_item"><a href="MainServlet?command=system">system</a></li>
					<li class="main_menu_item"><a href="MainServlet?command=login">login</a></li>
					<li class="main_menu_item"><a href="MainServlet?command=about">about</a></li>
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
							<label for="register_name">
								Name
							</label>
							<input id="register_name" type="text"  name="name" maxlength="100" required/>
						</div>
						<div class="login_item">
							<label for="register_age">
								Age
							</label>
							<input id="register_age" type="text"   name="age" pattern="[1-9][0-9]{0,2}" required/>
						</div>
						<div class="login_item">
							<label for="login_login">
								Login
							</label>
							<input id="login_login" type="text"    name="login" maxlength="20" required/>
						</div>
						<div class="login_item">
							<label for="login_pass">
								Password
							</label>
							<input id="login_pass" type="password" name="pass" maxlength="20" required/>
						</div>
						<div class="login_item">
							<label for="login_re_pass">
								Re-enter password
							</label>
							<input id="login_re_pass" type="password" name="re_pass" maxlength="20" required/>
						</div>
						<div class="login_item">
							<input type="submit"   value="register" />
						</div>
						<input type="hidden"   name="role" value="3"/>
						<input type="hidden"   name="command" value="reg_validation"/>
					</form>
				</div>
			</div>
			
		</div>
		<div class="footer">
			
		</div>
	</div>
</body>
</html>