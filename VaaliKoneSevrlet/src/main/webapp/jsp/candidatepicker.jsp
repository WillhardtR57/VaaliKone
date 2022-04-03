<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="app.data.*" %> 
 <%@ page import="app.dao.Dao" %> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vaalikone - Edit Candidates</title>
</head>
<body>

<c:import url="../navbaradmin.html" charEncoding="UTF-8"/>
<c:forEach var="candidate" items="${sessionScope.candidateslist}" >

<h2>Muokkaa tai poista ehdokkaita</h2> <br>




</c:forEach>

<%@ include file="../footer.html" %>
</body>
</html>