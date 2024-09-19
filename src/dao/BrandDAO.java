/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import model.Brand;

/**
 *
 * @author hoaiphuong
 */
public interface BrandDAO {
    
    
    Brand getBrandByID(String id);
    
    Brand getBrandByIndex(int i);
    
    String[] getBrandOptions();
}
