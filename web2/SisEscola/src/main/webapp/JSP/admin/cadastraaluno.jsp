<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastrar Aluno</title>
</head>
<body>
    <h1>Cadastrar Aluno</h1>
    <form action="CadastrarAlunoServlet" method="post">
        Nome: <input type="text" name="nome" required><br>
        Matrícula: <input type="text" name="matricula" required><br>
        <input type="submit" value="Cadastrar">
    </form>
</body>
</html>
