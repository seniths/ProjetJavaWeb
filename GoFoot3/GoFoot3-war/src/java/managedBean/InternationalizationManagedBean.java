/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import ejb.CategoriesEJBLocal;
import ejb.ItemsEJBLocal;
import exception.GetCategoriesException;
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
    
    private String catErrorMessage;
    private Locale locale = new Locale("fr");
    private Integer currentItemId;
    private Integer currentCatId;

    public Integer getCurrentCatId() {
        return currentCatId;
    }

    public void setCurrentCatId(Integer currentCatId) {
        this.currentCatId = currentCatId;
    }

    public Integer getCurrentItemId() {
        return currentItemId;
    }

    public void setCurrentItemId(Integer currentItemId) {
        this.currentItemId = currentItemId;
    }

    public String getCatErrorMessage() {
        return catErrorMessage;
    }

    public void setCatErrorMessage(String catErrorMessage) {
        this.catErrorMessage = catErrorMessage;
    }
    
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
        try{
            return categoriesEJB.getCategoriesByLanguageId(locale.getLanguage());
        } catch(GetCategoriesException e){
            if(locale.getLanguage().equals("fr"))
                catErrorMessage = e.getMessageFr();
            else 
                catErrorMessage = e.getMessageEn();
            return null;
        }
    }
    
    public List<ItemModel> getItemsByCatAndLang()
    {
        int catId = 0;
        String param = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("cat");
        if(param != null)
        {
            try {
                catId = Integer.parseInt(param);
                currentCatId = catId;
                return itemsEJB.getItemsByCatAndLang(catId, locale.getLanguage());
            } catch (NumberFormatException e) {
                return null;
            }
        }
        else if(currentCatId != null)
        {
            return itemsEJB.getItemsByCatAndLang(currentCatId, locale.getLanguage());
        }
        return null;
    }
    
    public void loadItemById()
    {
        String param = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("prod");
        if(param != null)
        {
            int id = 0;
            try{
                id = Integer.parseInt(param);
                currentItemId = id;
                itemMB.setSelectedItem(itemsEJB.getItemById(id, locale.getLanguage()));
            }catch(NumberFormatException e)
            {
                
            }
        }
        else if(currentItemId != null)
        {
            itemMB.setSelectedItem(itemsEJB.getItemById(currentItemId, locale.getLanguage()));
        }
    }
}
