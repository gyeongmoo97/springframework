<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

<!--카드 시작  -->
<div class="card m-2">

	<div class="card-header">국제화를 적용한 폼</div>

	<!--카드 내용 시작  -->
	<div class="card-body">
	
		<div class="form-group">
	<form:form modelAttribute="member" method="post" action="form5">
			<div class="form-group">
				<label for="mid"> <spring:message code="join.form.mid"/></label>
				<form:input type="text" class="form-control" id="mid" path="mid" />
			</div>
			<div class="form-group">
				<label for="mname">Name</label>
				<form:input type="text" class="form-control" id="mname" path="mname" />
			</div>
			<div class="form-group">
				<label for="mpassword">Password</label>
				<form:password class="form-control" id="mpassword" path="mpassword" />
			</div>
			<div class="form-group">
				<label for="mnation">Nation</label>
				<form:input type="text" class="form-control" id="mnation"
					path="mnation"
				/>
			</div>
			<button type="submit" class="btn btn-primary"><spring:message code="join.form.submit"/></button>
		</form:form>
	</div>
	<!--카드 내용 끝 -->
</div>
</div>
<!--카드 끝 -->

<%@ include file="/WEB-INF/views/common/footer.jsp"%>