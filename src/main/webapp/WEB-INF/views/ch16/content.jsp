<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

<!--카드 시작  -->
<div class="card m-2">

	<div class="card-header">트렌젝션 처리</div>

	<!--카드 내용 시작  -->
	<div class="card-body">



		<!--카드 시작  -->
		<div class="card m">

			<div class="card-header"></div>
			계좌 현황
			<!--카드 내용 시작  -->
			<div class="card-body">
				<c:if test="${transferError != null}">
					<div class="alert alert-danger" role="alert">${transferError}</div>
				</c:if>
				<table style="width: auto" class="table table-sm table-bordered">
					<tr>
						<th style="width: 50px">번호</th>
						<th style="width: 100px">소유주</th>
						<th style="width: 200px">잔고</th>
					</tr>

					<c:forEach var="account" items="${list}">
						<tr>
							<td>${account.ano}</td>
							<td>${account.owner}</td>
							<td style="text-align: right;">${account.balance}</td>
						</tr>
					</c:forEach>
				</table>

			</div>
			<!--카드 내용 끝 -->
		</div>
		<!--카드 끝 -->






		<!--카드 시작  -->
		<div class="card m">

			<div class="card-header">프로그래밍 방식</div>

			<!--카드 내용 시작  -->
			<div class="card-body">

				<form id="accountTransferForm1" method="post" action="transaction1">
					<table style="width: auto" class="table table-sm table-bordered">
						<tr>
							<th style="width: 150px">출금 계좌</th>
							<td><input id="fromAccount" type="text" name="fromAno"
								value="1"
							/></td>
						</tr>
						<tr>
							<th>입금 계좌</th>
							<td><input id="toAccount" type="text" name="toAno" value="2" /></td>
						</tr>
						<tr>
							<th>이체 금액</th>
							<td><input id="amount" type="text" name="amount"
								value="10000"
							/></td>
						</tr>
					</table>
					<input class="btn btn-info" type="submit" value="이체하기" />
				</form>

			</div>
			<!--카드 내용 끝 -->
		</div>
		<!--카드 끝 -->




		<!--카드 시작  -->
		<div class="card m">

			<div class="card-header">선언적 방식</div>

			<!--카드 내용 시작  -->
			<div class="card-body">

				<form id="accountTransferForm2" method="post" action="transaction2">
					<table style="width: auto" class="table table-sm table-bordered">
						<tr>
							<th style="width: 150px">출금 계좌</th>
							<td><input id="fromAccount" type="text" name="fromAno"
								value="1"
							/></td>
						</tr>
						<tr>
							<th>입금 계좌</th>
							<td><input id="toAccount" type="text" name="toAno" value="2" /></td>
						</tr>
						<tr>
							<th>이체 금액</th>
							<td><input id="amount" type="text" name="amount"
								value="10000"
							/></td>
						</tr>
					</table>
					<input class="btn btn-info" type="submit" value="이체하기" />
				</form>

			</div>
			<!--카드 내용 끝 -->
		</div>
		<!--카드 끝 -->



		<!--카드 시작  -->
		<div class="card m">

			<div class="card-header"></div>

			<!--카드 내용 시작  -->
			<div class="card-body"></div>
			<!--카드 내용 끝 -->
		</div>
		<!--카드 끝 -->







		<%@ include file="/WEB-INF/views/common/footer.jsp"%>






	</div>
	<!--카드 내용 끝 -->
</div>
<!--카드 끝 -->

<%@ include file="/WEB-INF/views/common/footer.jsp"%>