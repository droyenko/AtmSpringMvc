<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create card page</title>
</head>
<body>
    <form name="card" action="/addCard" method="post">
        <p>Card number</p>
        <input title="Number" type="text" name="number">
        <p>Blocked</p>
        <input title="Blocked" type="text" name="blocked">
        <p>Pin</p>
        <input title="Pin" type="text" name="pin">
        <p>Invalid attempts</p>
        <input title="InvalidAttempts" type="text" name="invalidAttempts">
        <p>Balance</p>
        <input title="Balance" type="text" name="balance">
        <input type="submit" value="Save">
    </form>
</body>
</html>