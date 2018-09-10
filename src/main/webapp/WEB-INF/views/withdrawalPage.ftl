<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script>
        function insert(num) {
            document.getElementById('withdrawal_input').value += num;
        }

        function clear() {
            document.getElementById('card_id_input').value = '';
        }

    </script>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        .button{
            width: 50px;
            height: 50px;
            font-size: 25px;
            margin: 2px;
            cursor: pointer;
        }
        .clear-button{
            width: 102px;
            height: 50px;
            font-size: 25px;
            margin: 2px;
            cursor: pointer;
        }
        .withdrawal_filed{
            width: 217px;
            margin: 5px;
            font-size: 25px;
            padding: 5px;
        }
    </style>
</head>
<body onload="clear()>
<div class="main">
    <form name="operation" action="/checkBalance" method="post">
        <h1>Please enter withdrawal amount</h1>
        <input class="withdrawal_filed" id="withdrawal_input" name="amount" type="text"/>
        <table>
            <tr>
                <td><input class="button" type="button" value="7" onclick="insert(7)"></td>
                <td><input class="button" type="button" value="8" onclick="insert(8)"></td>
                <td><input class="button" type="button" value="9" onclick="insert(9)"></td>
            </tr>
            <tr>
                <td><input class="button" type="button" value="4" onclick="insert(4)"></td>
                <td><input class="button" type="button" value="5" onclick="insert(5)"></td>
                <td><input class="button" type="button" value="6" onclick="insert(6)"></td>
            </tr>
            <tr>
                <td><input class="button" type="button" value="1" onclick="insert(1)"></td>
                <td><input class="button" type="button" value="2" onclick="insert(2)"></td>
                <td><input class="button" type="button" value="3" onclick="insert(3)"></td>
            </tr>
            <tr>
                <td><input class="button" type="button" value="0" onclick="insert(0)"></td>
                <td><input class="button" type="submit" value="OK"></td>
                <td><input class="clear-button" type="button" value="Clear" onclick="document.getElementById('withdrawal_input').value = ''"></td>
            </tr>
        </table>
        <form action="/operationsPage">
            <input class="clear-button" type="submit" value="Back" />
        </form>
        <form action="/">
            <input class="clear-button" type="submit" value="Exit" />
        </form>
    </form>
</div>

</body>
</html>
