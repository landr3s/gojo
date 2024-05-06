package net.gojo.registration.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.gojo.registration.dao.ProductDao;
import net.gojo.registration.model.Product;

@WebServlet("/editProduct")
public class EditProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductDao productDao;

    public void init() {
        productDao = new ProductDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("id"));
        
        try {
            // Obtener los detalles del producto desde la base de datos
            Product product = productDao.getProductById(productId);
            
            // Establecer los atributos del producto en la solicitud para mostrar en la vista
            request.setAttribute("id", product.getId());
            request.setAttribute("title", product.getTitle());
            request.setAttribute("description", product.getDescription());
            request.setAttribute("quantity", product.getQuantity());
            request.setAttribute("price", product.getPrice());
            
            // Redireccionar a la vista de edición de producto
            request.getRequestDispatcher("/WEB-INF/views/editProduct.jsp").forward(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            // Manejar cualquier excepción que pueda ocurrir al obtener el producto por su ID
            // Por ejemplo, podrías redirigir a una página de error o mostrar un mensaje de error
            response.sendRedirect(request.getContextPath() + "/index"); // Redireccionar al índice en caso de error
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double price = Double.parseDouble(request.getParameter("price"));

        // Crear un objeto Product con los datos actualizados
        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setDescription(description);
        product.setQuantity(quantity);
        product.setPrice(price);

        // Actualizar el producto en la base de datos
        try {
            productDao.updateProduct(product);
            response.sendRedirect(request.getContextPath() + "/index");
        } catch (Exception e) {
            e.printStackTrace();
            // Manejar cualquier excepción que pueda ocurrir al actualizar el producto
            // Por ejemplo, podrías redirigir a una página de error o mostrar un mensaje de error
            response.sendRedirect(request.getContextPath() + "/index"); // Redireccionar al índice en caso de error
        }
    }
}
