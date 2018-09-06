<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>Operation info:</h1>
    <table>
        <tr>
            <td>Id</td>
            <td>${operation.id}</td>
        </tr>
        <tr>
            <td>Card number</td>
            <td>${operation.cardId}</td>
        </tr>
        <tr>
            <td>Time</td>
            <td>${operation.time}</td>
        </tr>
        <tr>
            <td>Amount</td>
            <td>${operation.amount?c}</td>
        </tr>
        <tr>
            <td>Type</td>
            <td>${operation.type}</td>
        </tr>
    </table>

<a href="/operations">Back</a>
</body>
</html>