/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.ItemModel;
import model.PromotionModel;
import sessionFacade.LanguageitemFacadeLocal;
import sessionFacade.PromotioncategoryFacadeLocal;

/**
 *
 * @author Max
 */
@Stateless
public class ItemsEJB implements ItemsEJBLocal {
    @EJB
    private PromotioncategoryFacadeLocal promotioncategoryFacade;
    @EJB
    private LanguageitemFacadeLocal languageitemFacade;
    

    @Override
    public List<ItemModel> getItemsByCatAndLang(int catId, String locale) {
        int langId = localeToInt(locale);
        
        List<ItemModel> items = languageitemFacade.getItemsByCatAndLang(catId, langId);
        PromotionModel promo = getItemPromoByCatId(catId);
        
        if(promo != null)
        {
            for (ItemModel item : items) {
                item.setReducedPrice(item.getPrice() - item.getPrice() * promo.getPercentage());
            }
        }
        return items;
    }

    @Override
    public ItemModel getItemById(int id, String locale) {
        int langId = localeToInt(locale);
        ItemModel item = languageitemFacade.getItemById(id, langId);
        PromotionModel promo = getItemPromoByCatId(item.getIdCategory());
        if(promo != null)
            item.setReducedPrice(item.getPrice() - item.getPrice() * promo.getPercentage());
        return item;
    }
    
    private int localeToInt(String locale)
    {
        return (locale.equals("en") ? 1 : 2);
    }

    private PromotionModel getItemPromoByCatId(int catId){
        GregorianCalendar gregC = new GregorianCalendar();
        int weekNumber = gregC.get(Calendar.WEEK_OF_YEAR);
        return promotioncategoryFacade.getPromoByWeekNumberAndCatId(weekNumber, catId);
    }
    
}
