<%@page import="model.player" %>
	<%@page import="java.util.ArrayList" %>
		<html lang="en">

		<head>
			<meta charset="UTF-8">
			<meta name="viewport" content="width=device-width, initial-scale=1.0">
			<title>DetailsProduct</title>
			<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
				integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
				crossorigin="anonymous">
			<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
				integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
				crossorigin="anonymous"></script>
			<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js"
				integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa"
				crossorigin="anonymous"></script>
		</head>
		<style>
			body {
				display: flex;
				flex-direction: column;
				min-height: 100vh;
			}

			.left-side-product-box img {
				width: 100%;
				height: auto;
			}

			.my-list {
				list-style-type: square;
				color: #b0b0b0;
				display: flex;
				justify-content: center;
				align-items: flex-start;
				flex-direction: column;
			}

			/* Định dạng danh sách có kiểu (ordered list) */
			ol.my-list {
				list-style-type: decimal;
			}
		</style>

		<body style="background-color: #212529;">
			<%@include file="support/header.jsp" %>
				<div class="p-3" style="flex: 1;">
					<h1 class="rowm-0 pb-3"
						style="color: #fff; display: flex; justify-content: center; align-items: center;">
						${idTeam.name}
					</h1>
					<div class="row">
						<div class="col-lg-4 left-side-product-box pb-3">
							<img src="${idTeam.img_arena}" class="border p-3"> </img>
							<span class="my-list" style="align-items: center;">PlayList</span>
							<div class="px-3">
								<div class="my-list">
									<% ArrayList<player> playerMember = (ArrayList<player>)
											request.getAttribute("playerMember");
											for(int i = 0 ; i < playerMember.size(); i++ ) {%>
												<li>
													<%=playerMember.get(i).getName() %>
												</li>
												<% } %>
								</div>
							</div>
						</div>

						<div class="col-lg-8">
							<div class="border p-3" style="height: 100%;">
								<div class="row">
									<div class="col-lg-12">
										<h4 style="color: #fff; font-weight: bold;">Studium</h4>
										<h2 class="m-0 p-0" style="color: #b0b0b0;"">${idTeam.name_arena}</h2>
									</div>
									<span class=" col-lg-12 pt-2" style="color: #b0b0b0;">${idTeam.description}</span>
									</div>
								</div>
							</div>
						</div>
					</div>
					<%@include file="support/footer.jsp" %>
		</body>

		</html>