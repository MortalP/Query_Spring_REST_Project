
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
<select id="kyselyt" > </select>
<button onclick="add()">Lisää</button>
<div id="target"></div>
    
<p><a href="../">Peruuta</a></p>
<script>

function kyselyt(){
	var dataa = "http://proto353.haaga-helia.fi:8080/kysely/rest/";
	$.ajax({
		url: dataa,
        type: "GET",
		dataType: "json",
        contentType: "application/json; charset=utf-8",
		})
	.done(function(data){
        var lista = [];
   		var select = document.getElementById("kyselyt");
        $.each(data, function(index, kyselyt){
        	var found = lista.includes(kyselyt.nimi)
        	if(found == false && kyselyt.nimi != null){
        		lista[lista.length] = kyselyt.nimi;
        	}
        })
        for(var i=0; i<lista.length; i++){
            var option = document.createElement("option");
            option.innerHTML = lista[i];
            option.value = lista[i];
            select.appendChild(option);
        }
     
	})
	.fail(function() {
	})	
	.complete(function() {
	})
}
kyselyt();

function add(){
        var dataa = "http://proto353.haaga-helia.fi:8080/kysely/rest/";
        var nimi = $("#kyselyt").val();
        var idLista = [];
        var nimiLista = [];
        var valittu = 0;
        $.ajax({
            url: dataa,
            type: "GET",
            dataType: "json",
            contentType: "application/json; charset=utf-8",
            })
        .done(function(data){
            $.each(data, function(index, kyselyt){
            	if(kyselyt.nimi == nimi){
                    valittu = parseInt(kyselyt.kysely_id);
                }
            })
            var uusiKysymys = $("#kysymys").val();
            var jsonData = JSON.stringify({"kysymys": uusiKysymys, "kysely_id": valittu});
            $('#target').html('sending.. ' + $("#kysymys").val());
            $.ajax({
                url: "http://proto353.haaga-helia.fi:8080/kysely/rest/k/",
                type: "POST",
                data: jsonData,
                dataType: "json",
                contentType: "application/json; charset=utf-8",
                success: function (data) {
                    $('#target').html('Kysymys "' + $('#kysymys').val() + '" lisätty kyselyyn "' + nimi + '".');
                }
            });
        })
        .fail(function() {
        })	
        .complete(function() {
        })
}
</script>
</body>
</html>
