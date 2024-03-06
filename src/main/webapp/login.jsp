<html lang="en">

<head>
	<meta charset="UTF-8">

	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="author" content="Yinka Enoch Adedokun">

	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
		integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

	<title>Login Page</title>
	<link rel="stylesheet" href="css/login.css">
</head>

<body>
    
	<%
	// Hien Thi Cookie 60s
	Cookie[] arrCookie = request.getCookies();
	String email = "";
	String pass = "";
	if (arrCookie != null) {
		for (Cookie c : arrCookie) {
			if (c.getName().equals("emailC")) {
		email = c.getValue();
			}
			if (c.getName().equals("passCookie")) {
		pass = c.getValue();
			}
		}
	}
	%>

	<!-- Main Content -->
	<div class="rectangle" id="rectangleBody">
		<div class="row main-content text-center">
			<div class="col-md-4 text-center company__info">
				<img src="imgs/ui/LogoFootball.png" alt="LogoFootball">
			</div>
			<div class="col-md-8 col-xs-12 col-sm-12 login_form ">
				<div class="container-fluid">
					<div class="anmation-login-sign p-3">
						<h2>LOGIN</h2>
					</div>
					<div class=" ${lengthUrl>0 ?" alert alert-danger":"" }" id="myAlert">${Mess}</div>
					<div class=" ${lengthAlert>0 ?" alert alert-info":"" }" id="myAlert">${Alert}</div>

					<form control="" class="form-group" action="validateFormServlet?action=login" method="post">
						<div class="row">
							<div class="color-login-sign">
								<i class="fa-solid fa-user"></i> <span>Email</span>
							</div>
							<input type="email" name="email" id="email" class="form__input" value="<%=email %>"
								placeholder="enter your email" required>
						</div>
						<div class="row">
							<div class="color-login-sign">
								<i class="fa-solid fa-lock"></i> <span>Password</span>
							</div>
							<input type="password" name="password" id="password" class="form__input" value="<%=pass %>"
								placeholder="enter your password" required>
						</div>
						<div class="row ">
							<input type="checkbox" name="remember_me" id="remember_me" style="margin-right: 5px;">
							<label for="remember_me" class="m-0">Remember Me!</label>
						</div>
						<div class="row">
							<input type="submit" value="Submit" class="btn">
						</div>
						<div class="row_center">
							<a href="mail.jsp">Forgot your password?</a>
						</div>
						<div class="row_center">
							<p>Don't have an account? <a href="register.jsp">Register</a></p>
						</div>
					</form>

				</div>
			</div>
		</div>
	</div>
	<!-- Footer -->

</body>