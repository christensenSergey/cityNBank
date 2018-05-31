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

		<h1>List of transactions</h1>

		<!-- Building table from model -->
		<div class="table">
			<table class="table table-striped table-bordered" id="filter-table">
				<thead>
					<tr>
						<th>Transaction id</th>
						<th>Sender id</th>
						<th>Receiver id</th>
						<th>Amount</th>
						<th>Type</th>
						<th>Date</th>
					</tr>
					<tr class='table-filters'>
							<td><input type="number" /></td>
							<td><input type="number" /></td>
							<td><input type="number" /></td>
							<td><input type="number" /></td>
							<td><input type="text" /></td>
							<td><input type="date" /></td>
						</tr>

				</thead>
				<tbody>
					<c:forEach items="${transactionList}" var="transaction">
						<tr class='table-data'>
							<td><c:out value="${transaction.id}" /></td>
							<td><c:out value="${transaction.senderId}" /></td>
							<td><c:out value="${transaction.receiverId}" /></td>
							<td><c:out value="${transaction.amount}" /></td>
							<td><c:out value="${transaction.type}" /></td>
							<td><c:out value="${transaction.date}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="${pageContext.request.contextPath}/transaction/new"
				class="btn
			btn-primary btn-lg active" role="button"
				aria-pressed="true">New transaction</a>
		</div>
	</div>


		<%-- search --%>
	<script>
	$('.table-filters input').on('input', function () {
    	filterTable($(this).parents('table'));
	});

	function filterTable($table) {
    var $filters = $table.find('.table-filters td');
    var $rows = $table.find('.table-data');
   		$rows.each(function (rowIndex) {
     	  var valid = true;
      	  $(this).find('td').each(function (colIndex) {
            	if ($filters.eq(colIndex).find('input').val()) {
        	        if ($(this).html().toLowerCase().indexOf(
    	            $filters.eq(colIndex).find('input').val().toLowerCase()) == -1) {
	                    valid = valid && false;
                	}
            	}
        	});
    	    if (valid === true) {
	            $(this).css('display', '');
	        } else {
 	           $(this).css('display', 'none');
 	       }
 	   });
	}
	</script>
</body>
</html>