<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Introduce los datos del nuevo producto:
	<br />

	<form method="post" action="ServletRegistroProducto" enctype="multipart/form-data">
		nombre: <input type="text" name="campoNombre" /><br /> 
		precio: <input type="text" name="campoPrecio" /><br />
		Selecciona una categoria:
		<select name="campoIdCategoria">
		<c:forEach items="${categorias}" var="categoria">
		<option value="${categoria.id }"> ${categoria.nombre}</option>
		
		</c:forEach>
		
		</select>><br />
		
		
		
		imagen: <input type="file" name="campoImagen" /><br />
		<input type="submit" value="REGISTRAR PRODUCTO"/>

	</form>

</body>
</html>