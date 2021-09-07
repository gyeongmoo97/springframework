<%@ page contentType= "text/html; charset=UTF-8" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
	<div class="card-header">
		EL 을 활용하여  Object 안의 데이터 출력
	</div>
	<div class="card-body">
		<p>이름 : ${member.name} </p>
		<!-- 출력이 되려면 어떤 범위이던 일단 있어야한다.  -->
		<p>나이 : ${member.age} </p>
		<p>직업 : ${member.job} </p>
		<p>도시 : ${member.city.name} </p>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>