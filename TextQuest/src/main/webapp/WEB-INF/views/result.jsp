<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Результат игры</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div class="result-container">
    <h1>${victory ? "Победа!" : "Поражение"}</h1>
    <p>${description}</p>
    <p>Спасибо за игру, ${playerName}!</p>
    <p>Всего игр сыграно: ${gamesPlayed}</p>

    <form method="post" action="${pageContext.request.contextPath}/game">
        <button type="submit">Играть снова</button>
    </form>
    <a href="${pageContext.request.contextPath}/home">Вернуться на главную</a>
</div>
</body>
</html>
