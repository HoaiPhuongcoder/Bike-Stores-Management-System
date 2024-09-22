/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import model.Product;

/**
 *
 * @author hoaiphuong
 */
public interface ProductDAO {
    
    boolean addProduct(Product product);
    
    
    Product getProductByID(String id);
    
    
    List<Product> getAllProduct();
    
    
    List<Product> searchProductByName(String name); 
    
    Product deleteProduct(String id);
    
    List<Product> getList();
    
    void saveToFile();
    
    
}
