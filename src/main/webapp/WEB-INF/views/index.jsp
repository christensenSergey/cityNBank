<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	<a href="${pageContext.request.contextPath}/client/list"
		class="btn btn-primary btn-lg active" role="button"
		aria-pressed="true">Clients</a>
	<a href="${pageContext.request.contextPath}/account/list"
		class="btn btn-primary btn-lg active" role="button"
		aria-pressed="true">Accounts</a>
	<a href="${pageContext.request.contextPath}/transaction/list"
		class="btn btn-primary btn-lg active" role="button"
		aria-pressed="true">Transactions</a>
	<a href="${pageContext.request.contextPath}/transaction/new"
		class="btn btn-primary btn-lg active" role="button"
		aria-pressed="true">New transaction</a>
</body>
</html>