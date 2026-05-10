<%@ page import="java.util.*,com.model.FeePayment" %>

<html>
<head>
<link rel="stylesheet" href="style.css">
</head>

<body>

<div class="full-container">
<div class="full-card">

<h2>All Payments</h2>

<table border="1">

<tr>
<th>Payment ID</th>
<th>Student ID</th>
<th>Student Name</th>
<th>Payment Date</th>
<th>Amount</th>
<th>Status</th>
</tr>

<%
List<FeePayment> list =
(List<FeePayment>) request.getAttribute("list");

if(list != null){

for(FeePayment fp : list){
%>

<tr>

<td><%= fp.getPaymentID() %></td>

<td><%= fp.getStudentID() %></td>

<td><%= fp.getStudentName() %></td>

<td><%= fp.getPaymentDate() %></td>

<td><%= fp.getAmount() %></td>

<td><%= fp.getStatus() %></td>

</tr>

<%
}
}
%>

</table>

<br>

<a href="index.jsp" class="btn back-btn">Back</a>

</div>
</div>

</body>
</html>