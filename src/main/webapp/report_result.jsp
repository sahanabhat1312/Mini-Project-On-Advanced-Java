<%@ page import="java.util.*, com.model.FeePayment" %>

<html>
<head>
<link rel="stylesheet" href="style.css">
</head>

<body>

<div class="container">
<div class="card" style="width:80%;">

<%
String type = (String) request.getAttribute("type");
%>

<% if("overdue".equals(type)) { %>

<h2>Overdue Payments</h2>

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
    <td style="color:red;"><b><%= fp.getStatus() %></b></td>
</tr>

<%
    }
} else {
%>

<tr>
<td colspan="6">No Overdue Records Found</td>
</tr>

<%
}
%>

</table>

<% } %>

<br>
<a href="index.jsp" class="btn">Back</a>

</div>
</div>

</body>
</html>