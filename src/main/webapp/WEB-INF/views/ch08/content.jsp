<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

<!--카드 시작  -->
<div class="card m-2">
	<!--카드 헤더 시작  -->
	<div class="card-header">Session Surport</div>
	<!--카드 헤더 끝  -->

	<!--카드 내용 시작  -->
	<div class="card-body"></div>
	<!--카드 내용 끝 -->
	<!--카드 헤더 시작  -->
	<div class="card-header">세션 원리 : JSESSIONID 쿠키</div>
	<!--카드 헤더 끝  -->

	<!--카드 내용 시작  -->
	<div class="card-body">
		<p>서버 : 세션 객체 생성 -> JSESSION에 쿠키 발행</p>
		<p>브라우저 : JSESSION에 쿠키 전송 -> 세션객체 찾음 -> 세션 객체 이용</p>
		<a href="javascript:saveData()" class="btn btn-info bttn-sm">세션에
			데이터 저장</a> <a href="javascript:readData()" class="btn btn-info bttn-sm">세션에
			데이터 읽기</a>
	</div>
	<!--카드 내용 끝 -->
	<script>
	function saveData(){
		$.ajax({
			url: "saveData" ,
			data: {name:"홍길동"}
		})
		.done((data) => {
			console.log(data);
		});
		//url 은 상대경로상에서의 요청 내용이다. 8080/08/saveData요청한다.
		//data에는 응답바디의 데이터인 json이 파싱되어서 데이터 형태로 들어온다.
	}
	function readData(){
		$.ajax({
			url: "readData" 
		
		})
		.done((data) => {
			console.log(data); //{name: "홍길동"}
			console.log(data.name); //{홍길동}
		});
		//url 은 상대경로상에서의 요청 내용이다. 8080/08/saveData요청한다.
		//data에는 응답바디의 데이터인 json이 파싱되어서 데이터 형태로 들어온다.
	}
	
	</script>


	<div class="card">

		<!--카드 헤더 시작  -->
		<div class="card-header">form을 통한 login 처리</div>
		<!--카드 헤더 끝  -->

		<!--카드 내용 시작  -->
		<div class="card-body">
			<c:if test="${sessionMid == null}">
				<a href="login" class="btn btn-info btn-sm">로그인 폼 요청</a>
			</c:if>

			<c:if test="${sessionMid != null}">
				<a href="loginout" class="btn btn-info btn-sm">로그아웃 폼 요청</a>
			</c:if>


		</div>
		<!--카드 끝 -->

		<!--카드 헤더 시작  -->
		<div class="card-header">AJAX를 통한 login 처리</div>
		<!--카드 헤더 끝  -->

		<!--카드 내용 시작  -->
		<div class="card-body">



			<!-- 폼시작  -->
				<c:if test="${sessionMid==null}">
				<form>
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text">mid</span>
						</div>
						<input id="mid" type="text" name="mid" class="form-control">
						<span id="mid-error" class="error"></span>
					</div>
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text">mpassword</span>
						</div>
						<input id="mpassword" type="password" name="mpassword"
							class="form-control"> <span id="mpassword-error"
							class="error"></span>
					</div>
				</form>
			</c:if>
			<div class="mt-2">
				<c:if test="${sessionMid == null}">
					<a href="javascript:login()" class="btn btn-primary btn-sm">로그인</a>
				</c:if>
				<c:if test="${sessionMid != null}">
					<a href="javascript:logout()" class="btn btn-dark btn-sm">로그아웃</a>
				</c:if>
			<%-- 내가쓴 폼 
			<form>
				<div class="input-group">
					<div class="input-group-prepend">
						<span class="input-group-text">mid</span>
					</div>
					<input type="text" name="mid" class="form-control" value="spring">
					<span id="mid-error" class = "error"></span>
				</div>
				<div class="input-group">
					<div class="input-group-prepend">
						<span class="input-group-text">mpassword</span>
					</div>
					<input type="password" name="mpassword" class="form-control"
						value="12345">
						<span id="mpassword-error" class = "error"></span>
				</div>


				<div class="mt-2">
					<c:if test="${sessionMid == null}">
						<a href="javascript:login()" class="btn btn-info btn-sm">로그인 폼
							요청</a>
					</c:if>

					<c:if test="${sessionMid != null}">
						<a href="javascript:logout()" class="btn btn-info btn-sm">로그아웃
							폼 요청</a>
					</c:if>
				</div> --%>
				<script>
				function login(){
					let mid = $("#mid").val();
					let mpassword = $("#mpassword").val();
					$.ajax({
						url: "loginAjax",
						data : {mid, mpassword}, //{mid : mid , mpassword : mpassword},
						method : "post"
					}).done((data)=>{
						//로그인 성공 data = {reseult : "success"}
						//아이디 실패 data = {result : "wrongMid"}
						//비밀번호 실패 data = {result : "wrongMpassword"}
						const midError = $("#mid-error");
						const mpasswordError = $("mpassword-error");
						
						midError.html("");
						mpasswordError.html("");
						
						if(data.result == "success"){
							//위에 form과 연동도 해야하고
							//위 c:if문을 실행하기 위해
							//현재 페이지 전체를 다시 서버에서 받아오도록 함 
							window.location.reload();
						}else if (data.result =="wrongMid"){
							midError.html("아이디가 잘못되었습니다.");
						}else if (data.result = "wrongMpassword"){
							mpasswordError.html("비밀번호가 잘못되었습니다.");
						}
					});
				}
					/*내가 작성함 
					function login(){
						let mid = $("#mid").val();
						let mpassword = $("#mpassword").val();
						$.ajax({
							url: "loginAjax",
							data: {mid,mpassword},
							method: "post"
								// data: {mid:mid,mpassword:mpassword}
								// 속성명과 변수 이름이 같으면 생략가능
						}).done((data) =>{
							console.log(data)
							//data ={result:"success"}
							//data ={result:"wrongMid"}
							//data ={result:"worngMpasswordk"}
							if(data.result === "success"){
								window.location.reload();
								//리프레시를 통해서 현재 페이지 전체를 서버에서 다시 받온다.
								//was가 c:if 를 새롭게 해석하여 위의 폼요소를 적용시킨다.
								//서버에서 다시 읽어야 c:if 안의 내용이 변경된 것으로 적용되니까
							
								const midError = $("#mid-error");
								const mpasswordError = $("#password-error");
								midError.html("");
								mpasswordError.html("");
							}else if (data.result === "wrongMid"){
								midError.html("아이디 잘못됨");
							}else if (data.result === "worngMpasswordk"){
								mpasswordError.html("비밀번호 잘못됨");
							}
						});
						
					} */
					
					
					function logout(){
						$.ajax({
							url: "logoutAjax"
						}).done((data) =>{
							window.location.reload();
						})
					}
					
				</script>

			</form>
			<!-- 폼끝 -->


		
		
		<div class="card">

		<!--카드 헤더 시작  -->
		<div class="card-header">
		@SessionAttributes를 이용한 다단계 입력처리
		</div>
		<!--카드 헤더 끝  -->

		<!--카드 내용 시작  -->
		<div class="card-body">
			<a href = "inputStep1" class="btn btn-info btn-sm">1단계 입력</a>
		</div>

</div>
<!--카드 끝 -->


<%@ include file="/WEB-INF/views/common/footer.jsp"%>