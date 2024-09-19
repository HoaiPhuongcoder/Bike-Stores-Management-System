/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import dao.BrandDAO;
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
public class BrandDAL implements IFileManager<Brand>{
    private static final String FILE_NAME = "brand.txt";
    @Override
    public List<Brand> loadFromFile() {
        List<Brand> brands = new ArrayList<>();
        brands.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){
            String line;
            while ((line = reader.readLine())!= null ) {                
                String [] info = line.split(",");
                if(info.length == 3){
                    String brandID = info[0].trim();
                    String brandName = info[1].trim();
                    String origin = info[2].trim();
                    Brand brand = new Brand(brandID, brandName, origin);
                    brands.add(brand);
                }
            }
            System.out.println("Brand load form " +FILE_NAME+ " file Successfully");
        } catch (IOException e) {
            System.out.println("Error loading from file :" + FILE_NAME);
        }
        return brands;
    }

    @Override
    public void saveToFile(List<Brand> products) {
    }

}
