<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>

<link rel="stylesheet" href="style.css">

<style>

.icon{
    font-size:90px;
    margin-top:30px;
    margin-bottom:20px;
}

.success{
    color:green;
}

.fail{
    color:red;
}

.top-buttons{
    margin-bottom:20px;
}

.top-buttons .btn{
    width:180px;
    display:inline-block;
}

</style>

</head>

<body>

<div class="container">
<div class="card">

<!-- TOP BUTTONS -->

<div class="top-buttons">

<a href="index.jsp" class="btn">Home</a>

<a href="displayPayments" class="btn">View Payments</a>

</div>

<%
String msg = (String)request.getAttribute("msg");

String type = (String)request.getAttribute("type");
%>

<!-- ICON -->

<div class="icon <%= type %>">

<%= "success".equals(type) ? "✔️" : "❌" %>

</div>

<!-- MESSAGE -->

<h2 style="color:<%= "success".equals(type) ? "green" : "red" %>">

<%= msg %>

</h2>

</div>
</div>

</body>
</html>