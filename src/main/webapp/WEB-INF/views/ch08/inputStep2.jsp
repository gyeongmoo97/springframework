<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

<!--카드 시작  -->
<div class="card m-2">
	2단계 입력
	<div class="card-header"></div>

	<!--카드 내용 시작  -->
	<div class="card-body">
		<form method="post" action="inputDone">
			<div class="input-group">
				<div class="input-group-prepend">
					<span class="input-group-text">data3</span>
				</div>
				<input type="text" id="data3" name="data3" class="form-control"
					value="${inputForm.data3}">
			</div>

			<div class="input-group">
				<div class="input-group-prepend">
					<span class="input-group-text">data4</span>
				</div>
				<input type="text" id="data4" name="data4" class="form-control"
					value="${inputForm.data4}">
			</div>
			<a class="btn btn-info" href="inputStep1"> 이전 단계</a> <input
				class="btn btn-info" type="submit" value="최종 처리" />
		</form>
	</div>
	<!--카드 내용 끝 -->
</div>
<!--카드 끝 -->

<%@ include file="/WEB-INF/views/common/footer.jsp"%>