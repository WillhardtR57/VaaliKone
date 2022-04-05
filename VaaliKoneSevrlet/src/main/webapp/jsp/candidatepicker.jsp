<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="app.data.*" %> 
 <%@ page import="app.dao.Dao" %> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<link rel=stylesheet type="text/css" href="/css/styles.css"></link>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Vaalikone - Edit Candidates</title>
</head>
<body>
<c:import url="../navbaradmin.html" charEncoding="UTF-8"/>
<h1>You can edit or delete candidates</h1>

<c:forEach var="candidate" items="${sessionScope.candidateslist}" >

<b>${candidate.ehdokas_id}:</b> ${candidate.etunimi}, ${candidate.sukunimi} 
<a href="/editcandidate?ehdokas_id=${candidate.ehdokas_id}">Edit</a> 
<a href='/deletecandidate?ehdokas_id=${candidate.ehdokas_id}'>Delete</a> <br><br>

</c:forEach>

<%@ include file="../footer.html" %>
</body>
</html>