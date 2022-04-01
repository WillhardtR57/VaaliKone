<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="data.Ehdokkaat" %>
<%@ page import="app.dao.Dao" %>


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
<c:forEach var="Ehdokkaat" items="${requestScope.kaikkiEhdokkaat}">
	<tr>
		<td>${Ehdokkaat.ehdokas_id}</td>
		<td>${Ehdokkaat.sukunimi}</td>
		<td>${Ehdokkaat.etunimi}</td>
		<td>${Ehdokkaat.puolue}</td>
		<td>${Ehdokkaat.kotipaikkakunta}</td>
		<td>${Ehdokkaat.ika}</td>
		<td>${Ehdokkaat.miksi_eduskuntaan}</td>
		<td>${Ehdokkaat.mita_asioita_haluat_edistaa}</td>
		<td>${Ehdokkaat.ammatti}</td>
		<td>
		</td>
	</tr>
</c:forEach>
</table>

</body>
</html>