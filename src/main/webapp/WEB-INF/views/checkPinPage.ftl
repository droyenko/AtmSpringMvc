<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script>
        function insert(num) {
            document.getElementById('card_pin_input').value += num;
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
        .card_pin{
            width: 217px;
            margin: 5px;
            font-size: 25px;
            padding: 5px;
        }
    </style>
</head>
<body>
<div class="main">
    <form name="card" action="/checkPin" method="post">
        <h1>Please enter card PIN</h1>
        <input class="card_pin" id="card_pin_input" name="pin" type="password" readonly/>
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
                <td><input class="clear-button" type="button" value="Clear" onclick="document.getElementById('card_pin_input').value = ''"></td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>