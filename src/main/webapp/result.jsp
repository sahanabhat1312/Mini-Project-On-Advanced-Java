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

if(type == null) type = "success";
%>

<div class="icon <%= type %>">
    <%= type.equals("success") ? "✔️" : "❌" %>
</div>

<h2><%= msg %></h2>

<br>

<a href="index.jsp" class="btn">🏠 Home</a>
<a href="displayPayments" class="btn">📋 View Records</a>

</div>
</div>

</body>
</html>