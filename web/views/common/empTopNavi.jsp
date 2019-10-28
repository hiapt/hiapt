<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- ================================================================================= -->
<!---탑 메뉴  시작 =================---------------------------->
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

					<!-- Sidebar Toggle (Topbar) -->
					<button id="sidebarToggleTop"
						class="btn btn-link d-md-none rounded-circle mr-3">
						<i class="fa fa-bars"></i>
					</button>
<!--========================================================================================== -->

<!--========================================================================================== -->
					<!-- Topbar Navbar -->
					<ul class="navbar-nav ml-auto">						
<!--========================================================================================== -->

<!--========================================================================================== -->
<!--알림 아이콘 -->
						<!-- Nav Item - Alerts -->
						<li class="nav-item dropdown no-arrow mx-1"><a
							class="nav-link dropdown-toggle" href="#" id="alertsDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i class="fas fa-bell fa-fw"></i> <!-- Counter - Alerts -->
								<span class="badge badge-danger badge-counter">3+</span>
						</a> 
						<!-- Dropdown - Alerts -->
							<div
								class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="alertsDropdown">
								<h6 class="dropdown-header">알림</h6>
								<a class="dropdown-item d-flex align-items-center" href="#">
									<div class="mr-3">
										<div class="icon-circle bg-warning">
											<i class="fas fa-exclamation-triangle text-white"></i>
										</div>
									</div>
									<div>
										<div class="small text-gray-500">2019, 10.20</div>
										알림 메세지 샘플1
									</div>
								</a> <a class="dropdown-item text-center small text-gray-500"
									href="#">알림 더 읽기</a>
							</div>
						</li>
<!--알림 아이콘 끝-->
<!--========================================================================================== -->
<!-- 채팅 알림창   -->
<!--========================================================================================== -->
			<li class="nav-item dropdown no-arrow mx-1"><a class="nav-link dropdown-toggle" 
						href="#" id="messagesDropdown" role="button"
						onclick="window.open('/hiapt/views/emp/chat/chatManager.jsp?empno=<%= emp.getEmpNo() %>','name(채팅)','width=350,height=700')"
						> <i class="fas fa-comment-dots fa-fw"></i></a></li>

<!--========================================================================================== -->
<!-- 개인정보 창  -->
<!--========================================================================================== -->
						<li class="nav-item dropdown no-arrow"><a
							class="nav-link dropdown-toggle" href="#" id="userDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <span
								class="mr-2 d-none d-lg-inline text-gray-600 small"><%= emp.getEmpName() %></span> <img
								class="img-profile rounded-circle"
								src="/hiapt/resources/images/avatar.png">
						</a> <!-- Dropdown - User Information -->
							<div
								class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="userDropdown">
								<a class="dropdown-item" href="#"> <i
									class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> 개인정보
								</a> <a class="dropdown-item" href="#"> <i
									class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i> 설정
								</a> <a class="dropdown-item" href="#"> <i
									class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
									Activity Log
								</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="/hiapt/eout"> <i
									class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
									로그아웃
								</a>
							</div></li>
<!-- 개인정보 창 끝  -->
<!--========================================================================================== -->
					</ul>

				</nav>
<!---탑 메뉴 끝 ------------------------------------------->
<!--========================================================================================== -->