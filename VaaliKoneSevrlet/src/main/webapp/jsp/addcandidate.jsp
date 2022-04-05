<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="app.data.*" %> 
 <%@ page import="app.dao.Dao" %>   
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vaalikone - Add candidate</title>
</head>
<body>
<c:import url="../navbaradmin.html" charEncoding="UTF-8"/>

<h1>Add candidate</h1>

<br>
<form action='/addcandidate' method='post'>

<input type="hidden" name='ehdokas_id'>

<b> Sukunimi </b> <br>
<input type="text" name='sukunimi' value=''> <br>

<b> Etunimi </b> <br>
<input type="text" name='etunimi' value=''> <br>

<b>Puolue </b> <br>
<input type="text" name='puolue' value=''> <br>

<b>Kotipaikkakunta </b> <br>
<input type="text" name='kotipaikkakunta' value=''> <br>

<b>Ikä</b> <br>
<input type="text" name='ika' value=''> <br>

<b>Miksi sinut tulisi valita eduskuntaan? </b><br>
<textarea rows="5" cols="80" name='miksi_eduskuntaan' style="width:24rem;"></textarea><br>

<b>Mitä asioita haluaisit edistää?</b> <br>
<textarea rows="5" cols="80" name='mita_asioita_haluat_edistaa' style="width:24rem;"></textarea><br>

<b> Ammatti </b> <br>
<input type="text" name='ammatti' value=''> <br> 

<input type='Submit' name='ok' value='Add'> 
</form>

<%@ include file="../footer.html" %>
</body>
</html>