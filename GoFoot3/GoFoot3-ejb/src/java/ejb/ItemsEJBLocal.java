/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import java.util.HashMap;
import java.util.List;
import javax.ejb.Local;
import model.ItemModel;

/**
 *
 * @author Max
 */
@Local
public interface ItemsEJBLocal {
    
    List<ItemModel> getItemsByCatAndLang(int catId, String locale);
    
    ItemModel getItemById(int id, String locale);
    
    Double getTotalPrice(HashMap items);
}
