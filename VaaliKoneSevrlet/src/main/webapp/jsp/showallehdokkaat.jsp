<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="data.Ehdokkaat" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All datatable rows</title>
</head>
<body>

<table>
<tr>
	<th>ID</th>
	<th>Sukunimi</th>
	<th>Etunimi</th>
	<th>Puolue</th>
	<th>Kotipaikkakunta</th>
	<th>Ikä</th>
	<th>Miksi eduskuntaan?</th>
	<th>Mitä asioita haluat edistää?</th>
	<th>Ammatti</th>
</tr>
<c:forEach var="ehdokkaat" items="${sessionScope.kaikkiehdokkaat }">
	<tr>
		<td>${ehdokkaat.ehdokasId }</td>
		<td>${ehdokkaat.sukunimi }</td>
		<td>${ehdokkaat.etunimi }</td>
		<td>${ehdokkaat.puolue }</td>
		<td>${ehdokkaat.kotipaikkaKunta }</td>
		<td>${ehdokkaat.ika }</td>
		<td>${ehdokkaat.miksiEduskuntaan }</td>
		<td>${ehdokkaat.mitaAsioitaHaluatEdistaa }</td>
		<td>${ehdokkaat.ammatti }</td>
		<td>
		</td>
	</tr>
</c:forEach>
</table>

</body>
</html>