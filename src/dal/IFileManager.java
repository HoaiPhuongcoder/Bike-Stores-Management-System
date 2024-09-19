/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import dao.BrandDAO;
import dao.CategoryDAO;
import java.util.List;
import model.Product;

/**
 *
 * @author hoaiphuong
 * @param <E>
 */
public interface IFileManager<E> {

    void saveToFile(List<E> products);

    List<E> loadFromFile();
}
