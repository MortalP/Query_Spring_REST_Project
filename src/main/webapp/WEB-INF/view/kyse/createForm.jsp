<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <script
	src="https://code.jquery.com/jquery-2.1.4.js"
	integrity="sha256-siFczlgw4jULnUICcdm9gjQPZkw/YPDqhQ9+nAOScE4="
	crossorigin="anonymous"></script>
    
<title>Kysymyksen lisääminen</title>
</head>
<body>
<h1>Lisää kysymys</h1>

<input type="text" name="kysymys" id="kysymys"><br>
<input type="text" name="kysely_id" id="kysely_id"><br>
<button onclick="add()">Lisää</button>
<div id="target"></div>
    
<p><a href="../">Peruuta</a></p>
<script>
function add(){
       var uusiKysymys = $("#kysymys").val();
       var uusiKysely_id = $("#kysely_id").val();
       var jsonData = JSON.stringify({"kysymys": uusiKysymys, "kysely_id": uusiKysely_id});
        $('#target').html('sending..' + $("#kysymys").val());
       $.ajax({
           url: "http://proto353.haaga-helia.fi:8080/kysely/rest/k/",
           type: "POST",
           data: jsonData,
           dataType: "json",
           contentType: "application/json; charset=utf-8",
           success: function (data) {
                $('#target').html('Kysymys "' + $('#kysymys').val() + '" lisätty.');
            }
       });
}
</script>
</body>
</html>
