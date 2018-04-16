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

<a href="index.jsp">volver al inicio</a><br/>

<div>
 <form action="ServletListadoProductos">

Buscar: <input type="text" name="campoBusqueda"/>
<input type="submit" value="BUSCAR"/>



</form>
</div>



<div>
<c:if test="${desdeAnterior >= 0}">

<a href="ServletListadoProductos?desde=${desdeAnterior}&cuantos=20"> 
anterior</a>

</c:if>
<c:if test="${desdeSiguiente < productosTotales}">
<a href="ServletListadoProductos?desde=${desdeSiguiente}&cuantos=20"> 
siguiente</a>
</c:if>
</div>
<div>

Resultados:${productosTotales}

</div>


<c:forEach items="${productos}" var="producto">
<div style="margen: 8px">
nombre:${producto.nombre}<br/>
precio:${producto.precio}<br/>
categoria:${producto.categoria.nombre}<br/>

<div style="font-size:2em;"><b>id:${producto.id }</b>
</div>

<img src="${producto.rutaImagen }"
height="200"/>

</div>



</c:forEach>

</body>
</html>