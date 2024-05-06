<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Producto</title>
</head>
<body>
    <h1>Editar Producto</h1>
    <form action="/gojo/editProduct" method="post"> 
        <input type="hidden" name="id" value="${id}">
        <label for="title">Título:</label>
        <input type="text" id="title" name="title" value="${title}"><br>
        <label for="description">Descripción:</label>
        <textarea id="description" name="description">${description}</textarea><br>
        <label for="quantity">Cantidad:</label>
        <input type="number" id="quantity" name="quantity" value="${quantity}"><br>
        <label for="price">Precio:</label>
        <input type="number" id="price" name="price" value="${price}"><br>
        <input type="submit" value="Guardar Cambios">
    </form>
</body>
</html>
