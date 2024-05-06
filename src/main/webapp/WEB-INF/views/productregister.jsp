<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro de Producto</title>
</head>
<body>
    <div align="center">
        <h1>Formulario de Registro de Producto</h1>
        <form action="<%= request.getContextPath() %>/register" method="post">
            <table style="width: 80%">
                <tr>
                    <td>Código</td>
                    <td><input type="text" name="id" /></td> <!-- Agregar campo para el id -->
                </tr>
                <tr>
                    <td>Título</td>
                    <td><input type="text" name="title" /></td>
                </tr>
                <tr>
                    <td>Descripción</td>
                    <td><input type="text" name="description" /></td>
                </tr>
                <tr>
                    <td>Cantidad</td>
                    <td><input type="text" name="quantity" /></td>
                </tr>
                <tr>
                    <td>Precio</td>
                    <td><input type="text" name="price" /></td>
                </tr>
            </table>
            <input type="submit" value="Registrar" />
        </form>
    </div>
</body>
</html>
