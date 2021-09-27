<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

<div class="card m-2">
	<div class="card-header">회원 가입 폼</div>
	<div class="card-body">


		<form method="post" action="join">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}"
			/>
			<c:if test="${error !=null}">
				<div class="alert alert-danger mb-2" role="alert">${error}</div>
			</c:if>

			<div class="form-group">
				<label for="mid">Member ID</label> <input type="text"
					class="form-control" id="mid" name="mid"
				>
			</div>
				<div class="form-group">
				<label for="mpassword">Member Name</label> <input type="text"
					class="form-control" id="mname" name="mname"
				>
			</div>
			
			<div class="form-group">
				<label for="mpassword">Member PW</label> <input type="password"
					class="form-control" id="mpassword" name="mpassword"
				>
			</div>

			<div class="form-group">
				<label for="mid">Member ID</label> <select type="text"
					class="form-control" id="mrole" name="mrole"
				>
					<option value="ROLE_ADMIN">Admin</option>
					<option value="ROLE_MANAGER">Manager</option>
					<option value="ROLE_USER">User</option>
				</select>

			</div>


			<button type="submit" class="btn btn-info btn-sm mt-2">회원가입</button>
		</form>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>