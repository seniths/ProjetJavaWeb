/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import ejb.ItemsEJBLocal;
import ejb.OrderEJBLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import javax.ejb.EJB;
import javax.inject.Inject;
import model.ItemModel;

/**
 *
 * @author Maxime
 */
@Named(value = "caddieManagedBean")
@SessionScoped
public class CaddieManagedBean implements Serializable {
    @EJB
    private ItemsEJBLocal itemsEJB;
    @EJB
    private OrderEJBLocal orderEJB;

    private HashMap caddieHashMap;
    private Double totalPrice;
    
    @Inject
    private ItemManagedBean itemMB;
    @Inject
    private ClientManagedBean clientMB;
    @Inject
    private MessageManagedBean messageMB;
    @Inject 
    private InternationalizationManagedBean interMB;

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
        //refresh langue item
        Set set = caddieHashMap.entrySet();
        Iterator it = set.iterator();
        String locale = interMB.getLocale().getLanguage();
        while (it.hasNext()){
            Map.Entry me = (Map.Entry)it.next();
            ItemModel im = (ItemModel)me.getValue();
            ItemModel temp = itemsEJB.getItemById(im.getId(), locale);
            im.setLabel(temp.getLabel());
            me.setValue(im);
        }
        
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
        return itemsEJB.getTotalPrice(caddieHashMap);
    }
    
    public String removeItemFromCaddie(int key)
    {
        caddieHashMap.remove(key);
        return "caddie";
    }
    
    public void changeItemQuantity(int key, int qty)
    {
        ItemModel item = (ItemModel)caddieHashMap.get(key);
        if(item.getQuantity() + qty > 0 && item.getQuantity() + qty < 11)
            item.setQuantity(item.getQuantity() + qty);
    }
    
    public String orderItems()
    {
        ResourceBundle currentBundle = ResourceBundle.getBundle("language.lang",interMB.getLocale());
        try {
            orderEJB.createOrder(clientMB.getClient().getId(), caddieHashMap);
            messageMB.setMessage(currentBundle.getString("orderSucceed"));
        } catch (Exception e) {
            messageMB.setMessage(currentBundle.getString("orderFailed"));
        }
        return "message";
    }
}
