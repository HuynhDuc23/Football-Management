<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="en">

<head>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="author" content="Yinka Enoch Adedokun">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
	integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<title>Register</title>
<link rel="stylesheet" href="css/login.css">
</head>

<body>
	<!-- Main Content -->
	<div class="container-fluid">
		<div class="row main-content bg-success text-center">
			<div class="col-md-4 text-center company__info">
				<img src="imgs/ui/LogoFootball.png" alt="LogoFootball">
			</div>
			<div class="col-md-8 col-xs-12 col-sm-12 login_form ">
				<div class="container-fluid">
					<div class="anmation-login-sign p-3">
						<h2>SIGN UP</h2>
					</div>
					<form control="" class="form-group" action="validateFormServlet?action=register" method="post">		
							<div class=" ${lengthUrl>0?" alert
								alert-danger":"" }" id="myAlert">${Mess}</div>
							<div class="row">
								<div class="color-login-sign">
									<i class="fa-solid fa-user"></i> <span>Email</span>
								</div>
								<input type="email" name="email" id="email" class="form__input"
									placeholder="enter your email" required value="${email}">
							</div>
						

						<div class="row">

							<div class="color-login-sign">
								<i class="fa-solid fa-lock"></i> <span>Password</span>
							</div>
							<input type="password" name="password" id="password"
								class="form__input" placeholder="enter your password" required>
						</div>
						<div class="row">
							<div class="color-login-sign">
								<i class="fa-solid fa-lock"></i> <span>Confirm password</span>
							</div>
							<input type="password" name="re-password" id="re-password"
								class="form__input" placeholder="re-enter your password"
								required>
						</div>
						<div class="row_center">
							<input type="submit" value="Submit" class="btn">
						</div>
						<div class="row_center">
							<p>
								Do you already have an account? <a href="login.jsp">Sign in</a>
							</p>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>