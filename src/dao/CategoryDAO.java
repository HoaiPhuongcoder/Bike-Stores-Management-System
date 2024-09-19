/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import model.Category;

/**
 *
 * @author hoaiphuong
 */
public interface CategoryDAO {
    
    
    Category getCategoryByID(String id);

    Category getCategoryByIndex(int choice);
    
    String[] getCategoryOptions();
}
