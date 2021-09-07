<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

<div class="card">
	<div class="card-header">Controller/Data Delivery</div>
	<div class="card-body">
		<!--카드시작  -->
		<div class="card m">
			<div class="card-header">객체(데이터) 사용 범위</div>
			<div class="card-body">
				<a href="saveDate" class="btn btn-info btn-sm"">데이터 저장</a> 
				<a href="readDate" class="btn btn-info btn-sm"">데이터 읽기</a>
			</div>
 
		</div>

		<!--  카드 끝-->
		
		<!--카드시작  -->
		<div class="card m">
			<div class="card-header">EL(expressions language)</div>
			<div class="card-body">
				<a href="objectSaveAndRead1" class="btn btn-danger btn-sm"">객체를 저장하고 읽기1</a> 
				<a href="objectSaveAndRead2" class="btn btn-danger btn-sm"">객체를 저장하고 읽기2</a> 
				<a href="objectSaveAndRead3" class="btn btn-danger btn-sm"">객체를 저장하고 읽기3</a> 
			</div>
		</div>

		<!--  카드 끝-->
		
		
		<!--카드시작  -->
		<div class="card m">
			<div class="card-header">JSTL(java stanadard tag library) : 조건처리 반복처리 </div>
			<div class="card-body">
				<a href="useJstl1" class="btn btn-success btn-sm"">JSTL 사용하기1</a> 
				<a href="useJstl2" class="btn btn-success btn-sm"">JSTL 사용하기2</a> 
				
			</div>
		</div>

		<!--  카드 끝-->
		<!--카드시작  -->
		<div class="card m">
			<div class="card-header">@ModelAttribute 이용하여 데이터 전달 </div>
			<div class="card-body">
				<a href="useModelAttribute1" class="btn btn-success btn-sm"">@ModelAttribute 로 전달1</a> 
				<a href="useModelAttribute2" class="btn btn-success btn-sm"">@ModelAttribute 로 전달2</a> 
				
			</div>
		</div>

		<!--  카드 끝-->
		
		<!--카드시작  -->
		<div class="card m">
			<div class="card-header">@ModelAttribute 이용하여 매개 변수 값 전달 </div>
			<div class="card-body">
				<a href="argumentSaveAndRead1?kind=suite&sex=woman" class="btn btn-success btn-sm"">매개변수 값 전달1</a> 
				<a href="argumentSaveAndRead2?kind=suite&sex=woman" class="btn btn-success btn-sm"">매개변수 값 전달2</a> 
				<a href="argumentSaveAndRead3?kind=suite&sex=woman" class="btn btn-success btn-sm"">매개변수 객체 전달3</a> 
				
			</div>
		</div>

		<!--  카드 끝-->
		
		
		
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>