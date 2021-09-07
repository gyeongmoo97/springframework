<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
	<div class="card-header">
		Controller/Forward & Redirect
	</div>
	<div class="card-body">
		<a href="forward" class="btn btn-info btn-sm">JSP 포워드</a>
		<a href="redirect" class="btn btn-info btn-sm">홈으로 리다이렉트</a>
		
		<hr/>
		
		<p>[AJAX 요청은 리다이렉트를 하면 안됨]</p>
		<a href="javascript:ajax1()" class="btn btn-info btn-sm">AJAX 요청(HTML 조각 얻기)</a>
		<a href="javascript:ajax2()" class="btn btn-info btn-sm">AJAX 요청(PW활용 JSON)</a>
		<a href="javascript:ajax3()" class="btn btn-info btn-sm">AJAX 요청(request body 활용JSON)</a>
		<a href="javascript:ajax4()" class="btn btn-info btn-sm">AJAX 요청(리다이렉트 - (x))</a>
		<div id="content" class="mt-2"></div>
		<script>
		//여기 ajax로 들어오는 data는 response 객체가 절대 아니다 응답 바디에 있는 내용이다.
		// get의 requestbody에는 값이 없고 response body의 내용으로 값이 들어온다.
			function ajax1() {
				console.log("ajax1() 실행");
				$.ajax({
					url:"getFragmentHtml"
				})
				.done((data) => {
					console.log(data);
					$("#content").html(data);
				});
			}
			
			function ajax2() {
				console.log("ajax2() 실행");
				$.ajax({
					url:"getJson1"
				})
				.done((data) => {
					console.log(data);
					$("#content").html(
						"<img src='${pageContext.request.contextPath}/resources/images/" + 
						data.fileName + "' width='200px'/>");
				});
			}
			function ajax3() {
				console.log("ajax3() 실행");
				$.ajax({
					url:"getJson2"
				})
				.done((data) => {
					console.log(data);
					$("#content").html(
						"<img src='${pageContext.request.contextPath}/resources/images/" + 
						data.fileName + "' width='200px'/>");
				});
			}
			
			function ajax4() {
				console.log("ajax4() 실행");
				$.ajax({
					url:"getJson3"
				})
				.done((data) => {
					console.log(data);
					$("#content").html(
						"<img src='${pageContext.request.contextPath}/resources/images/" + 
						data.fileName + "' width='200px'/>");
				});
			}
			
		</script>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>


<%-- <%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file = "/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
	<div class="card-header">
		Controller/Forward & Redirect
	</div>
	<div class="card-body">
		<a href="forward" class="btn btn-warning btn-sm">JSP 포워드</a>
		<a href="redirect" class="btn btn-warning btn-sm">홈으로 리다이렉트</a>
		
		<hr />
		
		<p>[AJAX 요청은 리다이렉트를 하면 안됨]</p>
		<a href="javascript:ajax1()" class="btn btn-danger btn-sm">ajax 요청(HTML 조각 얻기) </a>
		<a href="javascript:ajax2()" class="btn btn-danger btn-sm">ajax 요청(JSON)</a>
		<div id="content" class="mt-2">
			
		</div>
		<script>
			function ajax1(){
				console.log("ajax1() 실행");
				$.ajax({
					url:"getFragmentHtml"
				})
				.done((data)=>{
					$("#content").html(data);
				});
			}
			
			function ajax2(){
				console.log("ajax2() 실행");
				$.ajax({
					url:"getJson"
				})
				.done((data)=>{
					$("#content").html("<img src='${pageContext.request.contextPath}/resources/images/" + data.fileName+"' width='200px'/>");
				});
			}
		</script>
	</div>
</div>

<%@ include file = "/WEB-INF/views/common/footer.jsp" %>

 --%>
<%-- <%@ page contentType= "text/html; charset=UTF-8" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
	<div class="card-header">
		Controller/Foward & Redirect
	</div>
	<div class="card-body">
		<a href="forward" class="btn btn-info btn-sm">JSP포워드</a>
		<a href="redirect" class="btn btn-info btn-sm">홈으로 리다이렉트</a>
	<hr>
	<p>[AJAX 요청은 리다이렉트 하면 안됨]</p>
		<a href="javascript:ajax1()" class="btn btn-info btn-sm">AJAX1 요청 html 조각 얻기</a>
		<a href="javascript:ajax2()" class="btn btn-info btn-sm">AJAX2 요청 json 얻기</a>
	<div id = "content" class="mt-2">
	
	</div>
	<script type="text/javascript">
		function ajax1(){
			// a 태그의 디폴트는 서버로 요청하는것
			//event.preventDefault();
			console.log('ajax1실행');
		}
		function ajax2(){
			// a 태그의 디폴트는 서버로 요청하는것
			//event.preventDefault();
			console.log("ajax2실행");
		}
	</script>
	<div class="card-body">
	
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %> --%>