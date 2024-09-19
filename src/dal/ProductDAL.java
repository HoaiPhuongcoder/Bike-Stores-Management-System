/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import dao.BrandDAO;
import dao.BrandDAOImpl;
import dao.CategoryDAO;
import dao.CategoryDAOImpl;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Product;

/**
 *
 * @author hoaiphuong
 */
public class ProductDAL implements IFileManager<Product>{
    private static final String  FILE_NAME = "product.txt";
    @Override
    public void saveToFile(List<Product> products) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Product product : products) {
                writer.write(product.getId() + "," + product.getName() + ","
                        + product.getBrand().getBrandId() + ","
                        + product.getCategory().getCategoryId() + "," + product.getModelYear()
                        + "," + product.getListPrice());
                writer.newLine();
            }
            System.out.println("Products have been successfully saved to " + FILE_NAME);
        } catch (Exception e) {
            System.out.println("Error saving products to file: " + e.getMessage());
        }
    }

    @Override
    public List<Product> loadFromFile() {
        BrandDAO brandDAO = new BrandDAOImpl();
        CategoryDAO categoryDAO = new CategoryDAOImpl();
        List<Product> products = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    String id = parts[0];
                    String name = parts[1];
                    String brandId = parts[2];
                    String categoryId = parts[3];
                    int modelYear = Integer.parseInt(parts[4]);
                    double listPrice = Double.parseDouble(parts[5]);
                    Product product = new Product(id, name, brandDAO.getBrandByID(brandId),
                            categoryDAO.getCategoryByID(categoryId), modelYear, listPrice);
                    products.add(product);
                }
            }
            System.out.println("Products have been successfully loaded from " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error loading products from file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing product data: " + e.getMessage());
        }
        return products;
    }
}
