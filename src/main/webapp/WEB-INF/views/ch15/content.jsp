<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

<!--카드 시작  -->
<div class="card m-2">

	<div class="card-header">AOP 관점지향 프로그래밍</div>

	<!--카드 내용 시작  -->
	<div class="card-body">


		<!--카드 시작  -->
		<div class="card m-2">

			<div class="card-header">ADVICE 테스트</div>

			<!--카드 내용 시작  -->
			<div class="card-body">
				<a href="before" class="btn btn-sm btn-success">@Before 테스트</a> <a
					href="after" class="btn btn-sm btn-success"
				>@After 테스트</a> <a href="afterReturning"
					class="btn btn-sm btn-success"
				>@AfterReturn 테스트</a> <a href="afterThrowing"
					class="btn btn-sm btn-success"
				>@AfterThrowing 테스트</a> <a href="around"
					class="btn btn-sm btn-success"
				>@Around 테스트</a>
			</div>
			<!--카드 내용 끝 -->
		</div>
		<!--카드 끝 -->


		<!--카드 시작  -->
		<div class="card m-2">

			<div class="card-header">AOP예제</div>

			<!--카드 내용 시작  -->
			<div class="card-body">
				<a href="runtimeCheck" class="btn btn-sm btn-success">요청 처리 시간
					측정</a> <a href="javascript:boardList1()" class="btn btn-sm btn-success">인증여부
					확인 html 응답</a>
					 <a href="javascript:boardList2()" class="btn btn-sm btn-success"
				>인증여부 확인 json 응답</a>
				<!-- 	<a href="authCheck" class="btn btn-sm btn-success">인증 여부 확인</a> -->
				<hr>
				<div>${methodName}실행시간:${howLong}</div>
				<hr />
				<div id="boardList"></div>

			</div>
			<script>
			
				function boardList1(){
					$.ajax({
						url: "boardList1"
						//컨트롤러의 boardList의 return 값은 사용하지 않는다. ajax 에서 요청 했으니까
						//done으로 받아오는건 response
						//브라우저단에서 실행되늰 코드라서 response, requset만 쓸 수 있다.
						//근데 html조각은 리턴된 값을 통해서 사용한다.
					}).done((data) =>{
							if(data.result==="authFail"){
								window.location.href="login";
							}else{
								$("#boardList").html(data);
							}					
							
									
					});
				}
				
				
				function boardList2(){
					$.ajax({
						url: "boardList2"
						//컨트롤러의 boardList의 return 값은 사용하지 않는다. ajax 에서 요청 했으니까
						//done으로 받아오는건 response
						//브라우저단에서 실행되늰 코드라서 response, requset만 쓸 수 있다.
						//근데 html조각은 리턴된 값을 통해서 사용한다.
					}).done((data) =>{
												
							if(data.result==="authFail"){ 
								//data내부 {result:"success", boards:[ {...}, {...}, {...}]}
								window.location.href="login"
							}else{
								let html="";
								// 안에 쌍따옴표가 들어가는 부분이 있어서 문자열 작은 따옴표로 넣는다.
								html += '<table class="table table-sm table-bordered">';
								html += '<tr>';
								html +=	'<th style="width: 30px">번호</th>';
								html +=	'<th style="width: 300px">제목</th>';
								html +=	'<th style="width: 70px">글쓴이</th>';
								html +=	'<th style="width: 70px">날짜</th>';
								html += '</tr>';

			
							 	for(var board of data.boards){
							 		html += '<tr>';
							 		html +=  '<td>'+board.bno + '</td>';
							 		html += '	<td><a href="detailBoard?bno=' + board+'">'+ board.btitle +'</a></td>';
							 		html += '<td>' + board.mid +'</td>';
						 		html += '<td>' + new Date().toLocaleDateString()+'</td>';
							 		//html += '<td>' + board.bdate +'</td>';
							 		html += 	'</tr>';
							 	}
									html +=	'</table>';
									$("#boardList").html(html);
							}
								
					});
				}
				
			
			</script>

			<!--카드 내용 끝 -->
		</div>
		<!--카드 끝 -->

		<div class="card m-2">
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
		</div>







		<!--카드 시작  -->
		<div class="card m-2">

			<div class="card-header"></div>

			<!--카드 내용 시작  -->
			<div class="card-body"></div>
			<!--카드 내용 끝 -->
		</div>
		<!--카드 끝 -->





	</div>
	<!--카드 내용 끝 -->
</div>
<!--카드 끝 -->

<%@ include file="/WEB-INF/views/common/footer.jsp"%>