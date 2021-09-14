<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

<!--카드 시작  -->
<div class="card m-2">

	<div class="card-header">
		Data Access
	</div>

	<!--카드 내용 시작  -->
	<div class="card-body">
		<div class="card-header">
	연결테스트
	</div>

	<!--카드 내용 시작  -->
	<div class="card-body">
		<a href="testConnectToDB" class = "btn btn-info btn-sm">DB연결</a>
	</div>
	<!--카드 내용 끝 -->
	
	
		<div class="card-header">
	JDBC연습
	</div>

	<!--카드 내용 시작  -->
	<div class="card-body">
		<a href="testInsert" class = "btn btn-info btn-sm">test testInsert</a>
		<a href="testSelect" class = "btn btn-info btn-sm">test testSelect</a>
		<a href="testUpdate" class = "btn btn-info btn-sm">test testUpdate</a>
		<a href="testDelete" class = "btn btn-info btn-sm">test testDelete</a>
	</div>
	<!--카드 내용 끝 -->
	
	</div>
	<!--카드 내용 끝 -->
	
		<div class="card-header">
	My Batis를 이용하는 DAO
	</div>

	<!--카드 내용 시작  -->
	<div class="card-body">
		
		<a href="join" class = "btn btn-info btn-sm">회원 가입</a>
		<a href="login" class = "btn btn-info btn-sm">로그인</a>
		<a href="boardList" class = "btn btn-info btn-sm">게시판</a>

	</div>
	<!--카드 내용 끝 -->
	
</div>
<!--카드 끝 -->

<%@ include file="/WEB-INF/views/common/footer.jsp"%>