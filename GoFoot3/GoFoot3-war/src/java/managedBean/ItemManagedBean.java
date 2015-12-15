/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedBean;

//import ejb.ItemsEJBLocal;
import ejb.ItemsEJBLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model.ItemModel;

/**
 *
 * @author Max
 */
@Named(value = "itemManagedBean")
@SessionScoped
public class ItemManagedBean implements Serializable {
    @EJB
    private ItemsEJBLocal itemsEJB;
    
    private ItemModel selectedItem;

    public ItemModel getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(ItemModel selectedItem) {
        this.selectedItem = selectedItem;
        selectedItem.setQuantity(1);
    }
    
    public ItemManagedBean() {
    }
    
    public void changeQty(int qty)
    {
        if(selectedItem.getQuantity() + qty > 0)
            selectedItem.setQuantity(selectedItem.getQuantity() + qty);
    }
    
    public String newPrice()
    {
        return selectedItem.getReducedPrice().toString();
    }
    
    public String promoPrice()
    {
        if(selectedItem.getReducedPrice() != null)
            return selectedItem.getReducedPrice().toString() + "€";
        return "";
    }
    
    public String priceClass(){
        if(selectedItem.getReducedPrice() != null)
            return "oldPrice";
        return "";
    }
}
