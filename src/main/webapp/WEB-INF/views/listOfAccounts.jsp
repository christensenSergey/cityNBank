<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/webjars/bootstrap/css/bootstrap.min.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/webjars/bootstrap/js/bootstrap.min.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/webjars/jquery/jquery.min.js"></script>

<%-- search --%>
<script>
	$(document).ready(
			function() {
				$("#search").keyup(
						function() {
							_this = this;
							$.each($("#mytable tbody tr"), function() {
								if ($(this).text().toLowerCase().indexOf(
										$(_this).val().toLowerCase()) === -1) {
									$(this).hide();
								} else {
									$(this).show();
								}
							});
						});
			});
</script>

</head>

<body>
	<div class="container">
		<a href="${pageContext.request.contextPath}/client/list"
			class="btn btn-primary btn-lg active" role="button"
			aria-pressed="true">Clients</a> <a
			href="${pageContext.request.contextPath}/account/list"
			class="btn btn-primary btn-lg active" role="button"
			aria-pressed="true">Accounts</a> <a
			href="${pageContext.request.contextPath}/transaction/list"
			class="btn btn-primary btn-lg active" role="button"
			aria-pressed="true">Transactions</a> <a
			href="${pageContext.request.contextPath}/transaction/new"
			class="btn btn-primary btn-lg active" role="button"
			aria-pressed="true">New transaction</a>

		<h1>List of accounts</h1>

		<div class="form-group">
			<input type="text" class="form-control pull-right" id="search"
				placeholder="Search">
		</div>

		<!-- Building table from model -->
		<div class="table-responsive">
			<table class="table table-striped table-bordered" id="mytable">
				<thead>
					<tr>
						<th>Account id</th>
						<th>Amount</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${accountList}" var="account">
						<tr>
							<td><c:out value="${account.id}" /></td>
							<td><c:out value="${account.amount}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<c:if test="${clientId != 0}">
			<h1>Add account to client with id ${clientId}</h1>
			<form:form method="post" modelAttribute="account" action="save">
				<div class="form-group">
					<label>Amount</label>
					<form:input type="number" path="amount" class="form-control"
						placeholder="Amount" step="1" autofocus="true" required="required"></form:input>
				</div>
				<input type="hidden" name="clientId" value="${clientId}">
				<button class="btn btn-lg btn-primary btn-block" type="submit">Add</button>
			</form:form>
		</c:if>

	</div>



</body>
</html>