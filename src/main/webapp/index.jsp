<%@page import="java.util.List"%>
<%@page import="net.gojo.registration.model.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Productos</title>
</head>
<body>
    <h1>Lista de Productos</h1>
    <table border="1">
        <tr>
            <th>Código</th>
            <th>Título</th>
            <th>Descripción</th>
            <th>Precio</th>
            <th>Cantidad</th>
            <th>Acciones</th>
        </tr>
        <% 
            List<Product> products = (List<Product>) request.getAttribute("products");
            if (products != null) {
                for (Product product : products) { 
        %>
                    <tr>
                        <td><%= product.getId() %></td>
                        <td><%= product.getTitle() %></td>
                        <td><%= product.getDescription() %></td>
                        <td><%= product.getPrice() %></td>
                        <td><%= product.getQuantity() %></td>
                        <td>
                            <a href="/gojo/editProduct?id=<%= product.getId() %>">Modificar</a>
                            <a href="/gojo/deleteProduct?id=<%= product.getId() %>">Eliminar</a>
                        </td>
                    </tr>
        <% 
                } 
            } else {
        %>
            <tr>
                <td colspan="6">No hay productos disponibles</td>
            </tr>
        <% 
            }
        %>
    </table>
</body>
</html>
