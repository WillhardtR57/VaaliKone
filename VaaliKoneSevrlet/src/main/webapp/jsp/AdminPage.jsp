<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <link rel=stylesheet type="text/css" href="/css/styles.css"></link>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Vaalikone - Admin Page</title>
</head>
<body>
<div>
<ul>
  <h1>Vaalikone</h1>
  <li><a href="../jsp/AdminPage.jsp">Admin Home</a></li>
  <li><a href="/addcandidate">Add Candidate</a></li>
  <li><a href="/candidatepicker">Edit Candidates</a></li>
  <li><a href="/logout">Logout</a></li>
</ul>
</div>
    <div style="text-align: center">
        <h1>Welcome to Vaalikone Admin Page :-D!!!</h1>
        <b>Hello </b><b>${user.username}</b>
        <br><br>
        <a href="/logout">Logout</a>
    </div>
    <%@ include file="../footer.html" %>
</body>
</html>