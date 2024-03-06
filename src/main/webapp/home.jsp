<%@page import="model.match" %>
	<%@page import="model.team" %>
		<%@page import="java.util.ArrayList" %>
			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
				<html lang="en">

				<head>
					<meta charset="UTF-8">
					<meta name="viewport" content="width=device-width, initial-scale=1.0">
					<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
						rel="stylesheet"
						integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
						crossorigin="anonymous">
					<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
						integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
						crossorigin="anonymous"></script>
					<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js"
						integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa"
						crossorigin="anonymous"></script>
					<link rel="stylesheet" href="css/teamCard.css">

					<style>
						.next,
						.prev {
							color: rgb(255, 255, 255);
							opacity: .4;
						}

						.two-img img {
							width: 48px;
							height: 48px;
							border-radius: 50%;
						}

						.carousel-item img {
							object-fit: cover;
						}
					</style>
				</head>

				<body style="background-color: #212529;">
					<% String urlPath=request.getScheme() + "://" + request.getServerName() + ":" +
						request.getServerPort() + request.getContextPath(); ArrayList<team> team = (ArrayList<team>)
							request.getAttribute("team");
							%>
							<%@ include file="support/header.jsp" %>
								<div id="carouselExampleDark" class="carousel carousel-dark slide"
									data-bs-ride="carousel">
									<div class="carousel-indicators">
										<button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="0"
											class="active" aria-current="true" aria-label="Slide 1"></button>
										<button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="1"
											aria-label="Slide 2"></button>
										<button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="2"
											aria-label="Slide 3"></button>
									</div>

									<div class="carousel-inner">
										<% String[] imageUrls=new
											String[]{ "https://static.bongda24h.vn/medias/original/2020/9/3/Netmedia.jpg"
											, "https://cdn-img.thethao247.vn/upload/lenhung/2020/09/07/7poster-mua-giai-moi-142554-6.jpg"
											, "https://i.ytimg.com/vi/7x-am5GHKu0/maxresdefault.jpg" }; for (int i=0; i
											< imageUrls.length; i++) { String imageUrl=imageUrls[i]; %>
											<div class="carousel-item <%= i== 0? " active":"" %>"
												data-bs-interval="5000">
												<img src="<%= imageUrl %>" class="d-block w-100" alt="...">
											</div>
											<% } %>
									</div>
									<button class="carousel-control-prev" type="button"
										data-bs-target="#carouselExampleDark" data-bs-slide="prev">
										<span class="carousel-control-prev-icon" aria-hidden="true"></span>
										<span class="visually-hidden">Previous</span>
									</button>
									<button class="carousel-control-next" type="button"
										data-bs-target="#carouselExampleDark" data-bs-slide="next">
										<span class="carousel-control-next-icon" aria-hidden="true"></span>
										<span class="visually-hidden">Next</span>
									</button>
								</div>

								<!-- ô phát video -->
								<div class="container justify-content-center d-flex pt-4">
									<iframe width="100%" height="600px" src="https://www.youtube.com/embed/7x-am5GHKu0"
										title="YouTube video player" frameborder="0"
										allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
										allowfullscreen></iframe>
								</div>

								<div class="row p-3">
									<div class="slider" id="slider" style="overflow-x: auto;">
										<c:forEach items="${team}" var="o">
											<div class="col-md-2 p-3" style="display: inline-block;">
												<div class="card p-3">
													<img src="${o.logo}">
													<h5 class="dress-name p-1">${o.name}</h5>
													<a href="DetailClubServlet?id=${o.id}"
														class="rectangle-link">Details</a>
												</div>
											</div>
										</c:forEach>
									</div>
								</div>

								<div class="row p-3 justify-content-center">
									<div class="slider" id="slider" style="overflow-x: auto;">
										<% ArrayList<match> matchSession = (ArrayList<match>)
												request.getAttribute("matchSession");
												for (int i = 0; i < matchSession.size() - 1; i +=2) { %>
													<div class="col-md-2 d-flex justify-content-center"
														style="display: inline-block;">
														<div class="card p-3">
															<img src="data:image/png;base64,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"
																alt="">
															<div class="two-img d-flex mb-3">
																<img src="<%=matchSession.get(i).getLogo()%>" alt=""
																	class="p-2">
																<p class="fs-4 m-0 lh-lg">VS</p>
																<img src="<%=matchSession.get(i + 1).getLogo()%>" alt=""
																	class="p-2">
															</div>
															<h4>
																<%=matchSession.get(i).getScore()%> -
																	<%=matchSession.get(i + 1).getScore()%>
															</h4>
															<% user user=(user)
																request.getSession().getAttribute("user"); if (user
																!=null) { %>
																<a href="MatchDetails?id_team_1=<%=matchSession.get(i).getId_team()%>&id_team_2=<%=matchSession.get(i + 1).getId_team()%>&id_match=<%=matchSession.get(i).getId_match()%>"
																	class="rectangle-link">Matchs</a>
																<% } %>

														</div>
													</div>
													<% } %>
									</div>
								</div>

								<%@ include file="support/footer.jsp" %>
				</body>

				</html>