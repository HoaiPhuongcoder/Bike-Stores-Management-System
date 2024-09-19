/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dal.CategoryDAL;
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
public class CategoryDAOImpl implements  CategoryDAO{
   
    private List<Category> categories;
    
    
    public CategoryDAOImpl() {
       loadFormFile();
    }

   private void loadFormFile(){
      CategoryDAL dal = new CategoryDAL();
      categories = dal.loadFromFile();
   }
    
    @Override
    public Category getCategoryByID(String id) {
        for (Category category : categories) {
            if(category.getCategoryId().equals(id)){
                return category;
            }
        }
        return null;
    }

    @Override
    public Category getCategoryByIndex(int index) { 
        int size = categories.size();
        if(index < 0 || index > size) return null;
        return this.categories.get(index);
    }

    @Override
    public String[] getCategoryOptions() {
        String[] ops = new String [categories.size()];
        for (int i = 0; i <categories.size(); i++) {
            ops[i] = categories.get(i).toString();
        }
        return ops;
    }
    
}
