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
			<a href="loginForm" class="btn btn-info btn-sm">로그인</a>
			<a href="${pageContext.request.contextPath}/logout" class="btn btn-info btn-sm">로그아웃</a>
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