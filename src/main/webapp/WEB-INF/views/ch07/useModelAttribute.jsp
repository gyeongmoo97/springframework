<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

<!--카드 시작  -->
<div class="card m-2">
	<!--카드 헤더 시작  -->
	<div class="card-header">
	
	</div>
	<!--카드 헤더 끝  -->

	<!--카드 내용 시작  -->
	<div class="card-body">
		<ul>	
			<c:forEach var="color" items="${colors}">
			<li>
			 ${color}
			</li>
			</c:forEach>
		</ul>
	</div>
	<!--카드 내용 끝 -->
</div>
<!--카드 끝 -->

<%@ include file="/WEB-INF/views/common/footer.jsp"%>