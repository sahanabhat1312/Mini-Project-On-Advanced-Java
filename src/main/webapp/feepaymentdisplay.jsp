<%@ page import="java.util.*, com.model.FeePayment" %>

<html>
<head>
<link rel="stylesheet" href="style.css">
</head>

<body>
<div class="container">
<div class="card" style="width:80%;">

<h2>All Payments</h2>

<table border="1">
<tr>
    <th>ID</th>
    <th>Student ID</th>
    <th>Name</th>
    <th>Date</th>
    <th>Amount</th>
    <th>Status</th>
</tr>

<%
List<FeePayment> list = (List<FeePayment>) request.getAttribute("list");

if(list != null && list.size() > 0) {
    for(FeePayment fp : list) {
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
} else {
%>
<tr>
    <td colspan="6">No Records Found</td>
</tr>
<%
}
%>

</table>

<br>
<a href="index.jsp" class="btn">Back</a>

</div>
</div>
</body>
</html>