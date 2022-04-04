<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>   
 <%@ page import="app.data.*" %> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vaalikone - Edit Candidate</title>
</head>
<body>
<c:import url="../navbaradmin.html" charEncoding="UTF-8"/>

<h1>Editing candidate</h1>

<br>
<form action='/editcandidate' method='post'>

<input type="hidden" name='ehdokas_id' value='${sessionScope.candidate.ehdokas_id}'> <br>

<b> Sukunimi </b> <br>
<input type="text" name='sukunimi' value='${sessionScope.candidate.sukunimi}'> <br>

<b> Etunimi </b> <br>
<input type="text" name='etunimi' value='${sessionScope.candidate.etunimi}'> <br>

<b>Puolue </b> <br>
<input type="text" name='puolue' value='${sessionScope.candidate.puolue}'> <br>

<b>Kotipaikkakunta </b> <br>
<input type="text" name='kotipaikkakunta' value='${sessionScope.candidate.kotipaikkakunta}'> <br>

<b>Ikä</b> <br>
<input type="text" name='ika' value='${sessionScope.candidate.ika}'> <br>

<b>Miksi sinut tulisi valita eduskuntaan? </b><br>
<textarea rows="5" cols="80" name='miksi_eduskuntaan' style="width:24rem;">${sessionScope.candidate.miksi_eduskuntaan}</textarea><br>

<b>Mitä asioita haluaisit edistää?</b> <br>
<textarea rows="5" cols="80" name='mita_asioita_haluat_edistaa' style="width:24rem;">${sessionScope.candidate.mita_asioita_haluat_edistaa}</textarea><br>

<b> Ammatti </b> <br>
<input type="text" name='ammatti' value='${sessionScope.candidate.ammatti}'> <br> 

<input type='Submit' name='ok' value='Save'> 
</form>

<%@ include file="../footer.html" %>
</body>
</html>