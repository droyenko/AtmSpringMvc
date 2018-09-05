<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit card page</title>
</head>
<body>
    <form name="card" action="/updateCard" method="post">
        <p>Id</p>
        <input title="Id" type="text" name="id" value="${card.id}">
        <p>Card number</p>
        <input title="Number" type="text" name="number" value="${card.number}">
        <p>Blocked</p>
        <input title="Blocked" type="text" name="blocked" value="${card.blocked?c}">
        <p>Pin</p>
        <input title="Pin" type="text" name="pin" value="${card.pin?c}">
        <p>Invalid attempts</p>
        <input title="InvalidAttempts" type="text" name="invalidAttempts" value="${card.invalidAttempts}">
        <p>Balance</p>
        <input title="Balance" type="text" name="balance" value="${card.balance?c}">
        <input type="submit" value="Save">
    </form>
</body>
</html>