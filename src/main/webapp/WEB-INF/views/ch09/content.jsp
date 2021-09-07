<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

<div class="card m-2">
	<div class="card-header">FileUpload & FileDownload</div>
	<div class="card-body">
		<div class="card">
			<div class="card-header">Form 태그를 이용한 FileUpload</div>
			<div class="card-body">
				<form method="post" enctype="multipart/form-data"
					action=fileupload>
					<div class="form-group">
						<label for="exampleFormControlInput1">File Title</label> <input
							type="text" class="form-control" id="title" name="title"
							placeholder="파일 이름"> <label
							for="exampleFormControlInput1">File Description</label> <input
							type="text" class="form-control" id="desc" name="desc"
							placeholder="파일 설명">
					</div>
					<div class="form-group">
						<label for="attach">Example file input</label> <input type="file"
							class="form-control-file" id="attach" name="attach" multiple>
					</div>
					<button class="btn btn-info btn-sm">form 파일 업로드</button>
					<a href="javascript:fileupload()" class="btn btn-info btn-sm">ajax
						파일 업로드</a>
				</form>

			</div>
			<script>
            function fileupload(){
               
               //입력된 정보를 얻기
               
               const title = $("#title").val();
               const desc = $("#desc").val();
               //input에 대한 jqery객체를 얻는다.
               //const attach = $("#attach")[0].files[0];
               //attach가 undefined라면 파일이 선택안된것이다.
               const attach = document.querySelector("#attach").files[0];
              /*  console.log(desc);
               console.log(title);
               console.log(attach); */
               //Multipart/form-data
               //javascript에서 multipart폼을 만들어내는 객체
               const formData = new FormData();
               formData.append("title", title);
               formData.append("desc",desc);
               formData.append("attach",attach);
               
               //Ajax로 서버로 전송
               //cache는 false로 꺼야한다. 
               //브라우져에서 그 파일에 대한 정보를 caching해서 저장할 이유가 없다.
               //ajax가 가공하면 안된다. 파일데이터는 있는그대로 서버로 전송하라는 뜻이다.
               //contentType은 false해야한다. 
               //왜냐하면 보내는 위의 3가지가 타입이 다를수 있기 때문이다.
               //그래서 전체적으로 content 타입이 뭔지 이야기할수 없다.
               $.ajax({
                  url: "fileuploadAjax",
                  method:"post",
                  data: formData,
                  cache: false,
                  processData: false,
                  contentType: false
               }).done((data)=>{
                  console.log(data);
                  if(data.result === "success"){
                     window.alert("파일이 전송이 성공됨");
                  }
               });
            }
         </script>
		</div>

		<div class="card m-2">
			<div class="card-header">FileUpload & FileDownload</div>
			<div class="card-body">
				<div class="card">
					<div class="card-header">Filedownload</div>
				</div>
				<div class="card-body">
					<a href="filedownload?fileNo=1" class="btn btn-light btn-sm">파일
						다운로드</a>

					<hr>
					<!-- 다운 받은 파일을 바로 보여줄 수 있다.  -->
					<img src="filedownload?fileNo=1" width="200px" />

				</div>
			</div>
		</div>


	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>

<%-- <%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

<!--카드 시작  -->
<div class="card m-2">
	<div class="card-header">FileUpload & File Download</div>

	<!--카드 내용 시작  -->
	<div class="card-body">
		<div class="card m-2">
			<div class="card-header">Form 태그를 이용한 FileUpload</div>

			<!--카드 내용 시작  -->
			<div class="card-body">
				<form method="post" enctype="multipart/form-data"
					action="fileupload">
					<div class="form-group">
						<label for="title">File title</label> <input type="text"
							class="form-control" id="title" name="title"
							placeholder="파일 title (힌트 글자)">
					</div>
					<div class="form-group">
						<label for="desc">File Description</label> <input type="text"
							class="form-control" id="desc" name="desc"
							placeholder="파일글자 (힌트 글자)">
					</div>
					<div class="form-group">
						<label for="attach">Example file input</label> <input type="file"
							class="form-control-file" id="attach" name="attach" multiple>
					</div>
					<button class="btn btn-light btn-sm">파일 업로드</button>
					<a href="javascript:fileupload()" class="btn btn-light btn-sm">
						파일 업로드 </a>
				</form>
			</div>
			<script>
				function fileupload(){
					//입력된 정보를 얻기
					const title = $("#title").val();
					const desc = $("#desc").val();
					const attach = document.querySelector("#attach").files[0];
					console.log(attach);
					//files[0]의 의미?
					
					//Multipart/form-data
					const formData = new FormData();
					formData.append("title",title);
					formData.append("desc",desc);
					formData.append("attach",attach);
					//만약 파일이 선택되지 않으면 attach 가 undifined 나오는데
					// undif 는 false 처리임
					
					//Ajax 서버로 전송
					$.ajax({
						url: "fileuploadAjax",
						method: "post",
						data: formData,
						cache: false,
						processData: false,
						contentType: false
						//false 된 부분은 고정적으로 들어간다고 생각해야함
					}).done(data) => {
						console.log(data);
						if(data.result==="success"){
							window.alter("파일전송성공");
						}
					});
				}
			</script>
			<!--카드 내용 끝 -->
		</div>
		<!--카드 끝 -->

		<div class="card m-2">
			<div class="card-header">2</div>
			읽기
			<!--카드 내용 시작  -->
			<div class="card-body">
				<button class="btn btn-light btn-sm">파일 업로드</button>
			</div>
			<!--카드 내용 끝 -->
		</div>
		<!--카드 끝 -->

	</div>
	<!--카드 내용 끝 -->
</div>
<!--카드 끝 -->

<%@ include file="/WEB-INF/views/common/footer.jsp"%> --%>