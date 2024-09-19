/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Scanner;

/**
 *
 * @author hoaiphuong
 */
public class Validator {
    private static final Scanner sc = new Scanner(System.in);

    private Validator() {
    }
    public static int getInt(String msg, String errRange, String errNumber, 
            int min, int max){
        do {            
            try {
                System.out.print(msg);
                int number = Integer.parseInt(sc.nextLine());
                if(number >= min && number <= max){
                    return number;
                }else{
                    System.out.println(errRange);
                }
            } catch (NumberFormatException e) {
                System.out.println(errNumber);
            }
        } while (true);
    }
    public static int getIntUpdate(String msg, String errRange, String errNumber, 
            int min, int max){
        do {            
            try {
                System.out.print(msg);
                String s = sc.nextLine();
                if(s.isEmpty()){
                    return 0;
                }
                int number = Integer.parseInt(s);
                if(number >= min && number <= max){
                    return number;
                }else{
                    System.out.println(errRange);
                }
            } catch (NumberFormatException e) {
                System.out.println(errNumber);
            }
        } while (true);
    }
    public static double getDouble(String msg, String errRange, String errNumber, 
            int min, int max){
        do {            
            try {
                System.out.print(msg);
                
                double number = Double.parseDouble(sc.nextLine());
                if(number >= min && number <= max){
                    return number;
                }else{
                    System.out.println(errRange);
                }
            } catch (NumberFormatException e) {
                System.out.println(errNumber);
            }
        } while (true);
    }
     public static double getDoubleUpdate(String msg, String errRange, String errNumber, 
            double min, double max){
        do {            
            try {
                System.out.print(msg);
                String s = sc.nextLine();
                if(s.isEmpty()){
                    return 0;
                }
                double number = Double.parseDouble(s);
                if(number >= min && number <= max){
                    return number;
                }else{
                    System.out.println(errRange);
                }
            } catch (NumberFormatException e) {
                System.out.println(errNumber);
            }
        } while (true);
    }
    public static String getString(String msg, String err, final String REGEX){
        do {            
            System.out.print(msg);
            String s = sc.nextLine();
            if(s.matches(REGEX)){
                return s;
            }
            System.out.println(err);
        } while (true);
    }
    public static String getStringUpdate(String msg){
        System.out.print(msg);
        String s = sc.nextLine();
        return s.trim();
    }
    public static String getStringUpdateRegex(String msg, String err, final String REGEX){
        do {            
            System.out.print(msg);
            String s = sc.nextLine();
            if(s.trim().isEmpty()){
                return s.trim();
            }
            if(s.matches(REGEX)){
                return s;
            }
            System.out.println(err);
        } while (true);
    }
    public static boolean getOut(String msg, String error){
        String status;
        while (true) {
            System.out.print(msg);
            status = sc.nextLine();
            if(status.equalsIgnoreCase("y")){
                return false;
            }else if(status.equalsIgnoreCase("n")){
                return true;
            }
            System.out.println(error);
            
        }
    }
}
