/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import exception.GetCategoriesException;
import java.util.List;
import javax.ejb.Local;
import model.CategoryModel;

/**
 *
 * @author Maxime
 */
@Local
public interface CategoriesEJBLocal {
    
    List<CategoryModel> getCategoriesByLanguageId(String lang) throws GetCategoriesException;
}
