<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

<!--카드 시작  -->
<div class="card m-2">

	<div class="card-header">DTO 객체의 필드값을 드롭다운리스</div>

	<!--카드 내용 시작  -->
	<div class="card-body">
		<form method="get" action="form3">
			<div>
				<c:forEach var="language" items="${languageList}" varStatus="status">
					<span><input type="checkbox" name="mlanguage"
							id="lang${status.count}" value="${language}"
							<c:forEach var="temp" items="${member.mlanguage}">
						<c:if test="${temp == language}">checked</c:if>
					</c:forEach>
						><label style="margin: 0; padding: 0" for="lang${language}">${language}</label></span>
				</c:forEach>
			</div>
			<button class ="btn btn-success btn-sm">제출</button>
		</form>


		<form:form modelAttribute="member" method="post" action="form3">
			<div>
				<form:checkboxes items="${languageList}" path="mlanguage"
				/>

			</div>
			<hr>
<button class ="btn btn-success btn-sm">제출</button>
		</form:form>

		<form:form modelAttribute="member" method="post" action="form3">

			<div >
				<form:checkboxes items="${skillList}" path="mskill" itemValue="code"
					itemLabel="label"
				/>
			</div>
			<button class ="btn btn-success btn-sm">제출</button>
		</form:form>

	</div>
	<!--카드 내용 끝 -->
</div>
<!--카드 끝 -->

<%@ include file="/WEB-INF/views/common/footer.jsp"%>