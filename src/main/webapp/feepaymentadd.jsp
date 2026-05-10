<html>
<head>
<link rel="stylesheet" href="style.css">
</head>

<body>

<div class="container">
<div class="card">

<h2>Add Payment</h2>

<form action="addPayment" method="post">

<input type="number"
       name="studentID"
       placeholder="Student ID"
       required>

<input type="text"
       name="studentName"
       placeholder="Student Name"
       required>

<input type="date"
       name="paymentDate"
       required>

<input type="number"
       name="amount"
       placeholder="Amount"
       required>

<select name="status">

<option value="Paid">Paid</option>

<option value="Pending">Pending</option>

<option value="Overdue">Overdue</option>

</select>

<button type="submit">Add Payment</button>

</form>

<br>

<a href="index.jsp" class="btn back-btn">Back</a>

</div>
</div>

</body>
</html>