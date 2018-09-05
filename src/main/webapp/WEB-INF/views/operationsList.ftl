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
        <th>Time</th>
        <th>Amount</th>
        <th>Type attempts</th>
    </tr>
        <#list operations as operation>
    <tr>
        <td><a href="/operation/${operation.id}">${operation.id}</a></td>
        <td>${operation.cardId}</td>
        <td>${operation.time?datetime}</td>
        <td>${operation.amount?c}</td>
        <td>${operation.type}</td>
        <td><a href="/deleteOperation/${operation.id}">Delete</a></td>
        <td><a href="/updateOperation/${operation.id}">Update</a></td>
    </tr>
        </#list>
</table>

<a href="/addOperation">Create new Operation</a>
</body>
</html>