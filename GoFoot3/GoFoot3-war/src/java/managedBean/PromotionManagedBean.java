/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import ejb.PromotionEJBLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import model.PromotionModel;

/**
 *
 * @author Maxime
 */
@Named(value = "promotionManagedBean")
@SessionScoped
public class PromotionManagedBean implements Serializable {
    @EJB
    private PromotionEJBLocal promotionEJB;
    
    private List<PromotionModel> promos;

    public List<PromotionModel> getPromos() {
        return promos;
    }

    public void setPromos(List<PromotionModel> promos) {
        this.promos = promos;
    }
    
    /**
     * Creates a new instance of PromotionManagedBean
     */
    public PromotionManagedBean() {
    }
    
    public Double percentageByCatID(int catId)
    {
        if(promos == null)
            promos = promotionEJB.getCurrentPromotion();
        
        for (PromotionModel promo : promos) {
            if(promo.getIdCategory() == catId)
                return promo.getPercentage();
        }
        
        return null;
    }
    
    public String displayPercentageByCatId(int catId){
        Double prc = percentageByCatID(catId);
        if(prc != null)
            return " - " + prc * 100 + "%";
        return "";
    }
}
