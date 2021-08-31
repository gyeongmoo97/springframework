<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

<div class="card m-2">
	<div class="card-header">Controller (Request Parameter)</div>
	<div class="card-body">
		<div class="card m-2">
			<div class="card-header">Get 방식으로 요청</div>
			<div class="card-body">
				<a class="btn btn-info btn-sm"
					href="method1?
					param1=문자열&
					param2=5& 
					param3=3.14&
					param4 =true&
					param5=2021-08-27">요청</a>
				<%-- href="method1" 이건 상대경로임 --%>

				<hr />
				<form method="get" action="method1">
					<%-- href="method1" 이건 상대경로임 --%>
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text">param1</span>
						</div>
						<input type="text" name="param1" class="form-control" value="문자열">
						<%-- !!!중요!!! input 태그 보면 name 에 param1 들어간다. name 속성에 들어가는 일므이 파라미터 이름이된다.--%>
					</div>
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text">param2</span>
						</div>
						<input type="text" name="param2" class="form-control" value="5">
					</div>
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text">param3</span>
						</div>
						<input type="text" name="param3" class="form-control" value="3.14">
					</div>
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text">param4</span>
						</div>
						<div class="btn-group btn-group-toggle" data-toggle="buttons">
							<label class="btn btn-secondary active"> <input
								type="radio" name="param4" checked value="true"> true
							</label> <label class="btn btn-secondary"> <input type="radio"
								name="param4" value="false"> false
							</label>
						</div>
					</div>
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text">param5</span>
						</div>
						<input type="date" name="param5" class="form-control"
							value="2030-12-05">
					</div>
					<input class="btn btn-info" type="submit" value="요청 파라미터 전송" />
				</form>
			</div>
		</div>


		<%-- Post방식으로 요청하는 구간  --%>
		<div class="card m-2">
			<div class="card-header">Post 방식으로 요청</div>
			<div class="card-body">
				<a class="btn btn-info btn-sm"
					href="method1?
					param1=문자열&
					param2=5 & 
					param3=3.14 &
					param4 =true&
					param5=2021-08-27">요청</a>
				<%-- href="method1" 이건 상대경로임 --%>

				<hr />
				<form method="post" action="method2">
					<%-- href="method1" 이건 상대경로임 --%>
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text">param1</span>
						</div>
						<input type="text"name="param1" class="form-control" value="문자열">
						<%-- !!!중요!!! input 태그 보면 name 에 param1 들어간다. name 속성에 들어가는 일므이 파라미터 이름이된다.--%>
					</div>
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text">param2</span>
						</div>
						<input type="text" name="param2" class="form-control" value="5">
					</div>
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text">param3</span>
						</div>
						<input  type="text" name="param3" class="form-control" value="3.14">
					</div>
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text">param4</span>
						</div>
						<div class="btn-group btn-group-toggle" data-toggle="buttons">
							<label class="btn btn-secondary active"> <input
								type="radio" name="param4" checked value="true"> true
							</label> <label class="btn btn-secondary"> <input type="radio"
								name="param4" value="false"> false
							</label>
						</div>
					</div>
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text">param5</span>
						</div>
						<input type="date" name="param5" class="form-control"
							value="2030-12-05">
					</div>
					<input class="btn btn-info m-2" type="submit" value="요청" />
				</form>
			</div>
		</div>

		<%-- ajax 방식 --%>

		<div class="card m-2">
			<div class="card-header">AJAX요청</div>
			<div class="card-body">
			<form name="form1">
					<%-- href="method1" 이건 상대경로임 --%>
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text">param1</span>
						</div>
						<input type="text" id="param1" name="param1" class="form-control" value="문자열">
						<%-- !!!중요!!! input 태그 보면 name 에 param1 들어간다. name 속성에 들어가는 일므이 파라미터 이름이된다.--%>
					</div>
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text">param2</span>
						</div>
						<input id="param2" type="text" name="param2" class="form-control" value="5">
					</div>
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text">param3</span>
						</div>
						<input id="param3" type="text" name="param3" class="form-control" value="3.14">
					</div>
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text">param4</span>
						</div>
						<div class="btn-group btn-group-toggle" data-toggle="buttons">
							<label class="btn btn-secondary active"> <input
								type="radio" id = "radio1"name="param4" checked value="true"> true
							</label> <label class="btn btn-secondary"> <input type="radio"
								name="param4" id = "radio2"value="false"> false
							</label>
						</div>
					</div>
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text">param5</span>
						</div>
						<input type="date" id ="param5" name="param5" class="form-control"
							value="2030-12-05">
					</div>
	
				</form>
				<div>
				
				<button class="btn btn-info btn-sm" onclick="requestGet()">get
					방식요청</button>
				<button class="btn btn-info btn-sm" onclick="requestPost()">post
					방식요청</button>
				</div>
			</div>
			<script>
      function requestGet(){
    	  const param1 = document.form1.param1.value;
    	  const param2 = document.querySelector("#param2").value; //94줄
    	  const param3 = $("#param3").val();
    /* 	  const param4 = $("#form1 input[type==ridio]"); //108줄 ->  */
    	const param4 = $("#form1 input[name=param4]:checked").val(); //108줄 -> 2개 찾는다. check 된것만 찾아오기
    	  const param5 = $("#param5").val();
    	  
    	  console.log("param1 :" , param1);
    	  console.log("param2 :" , param2);
    	  console.log("param3 :" , param3);
    	  console.log("param4 :" , param4);
    	  console.log("param5 :" , param5); 
         $.ajax({
            url:"method1",
            method: "GET",
            data: {
               param1: param1,
               param2: param2,
               param3: param3,
               param4,
               param5
               //속성이름과 변수이름이 같으면 생략가능
            }
         })
      } 
      function requestPost(){
         $.ajax({
            url:"method2",
            method: "POST",
               data: {
                  param1: "문자열",
                  param2: 5,
                  param3: 3.14,
                  param4: true,
                  param5:"2021-08-27"
               }
         })
      }
      </script>
			<!-- <script>
				function requestGet(){
					$.ajax({
						//url:"${pageContex.request.contextPath}/ch03/mdthod3"
						url: "method1",
						method:"get"
						//data: "param1=문자열&param2=5 & param3=3.14 &param4 =true&param5=2021-08-27"
						data: {
							param1;"문자열",
							param2:5, 
							param3:3.14, 
							param4:true,
							param5:2021-03-03 
						}
						//위의 주석처리된 data를 &로 넘기는 방식보다 아래의 방식이 보기도 좋고 다루기도 편하다.
					
					})
					.done(() => {});
				}
				function requestPost(){
					$.ajax({
						//url:"${pageContex.request.contextPath}/ch03/mdthod3"
						url: "method2",
						method:"post"
						//data: "param1=문자열&param2=5 & param3=3.14 &param4 =true&param5=2021-08-27"
						data: {
							param1;"문자열",
							param2:5, 
							param3:3.14, 
							param4:true,
							param5:2021-03-03 
						}
						//위의 주석처리된 data를 &로 넘기는 방식보다 아래의 방식이 보기도 좋고 다루기도 편하다.
					
					})
					.done(() => {});
				}
				

				
			</script> -->
		</div>

		<%-- ajax 방식 끝 --%>

	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>