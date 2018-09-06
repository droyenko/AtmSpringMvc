<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>Card info:</h1>
    <table>
        <tr>
            <td>Id</td>
            <td>${card.id}</td>
        </tr>
        <tr>
            <td>Card number</td>
            <td>${card.number}</td>
        </tr>
        <tr>
            <td>Blocked</td>
            <td>${card.blocked?c}</td>
        </tr>
        <tr>
            <td>Pin</td>
            <td>${card.pin?c}</td>
        </tr>
        <tr>
            <td>Invalid attempts</td>
            <td>${card.invalidAttempts}</td>
        </tr>
        <tr>
            <td>Balance</td>
            <td>${card.balance?c}</td>
        </tr>
    </table>

<a href="/cards">Back</a>
</body>
</html>