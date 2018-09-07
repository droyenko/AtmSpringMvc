<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

</head>
<body>
    <h1>Please select operation</h1>
    <form name="operation" action="/balanceReport" method="post">
        <input type="hidden" name="cardId" value="${cardNumber}">
        <input type="hidden" name="time" id="dateTime">
        <input type="hidden" name="amount" value="0">
        <input type="hidden" name="type" value="balance">
        <input type="submit" value="Balance" />
    </form>
    <form action="/withdrawalPage">
        <input type="submit" value="Withdrawal" />
    </form>
    <form action="/">
        <input type="submit" value="Exit" />
    </form>

    <script>
        // var d = Date.now();
        document.getElementById("dateTime").value = formatCurrentDate();

        function formatCurrentDate() {
            var d = new Date(),
                    month = '' + (d.getMonth() + 1),
                    day = '' + d.getDate(),
                    year = d.getFullYear(),
                    hours = '' + d.getHours(),
                    minutes = '' + d.getMinutes(),
                    seconds = '' + d.getSeconds();

            if (month.length < 2) month = '0' + month;
            if (day.length < 2) day = '0' + day;
            if (hours.length < 2) hours = '0' + hours;
            if (minutes.length < 2) minutes = '0' + minutes;
            if (seconds.length < 2) seconds = '0' + seconds;

            return [year, month, day].join('-') + " " + [hours, minutes, seconds].join(':');
        }
    </script>
</body>
</html>