<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

<!--카드 시작  -->
<div class="card m-2">

	<div class="card-header">1단계 입력</div>

	<!--카드 내용 시작  -->
	<div class="card-body">
		<form method="post" action="inputStep2">
			<div class="input-group">
				<div class="input-group-prepend">
					<span class="input-group-text">data1</span>
				</div>
				<input type="text" id="data1" name="data1" class="form-control"
					value="${inputForm.data1}">
			</div>

			<div class="input-group">
				<div class="input-group-prepend">
					<span class="input-group-text">data2</span>
				</div>
				<input type="text" id="data2" name="data2" class="form-control"
					value="${inputForm.data2}">
			</div>
			<input class="btn btn-info mt-2" type="submit" value="2 단계 입력으로 이동" />
		</form>
	</div>
	<!--카드 내용 끝 -->
</div>
<!--카드 끝 -->

<%@ include file="/WEB-INF/views/common/footer.jsp"%>