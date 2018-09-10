<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        .button{
            width: 120px;
            height: 50px;
            font-size: 25px;
            margin: 2px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <h1>Balance page</h1>
    <h2>Card number: ${operation.cardId}</h2>
    <h2>Balance: ${balance}</h2>
    <h2>Time: ${operation.time}</h2>
    <form action="/operationsPage">
        <input class="button" type="submit" value="Back" />
    </form>
    <form action="/">
        <input class="button" type="submit" value="Exit" />
    </form>
</body>
</html>