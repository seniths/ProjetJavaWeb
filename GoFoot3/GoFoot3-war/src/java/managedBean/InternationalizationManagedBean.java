/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import ejb.CategoriesEJBLocal;
import ejb.ItemsEJBLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import model.CategoryModel;
import model.ItemModel;

/**
 *
 * @author Maxime
 */
@Named(value = "internationalizationManagedBean")
@SessionScoped
public class InternationalizationManagedBean implements Serializable {
    @EJB
    private ItemsEJBLocal itemsEJB;
    @EJB
    private CategoriesEJBLocal categoriesEJB;
    @Inject
    private ItemManagedBean itemMB;
    

    private Locale locale = new Locale("fr");
    /**
     * Creates a new instance of InternationalizationManagedBean
     */
    public InternationalizationManagedBean() {
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
    
    public void setToEnglish()
    {
        locale = new Locale("en");
    }
    
    public void setToFrench()
    {
        locale = new Locale("fr");
    }
    
    public List<CategoryModel> getAllCategories()
    {
        return categoriesEJB.getCategoriesByLanguageId(locale.getLanguage());
    }
    
    public List<ItemModel> getItemsByCatAndLang()
    {
        int catId = 0;
        String param = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("cat");
        if(param != null)
        {
            catId = Integer.parseInt(param);
            return itemsEJB.getItemsByCatAndLang(catId, locale.getLanguage());
        }
        return null;
    }
    
    public void loadItemById()
    {
        int prodId = 0;
        String param = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("prod");
        if(param !=null)
        {
            prodId = Integer.parseInt(param);
            itemMB.setSelectedItem(itemsEJB.getItemById(prodId, locale.getLanguage()));
        }
    }
}
