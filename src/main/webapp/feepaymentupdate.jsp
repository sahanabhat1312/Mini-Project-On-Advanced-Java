<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
</head>

<body>

<div class="container">
<div class="card">

<h2>Update Payment</h2>

<form action="updatePayment"
      method="post"
      onsubmit="return confirmUpdate()">

<input type="number"
       id="paymentID"
       name="paymentID"
       placeholder="Enter Payment ID"
       onchange="fetchPayment()"
       required>

<input type="number"
       id="studentID"
       name="studentID"
       placeholder="Student ID"
       required>

<input type="text"
       id="studentName"
       name="studentName"
       placeholder="Student Name"
       required>

<input type="date"
       id="paymentDate"
       name="paymentDate"
       required>

<input type="number"
       id="amount"
       name="amount"
       placeholder="Amount"
       required>

<select id="status" name="status">

<option value="Paid">Paid</option>

<option value="Pending">Pending</option>

<option value="Overdue">Overdue</option>

</select>

<button type="submit">Update</button>

</form>

<br>

<a href="index.jsp" class="btn back-btn">Back</a>

</div>
</div>

<script>

function fetchPayment(){

    var pid = document.getElementById("paymentID").value;

    if(pid === "") return;

    fetch("updatePayment?paymentID=" + pid)

    .then(response => response.text())

    .then(data => {

        if(data.trim() !== ""){

            var parts = data.split("|");

            document.getElementById("studentID").value = parts[0];
            document.getElementById("studentName").value = parts[1];
            document.getElementById("paymentDate").value = parts[2];
            document.getElementById("amount").value = parts[3];
            document.getElementById("status").value = parts[4];
        }
    })
    .catch(err => console.log(err));
}

function confirmUpdate(){

    return confirm("Do you want to update this data?");
}

</script>

</body>
</html>