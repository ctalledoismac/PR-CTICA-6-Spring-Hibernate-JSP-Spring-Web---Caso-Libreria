<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Eliminar clientes</title>
</head>
<body>
    <h1>Eliminar clientes</h1>
    
    <form action="del" method="GET">
        <input type="hidden" id="idCliente" name="idCliente" value="${cliente.idCliente }">
        <strong>¿Desea eliminar el dato?</strong>
        <br/><br/>
        <button type="submit">Aceptar</button>
        <a href="${pageContext.request.contextPath}/clientes/findAll">
            <button type="button">Cancelar</button>
        </a>
    </form>

</body>
</html>
