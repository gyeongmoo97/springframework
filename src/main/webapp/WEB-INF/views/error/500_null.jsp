<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

<!--카드 시작  -->
<div class="card m-2">

	<div class="card-header">
	 서버 실행 오류
	</div>

	<!--카드 내용 시작  -->
	<div class="card-body">
		<p>데이터가 존재하지 않습니다</p>
		<div>
		<!--  어떤 경로에서 예외가 발생하는 지 모르기 때문에 절대경로 사용해야함-->
			<%-- "${pageContext.request.contextPath}" -> 우리의 root context 는 /인데 빈값 취급임 그래서 / 붙인다--%>
			<a href="${pageContext.request.contextPath}/" class ="btn btn-success btn-sm">홈으로 가기</a>
		</div>
	</div>
	<!--카드 내용 끝 -->
</div>
<!--카드 끝 -->

<%@ include file="/WEB-INF/views/common/footer.jsp"%>