<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        .button{
            width: 150px;
            height: 50px;
            font-size: 25px;
            margin: 2px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<h1>${message}</h1>
<button class="button" onclick="goBack()">Go Back</button>
<script>
    function goBack() {
        window.history.back();
    }
</script>
</body>
</html>