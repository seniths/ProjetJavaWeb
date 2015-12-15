/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionFacade;

import entityBean.Languageitem;
import java.util.List;
import javax.ejb.Local;
import model.ItemModel;

/**
 *
 * @author Maxime
 */
@Local
public interface LanguageitemFacadeLocal {

    void create(Languageitem languageitem);

    void edit(Languageitem languageitem);

    void remove(Languageitem languageitem);

    Languageitem find(Object id);

    List<Languageitem> findAll();

    List<Languageitem> findRange(int[] range);

    int count();
    
    List<ItemModel> getItemsByCatAndLang(int catId, int langId);
    
    ItemModel getItemById(int id, int langId);
}
