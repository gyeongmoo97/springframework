<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

<!--카드 시작  -->
<div class="card m-2">

	<div class="card-header">
		DI 의존성주입
	</div>

	<!--카드 내용 시작  -->
	<div class="card-body">
	<div class ="card">
	<div class ="card-header">
		XML 방식과 Annotation 방식으로 주입
	</div>
	
	<div class ="card-body">

		<a href = "request1" class ="btn btn-info btn-sm">request1</a>
		<a href = "request2" class ="btn btn-info btn-sm">request2</a>

	</div>
	
	<!--카드 내용 끝 -->
	
	<div class ="card">
	<div class ="card-header">
		타입에 의한 주입과 이름에 의한 주입
	</div>
	
	<div class ="card-body">

		<a href = "request3" class ="btn btn-info btn-sm">request3 타입에 의한 주입</a>
	

	</div>
	
</div>
<!--카드 끝 -->

<%@ include file="/WEB-INF/views/common/footer.jsp"%>