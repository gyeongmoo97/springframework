<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

<div class="card m-2">
	<div class="card-header">DTO 객체의 필드값을 양식의 드롭다운리스트(select 태그)로 세팅
	</div>
	<div class="card-body">
		<!-- 위에꺼 알아야함 -->
		<%-- 	<form method="post" action="form2">
			<div class="form-group">
				<label for="mtype">Type</label> <select class="form-control"
					id="mtype" name="mtype">
					<c:forEach var="type" items="${typeList}">
						
						<option value="${type}"
							<c:if test="${member.mtype == type}">selected</c:if>>${type}</option>
					</c:forEach>
				</select>
			</div>

			<div class="form-group">
				<label for="mjob">Job</label> 
				<select class="form-control"
					id="mjob" name="mjob">
						<option value="">---선택하세요</option>
						<c:forEach var="jab" items="${jobList}">
						<!--value는 선택했을 때 전달되는 값  -->
						<option value="${job}"
							<c:if test="${member.mjob == job}">selected</c:if>>${job}</option>
					</c:forEach>
							
				</select>
			</div>



			<button type="submit" class="btn btn-primary">제출</button>
		</form> --%>

		<%-- 	<form:form method="post" action="form2" modelAttribute="member">
			<div class="form-group">
				<label for="mtype">Type</label>
				<form:select path="mtype" items="${typeList}" class="form-control" />
			</div>
			<div class="form-group">
				<label for="mjob">JOB</label>
				<form:select path="mjob"  class="form-control" >
				<option value="">---선택하세요</option>
				<form:options items="${jobList}"/> 
				</form:select>
			</div>
			<button type="submit" class="btn btn-primary">제출</button>
		</form:form>
 --%>

<%-- 		<form method="post" action="form2">
			<div class="form-group">
				<label for="mtype">Type</label>
				<select class="form-control" id="mtype" name="mtype">
					<c:forEach var="type" items="${typeList}">

						<option value="${type}"
							<c:if test="${member.mtype == type}">selected</c:if>
						>${type}</option>
					</c:forEach>
				</select>
			</div>

			<div class="form-group">
				<label for="mtype">Job</label>
				<select class="form-control" id="mjob" name="mjob">
					<option value="">=====선택하세요=====</option>
					<c:forEach var="mjob" items="${jobList}">
						<option value="${mjob}">${mjob}</option>
					</c:forEach>
				</select>
			</div>


			<div class="form-group">
				<label for="mcity">City</label>
				<select class="form-control" id="mcity" name="mcity">
					<c:forEach var="city" items="${cityList}">
						<option value="${city.code}"
							<c:if test="${member.mcity == city.code}">selected</c:if>
						>${city.label}</option>

					</c:forEach>

				</select>
			</div>




			<button type="submit" class="btn btn-primary">제출</button>
		</form> --%>

		<form:form method="post" action="form2" modelAttribute="member">
			<div class="form-group">
				<label for="mcity">Type</label>
				<form:select path="mtype" items="${typeList}" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="mjob">JOB</label>
				<form:select path="mjob"  class="form-control" >
				<form:option value="">---선택하세요</form:option>
				<form:options items="${jobList}"/> 
				</form:select>
			</div>
			
			<div class="form-group">
				<label for="mcity">City</label>
				<!-- path="mcity" 는 값을 전달 받을 맴버 변수
				 items="${cityList}"  컨테이너에 있는 collections
				 itemValue="code" 
				 itemLabel="label"  -->
				<form:select path="mcity" items="${cityList}" itemValue="code" itemLabel="label" class="form-control"/>
			</div>
			
			<button type="submit" class="btn btn-primary">제출</button>
		</form:form>


	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>


<%-- <%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

<!--카드 시작  -->
<div class="card m-2">

	<div class="card-header">DTO 객체의 필드값을 드롭다운리스트 (select 태그)로 세팅</div>

	<!--카드 내용 시작  -->
	<div class="card-body">
		순수 HTML 태그 활용 방식
		
		<form method="post" action="form2">
			<div class="form-group">
				<label for="mtype">type</label> 
				<select class="form-control" id="mtype" name="mtype">
					<c:forEach var="type" items="${typeList}">
						<option value="${type}"
						<c:if test="${member.mtype == type}">selected</c:if>
						>${type}</option>
					</c:forEach>
					
				</select>
				<button type="submit" class="btn btn-primary">제출</button>
			</div>
		</form> 
	 <form>
		  <div class="form-group">
		    <label for="mtype">Type</label>
		    <select class="form-control" id="mtype">
		    	<c:forEach var="mtype" items="${member.mtypes}">
		    		<option value="${mtype}">${mtype}</option>
		    	</c:forEach>
		
		    </select>
		  </div>
  		 	 <button type="submit" class="btn btn-primary">제출</button>
		</form> 
		 
		
 		<form:form method="post" action="form2" modelAttribute="member">
			<div class="form-group">
				<label for="mtype">type</label> 
					<form:select path="mtype" items="${typeList}" class="form-control"/>
			
				<button type="submit" class="btn btn-primary">제출</button>
			</div>
		</form:form>   
		
		
	</div>
	<!--카드 내용 끝 -->
</div>
<!--카드 끝 -->

<%@ include file="/WEB-INF/views/common/footer.jsp"%> --%>