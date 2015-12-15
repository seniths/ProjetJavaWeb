/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionFacade;

import entityBean.Category;
import entityBean.Language;
import entityBean.Languagecategory;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.CategoryModel;

/**
 *
 * @author Maxime
 */
@Stateless
public class LanguagecategoryFacade extends AbstractFacade<Languagecategory> implements LanguagecategoryFacadeLocal {
    @PersistenceContext(unitName = "GoFoot3-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LanguagecategoryFacade() {
        super(Languagecategory.class);
    }

    @Override
    public List<CategoryModel> getCategoriesByLanguageId(int idLang) {
        List<CategoryModel> categories = new ArrayList<>();
        
        entityBean.Language lang = new Language(idLang);
        Query query = em.createNamedQuery("Languagecategory.findByLangId");
        query.setParameter("idlang", lang);
        List<Languagecategory> allCats = query.getResultList();
        
        for (Languagecategory c : allCats) {
            CategoryModel cm = new CategoryModel();
            Category cat = c.getIdcategory();
            cm.setName(c.getLabel());
            cm.setId(cat.getIdcategory());
            categories.add(cm);
        }
        
        return categories;
    }
    
}
