<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

<!--카드 시작  -->
<div class="card m-2">

	<div class="card-header">DTO 객체의 필드값을 라디오박스 (radiobox 태그)로세팅 (select 태그)로 세팅</div>

	<!--카드 내용 시작  -->
	<div class="card-body">
		<form method="post" action="form4">
			<div>
				<c:forEach var="job" items="${jobList}" varStatus="status">
					<span><input type="radio" name="mjob"
							id="job${status.count}" value="${job}"
							
						<c:if test="${member.mjob == job}">checked</c:if>
	
						><label for="job${status.count}">${job}</label></span>
				</c:forEach>
			</div>
			<button class ="btn btn-success btn-sm">제출</button>
		</form>


 	<%-- 	<form:form modelAttribute="member" method="post" action="form4">
			<div style="margin: 0; padding: 0">
				<form:radiobuttons items="${languageList}" path="mlanguage"
					Class="ml-2"
				/>

			</div>
			<hr>

		</form:form>

		<form:form modelAttribute="member" method="post" action="form4">

			<div class="form-check form-check-inline">
				<form:radiobuttons items="${skillList}" path="mskill" itemValue="code"
					itemLabel="label"
				/>
			</div>
		</form:form>  --%>

	</div>
	<!--카드 내용 끝 -->
</div>
<!--카드 끝 -->

<%@ include file="/WEB-INF/views/common/footer.jsp"%>