<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

<!--카드 시작  -->
<div class="card m-2">

	<div class="card-header">예외처리</div>

	<!--카드 내용 시작  -->
	<div class="card-body">


		<!--카드 시작  -->
		<div class="card m-2">

			<div class="card-header">예외처리</div>
			try-catch를 이용한 예외처리1 (사용하지 말라 까지는 아니지만 효율적이지 못하다.)
			<!--카드 내용 시작  -->
			<div class="card-body">
				<a href="handlingException1" class="btn btn-danger btn-sm">예외처리1 try
					catch </a>
			</div>
			<!--카드 내용 끝 -->
		</div>
		<!--카드 끝 -->

		<!--카드 시작  -->
		<div class="card m-2">

			<div class="card-header">예외처리</div>
			 	예외처리 클래스를 이용한 예외처리
			<!--카드 내용 시작  -->
			<div class="card-body">
				<a href="handlingException2" class="btn btn-danger btn-sm">예외처리2 클래스 이용 null 예외처리</a>
				<a href="handlingException3" class="btn btn-danger btn-sm">예외처리3 클래스 이용 cast 예외처리</a>
				<a href="handlingException4" class="btn btn-danger btn-sm">예외처리4 클래스 이용 언급되지 않은 예외처리</a>
				<a href="handlingException5" class="btn btn-danger btn-sm">예외처리5 클래스 이용 사용자 생성예외 처리</a>
			</div>
			<!--카드 내용 끝 -->
		</div>
		<!--카드 끝 -->




	</div>
	<!--카드 내용 끝 -->
</div>
<!--카드 끝 -->

<%@ include file="/WEB-INF/views/common/footer.jsp"%>