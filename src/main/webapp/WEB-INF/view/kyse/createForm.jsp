<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>Kysymyksen lisääminen</title>
</head>
<body>
<h1>Lisää kysymys</h1>
<form:form modelAttribute="kysymys" method="post">
	<fieldset>
			<legend>Kysymys</legend>
			<p>
			<form:label path="kysymys">Kysymys</form:label><br/>
			<form:input path="kysymys"/>
			<p>
			<button type="submit">Lisää</button>
			</p>
	</fieldset>
	</form:form>
	<p><a href="../">Peruuta</a></p>
</body>
</html>