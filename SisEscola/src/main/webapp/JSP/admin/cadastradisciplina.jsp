<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastrar Disciplina</title>
</head>
<body>
    <h1>Cadastrar Disciplina</h1>
    <form action="CadastrarDisciplinaServlet" method="post">
        Nome: <input type="text" name="nome" required><br>
        Descrição: <textarea name="descricao" required></textarea><br>
        <input type="submit" value="Cadastrar">
    </form>
</body>
</html>
