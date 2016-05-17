<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<title>Norton Cantine Login</title>
<meta charset="utf-8">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	rel='stylesheet' type='text/css' />

<link href="${pageContext.request.contextPath}/resources/login-assets/css/style.css"
	rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript">
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 

</script>
<script type="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<!--webfonts-->
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:600italic,400,300,600,700'
	rel='stylesheet' type='text/css'>
<!--//webfonts-->
</head>
<body>

	<!-----start-main---->
	<div class="login-form">
		<div class="head">
			<img
				src="${pageContext.request.contextPath}/resources/images/mem2.jpg"
				alt="" />

		</div>
		<form action="login" method="POST">
			<c:if test="${param.error != null}">
				<div class="alert alert-danger">
					<p>Invalid username and password.</p>
				</div>
			</c:if>
			<c:if test="${param.logout != null}">
				<div class="alert alert-success">
					<p>You have been logged out successfully.</p>
				</div>
			</c:if>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<li><input type="text" name="username" class="text"
				value="USERNAME" onfocus="this.value = '';"
				onblur="if (this.value == '') {this.value = 'USERNAME';}"><a
				href="#" class=" icon user"></a></li>
			<li><input type="password" name="password" value="Password"
				onfocus="this.value = '';"
				onblur="if (this.value == '') {this.value = 'Password';}"><a
				href="#" class=" icon lock"></a></li>
			<div class="p-container">
				<!-- <label class="checkbox"><input type="checkbox" name="checkbox" checked><i></i>Remember Me</label> -->
				<input type="submit" onclick="myFunction()" value="SIGN IN">
				<div class="clear"></div>
			</div>
		</form>
	</div>
	<!--//End-login-form-->

</body>
</html>