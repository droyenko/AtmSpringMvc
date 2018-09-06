<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit operation page</title>
</head>
<body>
    <form name="operation" action="/updateOperation" method="post">
        <p>Id</p>
        <input title="Id" type="text" name="id" value="${operation.id}">
        <p>Card number</p>
        <input title="Number" type="text" name="cardId" value="${operation.cardId}">
        <p>Time</p>
        <input title="Time" type="text" name="time" value="${operation.time}">
        <p>Amount</p>
        <input title="Amount" type="text" name="amount" value="${operation.amount}">
        <p>Type</p>
        <input title="Type" type="text" name="type" value="${operation.type}">
        <input type="submit" value="Save">
    </form>
</body>
</html>