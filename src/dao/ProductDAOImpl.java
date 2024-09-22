/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dal.IFileManager;
import dal.ProductDAL;
import java.util.ArrayList;
import java.util.List;
import model.Product;

/**
 *
 * @author hoaiphuong
 */
public class ProductDAOImpl implements ProductDAO {

    private List<Product> plist;
    private String lastID;
    

    public ProductDAOImpl() {
        loadFromFile();
        lastID = "";
    }
    private void loadFromFile(){
       IFileManager productFileManager = new ProductDAL();
       plist = productFileManager.loadFromFile();
    }
    
    @Override
    public void saveToFile(){
        IFileManager productFileManager = new ProductDAL();
        productFileManager.saveToFile(plist);
    }
    @Override
    public boolean addProduct(Product product) {
        if (plist.isEmpty()) {
            lastID = "P001";
        } else {
            String lastIDProduct = plist.get(plist.size() - 1).getId();
            int number = Integer.parseInt(lastIDProduct.substring(1));
            lastID = String.format("P%03d", number + 1);
        }
        product.setId(lastID);
        plist.add(product);
        return true;
    }

    @Override
    public Product getProductByID(String id) {
        for (Product product : plist) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> getAllProduct() {
        return plist;
    }

    @Override
    public List<Product> searchProductByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product product : plist) {
            if (product.getName().contains(name)) {
                result.add(product);
            }
        }
        return result;
    }

    @Override
    public Product deleteProduct(String id) {
        for (int i = 0; i < plist.size(); i++) {
            if (plist.get(i).getId().equals(id)) {
                return plist.remove(i);
            }

        }
        return null;
    }
    @Override
    public List<Product> getList(){
        return new ArrayList<>(plist) ;
    }
    
}
