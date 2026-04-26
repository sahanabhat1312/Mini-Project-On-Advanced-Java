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

<input type="text" name="studentName" placeholder="New Name" required>

<input type="number" name="amount" placeholder="New Amount" required>

<button type="submit">Update</button>

</form>

<a href="index.jsp" class="btn">Back</a>

</div>
</div>
</body>
</html>