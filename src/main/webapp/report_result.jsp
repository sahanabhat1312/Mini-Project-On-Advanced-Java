<%@ page contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"
         import="java.util.*,com.model.FeePayment" %>

<html>
<head>

<link rel="stylesheet" href="style.css">

<meta charset="UTF-8">

</head>

<body>

<div class="medium-container">
<div class="medium-card">

<%
if(request.getAttribute("total") != null){
%>

<h2>Total Collection</h2>

<p>
From :
<%= request.getAttribute("from") %>
</p>

<p>
To :
<%= request.getAttribute("to") %>
</p>

<h3>
₹ <%= request.getAttribute("total") %>
</h3>

<%
} else {
%>

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
List<FeePayment> list =
(List<FeePayment>) request.getAttribute("list");

if(list != null && !list.isEmpty()){

for(FeePayment fp : list){
%>

<tr>

<td><%= fp.getPaymentID() %></td>

<td><%= fp.getStudentID() %></td>

<td><%= fp.getStudentName() %></td>

<td><%= fp.getPaymentDate() %></td>

<td>₹ <%= fp.getAmount() %></td>

<td><%= fp.getStatus() %></td>

</tr>

<%
}
}
else{
%>

<tr>

<td colspan="6">
No Records Found
</td>

</tr>

<%
}
%>

</table>

<%
}
%>

<br>

<a href="index.jsp" class="btn back-btn">
Back
</a>

</div>
</div>

</body>
</html>