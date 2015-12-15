/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import model.ItemModel;

/**
 *
 * @author Maxime
 */
@Named(value = "caddieManagedBean")
@SessionScoped
public class CaddieManagedBean implements Serializable {

    private HashMap caddieHashMap;
    private Double totalPrice;
    @Inject
    private ItemManagedBean itemMB;

    public ItemManagedBean getItemMB() {
        return itemMB;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setItemMB(ItemManagedBean itemMB) {
        this.itemMB = itemMB;
    }

    public HashMap getCaddieHashMap() {
        return caddieHashMap;
    }

    public void setCaddieHashMap(HashMap caddieHashMap) {
        this.caddieHashMap = caddieHashMap;
    }
    /**
     * Creates a new instance of CaddieManagedBean
     */
    
    public CaddieManagedBean() {
        caddieHashMap = new HashMap();
    }
    
    public String addItemToCaddie()
    {
        ItemModel im = itemMB.getSelectedItem();
        caddieHashMap.put(im.getId(), im);
        return "index";
    }
    
    public Double getTotalPrice()
    {
        Set set = caddieHashMap.entrySet();
        Iterator it = set.iterator();
        setTotalPrice(0.);
        while (it.hasNext()) {
            Map.Entry me = (Map.Entry)it.next();
            ItemModel im = (ItemModel)me.getValue();
            if(im.getReducedPrice() != null)
                totalPrice += im.getReducedPrice()* im.getQuantity();
            else
                totalPrice += im.getPrice() * im.getQuantity();
        }
        return totalPrice;
    }
    
    public String removeItemFromCaddie(int key)
    {
        caddieHashMap.remove(key);
        return "caddie";
    }
    
    public void changeItemQuantity(int key, int qty)
    {
        ItemModel item = (ItemModel)caddieHashMap.get(key);
        if(item.getQuantity() + qty > 0)
            item.setQuantity(item.getQuantity() + qty);
    }
    
    public String orderItems()
    {
        return "index";
    }
}
