<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <link rel=stylesheet type="text/css" href="/css/styles.css"></link>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Vaalikone - Admin Login</title>
<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>
<script type="text/javascript"
    src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js"></script>
</head>
<body>
<c:import url="../navbar.html" charEncoding="UTF-8"/>
    <div style="text-align: center">
        <h1>Admin Login</h1>
        <form action="../login" method="post">
            <label for="username">Username:</label>
            <input name="username" size="30" />
            <br><br>
            <label for="password">Password:</label>
            <input type="password" name="password" size="30" />
            <br>${message}
            <br><br>           
            <button type="submit">Login</button>
        </form>
    </div>
    <%@ include file="../footer.html" %>
</body>
<script type="text/javascript">
 
    $(document).ready(function() {
        $("#loginForm").validate({
            rules: {
                username: {
                    required: true,
                    username: true
                },
         
                password: "required",
            },
             
            messages: {
                username: {
                    required: "Please enter username",
                    username: "Please enter a valid username"
                },
                 
                password: "Please enter password"
            }
        });
 
    });
</script>
</html>