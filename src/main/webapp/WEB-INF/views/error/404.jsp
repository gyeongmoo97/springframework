<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

<!--카드 시작  -->
<div class="card m-2">

	<div class="card-header">
	 	요청 URL 문제
	</div>

	<!--카드 내용 시작  -->
	<div class="card-body">
		 	<p>요청 URL이 잘못 구성되었습니다.</p>
		 	<a href="${pageContext.request.contextPath}/" class ="btn btn-success btn-sm">홈으로 가기</a>
	</div>
	<!--카드 내용 끝 -->
</div>
<!--카드 끝 -->

<%@ include file="/WEB-INF/views/common/footer.jsp"%>