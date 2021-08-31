<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

<div class="card m-2">
	<div class="card-header">Browser 1차 유효성검사</div>
	<div class="card-body">
		<div class="card m-2">
			<div class="card-header">  POST 방식으로 요청
            </div>
            <div class="card-body">
               <form id="form0" method="post" onsubmit="checkData(this)" >
                      <div class="input-group">
                         <div class="input-group-prepend"><span class="input-group-text">param1</span></div>
                         <input type="text" name="param1" class="form-control" value="">
                         <span class="param1-error text-danger">*</span>
                      </div>
                      <div class="input-group">
                         <div class="input-group-prepend"><span class="input-group-text">param2</span></div>
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
						<input type="date" name="param5" class="form-control"
							value="">
							  <span class="param5-error text-danger">*</span>
					</div>
					<input class="btn btn-info m-2" type="submit" value="요청" />
				</form>
			</div>
			<script>
				function checkData(form){
					//form의 제출기능을 off
					event.preventDefault();
					
					//유효성 검사 결과 변수
					let checkResult = true;
					
					//입력길리 체크
					let param1 = form.param1.value;
					const param1Error = document.querySelector("#form0 .param1-error");
					console.log(param1Error);
					if(param1===""){
						//window.alert("param1은 필수입력입니다.");
						
						param1Error.innerHTML="필수 입력 사항"
							let checkResult = false;
					}else{
						if(param1.length<8 ||param.length>15){
							const param1Error = document.querySelector("form0 .param1-error")
							param1Error.innerHTML = "8자 이상, 15자 이하 입력 필요"
								let checkResult = false;
						};
					}
					
					let param2 = form.param2.value;
					const param2Error = document.querySelector("#form0 .param2-error");
					param2Error.innerHTML="";
					if(param1 ===""){
						
						param2Error.innerHTML="필수 입력 사항"
							let checkResult = false;
					} else{
						const pattern =/(010|011)-[0-9]{3,4}-[0-9]{4}/i;
						const result = pattern.test(param2);
						if(result === false){
							param2Error.innerHTML ="전화번호 형식이 아님";
							let checkResult = false;
						}
					}
					
					//맨앞 010-는 고정문자, 중간은 0~9까지의 3자,4자의 숫자, 마지막은 0~9까지의 4자리 숫자
				/*	const pattern= /(010|011)-[0-9]{3,4}-[0-9]{4}/i;
					
					const result = patteren.test("011-123-1234");
					console.log(result);*/
					
					let param3 = form.param3.value;
					const param3Error = document.querySelector("#form0 .param3-error");
					param3Error.innerHTML = "";
					if(param3 ===""){
						
						param3Error.innerHTML="필수 입력 사항"
					} else{
						const pattern =/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
						const result = pattern.test(param3);
						if(result === false){
							param3Error.innerHTML ="email 형식이 아님";
							let checkResult = false;
						}
					}
				/* 	
					const pattern = 
					const result = pattern.test("mwe226@naver.com");
					console.log(result); */
					//날짜가 비었는지 체크
					let param5 = form.param5.value;
					const param5Error = document.querySelector("#form0 .param5-error");
					if(param5===""){
						param5Error.innerHTML="필수 입력 사항"
					} 
					
					///서버로 제출 할지 말지 결정해야함
					if(checkResult){
						//form은 함수의 요소로 들어온 값. form의 submit 메서드로 서버에 제출가능
						form.submit();
					}
					
				}
			</script>	
		
		</div>

		<%-- ajax 방식 --%>

		<div class="card m-2">
			<div class="card-header">AJAX요청</div>
			<div class="card-body">
				<form name="form1" id="form1" >
					<%-- href="method1" 이건 상대경로임 --%>
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text">param1</span>
						</div>
						<input type="text" id="param1" name="param1" class="form-control"
							value="문자열">
							
							
						<%-- !!!중요!!! input 태그 보면 name 에 param1 들어간다. name 속성에 들어가는 일므이 파라미터 이름이된다.--%>
					</div>
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text">param2</span>
						</div>
						<input id="param2" type="text" name="param2" class="form-control"
							value="5">
					</div>
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text">param3</span>
						</div>
						<input id="param3" type="text" name="param3" class="form-control"
							value="3.14">
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
								name="param4" id="radio2" value="false"> false
							</label>
						</div>
					</div>
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text">param5</span>
						</div>
						<input type="date" id="param5" name="param5" class="form-control"
							value="2030-12-05">
					</div>

				</form>
				<div>

					<button class="btn btn-info btn-sm" onclick="requestPost()">post
						방식요청</button>
				</div>
			</div>
			<script>
   
      function requestPost(){
        	const param1 = $("param1").val();
        	const param2 = $("param2").val();
        	const param3 = $("param3").val();
        	const param4 = $("#form1 input[name=param4]:checked").val();
        	const param5 = $("param5").val();
    	  
    	  
    	  $.ajax({
            url:"method1",
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
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>