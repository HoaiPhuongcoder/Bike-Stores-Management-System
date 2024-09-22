/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;

import ui.IMenu;
import ui.Menu;
import dao.BrandDAO;
import dao.BrandDAOImpl;
import dao.CategoryDAO;
import dao.CategoryDAOImpl;
import dao.ProductDAO;
import dao.ProductDAOImpl;
import java.util.Comparator;
import java.util.List;
import model.Brand;
import model.Category;
import model.Product;
import utils.Validator;

/**
 *
 * @author hoaiphuong
 */
public class Management {

    private  ProductDAO productDAO;
    private  BrandDAO brandDAO;
    private  CategoryDAO categoryDAO;

    public Management() {
        productDAO = new ProductDAOImpl();
        brandDAO = new BrandDAOImpl();
        categoryDAO = new CategoryDAOImpl();
    }

    public void addProduct() {
        String name = Validator.getString("Enter name Product: ",
                "Please Enter string not Empty", "^(?!\\s*$).+");
        IMenu bm = new Menu(brandDAO.getBrandOptions());
        bm.showMenu();
        Brand brand = brandDAO.getBrandByIndex(bm.getChoice() - 1);
        IMenu cm = new Menu(categoryDAO.getCategoryOptions());
        cm.showMenu();
        Category category = categoryDAO.getCategoryByIndex(cm.getChoice() - 1);

        int modelyear = Validator.getInt("Enter model year: ",
                "Please Enter model year 2000 - > 2024", "Invalid", 2000, 2024);
        double listPrice = Validator.getDouble("Enter list price: ",
                "Please Enter list price > 0", "Invalid", 1, 9999991
        );
        Product product = new Product(null, name, brand, category,
                modelyear, listPrice);
        if (productDAO.addProduct(product)) {
            System.out.println("Add success Product: " + product);
        } else {
            System.out.println("Add fail");
        }
    }

    public void searchProductByName() {
        String name = Validator.getString("Enter name Product: ",
                "Please Enter string not Empty", "^(?!\\s*$).+");
        List<Product> result = productDAO.searchProductByName(name);
        if (result.isEmpty()) {
            System.out.println("Have no any Product");
        } else {
            result.sort(Comparator.comparingInt(Product::getModelYear));

            System.out.println("------------------------------- List Product information ASC ------------------------------------");
            System.out.printf("| %-6s | %-20s | %-12s | %-15s | %-10s | %-15s |\n",
                    "ID", "Name", "Brand ID", "Category ID", "Model Year", "List Price");
            for (Product product : result) {

                System.out.printf("| %-6s | %-20s | %-12s | %-15s | %-10d | %-15.2f |\n",
                        product.getId(), product.getName(), product.getBrand().getBrandId(), product.getCategory().getCategoryId(), product.getModelYear(), product.getListPrice());
            }
        }
    }

    public void updateProduct() {
        String id = Validator.getString("Enter ID Product: ", "Must be Pxxx(x is digit)", "^P\\d{3}$");
        Product product = productDAO.getProductByID(id);
        if (product == null) {
            System.out.println("Product does not exist");
        } else {
            System.out.println("Before update: " + product);
            String newName = Validator.getStringUpdate("Enter new Name: ");

//        BRAND UPDATE
            Brand newBrand = null;
            String[] opsB = brandDAO.getBrandOptions();
            IMenu bm = new Menu(opsB);
            bm.addItem("Quit");
            bm.showMenu();
            int brandChoice = bm.getChoice();

            if (opsB.length >= brandChoice) {
                newBrand = brandDAO.getBrandByIndex(brandChoice - 1);
            }
//        CATEGORY UPDATE
            Category newCategory = null;
            String[] opsC = categoryDAO.getCategoryOptions();
            IMenu cm = new Menu(opsC);
            cm.addItem("Quit");
            cm.showMenu();
            int categoryChoice = cm.getChoice();
            if (opsC.length >= categoryChoice) {
                newCategory = categoryDAO.getCategoryByIndex(categoryChoice - 1);
            }

//        }
            int newModelYear = Validator.getIntUpdate("Enter model year: ", "Must be 2000->2024",
                    "Invalid!", 2000, 2024);
            int newListPrice = Validator.getIntUpdate("Enter list price: ", "Must be >0", "Invalid!",
                    1, Integer.MAX_VALUE);
            if (!newName.isEmpty()) {
                product.setName(newName);
            }
            if (newBrand != null) {
                product.setBrand(newBrand);
            }
            if (newCategory != null) {
                product.setCategory(newCategory);
            }
            if (newModelYear >= 2000 && newModelYear <= 2024) {
                product.setModelYear(newModelYear);
            }
            if (newListPrice > 0) {
                product.setListPrice(newListPrice);
            }
            System.out.println("After Update: " + product);
        }

    }

