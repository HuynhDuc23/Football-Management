<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
		integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
		integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
		crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js"
		integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa"
		crossorigin="anonymous"></script>
	<title>Password Reset</title>
	<style>
		/* CSS để căn giữa card */
		.centered-card {
			display: flex;
			justify-content: center;
			align-items: center;
			height: 100vh;
		}

		/* CSS cho phần form */
		.card {
			width: 100%;
			max-width: 400px;
		}

		/* CSS cho đường link "Login" và "Register" */
		.d-flex a {
			text-decoration: none;
			color: #007bff;
		}

		.d-flex a:hover {
			text-decoration: underline;
		}

		.inner-css {
			margin-top: 10px;
		}
	</style>
</head>

<body>
	<% String email=(String) request.getAttribute("email"); email=((email==null) ? "" : email); String Mess=(String)
		request.getAttribute("Mess"); Mess=((Mess==null) ? "" : Mess); %>
		<div class="container">
			<div class="centered-card">
				<div class="card text-center">
					<div class="card-header h5 text-white bg-primary">Password
						Reset</div>
					<div class="card-body">
						<p class="card-text py-2">Enter your email address and we'll
							send you an email with instructions to reset your password.</p>
						<form action="checkMailServlet" method="post">
							<div class="${lengthUrl > 0 ? " alertalert-danger" : "" }">${Mess}</div>
							<div class="form-group">
								<input type="email" id="typeEmail" class="form-control" name="email" required
									value="<%=email%>">
							</div>
							<button type="submit" class="btn btn-primary btn-block inner-css">Reset
								Password</button>
						</form>
						<div class="d-flex justify-content-between mt-4">
							<a href="login.jsp">Login</a> <a href="register.jsp">Register</a>
						</div>
					</div>
				</div>
			</div>
		</div>
</body>

</html>