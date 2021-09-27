<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>
 
<!--카드 시작  -->
<div class="card m-2">

	<div class="card-header">Spring Security</div>

	<!--카드 내용 시작  -->
	<div class="card-body">

 
		<div class="card">

			<div class="card-header">로그인 로그아웃</div>

			<!--카드 내용 시작  -->
			<div class="card-body">

				<sec:authorize access="isAnonymous()">
					<a href="loginForm" class="btn btn-info btn-sm">로그인</a>
				</sec:authorize>
				<!-- CSRF 비활성화 일때 -->
				<!-- <a href="${pageContext.request.contextPath}/logout"
		       class="btn btn-info btn-sm"
		       >로그아웃</a> -->

				<!-- 사이트간 요청 위조 방지 활성화 되어있을 경우  -->
				<sec:authorize access="isAuthenticated()">
				<form  method="post" action="${pageContext.request.contextPath}/logout"
				style="display: inline;"
				>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<button class="btn btn-info btn-sm"> 로그아웃</button>

				</form>
				<a href="javascript:userInfo()" class="btn btn-info btn-sm ml-2">사용자 정보</a>
				
				<div id="userInfo"></div>
				
				</sec:authorize>
				
			</div>
			
			<script>
			function userInfo(){
				$.ajax({
					url: "userInfo"
				}).done((data)=>{
					//json응답
					//{mid: xxx, mrole:[yyy, yyy,…], ip: zzz} -> json객체
					var html = "";
					html += "<p>Member Id : "+data.mid+"</p>";
					//배열 받기
					html += "<p>Member Role :"+data.mrole.toString()+"</p>";
					html += "<p>Member IP :"+data.ip+"</p>";
					$("#userInfo").html(html);
				});
			}
			/* 
				function userInfo(){
					$.ajax({
						url: "userInfo"
					}).done((data)=>{
						//{mid:xxx, mrole:[yyy, xxx, zzz], ip:zzz} 이렇게 넘길 예정
						
						var html ="";
						//html 에 var 안붙이면 전역에 선언하게 된다.
						html += '<p>Member ID :'+ data.mid +'</p>';
						html += '<p>Member ROLE :'+ data.mrole.toString() + ' </p>';
						html += '<p>Member IP :' +data.ip '+ </p>';
						$("#userInfo").html(html);
					});
				}
			 */
			</script>
			
			
			<!--카드 내용 끝 -->
		</div>
		<!--카드 끝 -->





		<div class="card">

			<div class="card-header">접근권한</div>

			<!--카드 내용 시작  -->
			<div class="card-body">

				<a href="adminAction" class="btn btn-info btn-sm">Admin Action</a> <a
					href="managerAction" class="btn btn-info btn-sm"
				>Manager Action</a> <a href="userAction" class="btn btn-info btn-sm">User
					Action</a>

				<hr>

				<ul>
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<li>Admin Menu</li>
					</sec:authorize>
					<sec:authorize access="hasRole('ROLE_MANAGER')">
						<li>Manager Menu</li>
					</sec:authorize>
					<sec:authorize access="isAuthenticated()">
						<li>User Menu</li>
					</sec:authorize>
				</ul>
			</div>
			<!--카드 내용 끝 -->
		</div>
		<!--카드 끝 -->





		<div class="card">

			<div class="card-header">
				회원가입 (비밀 번호 암호화)
			</div>

			<!--카드 내용 시작  -->
			<div class="card-body">
			
			<a href="joinForm" class="btn btn-info btn-sm">회원 가입</a>
			
			
			</div>
			<!--카드 내용 끝 -->
		</div>
		<!--카드 끝 -->




		<div class="card">

			<div class="card-header"></div>

			<!--카드 내용 시작  -->
			<div class="card-body"></div>
			<!--카드 내용 끝 -->
		</div>
		<!--카드 끝 -->




	</div>
	<!--카드 내용 끝 -->
</div>
<!--카드 끝 -->

<%@ include file="/WEB-INF/views/common/footer.jsp"%>