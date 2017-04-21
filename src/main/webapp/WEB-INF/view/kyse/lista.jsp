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
<title>Kysymys lista</title>
<link rel="stylesheet" type="text/css" href="../resources/styles/common.css">
</head>	
<body>
<form:form modelAttribute="vastaus" method="post">
	<table>
	<caption>Kysymykset</caption>
	<thead>
		<tr>
			<td>ID</td>
			<td>Kysymys</td>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${kysymykset}" var="kyse">
		<tr>
			<td><c:out value="${kyse.id}"/></td>
			<td><c:out value="${kyse.kysymys}"/></td>
			<td><form:label path="vastaus">Vastaus: </form:label>
			<form:input path="vastaus"/></td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
	<p>
		<button type="submit">Lisää</button>
	</p>
</form:form>
	<p><a href="../">Etusivulle</a></p>
</body>
</html>