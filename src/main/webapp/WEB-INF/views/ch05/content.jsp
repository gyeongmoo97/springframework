<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

<div class="card m-2">

	<div class="card-header">HTTP 정보 읽기 및 설정</div>
	<div class="card-body"></div>
	<div class="card m-2">

		<div class="card-header">요청 HTTP 해더 정보 읽기</div>
		<div class="card-body">
		<a href="getHeaderValue" class="btn btn-danger btn-sm">요청</a>
		</div>
		

	</div>
	<div class="card m-2">

		<div class="card-header">쿠기 저장 및 읽기</div>
		<div class="card-body">
		<a href="createCookie" class="btn btn-danger btn-sm">쿠키 생성 ->(클라이언트 브라우저 저장)</a>
		<a href="getCookie1" class="btn btn-danger btn-sm">쿠키 읽기1</a>
		<a href="getCookie2" class="btn btn-danger btn-sm">쿠키 읽기2</a>
		<a href="#" class="btn btn-danger btn-sm" onclick="getCookie()">쿠키 읽기JS</a>
		<a href="createJsonCookie" class="btn btn-info btn-sm">JSON 쿠키 생성</a>
		<a href="getJsonCookie" class="btn btn-info btn-sm">JSON 쿠키 읽기</a>
		<hr>
		<a href="createJwtCookie" class="btn btn-info btn-sm">JWT 쿠키 생성</a>
		<a href="getJwtCookie" class="btn btn-info btn-sm">JWT  쿠키 읽기</a>
		
			<script>
				function getCookie() {
					console.log(document.cookie);
				}
			</script>
		</div>


	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>