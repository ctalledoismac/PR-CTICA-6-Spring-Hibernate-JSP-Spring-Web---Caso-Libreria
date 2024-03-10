<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>

    <h1>Hola Mundo</h1>

    <ul><li><a href="${pageContext.request.contextPath}/">Home</a></li></ul>
    <ul><li><a href="${pageContext.request.contextPath}/clientes/findAll">Clientes</a></li></ul>
    <ul><li><a href="${pageContext.request.contextPath}/libros/findAll">Libros</a></li></ul>
    <ul><li><a href="${pageContext.request.contextPath}/reportes">Reportes</a></li></ul>

</body>
</html>
