<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

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
        .card_id{
            width: 250px;
            margin: 5px;
            font-size: 25px;
            padding: 5px;
        }
    </style>
</head>
<body onload="clear()">
<div class="main">
    <form name="card" action="/checkCard" method="post">
        <h1>Please enter card number</h1>
        <input class="card_id" id="card_id_input" name="number" type="text" readonly/>
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
                <td><input class="clear-button" type="button" value="Clear" onclick="document.getElementById('card_id_input').value = ''"></td>
            </tr>
        </table>
    </form>
</div>
<script>
    function insert(num) {
        var currentValue = document.getElementById('card_id_input').value;
        if (currentValue.replace(/-/g, '').length % 4 == 0 && currentValue.length != 0) {
            document.getElementById('card_id_input').value += -num
        } else {
            document.getElementById('card_id_input').value += num;
        }
    }

    function clear() {
        document.getElementById('card_id_input').value = '';
    }

</script>
</body>
</html>