
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Текстовый квест</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div class="game-container">
    <h1>Текстовый квест</h1>
    <div class="player-info">
        Игрок: ${playerName} | Игр сыграно: ${gamesPlayed}
    </div>

    <div class="situation">
        <p>${description}</p>
    </div>

    <c:if test="${not gameOver}">
        <form method="post" action="${pageContext.request.contextPath}/game">
            <div class="choices">
                <c:forEach items="${choices}" var="choice">
                    <label>
                        <input type="radio" name="choice" value="${choice.charAt(0)}" required>
                            ${choice}
                    </label><br>
                </c:forEach>
            </div>
            <button type="submit">Выбрать</button>
        </form>
    </c:if>

    <c:if test="${gameOver}">
        <form method="post" action="${pageContext.request.contextPath}/game">
            <button type="submit">Играть снова</button>
        </form>
        <a href="${pageContext.request.contextPath}/home">Вернуться на главную</a>
    </c:if>
</div>
</body>
</html>