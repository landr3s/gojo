package net.gojo.registration.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.gojo.registration.dao.ProductDao;
import net.gojo.registration.model.Product;

@WebServlet({"/register", "/index"})
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductDao productDao;

    public void init() {
        productDao = new ProductDao();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            case "/register":
                // Redireccionar a la vista de registro de productos
                RequestDispatcher registerDispatcher = request.getRequestDispatcher("/WEB-INF/views/productregister.jsp");
                registerDispatcher.forward(request, response);
                break;
            case "/index":
                // Obtener la lista de productos desde la base de datos
                List<Product> products = null;
                try {
                    products = productDao.getAllProducts();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                // Establecer los productos como atributo en la solicitud para enviarlos a la vista
                request.setAttribute("products", products);

                // Redireccionar a la vista de la lista de productos
                RequestDispatcher indexDispatcher = request.getRequestDispatcher("/index.jsp");
                indexDispatcher.forward(request, response);
                break;
            default:
                // Si la acción no coincide con ninguna ruta conocida, redireccionar al índice por defecto
                response.sendRedirect(request.getContextPath() + "/index");
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        // Recuperar los datos del formulario
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double price = Double.parseDouble(request.getParameter("price"));

        // Crear un nuevo producto
        Product product = new Product(id, title, description, quantity, price);

        try {
            // Registrar el producto en la base de datos
            productDao.registerProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Redirigir al usuario a la página de detalles del producto
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/productdetails.jsp");
        dispatcher.forward(request, response);
    }
}
