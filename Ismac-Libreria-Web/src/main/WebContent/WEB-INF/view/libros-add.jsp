<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Libros</h1>

	<form action="add" method="post">
		idLibro
		<input type ="hidden" id ="idLibro" name ="idLibro" value ="${libro.idLibro}"/>
		<br/><br/>
		titulo
		<input type ="text" id ="titulo" name ="titulo" value ="${libro.titulo}"/>
		<br/><br/>
		editorial
		<input type ="text" id ="editorial" name ="editorial" value ="${libro.editorial}"/>
		<br/><br/>
		numPaginas
		<input type ="number" id ="numPaginas" name ="numPaginas" value ="${libro.numPaginas}"/>
		<br/><br/>
		edicion
		<input type ="text" id ="edicion" name ="edicion" value ="${libro.edicion}"/>
		<br/><br/>
		idioma
		<input type ="text" id ="idioma" name ="idioma" value ="${libro.idioma}"/>
		<br/><br/>
		fechaPublicacion
		<input type ="Date" id ="fechaPublicacion" name ="fechaPublicacion" value ="${libro.fechaPublicacion}"/>
		<br/><br/>
		descripcion
		<input type ="text" id ="descripcion" name ="descripcion" value ="${libro.descripcion}"/>
		<br/><br/>
		tipoPasta
		<input type ="text" id ="tipoPasta" name ="tipoPasta" value ="${libro.tipoPasta}"/>
		<br/><br/>
		ISBN
		<input type ="text" id ="ISBN" name ="ISBN" value ="${libro.ISBN}"/>
		<br/><br/>
		numEjemplares
		<input type ="number" id ="numEjemplares" name ="numEjemplares" value ="${libro.numEjemplares}"/>
		<br/><br/>
		portada
		<input type ="text" id ="portada" name ="portada" value ="${libro.portada}"/>
		<br/><br/>
		presentacion
		<input type ="text" id ="presentacion" name ="presentacion" value ="${libro.presentacion}"/>
		<br/><br/>
		precio
		<input type ="number" step="any" id ="precio" name ="precio" value ="${libro.precio}"/>
		<br/><br/>
		Categoria
		<input type ="hidden" id ="idCategoria" name ="idCategoria" value ="${libro.categoria.idCategoria}"/>
		<br/><br/>
		Autor
		<input type ="hidden" id ="idAutor" name ="idAutor" value ="${libro.autor.idAutor}"/>
		<br/><br/>
		
	</form>
</body>
</html>