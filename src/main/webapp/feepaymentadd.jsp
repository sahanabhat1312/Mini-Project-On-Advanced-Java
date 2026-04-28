<html>
<head>
<link rel="stylesheet" href="style.css">
</head>

<body>
<div class="container">
<div class="card">

<h2>Add Payment</h2>

<form action="addPayment" method="post">

<input type="number" id="studentID" name="studentID"
       placeholder="Student ID"
       onkeyup="fetchName()" required>

<input type="text" id="studentName" name="studentName"
       placeholder="Student Name" required>

<input type="date" name="paymentDate" required>

<input type="number" name="amount" placeholder="Amount" required>

<select name="status">
    <option value="Paid">Paid</option>
    <option value="Pending">Pending</option>
    <option value="Overdue">Overdue</option>
</select>


<button type="submit">Add Payment</button>

</form>
<script>
function fetchName(){
    var id = document.getElementById("studentID").value;

    if(id === "") return;

    fetch("addPayment?studentID=" + id)
    .then(response => response.text())
    .then(data => {
        if(data !== ""){
            document.getElementById("studentName").value = data;
        }
    });
}
</script>

<a href="index.jsp" class="btn">Back</a>

</div>
</div>
</body>
</html>