<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


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

<title>User Profile</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<div class="col-lg-4">
				<div class="row">
					<div class="col-md-3"></div>
					<div class="col-md-6">
						<img src="/static/img/app.png " class="img-responsive img-circle" />

					</div>
					<div class="col-md-3"></div>
				</div>
				<div>
					<h2>User Details</h2>
				</div>
			</div>
			<div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
				<div>
					<span class="text-danger">${error}</span>
				</div>
				<form:form
					action="${pageContext.request.contextPath}/updateUser/${userId}"
					method="post" modelAttribute="updateData">

					<div>
						<form:label path="firstName" class="form-group">First Name : </form:label>
						<form:input path="firstName" type="text" value="${user.firstName}"
							class="form-control" />
					</div>
					<div>
						<form:label path="lastName" class="form-group">Last Name : </form:label>
						<form:input path="lastName" type="text" value="${user.lastName}"
							class="form-control" />
					</div>
					<div>
						<form:label path="email" class="form-group">Email : </form:label>
						<form:input path="email" type="text" value="${user.email}"
							readonly="true" class="form-control" />
					</div>
					<div>
						<form:label path="password" class="form-group">Password : </form:label>
						<form:input path="password" type="text" value="${user.password}"
							class="form-control" />
					</div>
					<div>
						<br /> <input type="submit" value="Update"
							class="btn btn-sm btn-success">
					</div>
				</form:form>
				<br />
				<div>
					<a href="/Revisit/"><button class="btn btn-sm btn-primary">Home</button></a>
				</div>
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