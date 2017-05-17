
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
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/jquery.validate.min.js" type="text/javascript" ></script>
	<style type="text/css">
        .virhe{
            color: red;
            font-size: 130%;
        }
        input.kenttaVirhe, textarea.kenttaVirhe {
            border: 1px solid red !important;
        }
    </style>
    
<title>Kysymyksen lisääminen</title>
</head>
<body>
<h1>Kysely lisäys</h1>
<form id="validointi">
<label for="kysely">Anna kyselyn nimi</label><input type="text" name="kysely" id="kysely"><br>
<label for="ekaKysymys">Anna ensimmäinen kysymys</label><input type="text" name="ekaKysymys" id="ekaKysymys"><br>
</form>
<button onclick="addKysely()">Lisää kysely</button>
<div id="targetKysely"></div>
<div id="targetKysymys"></div>

<h1>Kysymyksen lisäys</h1>
<input type="text" name="kysymys" id="kysymys"><br>
<select id="kyselyt" > </select>
<button onclick="add()">Lisää kysymys</button>
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
                success: function (data){
                    $('#target').html('Kysymys "' + $('#kysymys').val() + '" lisätty kyselyyn "' + nimi + '".');
                }
            });
        })
        .fail(function() {
        })	
        .complete(function() {
        })
}
	
function addKysely(){
	if ($("#validointi").valid()) {
        var uusiKysely = $("#kysely").val();
        var jsonData = JSON.stringify({"nimi": uusiKysely});
        $('#targetKysely').html('sending.. ' + $("#kysely").val());
        $.ajax({
                url: "http://proto353.haaga-helia.fi:8080/kysely/rest/",
                type: "POST",
                data: jsonData,
                dataType: "json",
                contentType: "application/json; charset=utf-8",
                success: function (data) {
                    $('#targetKysely').html('Kysely"' + $('#kysely').val() + '" lisätty.');
                    addEkaKysymys();
             	}
        });
	}
      
}
function addEkaKysymys(){
	 var dataa = "http://proto353.haaga-helia.fi:8080/kysely/rest/ky/";
     var valittu = 0;
     $.ajax({
         url: dataa,
         type: "GET",
         dataType: "json",
         contentType: "application/json; charset=utf-8",
         })
     .done(function(data){
         var uusiKysely = $("#kysely").val();
         $.each(data, function(index, kyselyt){
       
                 valittu = parseInt(kyselyt.id);
             
         })
         var uusiKysymys = $("#ekaKysymys").val();
         var kysymysJsonData = JSON.stringify({"kysymys": uusiKysymys, "kysely_id": valittu});
         $('#targetKysymys').html('sending.. ' + $("#ekaKysymys").val());
         $.ajax({
             url: "http://proto353.haaga-helia.fi:8080/kysely/rest/k/",
             type: "POST",
             data: kysymysJsonData,
             dataType: "json",
             contentType: "application/json; charset=utf-8",
             success: function (data){
                 $('#targetKysymys').html('Kysymys "' + $('#ekaKysymys').val() + '" lisätty kyselyyn "' + uusiKysely + '".');
             }
         });
     })
     .fail(function() {
     })	
     .complete(function() {
     })
    
}
var validator = $("#validointi").validate({
	errorClass: "virhe",
	errorElement: "div",				
	rules: {
		kysely:  {
			required: true,
		},	
		ekaKysymys:  {
			required: true,

		},	
	},
	messages: {
		kysely: {
			required: "Anna kyselyn nimi",
            
		},
		ekaKysymys: {
		   required: "Anna ensimmäinen kysymys"
		},
		
	},
	highlight: function(element) {
		$(element).addClass("kenttaVirhe");
	}, 
	unhighlight: function(element) {
		$(element).removeClass("kenttaVirhe");
	},
	errorPlacement: function(error, element) {
		error.insertAfter(element.parent());
	},
}) // validator
</script>
</body>
</html>
