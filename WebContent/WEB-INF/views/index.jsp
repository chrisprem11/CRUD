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


<title>Spring Revisit</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col-lg-12 col-sm-12 col-sm-12 col-xs-12">
				<h3 id="text1">
					<a href="${pageContext.request.contextPath}/showAll">All Users</a>
				</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12 col-sm-12 col-sm-12 col-xs-12">
				<h3 id="text2">
					<a href="${pageContext.request.contextPath}/registration">New
						User ? Register Here.</a>
				</h3>
			</div>
		</div>
		<hr />
		<div>

			<p>
				<c:out value="${role}"></c:out>
			</p>

		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>


	<script src="<c:url value='/static/js/jquery-3.1.1.slim.js'/>"
		type="text/javascript"></script>
	<script src="<c:url value='/static/js/bootstrap.js'/>"
		type="text/javascript"></script>
	<script src="<c:url value='/static/js/script.js'/>"
		type="text/javascript"></script>
</body>
</html>