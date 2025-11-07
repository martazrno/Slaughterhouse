package via.pro3.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalProductRepo {

    private final Connection connection;

    public AnimalProductRepo() {
        try {connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/slaughterhouse_db",
                    "admin",
                    "admin");
            System.out.println("Connected to DB");}
        catch (SQLException e) {throw new RuntimeException("DB connection failed: " + e.getMessage(), e);}}

    public List<String> getAnimalsForProduct(String productId) {
        List<String> animals = new ArrayList<>();
        String sql = "SELECT animal_id FROM animal_product WHERE product_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, productId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {animals.add(rs.getString("animal_id"));}}
        catch (SQLException e) {throw new RuntimeException(e);}
        return animals;}

    public List<String> getProductsForAnimal(String animalId) {
        List<String> products = new ArrayList<>();
        String sql = "SELECT product_id FROM animal_product WHERE animal_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, animalId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {products.add(rs.getString("product_id"));}}
        catch (SQLException e) {throw new RuntimeException(e);}
        return products;}

    public String getRegistrationNumber(String animalId) {
        try (PreparedStatement stmt = connection.prepareStatement("SELECT registration_number FROM animal WHERE animal_id = ?")) {
            stmt.setString(1, animalId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return rs.getString("registration_number");}
        catch (SQLException e) {throw new RuntimeException(e);}
        return "UNKNOWN";}

    public String getProductName(String productId) {
        try (PreparedStatement stmt = connection.prepareStatement("SELECT product_name FROM product WHERE product_id = ?")) {
            stmt.setString(1, productId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return rs.getString("product_name");}
        catch (SQLException e) {throw new RuntimeException(e);}
        return "UNKNOWN";}
}