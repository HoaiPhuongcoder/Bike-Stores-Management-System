/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dal.BrandDAL;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Brand;

/**
 *
 * @author hoaiphuong
 */
public class BrandDAOImpl implements BrandDAO{
    private List<Brand> brands;
    public BrandDAOImpl() {
        loadFromFile();
    }
    private void loadFromFile(){
        BrandDAL dal= new BrandDAL();
        brands = dal.loadFromFile();       
    }
    @Override
    public Brand getBrandByID(String id) {
        for (Brand brand : brands) {
            if(brand.getBrandId().equals(id)){
                return brand;
            }
        }
        return null;
    }


    @Override
    public Brand getBrandByIndex(int index) {
        int size = brands.size();
        if(index < 0 || index > size )return null;
        return (Brand)this.brands.get(index);
        
//        for (int i = 0; i < brands.size() ; i++) {
//            if(i== (choice - 1)){
//                return brands.get(i);
//            }
//            
//        }
    }
    
    @Override
    public String[] getBrandOptions(){
        String[] ops = new String [brands.size()];
        for (int i = 0; i < brands.size(); i++) {
            ops[i] = brands.get(i).toString();
        }
        return ops;
    }
    
}
