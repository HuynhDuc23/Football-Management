<!DOCTYPE html>
<%@page import="model.team"%>
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
<title>Update!</title>
<style>
/* Modal styles */
    body {
        margin: 0;
        padding: 0;
        background-image: url('https://img4.thuthuatphanmem.vn/uploads/2020/07/05/background-bong-da_045001219.jpg');
        background-size: cover;
        background-repeat: no-repeat;
        background-position: center;
        font-family: Arial, sans-serif; /* Optional: Set a default font-family */
    }

.modal-dialog {
	margin-top: 20px;
	max-width: 500px;
	background: #778899;
}

.modal-header, .modal-body, .modal-footer {
	padding: 10px 15px;
}

.modal-content {
	border-radius: 5px;
	font-size: 15px;
}

.modal-footer {
	border-radius: 0 0 5px 5px;
}

.modal-title {
	font-size: 20px;
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
	font-size: small;
}

button {
	background-color: #198754;
	border-color: #198754;
	border-radius: 3px;
	border-style: solid;
	border-width: 1.25px;
	padding: 6px 24px;
	margin-right: 10px;
}

button a {
	font-family: system-ui;
	line-height: 24px;
	text-decoration: none;
	color: #ffffff;
}

.model-css {
	margin-left: 10px;
}

.model-css>h5 {
	font-family: system-ui;
	line-height: 24px;
	text-decoration: none;
	color: #ffffff;
	font-weight: normal;
}
</style>
</head>
<body>
	<%
	String id = (String) request.getAttribute("id");
	team teamId = (team) request.getAttribute("teamId");

	id = ((id == null) ? "" : id);
	%>
	<!-- Edit Modal HTML -->
	<div class="container">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="updateTeamServlet" method="post">
					<div class="row">
						<div class="modal-header">
							<div class="model-css">
								<h5 class="modal-title">Update Team</h5>
							</div>
							<button>
								<a href="crudTeamServlet">Home</a>
							</button>
						</div>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label>ID</label> <input type="text" name="id"
								required="required" class="form-control" value="<%=id%>"
								readonly>
						</div>
						<div class="form-group">
							<label>Name</label> <input type="text" name="name"
								required="required" class="form-control"
								value="<%=teamId.getName()%>">
						</div>
						<div class="form-group">
							<label>Logo</label> <input type="text" name="logo"
								class="form-control" value="<%=teamId.getLogo()%>"
								required="required">
						</div>
						<div class="form-group">
							<label>Name Arena</label> <input type="text" name="namearena"
								class="form-control" value="<%=teamId.getName_arena()%>"
								required="required">
						</div>
						<div class="form-group">
							<label>Image Arena</label> <input type="text" name="imgarena"
								class="form-control" value="<%=teamId.getImg_arena()%>"
								required="required">
						</div>
						<div class="form-group">
							<label>Description</label> <input type="text" name="description"
								class="form-control" value="<%=teamId.getDescription()%>"
								required="required">
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
						<button type="submit" class="btn btn-success">Update</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
