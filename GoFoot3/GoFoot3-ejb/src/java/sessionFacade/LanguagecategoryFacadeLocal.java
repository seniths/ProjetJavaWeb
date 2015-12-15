/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionFacade;

import entityBean.Languagecategory;
import exception.GetCategoriesException;
import java.util.List;
import javax.ejb.Local;
import model.CategoryModel;

/**
 *
 * @author Maxime
 */
@Local
public interface LanguagecategoryFacadeLocal {

    void create(Languagecategory languagecategory);

    void edit(Languagecategory languagecategory);

    void remove(Languagecategory languagecategory);

    Languagecategory find(Object id);

    List<Languagecategory> findAll();

    List<Languagecategory> findRange(int[] range);

    int count();
    
    List<CategoryModel> getCategoriesByLanguageId(int idLang) throws GetCategoriesException;
    
}
