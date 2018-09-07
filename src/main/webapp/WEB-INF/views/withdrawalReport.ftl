<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <h1>Balance page</h1>
    <h2>Card number: ${card.number}</h2>
    <h2>Time: ${operation.time}</h2>
    <h2>Amount withdrawn: ${operation.amount}</h2>
    <h2>Balance: ${card.balance}</h2>
    <form action="/operationsPage">
        <input type="submit" value="Back" />
    </form>
    <form action="/">
        <input type="submit" value="Exit" />
    </form>
</body>
</html>