<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

<!--카드 시작  -->
<div class="card m-2">
	<!--카드 헤더 시작  -->
	<div class="card-header"></div>
	<!--카드 헤더 끝  -->
	Login Form
	<!--카드 내용 시작  -->
	<div class="card-body">

		<c:if test="${error !=null}">
			<div class="alert alert-danger mb-2" role="alert">${error}</div>
		</c:if>

		<form method="post" action="login">
			<div class="input-group">
				<div class="input-group-prepend">
					<span class="input-group-text">mid</span>
				</div>
				<input type="text" name="mid" class="form-control" value="spring">
			</div>
			<div class="input-group">
				<div class="input-group-prepend">
					<span class="input-group-text">mpassword</span>
				</div>
				<input type="password" name="mpassword" class="form-control"
					value="aaaaa"
				>
			</div>
			<div class"mt-2">
				<input class="btn btn-info btn-sm" type="submit" value="로그인" />
				<input class="btn btn-info btn-sm" type="reset" value="다시작성" />
				<a class="btn btn-info btn-sm" href="content">취소</a>
			
	</div>
		</form>
		<!-- 폼끝 -->
	</div>
<!--카드 내용 끝 -->
</div>
<!--카드 끝 -->

<%@ include file="/WEB-INF/views/common/footer.jsp"%>