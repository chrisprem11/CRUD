<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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

<title>Registration</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
				<div>
					<div>
						<h3 class="text-danger">${error}</h3>
					</div>
					<form:form action="${pageContext.request.contextPath}/register"
						method="post" modelAttribute="userData">
						<div>
							<form:label path="firstName" class="form-group">First Name : </form:label>
							<form:input path="firstName" type="text" class="form-control"
								required="true" maxlength="20" />
						</div>
						<div>
							<form:label path="lastName" class="form-group">Last Name : </form:label>
							<form:input path="lastName" type="text" class="form-control"
								required="true" maxlength="25" />
						</div>
						<div>
							<form:label path="email" class="form-group">Email : </form:label>
							<form:input path="email" type="text" class="form-control"
								required="true" maxlength="40" />
						</div>
						<div>
							<form:label path="password" class="form-group">Password : </form:label>
							<form:input path="password" type="text" class="form-control"
								required="true" maxlength="10" />
						</div>
						<div>
							<br /> <input type="submit" value="Register"
								class="btn btn-sm btn-warning">
						</div>
					</form:form>
					<div>
						<a href="/Revisit/"><button class="btn btn-sm btn-primary">Home</button></a>
					</div>
				</div>
			</div>
			<div class="col-md-6"></div>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>