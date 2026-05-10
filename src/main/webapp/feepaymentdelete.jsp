<html>
<head>
<link rel="stylesheet" href="style.css">
</head>

<body>

<div class="container">
<div class="card">

<h2>Delete Payment</h2>

<form action="deletePayment"
      method="post"
      onsubmit="return confirmDelete()">

<input type="number"
       name="paymentID"
       placeholder="Enter Payment ID"
       required>

<button type="submit">Delete</button>

</form>

<br>

<a href="index.jsp" class="btn back-btn">Back</a>

</div>
</div>
<script>

function confirmDelete(){

    return confirm("Do you want to delete this payment?");
}

</script>
</body>
</html>