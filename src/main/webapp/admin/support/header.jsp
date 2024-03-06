<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin Panel</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css" />
<link rel="stylesheet" href="main.css" />
</head>
<style>
* {
	margin: 0;
	padding: 0;
	-webkit-box-sizing: border-box;
	box-sizing: border-box;
}

body {
	font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
	background-image:
		url('https://thethaodonga.com/wp-content/uploads/2023/05/hinh-anh-qua-bong-da-dep-2.jpg');
	background-size: cover;
	background-repeat: no-repeat;
	background-attachment: fixed; /* Giữ ảnh nền cố định khi cuộn trang */
	background-position: center center;
	margin: 0;
	padding: 0;
}

.navbar-side {
	width: 260px;
	height: 100vh;
	position: fixed;
	background-color: #343a40;
	-webkit-transition: 0.2s all ease-in-out;
	transition: 0.2s all ease-in-out;
}

.navbar-side h6 {
	color: #fff;
	margin: 9px 0 10px 20px;
	font-size: 18px;
	line-height: 1.6;
	white-space: nowrap;
}

.navbar-side ul li {
	list-style-type: none;
}

.navbar-side ul li a {
	padding: 17px;
	display: inline-block;
	text-decoration: none;
	color: #ccc;
	font-size: 1.1em;
	width: 100%;
	-webkit-transition: 0.2s all ease-in-out;
	transition: 0.2s all ease-in-out;
	white-space: nowrap;
}

.navbar-side ul li a:hover, .navbar-side ul li {
	background-color: #212121;
	border-left: 5px solid #ccc;
}

.content {
	-webkit-transition: 0.2s all ease-in-out;
	transition: 0.2s all ease-in-out;
}

.content #navBtn {
	font-size: 20px;
}

.main.animate .navbar-side {
	-webkit-transition: 0.2s all ease-in-out;
	transition: 0.2s all ease-in-out;
}

.main.animate .navbar-side .link-text {
	display: none;
}

.main.animate .navbar-side .myCaret {
	display: none;
}

.myBtn[aria-expanded="false"] .myCaret:before {
	font-family: "Font Awesome 5 Free";
	font-weight: 900;
	content: "f107";
	float: right;
	transition: all 0.5s;
}

.myBtn[aria-expanded="true"] .myCaret:before {
	font-family: "Font Awesome 5 Free";
	font-weight: 900;
	content: "f107";
	float: right;
	transition: all 0.5s;
	-webkit-transform: rotate(180deg);
	-moz-transform: rotate(180deg);
	transform: rotate(180deg);
}

@media ( max-width : 991px) {
	.main .navbar-side {
		width: 40px;
		-webkit-transition: 0.2s all ease-in-out;
		transition: 0.2s all ease-in-out;
		font-size: 0.8em;
	}
	.main .navbar-side .link-text {
		display: none;
	}
	.main .navbar-side .caret {
		display: none;
	}
	.main .navbar-side h6 {
		margin: 9px 0 10px 9px;
		line-height: 1.9;
	}
	.main .navbar-side ul li a {
		padding-left: 10px;
	}
	.main .navbar-side, .main .navbar-side ul li a.link-active {
		border-left: 2px solid #ccc;
	}
	.main .content {
		margin-left: 40px;
	}
	.main.animate .navbar-side {
		width: 150px;
		-webkit-transition: 0.2s all ease-in-out;
		transition: 0.2s all ease-in-out;
	}
	.main.animate .navbar-side .link-text {
		display: inline-block;
	}
	.main.animate .navbar-side .caret {
		display: block;
	}
	.main.animate .content {
		margin-left: 150px;
	}
	.myCaret {
		display: none;
	}
}

.navbar-css {
	color: #fff;
	padding: 20px;
	position: fixed;
	top: 0;
	left: 0; /* Di chuyển thanh navbar về bên trái */
	width: 230px;
}
      /* CSS cho hộp chứa menu */
        .menu-box {
            
            color: #fff;
            padding: 20px;
            border-radius: 10px;
            
        }

   

        /* CSS cho các mục menu */
        .menu-item {
            margin: 10px 0;
        }

        .menu-item a {
            text-decoration: none;
            color: #fff;
        }
</style>
<body>
	<div class="main">
		<div class="navbar-side navbar-css">
			<h3 class="my-css-admin" style="margin-left: 40px">
				<span class="icon"><i class="fas fa-code"></i></span> <span
					class="link-text">Admin</span>
			</h3>
			<ul>
				<li><a href="adminaccountServlet" class="link-active"
					title="Account"> <span class="icon"><i
							class="fas fa-chart-bar"></i></span> <span class="link-text">Account</span>
				</a></li>

				<li><a href="adminuserServlet" class="link-active" title="User">
						<span class="icon"><i class="fas fa-list"></i></span> <span
						class="link-text">User</span>

				</a></li>

				<li><a href="seasionAddofDelete" title="Seasion"> <span
						class="icon"><i class="fas fa-list-alt"></i></span> <span
						class="link-text">Seasion</span>
				</a></li>
				<li><a href="crudCommentServlet" title="Comment"> <span
						class="icon"><i class="fas fa-comment"></i></span> <span
						class="link-text">Comment</span>
				</a></li>
				<li><a href="crudTeamServlet" title="Team"> <span
						class="icon"><i class="fas fa-tags"></i></span> <span
						class="link-text">Team</span>
				</a></li>
				<li><a href="crudPlayerServlet" title="Player"> <span
						class="icon"><i class="fas fa-user-circle"></i></span> <span
						class="link-text">Player</span>
				</a></li>
				<li><a href="crudMatchServlet" title="Match"> <span
						class="icon"><i class="fas fa-cog"></i></span> <span
						class="link-text">Match</span>
				</a></li>
				<li><a href="signOutServlet" title="Sign Out"> <span
						class="icon"><i class="fas fa-sign-out-alt"></i></span> <span
						class="link-text">Sign Out</span>
				</a></li>
				<li><a href="#" title="Sign Out"> </a></li>

				</a>
				</li>

			</ul>
			<div class="container">
				<div class="menu-box">
				</div>
			</div>

		</div>
	</div>
	<div class="content">


		<div class="d-flex">
			<a class="nav-link text-light px-2" href="#"><i
				class="fas fa-sign-out-alt"></i></a>
		</div>

		</nav>
		<div class="container-fluid"></div>
	</div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<script src="script.js"></script>
</body>

</html>