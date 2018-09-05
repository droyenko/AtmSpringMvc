<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>Cards list</h1>
<table>
    <tr>
        <th>Id</th>
        <th>Card Number</th>
        <th>Blocked</th>
        <th>Pin</th>
        <th>Invalid attempts</th>
        <th>Balance</th>
    </tr>
        <#list cards as card>
    <tr>
        <td><a href="/card/${card.id}">${card.id}</a></td>
        <td>${card.number}</td>
        <td>${card.blocked?c}</td>
        <td>${card.pin?c}</td>
        <td>${card.invalidAttempts}</td>
        <td>${card.balance?c}</td>
        <td><a href="/deleteCard/${card.id}">Delete</a></td>
        <td><a href="/updateCard/${card.id}">Update</a></td>
    </tr>
        </#list>
</table>

<a href="/addCard">Create new Card</a>
</body>
</html>