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

		<h1>Add transaction</h1>
		<form:form method="post" modelAttribute="transaction" action="new">
			<div class="form-group">
				<label>Sender account id</label>
				<form:input type="number" path="senderId" class="form-control"
					placeholder="Sender account id" step="1" min="0" value="0"
					required="required"></form:input>
			</div>
			<div class="form-group">
				<label>Receiver account id</label>
				<form:input type="number" path="receiverId" class="form-control"
					placeholder="Receiver account id" step="1" min="1"
					required="required" autofocus="true"></form:input>
			</div>
			<div class="form-group">
				<label>Amount</label>
				<form:input type="number" path="amount" class="form-control"
					placeholder="Amount" step="1" min="1"></form:input>
			</div>
			<div class="form-group">
				<label for="type">Type</label> <select class="form-control"
					name="type">
					<c:forEach var="type" items="${payTypes}">
						<option value="${type}">${type}</option>
					</c:forEach>
				</select>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Add</button>
		</form:form>
	</div>

</body>
</html>