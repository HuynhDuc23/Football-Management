<%@page import="model.user" %>
	<html lang="en">

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Header</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
			integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
			integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
			crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js"
			integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa"
			crossorigin="anonymous"></script>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
			integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
			crossorigin="anonymous" referrerpolicy="no-referrer" />
		<link rel="stylesheet" href="css/header.css">
	</head>

	<body>

		<header style="background-color: #333;">
			<div class="d-flex flex-wrap">
				<input class="dropdown" type="checkbox" id="dropdown" name="dropdown" />
				<label for="dropdown"><img src="./${sessionScope.user.img}" alt="mdo" style="width: 40px; height: 40px;"
						class="rounded-circle"></img></label>
				<div class="section-dropdown">
					<a-drop>
						<a href="profileServlet" style="text-decoration: none;
						color: white;">Profile</a>
						<i class="uil uil-arrow-right"></i>
					</a-drop>

					<a-drop>
						<a href="#" style="text-decoration: none;
						color: white;">Favorite</a>
						<i class="uil uil-arrow-right"></i>
					</a-drop>
					<input class="dropdown-sub" type="checkbox" id="dropdown-sub" name="dropdown-sub" />
					<label class="for-dropdown-sub" for="dropdown-sub">More<i class="uil uil-plus"></i></label>
					<div class="section-dropdown-sub">
						<a-drop>
							<a href="#" style="text-decoration: none;
						color: white;">Team</a>
							<i class="uil uil-arrow-right"></i>
						</a-drop>
						<a-drop>
							<a href="#" style="text-decoration: none;
						color: white;">About</a>
							<i class="uil uil-arrow-right"></i>
						</a-drop>
					</div>

					<a-drop>
						<a href="LogoutServlet" style="text-decoration: none;
						color: white;">Sign out</a>
						<i class="uil uil-arrow-right"></i>
					</a-drop>
				</div>


				<form action="searchTeamServlet" method="post" class="d-flex flex-grow-1 align-items-center px-2"
					style="min-width: 100px;">
					<div class="pe-2 flex-grow-1">
						<input type="search" id="form1" class="form-control" name="search" style="width: 100%;"
							placeholder="search" />
					</div>
					<button type="submit" class="btn btn-primary" style="min-height: 38px; min-width: 38px;">
						<i class="fas fa-search"></i>
					</button>
				</form>

				<ul-hd>
					<li-hd><a href="HomeServletHeader">Home</a></li-hd>
				</ul-hd>
				<ul-hd>
					<li-hd><a href="pagingServlet">Team</a></li-hd>
				</ul-hd>
				<ul-hd>
					<li-hd><a href="session.jsp">Session</a></li-hd>
				</ul-hd>
			</div>
		</header>

	</body>

	</html>