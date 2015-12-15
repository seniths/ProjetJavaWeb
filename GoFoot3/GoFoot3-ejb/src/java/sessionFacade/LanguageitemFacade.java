/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionFacade;

import entityBean.Category;
import entityBean.Item;
import entityBean.Language;
import entityBean.Languageitem;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.ItemModel;

/**
 *
 * @author Maxime
 */
@Stateless
public class LanguageitemFacade extends AbstractFacade<Languageitem> implements LanguageitemFacadeLocal {
    @PersistenceContext(unitName = "GoFoot3-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LanguageitemFacade() {
        super(Languageitem.class);
    }

    @Override
    public List<ItemModel> getItemsByCatAndLang(int catId, int langId) {
        List<ItemModel> items = new ArrayList<>();
        
        Category cat = new Category(catId);
        Language lang = new Language(langId);
        Query query = em.createNamedQuery("Languageitem.findByCatAndLang");
        query.setParameter("idcategory", cat);
        query.setParameter("idlanguage", lang);
        List<Languageitem> itemsDB = query.getResultList();
        
        for (Languageitem item : itemsDB) {
            ItemModel im = new ItemModel();
            im.setId(item.getIditem().getIditem());
            im.setImageSrc(item.getIditem().getImagesrc());
            im.setPrice(item.getIditem().getPrice().doubleValue());
            im.setLabel(item.getLabel());
            im.setIdCategory(item.getIditem().getIdcategory().getIdcategory());
            items.add(im);
        }
        
        return items;
    }

    @Override
    public ItemModel getItemById(int id, int langId) {
        ItemModel im = new ItemModel();
        
        Item i = new Item(id);
        Language l = new Language(langId);
        Query query = em.createNamedQuery("Languageitem.findByItemId");
        query.setParameter("iditem", i);
        query.setParameter("idlang", l);
        Languageitem li = (Languageitem)query.getSingleResult();
        
        im.setId(id);
        im.setImageSrc(li.getIditem().getImagesrc());
        im.setLabel(li.getLabel());
        im.setPrice(li.getIditem().getPrice().doubleValue());
        im.setIdCategory(li.getIditem().getIdcategory().getIdcategory());
        
        return im;
    }
    
}
