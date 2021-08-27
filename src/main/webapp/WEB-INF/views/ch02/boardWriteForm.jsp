<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

<div class="card m-2">
	<div class="card-header">게시물 작성</div>
	<div class="card-body">
<%-- 	<form method="POST" action="<%= application.getContextPath()%>/ch02/boardwrite"> --%>		
		<form method="POST" action="${pageContext.request.contextPath}/ch02/boardwrite">
		<%-- 두가지 방법으로 동적으로 context root 바뀌는 것 반영가능 --%>
		<%-- jsp 표현식 지금은 통으로 기억하는게 좋다 -> 상대경로는 바꿀게 없다.--%>
		
			<div class="form-group">
				<label for="exampleInputEmail1">Email address</label> <input
					type="email" class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp"> <small id="emailHelp"
					class="form-text text-muted">We'll never share your email
					with anyone else.</small>
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Password</label> <input
					type="text" class="form-control" id="exampleInputPassword1">
			</div>
			<div class="form-group form-check">
				<input type="checkbox" class="form-check-input" id="exampleCheck1">
			</div>
			<button class ="btn btn-primary bnt-sm">저장</button>
		</form>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>