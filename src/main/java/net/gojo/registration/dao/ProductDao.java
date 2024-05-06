package net.gojo.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.gojo.registration.model.Product;

public class ProductDao {

    public int registerProduct(Product product) throws ClassNotFoundException {
        String INSERT_PRODUCT_SQL = "INSERT INTO products" +
            "  (id, title, description, quantity, price) VALUES " +
            " (?, ?, ?, ?, ?);";

        int result = 0;

        Class.forName("org.postgresql.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/gojo", "postgres", "123");

            // Step 2: Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL)) {
            preparedStatement.setInt(1, product.getId()); // Cambiado para incluir el id
            preparedStatement.setString(2, product.getTitle());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setInt(4, product.getQuantity());
            preparedStatement.setDouble(5, product.getPrice());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process SQL exception
            printSQLException(e);
        }
        return result;
    }
    
    public List<Product> getAllProducts() throws ClassNotFoundException {
        String SELECT_ALL_PRODUCTS = "SELECT * FROM products";
        List<Product> products = new ArrayList<>();

        Class.forName("org.postgresql.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/gojo", "postgres", "123");
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS);
            ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id"); // Cambiado para incluir el id
                String title = rs.getString("title");
                String description = rs.getString("description");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                Product product = new Product(id, title, description, quantity, price);
                products.add(product);
            }

        } catch (SQLException e) {
            printSQLException(e);
        }
        return products;
    }
    
    public int updateProduct(Product product) throws ClassNotFoundException {
        String UPDATE_PRODUCT_SQL = "UPDATE products SET title=?, description=?, quantity=?, price=? WHERE id=?";

        int result = 0;

        Class.forName("org.postgresql.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/gojo", "postgres", "123");
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT_SQL)) {

            preparedStatement.setString(1, product.getTitle());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.setInt(5, product.getId());

            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            printSQLException(e);
        }
        return result;
    }

    public Product getProductById(int productId) throws ClassNotFoundException {
        String SELECT_PRODUCT_BY_ID = "SELECT * FROM products WHERE id=?";

        Product product = null;

        Class.forName("org.postgresql.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/gojo", "postgres", "123");
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID)) {

            preparedStatement.setInt(1, productId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String title = rs.getString("title");
                String description = rs.getString("description");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                product = new Product(productId, title, description, quantity, price);
            }

        } catch (SQLException e) {
            printSQLException(e);
        }
        return product;
    }

    public int deleteProduct(int productId) throws ClassNotFoundException {
        String DELETE_PRODUCT_SQL = "DELETE FROM products WHERE id=?";

        int result = 0;

        Class.forName("org.postgresql.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/gojo", "postgres", "123");
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_SQL)) {

            preparedStatement.setInt(1, productId);

            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            printSQLException(e);
        }
        return result;
    }
    
    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
