<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
<link rel="stylesheet" href="style.css">

<style>
.icon {
    font-size: 80px;
    margin-bottom: 10px;
}
.success { color: green; }
.fail { color: red; }
</style>

</head>

<body>

<div class="container">
<div class="card">

<%
String msg = (String) request.getAttribute("msg");
String type = (String) request.getAttribute("type");
%>


<a href="index.jsp" class="btn">🏠 Home</a>
<a href="displayPayments" class="btn">📋 View Records</a>
<h2 style="color:<%= "success".equals(type) ? "green" : "red" %>;">
    <%= msg %>
</h2>

<div class="icon <%= type %>">
    <%= "success".equals(type) ? "✔️" : "❌" %>
</div>

<br>


</div>
</div>

</body>
</html>