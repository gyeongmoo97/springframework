<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- perfix 는 관례적으로 c 를 많이 쓰지만 Core 를 쓰면 Core 가된다 -->
<%@ include file="/WEB-INF/views/common/header.jsp"%>

<div class="card m-2">
	<div class="card-header">JSTL을 이용한 List 반복 처리</div>
	<div class="card-body">
		<h6>[게시물 목록]</h6>

		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">No.</th>
					<th scope="col">Title</th>
					<th scope="col">Content</th>
					<th scope="col">Writer</th>
					<th scope="col">Date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="board" items="${boardList}">
					<tr>
						
						<td  scope="row">${board.no}</td>
						<td>${board.title}</td>
						<td>${board.content}</td>
						<td>${board.writer}</td>
						<td><fmt:formatDate value="${board.date}" pattern="yyyy-MM-dd"/> </td>
				
					</tr>
		<!--mm 하면 분이된다.  -->
			</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<!--  -->
<%@ include file="/WEB-INF/views/common/footer.jsp"%>

