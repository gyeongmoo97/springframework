<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

<!--카드 시작  -->
<div class="card m-2">

	<div class="card-header">
		ViewName을 객체 이름으로 해석
	</div>

	<!--카드 내용 시작  -->
	<div class="card-body">
		<h6>다운로드 파일목록 (<span id="totalFileNum" class="text-danger">0</span>)</h6>
		<div id ="fileList"></div>
	</div>
	<script type="text/javascript">
		$(function() {
			$.ajax({
				url: "fileList"
			}).done((data)=>{
				//data= {totalFileNum:10, fileList:["photo1.jpg", "photo2.jpg", ...] }
				$("#totalFileNum").html(data.totalFileNum);
				var ulTag = "<ul>";
				for(var i=0; i<data.fileList.length; i++){
					ulTag += "<li>";
					ulTag += "<a href='fileDownload?fileName="+ data.fileList[i] + "'>" + data.fileList[i] + "</a>";
					ulTag += "</li>"
				}
				ulTag += "</ul>"
				$("#fileList").html(ulTag);
				
				});
		});
	</script>
	<!--카드 내용 끝 -->
</div>
<!--카드 끝 -->

<%@ include file="/WEB-INF/views/common/footer.jsp"%>