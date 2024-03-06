<!DOCTYPE html>
<%@page import="model.user" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<html>

		<head>
			<meta charset="UTF-8">
			<meta name="viewport" content="width=device-width, initial-scale=1.0">
			<title>Profile Information</title>
			<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
			<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
			<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
			<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
			<style>
				body {
					display: flex;
					flex-direction: column;
					min-height: 100vh;
				}

				.container {
					flex: 1;
				}
			</style>
		</head>

		<body style="background-color: #212529; color: #ffffff;">
			<jsp:include page="support/header.jsp"></jsp:include>
			<div class="container mt-5">
				<h2>Profile Information</h2>
				<form action="editProFile" method="post" enctype="multipart/form-data">
					<div class="form-group">
						<label for="fullName">Fullname</label> <input type="text" class="form-control" id="fullName"
							name="fullname" value="${sessionScope.user.fullname}" required>
					</div>
					<div class="form-group">
						<label for="age">Age:</label> <input type="number" class="form-control" id="age" name="age"
							value="${sessionScope.user.age}" required>
					</div>
					<div class="form-group">
						<label for="file">Select file to upload (PNG or JPEG only):</label>
						<input type="file" class="form-control-file" id="file" name="file"
							accept="image/png, image/jpeg">
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
			<jsp:include page="support/footer.jsp"></jsp:include>
		</body>

		</html>