<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Inscrição em Disciplina</title>
</head>
<body>
    <h1>Inscrição em Disciplina</h1>
    <form action="InscreverDisciplinaServlet" method="post">
        Disciplina:
        <input type="text" name="disciplinaId" required><br>
        <input type="submit" value="Inscrever">
    </form>
</body>
</html>
