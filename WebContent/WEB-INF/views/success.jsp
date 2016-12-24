<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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


<title>Success!</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<h3 class="text-success">
					Thank You, <span>${firstName}</span> !!
				</h3>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<h3>
					<span>${success}</span>
				</h3>
				<br /> <a href="/Revisit/"><button
						class="btn btn-sm btn-primary">Home</button></a>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>

	<script src="<c:url value='/static/js/jquery-3.1.1.slim.js'/>"
		type="text/javascript"></script>
	<script src="<c:url value='/static/js/bootstrap.js'/>"
		type="text/javascript"></script>
</body>
</html>