<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create operation page</title>
</head>
<body>
    <form name="operation" action="/addOperation" method="post">
        <p>Card number</p>
        <input title="Number" type="text" name="cardId">
        <p>Time</p>
        <input title="Time" type="text" name="time">
        <p>Amount</p>
        <input title="Amount" type="text" name="amount">
        <p>Type</p>
        <input title="Type" type="text" name="type">
        <input type="submit" value="Save">
    </form>
</body>
</html>