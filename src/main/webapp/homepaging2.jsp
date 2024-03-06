<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Document</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
			integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
			integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
			crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js"
			integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa"
			crossorigin="anonymous"></script>
		<style>
			.container {
				display: flex;
				justify-content: space-between;
			}

			.card {
				width: 18rem;
			}
		</style>
	</head>

	<body>
		<jsp:include page="support/header.jsp"></jsp:include>
		<div class="inner-section-one">

			<div class="container">
				<c:forEach items="${pagingTeam}" var="t">
					<div class="card">
						<img src="${t.logo}" class="card-img-top" alt="AnhLoi">
						<div class="card-body">
							<h5 class="card-title">${t.name}</h5>
							<p class="card-text">${t.description}</p>
							<a href="DetailClubServlet?id=${t.id}" class="btn btn-primary">Details</a>
						</div>
					</div>
				</c:forEach>

			</div>
			<div class="container mt-3">
				<nav aria-label="Page navigation example">
					<ul class="pagination">
						<c:if test="${tag > 1}">
							<li class="page-item"><a class="page-link"
									href="searchTeamServlet1?index=${tag - 1}">Previous</a></li>
						</c:if>


						<c:forEach begin="1" end="${paging}" var="o">
							<li class="page-item ${tag == o ? " active":"" }"><a class="page-link"
									href="searchTeamServlet1?index=${o}">${o}</a></li>
						</c:forEach>
						<c:if test="${ tag < paging}">
							<li class="page-item"><a class="page-link"
									href="searchTeamServlet1?index=${tag + 1}">Next</a></li>
						</c:if>
					</ul>
				</nav>
			</div>
			<jsp:include page="support/footer.jsp"></jsp:include>
		</div>



	</body>

</html>