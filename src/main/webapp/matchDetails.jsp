<!DOCTYPE html>
<%@page import="model.user" %>
	<%@page import="model.comment" %>
		<%@page import="model.session" %>
			<%@page import="model.matchGoal" %>
				<%@page import="model.matchDetails" %>
					<%@page import="java.util.ArrayList" %>
						<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

							<html lang="en">

							<head>
								<meta charset="UTF-8">
								<meta name="viewport" content="width=device-width, initial-scale=1.0">
								<title>Match Details</title>

								<script>CKEDITOR.replace('editor1');</script>

								<script src="https://cdn.ckeditor.com/ckeditor5/39.0.1/classic/ckeditor.js"></script>
								<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
								<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
								<script
									src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
								<script
									src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
								</div>
								<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
									integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
									crossorigin="anonymous"></script>
								<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js"
									integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk"
									crossorigin="anonymous"></script>
								<link rel="stylesheet"
									href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

								<style>
									/* Thiết lập kiểu cho container */
									.container {
										margin: 0 0;
										padding: 0 0;
										border-radius: 5px;
										background-color: #fff;
									}

									.container img {
										max-width: 100px;
										height: auto;
										background-color: transparent;
									}

									label {
										display: block;
										font-weight: bold;
										margin-bottom: 5px;
										color: #333;
									}

									input[type="text"],
									textarea {
										width: 100%;
										border: 1px solid #ddd;
										border-radius: 4px;
									}

									button {
										background-color: #007bff;
										color: #fff;
										border: none;
										padding: 10px 20px;
										cursor: pointer;
										font-weight: bold;
										transition: background-color 0.3s;
									}

									button:hover {
										background-color: #0056b3;
									}

									img {
										max-width: 100%;
										height: auto;
										display: block;
									}
								</style>

							</head>

							<body style="background-color: #212529;">
								<jsp:include page="support/header.jsp"></jsp:include>

								<!-- ô phát video -->
								<div class="container justify-content-center d-flex pt-4"
									style="background-color: transparent;">
									<iframe width="100%" height="600px" src="https://www.youtube.com/embed/7x-am5GHKu0"
										title="YouTube video player" frameborder="0"
										allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
										allowfullscreen></iframe>
								</div>

								<% ArrayList<matchDetails> match = (ArrayList<matchDetails>)
										request.getAttribute("matchDetails");%>
										<div style="padding: 50px;">
											<div class="row">
												<div class="container col p-3">
													<div class="row justify-content-center">
														<div
															class="col-md-4 d-flex justify-content-center align-items-center">
															<img src="<%=match.get(0).getLogo()%>"
																alt="Logo đội bóng 1">
														</div>
														<div
															class="col-md-4 d-flex justify-content-center align-items-center">
															<h2>
																<%=match.get(0).getScore()%> -
																	<%=match.get(1).getScore()%>
															</h2>
														</div>
														<div
															class="col-md-4 d-flex justify-content-center align-items-center">
															<img src="<%=match.get(1).getLogo()%>"
																alt="Logo đội bóng 2">
														</div>
													</div>

													<div class="m-3">
														<h4 class="">Session</h4>
														<% ArrayList<session> ss = (ArrayList<session>)
																request.getAttribute("sessionPresent");
																int YearS = 0;
																int YearE = 0;
																for (int i = 0; i < ss.size(); i++) {
																	YearS=ss.get(i).getYearS();
																	YearE=ss.get(i).getYearE(); } %>
																	<p><strong>Session: </strong>
																		<%=YearS%> - <%=YearE%>
																	</p>
																	<p><strong>Date: </strong>
																		<%=match.get(0).getDate()%>
																	</p>
																	<p><strong>Math: </strong>
																		<%=match.get(0).getName()%> vs
																			<%=match.get(1).getName()%>
																	</p>
																	<p><strong>Studium: </strong>
																		<%=match.get(0).getStudium()%>
																	</p>
																	<% ArrayList<matchGoal> matchGoals = (ArrayList
																		<matchGoal>)
																			request.getAttribute("matchGoals1");
																			ArrayList<matchGoal> matchGoals2 =
																				(ArrayList
																				<matchGoal>
																					)
																					request.getAttribute("matchGoals2");
																					int sumMatch = 0;
																					for (int i = 0; i <
																						matchGoals.size(); i++) {
																						sumMatch
																						+=matchGoals.get(i).getCard(); }
																						for (int i=0; i <
																						matchGoals2.size(); i++) {
																						sumMatch
																						+=matchGoals2.get(i).getCard();
																						} %>
																						<p>
																							<strong>Card: </strong>
																							<%=sumMatch%>
																						</p>
													</div>
												</div>
												<div style="width: 10px;"></div>
												<div class="container col p-3">
													<div class="d-flex justify-content-center align-items-center">
														<h2>
															Player
														</h2>
													</div>
													<div class="row">
														<% for (int j=0; j<2; j++) { %>
															<div class="col-md-6">
																<h5>
																	<%=match.get(j).getName()%>
																</h5>
																<ul>
																	<% ArrayList<matchGoal> currentMatchGoals = (j == 0)
																		? matchGoals : matchGoals2;
																		for (int i=0; i < currentMatchGoals.size(); i++)
																			{ %>
																			<li>
																				<%=currentMatchGoals.get(i).getName()%>
																					-
																					<%=currentMatchGoals.get(i).getMinute()%>
																						'
																			</li>
																			<% } %>
																</ul>
															</div>
															<% } %>
													</div>
												</div>
											</div>

											<% int id_match=0; for (int i=0; i < match.size(); i++)
												{id_match=match.get(i).getId_match(); } ArrayList<comment> userCurrent
												=(ArrayList<comment>) request.getAttribute("userCurrent");%>

													<div class="container p-3 my-3">

														<!-- Form nhập bình luận mới -->
														<div>
															<div class="row align-items-center">
																<div class="col-auto">
																	<img class="rounded-circle"
																		src="${sessionScope.user.img}" alt="" width="80"
																		height="80">
																</div>
																<div class="col">
																	<form action="commentServlet" method="post">
																		<input type="hidden" name="id_match"
																			value="<%=id_match%>">
																		<input type="hidden" name="url"
																			value="${requestScope['jakarta.servlet.forward.request_uri']}?<%=request.getQueryString()%>">
																		<textarea id="editor1" name="comment" required
																			placeholder="enter your comment"></textarea>
																</div>
																<div class="col-auto">
																	<button type="submit"
																		class="btn btn-primary">send</button>
																</div>
																</form>
															</div>
														</div>

														<!-- Hiển thị bình luận -->
														<section>
															<% ArrayList<comment> getAllComment = (ArrayList<comment>)
																	request.getAttribute("getAllComment");
																	%>
																	<% for (int i=0; i < getAllComment.size(); i++) { %>
																		<div
																			class="row d-flex justify-content-center m-3">
																			<div class="card">
																				<div class="card-body">
																					<div
																						class="d-flex flex-start align-items-center">
																						<img class="rounded-circle shadow-1-strong me-3"
																							src="<%=getAllComment.get(i).getImg()%>"
																							alt="avatar" width="60"
																							height="60" />
																						<div>
																							<h6
																								class="fw-bold text-primary mb-1">
																								<%=getAllComment.get(i).getFullname()%>
																							</h6>

																							<p
																								class="text-muted small mb-0">
																								<%=getAllComment.get(i).getDate()%>
																							</p>
																							<% user checkUser=(user)
																								request.getSession().getAttribute("user");
																								if
																								(checkUser.getId()==getAllComment.get(i).getId_user())
																								{ %>
																								<div
																									class="d-flex flex-start align-items-center">
																									<form
																										action="deleteServlet"
																										method="post">
																										<input
																											type="hidden"
																											name="id_comment"
																											value="<%=getAllComment.get(i).getId()%>" />
																										<input
																											type="hidden"
																											name="url"
																											value="${requestScope['jakarta.servlet.forward.request_uri']}?<%=request.getQueryString() %>" />
																										<input
																											type="submit"
																											value="Delete"
																											style="border: none; outline: none; background-color: white; color: #0d6efd; font-weight: 600;" />
																									</form>
																									<a href="javascript:void(0)"
																										class="d-flex align-items-center me-3 text-decoration-none"
																										data-role="edit"
																										data-id="<%=getAllComment.get(i).getId()%>"
																										style="font-weight: 600;">
																										
																										<p class="mb-0">
																											- Edit</p>
																									</a>
																								</div>
																								<% } %>

																						</div>
																					</div>
																					<p class="p-2">
																						<%=getAllComment.get(i).getContent()%>
																					</p>
																				</div>
																			</div>
																		</div>
																		<% } %>
																			<!-- Modal Edit Comment -->
																			<div class="modal fade" id="ModalEdit"
																				tabindex="-1"
																				aria-labelledby="exampleModalLabel"
																				aria-hidden="true">
																				<div
																					class="modal-dialog modal-dialog-centered">
																					<div class="modal-content">
																						<div class="modal-header">
																							<h5 class="modal-title"
																								id="exampleModalLabel">
																								Edit Comment
																							</h5>
																							<button type="button"
																								class="btn-close"
																								data-bs-dismiss="modal"
																								aria-label="Close"></button>
																						</div>
																						<div class="modal-body">
																							<input type="text"
																								id="content"
																								style="width: 100%; outline: none; padding: 5px;" />
																						</div>
																						<div class="modal-footer">
																							<button type="button"
																								class="btn btn-secondary"
																								data-bs-dismiss="modal">Close</button>
																							<button id="save"
																								type="button"
																								class="btn btn-primary">Save
																								changes</button>
																						</div>
																					</div>
																				</div>
																			</div>
														</section>
													</div>
										</div>
										<%@ include file="support/footer.jsp" %>
							</body>

							<script type="text/javascript">
								$(document).ready(function () {
									$(document).on('click', 'a[data-role=edit]', function () {
										var id = $(this).data("id");
										var content = $('p[data-target=content' + id + ']').text();
										console.log(id)
										console.log(content)
										$('#content').val(content);
										$('#ModalEdit').modal('toggle');
									});

									$('#save').click(function () {
										var id = $('a[data-role=edit]').data("id");
										var content = $('#content').val();
										console.log(id + content);
										$.ajax({
											url: 'editComment',
											method: 'post',
											data: {
												id: id,
												content: content
											},
											success: function (res) {
												$('p[data-target=content' + id + ']').text(content);
												$('#ModalEdit').modal('toggle');
											}
										})
									})

								});
							</script>

							</html>