/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.CategoryModel;
import sessionFacade.LanguagecategoryFacadeLocal;

/**
 *
 * @author Maxime
 */
@Stateless
public class CategoriesEJB implements CategoriesEJBLocal {
    @EJB
    private LanguagecategoryFacadeLocal languagecategoryFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<CategoryModel> getCategoriesByLanguageId(String lang) {
        int idLang = (lang.equals("en") ? 1 : 2);
        return languagecategoryFacade.getCategoriesByLanguageId(idLang);
    }
}
