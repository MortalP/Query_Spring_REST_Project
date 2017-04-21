<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<title>Vastaus lista</title>
<!-- <link rel="stylesheet" type="text/css" href="../resources/styles/common.css"> -->
</head>	
<body>
	<table>
	<caption>Vastaukset kysymyksiin</caption>
	<thead>
		<tr>
			<td>Vastaus</td>
			<td>Kysymys</td>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${vastaukset}" var="vast">
		<tr>
			<td><c:out value="${vast.vastaus}"/></td>
			<td> --- <c:out value="${vast.kysymys}"/></td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
	<p><a href="../">Etusivulle</a></p>
</body>
</html>