<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

<!--카드 시작  -->
<div class="card m-2">

	<div class="card-header">로그인 </div>

	<!--카드 내용 시작  -->
	<div class="card-body">
	<!-- 아이디가 없습니다 페스워득 ㅏ없습니다  -->
		<c:if test="${error !=null}">
			<div class="alert alert-danger mb-2" role="alert"> ${error}</div>
		</c:if>


		<form method="post" action="login">
			<div class="input-group">
				<div class="input-group-prepend">
					<span class="input-group-text">mid</span>
				</div>
				<input type="text" name="mid" class="form-control">
			</div>
		
			<div class="input-group">
				<div class="input-group-prepend">
					<span class="input-group-text">mpassword</span>
				</div>
				<input type="text" name="mpassword" class="form-control">
			</div>
			<input class="btn btn-info" type="submit" value="로그인" />
		</form>



	</div>
	<!--카드 내용 끝 -->
</div>
<!--카드 끝 -->

<%@ include file="/WEB-INF/views/common/footer.jsp"%>