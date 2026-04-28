<html>
<head>
<link rel="stylesheet" href="style.css">
</head>

<body>
<div class="container">
<div class="card">

<h2>Update Payment</h2>

<form action="updatePayment" method="post">

<input type="number" name="paymentID" placeholder="Payment ID" required>

<input type="number" name="studentID" placeholder="Student ID" min="1" required 
       oninvalid="this.setCustomValidity('Enter positive Student ID')"
       oninput="this.setCustomValidity('')">

<input type="text" name="studentName" placeholder="Student Name" required>

<input type="date" name="paymentDate" required>

<input type="number" name="amount" placeholder="Amount" required>

<select name="status">
    <option value="Paid">Paid</option>
    <option value="Overdue">Overdue</option>
    <option value="Pending">Pending</option>
</select>

<button type="submit">Update</button><br>
<a href="index.jsp" class="btn">Back</a>
</form>

</div>
</div>
</body>
</html>