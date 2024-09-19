/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hoaiphuong
 */
public class Brand {
    private String brandId;
    private  String brandName;
    private String origin;

    public Brand() {
    }

    public Brand(String brandId, String brandName, String origin) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.origin = origin;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
    

    @Override
    public String toString() {
        String s = String.format("%s, %s, %s", brandId, brandName, origin);
        return s;
    }
    
}
