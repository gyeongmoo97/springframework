<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

<!--카드 시작  -->
<div class="card m-2">

	<div class="card-header">DTO 객체 ( Command Object )와 form 연결</div>

	<!--카드 내용 시작  -->
	<div class="card-body">

		<form:form method="post" modelAttribute="member">
			<div class="form-group">
				<label for="mid"> ID</label> 
				<form:input
					type="text" class="form-control" id="mid" path="mid"/>
			</div>
			<div class="form-group">
				<label for="mname">Name</label> 
				<form:input
					type="text" class="form-control" id="mname" path="mname"/>
			</div>
			<div class="form-group">
				<label for="mpassword">Password</label> 
				<form:password
					 class="form-control" id="mpassword" path="mpassword"/>
			</div>
			<div class="form-group">
				<label for="mnation">Nation</label> 
				<form:input type="text" class="form-control" id="mnation" path="mnation"/>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
	</div>
	<!--카드 내용 끝 -->
</div>
<!--카드 끝 -->

<%@ include file="/WEB-INF/views/common/footer.jsp"%>