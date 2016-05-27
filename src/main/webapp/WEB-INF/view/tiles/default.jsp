<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<tiles:importAttribute name="javascripts" />
<tiles:importAttribute name="stylesheets" />

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" href="favicon.ico" />
<title><tiles:insertAttribute name="title"></tiles:insertAttribute></title>
<!-- stylesheets -->
<c:forEach var="css" items="${stylesheets}">
	<link rel="stylesheet" type="text/css" href="<c:url value="${css}"/>">
</c:forEach>
<!-- end stylesheets -->
</head>
<body class="page-container-bg-solid page-boxed">

	<!--[if lt IE 10]>
        <p class="alert alert-warning">
            Warning: You are using an unsupported version of Internet Explorer. We recommend using Internet Explorer
            10+. If you are a Windows XP user you'll need to download an alternative browsers such as FireFox, Chrome,
            Opera, or Safari. 
        </p>
    <![endif]-->

	<!-- header -->
	<div id="header">
		<tiles:insertAttribute name="header"></tiles:insertAttribute>
	</div>
	<!-- end header  -->

	<!-- content -->
	<div id="content">
		<tiles:insertAttribute name="content"></tiles:insertAttribute>
	</div>
	<!-- end content -->

	<!-- footer -->
	<div id="footer">
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	</div>
	<!-- end footer -->

	<!-- scripts -->
	<c:forEach var="script" items="${javascripts}">
		<script src="<c:url value="${script}"/>"></script>
	</c:forEach>
	<!-- END JAVASCRIPTS -->
	<!-- end scripts -->

</body>
</html>