    public void deleteProduct() {
        String id = Validator.getString("Enter id Product (Pxxx): ",
                "Please Enter with format (Pxxx)", "^P\\d{3}$");
        Product product = productDAO.deleteProduct(id);
        if (product == null) {
            System.out.println("Product does not exist");
        } else {
            System.out.println("Delete successfull: " + product);
        }
    }

    public void printFormFile() {
        List<Product> result = productDAO.getList();
        result.sort(Comparator.comparingDouble(Product::getListPrice).reversed().thenComparing(Product::getName));

        System.out.println("----------------------------------List Product Infomation----------------------------------------");
        System.out.printf("| %-6s | %-20s | %-12s | %-15s | %-10s | %-15s |\n",
                "ID", "Name", "Brand Name", "Category Name", "Model Year", "List Price");
        for (Product product : result) {
            System.out.printf("| %-6s | %-20s | %-12s | %-15s | %-10d | %-15.2f |\n", product.getId(),
                    product.getName(),
                    brandDAO.getBrandByID(product.getBrand().getBrandId()).getBrandName(),
                    categoryDAO.getCategoryByID(product.getCategory().getCategoryId()).getCategoryName(),
                    product.getModelYear(), product.getListPrice());
        }
    }

    public void run() {

        Menu menu = new Menu();
        menu.addItem("Add a product.");
        menu.addItem("Search product by product name");
        menu.addItem("Update product.");
        menu.addItem("Delete product");
        menu.addItem("Save products to file.");
        menu.addItem("Print list products from the file");
        menu.addItem(" Quit.");
        boolean flag = false;
        do {
            menu.showMenu();
            int choice = menu.getChoice();
            switch (choice) {
                case 1 -> {
                    do {
                        addProduct();
                    } while (!menu.confirmYesNo("  ~~ Do you want to go back to Menu? (Y/N): "));
                }
                case 2 -> {
                    do {
                        searchProductByName();
                    } while (!menu.confirmYesNo(" ~~ Do you want to go back to Menu? (Y/N): "));
                }
                case 3 -> {
                    do {
                        updateProduct();
                    } while (!menu.confirmYesNo(" ~~ Do you want to go back to Menu? (Y/N): "));
                }
                case 4 -> {
                    do {
                        deleteProduct();
                    } while (!menu.confirmYesNo(" ~~ Do you want to go back to Menu? (Y/N): "));
                }

                case 5 -> {
                    do {
                        productDAO.saveToFile();
                    } while (!menu.confirmYesNo(" ~~ Do you want to go back to Menu? (Y/N): "));
                }
                case 6 -> {
                    do {
                        printFormFile();
                    } while (!menu.confirmYesNo(" ~~ Do you want to go back to Menu? (Y/N): "));
                }
                case 7 -> {
                    flag = true;
                    System.out.println("      ------------------------");
                    System.out.println("==>   | *** Good Bye Sir *** |   <==");
                    System.out.println("      ------------------------");
                }
                default -> System.out.println(" ~ Pls choose from 1 to 7 only! ");
            }
        } while (!flag);

    }
}
