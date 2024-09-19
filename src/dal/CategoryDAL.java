/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Category;

/**
 *
 * @author hoaiphuong
 */
public class CategoryDAL implements IFileManager<Category>{
    private static final String FILE_NAME = "category.txt";
    @Override
    public List<Category> loadFromFile() {
        List<Category> categories = new ArrayList<>();
        categories.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){
            String line;
            while ((line = reader.readLine())!= null ) {                
                String [] info = line.split(",");
                if(info.length == 2){
                    String categoryID = info[0].trim();
                    String categoryName = info[1].trim();
                    Category category = new Category(categoryID, categoryName);
                    categories.add(category);
                }
            }
            System.out.println("Category load form " +FILE_NAME+ " file Successfully");
        } catch (IOException e) {
            System.out.println("Error loading from file: " + FILE_NAME);
        }
        return categories;
    }

    @Override
    public void saveToFile(List<Category> products) {
    }
}
