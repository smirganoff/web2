<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Erro</title>
</head>
<body>
    <h2>Pane no sistema.</h2>
    <p>Detalhes do erro:</p>
    <p><strong>Mensagem:</strong> <%= exception.getMessage() %></p>
    <p><strong>Causa:</strong> <%= exception.getCause() %></p>
    <p><strong>Stack Trace:</strong></p>
    <pre><%= exception.getStackTrace() %></pre>
</body>
</html>
