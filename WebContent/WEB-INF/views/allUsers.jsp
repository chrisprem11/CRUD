<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://fonts.googleapis.com/css?family=Molle:400i|Oleo+Script|Philosopher|Prociono"
	rel="stylesheet">
<link href="<c:url value='/static/styles/style.css'/>" rel="stylesheet"
	type="text/css"></link>
<link href="<c:url value='/static/css/bootstrap.css'/>" rel="stylesheet"
	type="text/css"></link>
<link href="<c:url value='/static/css/bootstrap-theme.css'/>"
	rel="stylesheet" type="text/css"></link>


<title>All Users</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<div class="list col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<h3>All Registered Users</h3>
				<hr />
				<div>
					<span class="text-success">${message}</span> <span
						class="text-success">${error}</span>

				</div>
				<table class="table table-hover table-striped">
					<thead>
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Email</th>
							<th>Password</th>
							<th>Account</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${allUsers}">
							<tr>
								<td><c:out value="${item.firstName}"></c:out></td>
								<td><c:out value="${item.lastName}"></c:out></td>
								<td><c:out value="${item.email}"></c:out></td>
								<td><c:out value="${item.password}"></c:out></td>
								<td><c:out value="${item.enabled ? 'Enabled' : 'Disabled'}"></c:out></td>
								<td><a
									href="${pageContext.request.contextPath}/userProfile/${item.userId}"><button
											class="btn btn-sm btn-warning">Update</button></a> <a
									href="${pageContext.request.contextPath}/deleteUser/${item.userId}"><button
											class="btn btn-sm btn-danger">Delete</button></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>
		<br />
		<div class="row">
			<a href="/Revisit/"><button class="btn btn-sm btn-primary">Home</button></a>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>

	<script src="<c:url value='/static/js/jquery-3.1.1.slim.js'/>"
		type="text/javascript"></script>
	<script src="<c:url value='/static/js/bootstrap.js'/>"
		type="text/javascript"></script>
</body>
</html>