<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
	integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
	integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
	integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
	crossorigin="anonymous"></script>
<title>Admin Dashboard</title>
<style>
body {
	font-family: 'Poppins', sans-serif;
	background-color: #f0f0f0;
}

.container {
	max-width: 1200px;
	margin: 0 auto;
	padding: 0;
}

.card {
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
}

.card img {
	border-radius: 50%;
	width: 150px;
	height: 150px;
	object-fit: cover;
	margin: 0 auto;
	display: block;
}

.card h4 {
	font-size: 24px;
}

.card p {
	font-size: 16px;
	color: #555;
}

.btn-outline-primary {
	border-color: #007bff;
	color: #007bff;
}

.btn-outline-primary:hover {
	background-color: #007bff;
	color: #fff;
}

.btn-primary {
	background-color: #007bff;
	border-color: #007bff;
}

.btn-primary:hover {
	background-color: #0056b3;
	border-color: #0056b3;
}
</style>
</head>
<body>

	<div class="container">

		<%
		String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath();
		%>
		<section>
			<jsp:include page="/admin/support/header.jsp"></jsp:include>

			<div class="container py-5 h-100">
				<div class="row d-flex justify-content-center align-items-center">
					<div class="col-md-12 col-xl-4">

						<div class="card">
							<div class="card-body text-center">
								<div class="mt-3 mb-4">
									<img src="<%=url%>/${sessionScope.user.img}"
										class="rounded-circle img-fluid" alt="User Avatar" />
								</div>
								<h4 class="mb-2">${sessionScope.user.fullname}</h4>
								<p class="text-muted mb-4">@ducspdn-0702525937</p>
								<div class="mb-4 pb-2">
									<button type="button"
										class="btn btn-outline-primary btn-floating">
										<i class="fab fa-facebook-f fa-lg"></i>
									</button>
									<button type="button"
										class="btn btn-outline-primary btn-floating">
										<i class="fab fa-twitter fa-lg"></i>
									</button>
									<button type="button"
										class="btn btn-outline-primary btn-floating">
										<i class="fab fa-skype fa-lg"></i>
									</button>
								</div>
								<button type="button" class="btn btn-primary btn-rounded btn-lg">Message
									now</button>
								<div>
									
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>


</body>
</html>