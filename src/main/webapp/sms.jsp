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
	<title>OTP Verification</title>

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

		.otp-container {
			text-align: center;
			background-color: #fff;
			border-radius: 10px;
			padding: 20px;
			box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
		}

		.otp-input {
			font-size: 24px;
			padding: 10px;
			width: 60px;
			text-align: center;
			border: 1px solid #ccc;
			margin: 5px;
		}

		.submit-button {
			margin-top: 20px;
			background-color: #007bff;
			color: #fff;
			border: none;
			padding: 10px 20px;
			font-size: 18px;
			cursor: pointer;
			border-radius: 5px;
		}

		.alert {
			margin-top: 10px;
			color: #dc3545;
		}

		h2 {
			color: #333;
		}

		p {
			color: #666;
		}
	</style>
</head>

<body>
	<% String Mess=(String) request.getAttribute("Mess"); Mess=((Mess==null) ? "" : Mess); %>
		<div class="otp-container">
			<h2>Enter OTP Code</h2>
			<p>A 6-digit code has been sent to your email.</p>
			<div class="${legnthUrl > 0 ? " alert alert-danger" : "" }" role="alert">${Mess}</div>
			<form action="changePassWordServlet" method="post">
				<div>

					<input class="otp-input" type="number" maxlength="1" name="o1" /> <input class="otp-input"
						type="number" maxlength="1" name="o2" /> <input class="otp-input" type="number" maxlength="1"
						name="o3" /> <input class="otp-input" type="number" maxlength="1" name="o4" /> <input
						class="otp-input" type="number" maxlength="1" name="o5" /> <input class="otp-input"
						type="number" maxlength="1" name="o6" />
				</div>
				<button class="submit-button" type="submit">Submit</button>
			</form>
		</div>
</body>

</html>