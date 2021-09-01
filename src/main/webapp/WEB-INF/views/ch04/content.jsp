<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>

<div class="card m-2">
	<div class="card-header">Browser (1차) 유효성 검사</div>
	<div class="card-body">
		<div class="card m-2">
			<div class="card-header">POST 방식으로 요청</div>
			<div class="card-body">
				<form id="form0" method="post" action="method1"
					onsubmit="checkData(this)">
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text">param1</span>
						</div>
						<input type="text" name="param1" class="form-control" value="">
						<span class="param1-error text-danger">*</span>
					</div>
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text">param2</span>
						</div>
						<input type="text" name="param2" class="form-control" value="">
						<span class="param2-error text-danger">*</span>
					</div>
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text">param3</span>
						</div>
						<input type="text" name="param3" class="form-control" value="">
						<span class="param3-error text-danger">*</span>
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
						<input type="date" name="param5" class="form-control"> <span
							class="param5-error text-danger">*</span>
					</div>
					<input class="mt-2 btn btn-info btn-sm" type="submit" value="요청" />
				</form>
			</div>
			<script>
                function checkData(form) {
                    // form의 제출 기능을 off
                    event.preventDefault();

                	//유효성 검사 결과 변수
					let checkResult = true;
                    
                    //정규 표현식을 이용한 입력길이 체크
                    let param1 = form.param1.value;
                    const param1Error = document.querySelector("#form0 .param1-error");
                    param1Error.innerHTML = "";
                    
                    if (param1 === "") {
                        const param1Error = document.querySelector("#form0 .param1-error");
                        param1Error.innerHTML = "필수 입력 사항";
                    } else {
                       if(param1.length < 8 || param1.length > 15) {
                            param1Error.innerHTML = "8자 이상, 15자 이하로 입력";
                       }
                    }
                    
                  //정규 표현식을 이용한 전화번호 형식 체크
                    let param2 = form.param2.value;
                    const param2Error = document.querySelector("#form0 .param2-error");
                    param2Error.innerHTML = "";
                    if(param2 === ""){
                        param2Error.innerHTML = "필수 입력 사항";
                    }else{
                        const pattern = /(010|011)-[0-9]{3,4}-[0-9]{4}/i;
                        const result = pattern.test(param2);
                        if(result === false){
                           param2Error.innerHTML = "유효하지 않은 전화번호";
                        }
                    }
                    
                    //정규 표현식을 이용한 이메일 체크
                    let param3 = form.param3.value;
                    const param3Error = document.querySelector("#form0 .param3-error");
                    param3Error.innerHTML = "";
                    if(param3 === ""){
                        param3Error.innerHTML = "필수 입력 사항";
                    }else{
                        const pattern = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
                        const result = pattern.test(param3);
                        if(result === false){
                           param3Error.innerHTML = "이메일 형식이 아님";
                        }
                    }
                    //날짜가 비었는지
                    let param5 = form.param5.value;
                    const param5Error = document.querySelector("#form0 .param5-error");
                    param5Error.innerHTML = "";
                    if(param5 === ""){
                        param5Error.innerHTML = "필수 입력 사항";
                    }
                    
                    /* const pattern = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
                    const result = pattern.test("cy990342@naver.com");
                    console.log(result); */
                    
                }
            </script>
		</div>
		<div class="card m-2">
			<div class="card-header">AJAX 방식으로 요청</div>
			<div class="card-body">

				<form id="form1" name="form1">
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text">param1</span>
						</div>
						<input type="text" id="param1" name="param1" class="form-control"
							value=""> <span class="param1-error text-danger">*</span>
					</div>
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text">param2</span>
						</div>
						<input type="text" id="param2" name="param2" class="form-control"
							value=""> <span class="param2-error text-danger">*</span>
					</div>
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text">param3</span>
						</div>
						<input type="text" id="param3" name="param3" class="form-control"
							value=""> <span class="param3-error text-danger">*</span>
					</div>
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text">param4</span>
						</div>
						<div class="btn-group btn-group-toggle" data-toggle="buttons">
							<label class="btn btn-secondary active"> <input
								type="radio" id="radio1" name="param4" checked value="true">
								true
							</label> <label class="btn btn-secondary"> <input type="radio"
								id="radio2" name="param4" value="false"> false
							</label>
						</div>
					</div>
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text">param5</span>
						</div>
						<input type="date" id="param5" name="param5" class="form-control"
							value="2030-12-05"> <span
							class="param5-error text-danger">*</span>
					</div>
				</form>
				<div class="mt-2">
					<button class="btn btn-info btn-sm" onclick="requestPost()">POST
						방식 요청</button>
				</div>
			</div>
			<script>
            //jquery 사요해서 진행해본다.
                function requestPost() {
                	const param1 = $("#param1").val(); //주민번호 : 앞 6자리 뒤 7자리 123456-1234567 반드시 뒷자리의 첫자리는 1234만 올 수있다.
                	const param2 = $("#param2").val(); // 년월일: 19971115 (년월일 월을 1~12 일은 1~31까지 가능)
                	const param3 = $("#param3").val(); // 패스워드 : 알파뱃으로 시작, 최소 8자  최대 10자
                	const param4 = $("#form1 input[name=param4]:checked").val(); //
                	const param5 = $("#param5").val(); //
                    // 유효성 검사: 클라이언트에서 데이터가 올바른지 검증 후 서버에 보내는 것
                   // form의 제출 기능을 off
                    
                    
					
	                    const param1Error =$("#form1 .param1-error");
                		/* param1Error.innerHTML  jquery 객체라서 innerHTML 안됨*/ 
                		console.log(param1);
                		param1Error.html("");
	                    if(param1 ===""){
	                        param1Error.html("필수 입력 사항");
	                    }else{
	                        const pattern = /^\d{2}([0]\d|[1][0-2])([0][1-9]|[1-2]\d|[3][0-1])[-]*[1-4]\d{6}$/;
	                      /*   const pattern =/\d{2}([0]\d|[1][0-2])([0][1-9]|[1-2]\d|[3][0-1])[-]*[1-4]\d{6}/; */
	                        const result = pattern.test(param1);
	                        if(result === false){
	                           param1Error.html("주민번호 형식이 아1님");
	                        }
	                    }
                    
                    
                    
                    
         //아래의 코드블럭이 실행되면 submit 임
         
          $.ajax({
             url: "method1",
             method: "post",
             data: {
                 param1: param1,
                 param2,
                 param3,
                 param4,
                 param5,
             }
         })
             .done(() => { });
                }
            </script>
		</div>
		<div class="card m-2">
			<div class="card-header">서버측 유효성 검사</div>
			<div class="card-body">
				<div class="card m-2">
					<div class="card-header">회원가입 폼</div>
					<div class="card-body">


						<form method="post" action="join">
							<div class="input-group">
								<div class="input-group-prepend">
									<span class="input-group-text">mid</span>
								</div>
								<input type="text" name="mid" class="form-control"
									value="${joinForm.mid}" autocomplete="username">
								<form:errors cssClass="text-danger" path="joinForm.mid" />
							</div>
							<div class="input-group">
								<div class="input-group-prepend">
									<span class="input-group-text">mpassword</span>
								</div>
								<input type="password" name="mpassword" class="form-control"
									value="${joinForm.mpassword}" autocomplete="current-password">
								<form:errors cssClass="text-danger" path="joinForm.mpassword" />
							</div>
							<div class="input-group">
								<div class="input-group-prepend">
									<span class="input-group-text">memail</span>
								</div>
								<input type="text" name="memail" class="form-control"
									value="${joinForm.memail}">
								<form:errors cssClass="text-danger" path="joinForm.memail" />
							</div>
							<div class="input-group">
								<div class="input-group-prepend">
									<span class="input-group-text">mtel</span>
								</div>
								<input type="text" name="mtel" class="form-control"
									value="${joinForm.mtel}">
								<form:errors cssClass="text-danger" path="joinForm.mtel" />
							</div>
							<input class="btn btn-info" type="submit" value="가입" />
						</form>
					</div>


				</div>
				<div class="card m-2">
					<div class="card-header">서버측 유효성 검사</div>
					<div class="card-body">
						<div class="card m-2">
							<div class="card-header">로그인폼</div>
							<div class="card-body">
								<form method="post" action="login">
									<div class="input-group">
										<div class="input-group-prepend">
											<span class="input-group-text">mid</span>
										</div>
										<input type="text" name="mid" class="form-control"
											value="${loginForm.mid}">
										<form:errors cssClass="text-danger" path="loginForm.mid" />
									</div>
									<div class="input-group">
										<div class="input-group-prepend">
											<span class="input-group-text">mpassword</span>
										</div>
										<input type="password" name="mpassword" class="form-control"
											value="${loginForm.mpassword}">
										<form:errors cssClass="text-danger" path="loginForm.mpassword" />
									</div>
									<input class="btn btn-info" type="submit" value="로그인" />
								</form>
							</div>
						</div>
					</div>
				</div>




			</div>
		</div>

		<%@ include file="/WEB-INF/views/common/footer.jsp"%>