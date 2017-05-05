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
<title>Kyselylista</title>
<!-- <link rel="stylesheet" type="text/css" href="../resources/styles/common.css"> -->
</head>	
<body>
	<table>
	<caption>Kyselyt</caption>
	<thead>
		<tr>
			<td>Nimi</td>
			<td>Kysymys</td>
			<td>Vastaus</td>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${kyselyt}" var="kyse">
		<tr>
			<td><c:out value="${kyse.nimi}"/></td>
			<td> --- <c:out value="${kyse.kysymys}"/></td>
			<td> --- <c:out value="${kyse.vastaus}"/></td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
	<p><a href="../">Etusivulle</a></p>
</body>
</html>