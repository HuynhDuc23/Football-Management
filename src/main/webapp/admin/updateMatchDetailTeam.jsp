<!DOCTYPE html>
<%@page import="model.matchDetailTeam"%>
<%@page import="model.player"%>
<%@page import="model.team"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.playerTeam"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
	integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
	integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
	crossorigin="anonymous"></script>
<title>MATCHDETAILS</title>
<style>
body {
	margin: 0;
	padding: 0;
	background-image:
		url('https://img4.thuthuatphanmem.vn/uploads/2020/07/05/background-bong-da_045001219.jpg');
	background-size: cover;
	background-repeat: no-repeat;
	background-position: center;
	font-family: Arial, sans-serif;
	/* Optional: Set a default font-family */
}
/* Modal styles */
.modal-dialog {
	margin-top: 20px;
	max-width: 600px;
	background: #778899;
}

.modal-header, .modal-body, .modal-footer {
	padding: 15px 20px;
}

.modal-content {
	border-radius: 5px;
	font-size: 20px;
}

.modal-footer {
	border-radius: 0 0 5px 5px;
}

.modal-title {
	font-size: 30px;
}

.form-control {
	border-radius: 3px;
	border: 1px solid #ccc;
	margin-bottom: 10px;
}

.btn {
	border-radius: 3px;
	min-width: 100px;
}

label {
	font-size: x-large;
}

button {
	background-color: #198754;
	border-color: #198754;
	border-radius: 3px;
	border-style: solid;
	border-width: 1.25px;
	padding: 6px 12px;
}

button a {
	font-family: system-ui;
	line-height: 24px;
	text-decoration: none;
	color: #ffffff;
}
</style>
</head>
<body>
	<%
	matchDetailTeam t = (matchDetailTeam) request.getAttribute("matchDetailTeam");
	System.out.println(t);
	%>
	<!-- Edit Modal HTML -->
	<div class="container">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="row">
					<div class="modal-header">
						<h4 class="modal-title">Update Match</h4>
						<button>
							<a href="crudMatchServlet">Home</a>
						</button>
					</div>
				</div>
				<form action="updateMatchDetailsServlet?action=update" method="post">
					<div class="modal-body">
						<div class="form-group">
							<label>Match</label> <input type="text" name="idMatch"
								required="required" class="form-control"
								value="<%=t.getId_details()%>" readonly>
						</div>
						<div class="form-group">
							<label>Score</label> <input type="text" name="score"
								class="form-control" value="<%=t.getScore()%>"
								required="required">
						</div>
					</div>
					<button type="submit" class="btn btn-success">Update</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
