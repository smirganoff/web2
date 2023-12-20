<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastrar Turma</title>
</head>
<body>
    <h1>Cadastrar Turma</h1>
    <form action="CadastrarTurmaServlet" method="post">
        Disciplina: 
        <input type="text" name="disciplinaId" required><br>
        <input type="submit" value="Cadastrar">
    </form>
</body>
</html>
