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
	<title>Change Password</title>
	<style>
		body {
			font-family: Arial, sans-serif;
			background-color: #f4f4f4;
			margin: 0;
			padding: 0;
			display: flex;
			justify-content: center;
			align-items: center;
			height: 100vh;
		}

		.change-password-container {
			text-align: center;
			background-color: #fff;
			border-radius: 10px;
			padding: 20px;
			box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
		}

		.password-input {
			width: 100%;
			padding: 10px;
			margin-bottom: 10px;
		}

		.change-button {
			background-color: #007bff;
			color: #fff;
			border: none;
			padding: 10px 20px;
			font-size: 18px;
			cursor: pointer;
		}

		.change-button:hover {
			background-color: #0056b3;
		}
	</style>
</head>

<body>
	<div class="change-password-container">
		<h2>Change Password</h2>
		<% String Mess=(String) request.getAttribute("Mess"); Mess=(Mess==null ? "" : Mess); String newPassword=(String)
			request.getAttribute("newPassword"); newPassword=(newPassword==null ? "" : newPassword); String
			re_newPassword=(String) request.getAttribute("re_newPassword"); re_newPassword=(re_newPassword==null ? "" :
			re_newPassword); %>


			<form action="renewPassWordServlet" method="post">
				<h4 class="${LengthMess > 0 ? " alert alert-danger":"" }" role="alert">
					<%=Mess%>
				</h4>
				<input type="password" class="password-input" name="newPassword" placeholder="New Password" required
					value="<%=newPassword%>">
				<input type="password" class="password-input" name="re-newPassword" placeholder="Confirm Password"
					required value="<%=re_newPassword%>">
				<button type="submit" class="change-button">Change Password</button>
			</form>
	</div>
</body>

</html>