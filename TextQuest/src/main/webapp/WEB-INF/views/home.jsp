
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Текстовый квест - Главная</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div class="home-container">
    <h1>Добро пожаловать в текстовый квест!</h1>

    <div class="story">
         <p>Представь, что ты Колобок, который убежал от бабушки и дедушки.</p>
         <p>Просто пошел погулять и заблудился.</p>
         <p> Твой выбор будут определять исход этой прогулки. Будь осторожен в своем выборе!</p>
    </div>

    <form action="${pageContext.request.contextPath}/game" method="get">
        <label for="playerName">Введите ваше имя:</label>
        <input type="text" id="playerName" name="playerName" placeholder="Имя героя" required>
        <button type="submit">Начать игру</button>
    </form>
</div>
</body>
</html>
