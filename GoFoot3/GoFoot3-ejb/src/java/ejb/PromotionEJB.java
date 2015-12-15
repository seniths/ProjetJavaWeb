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
import model.PromotionModel;
import sessionFacade.PromotioncategoryFacadeLocal;

/**
 *
 * @author Maxime
 */
@Stateless
public class PromotionEJB implements PromotionEJBLocal {
    @EJB
    private PromotioncategoryFacadeLocal promotioncategoryFacade;

    
    
    @Override
    public List<PromotionModel> getCurrentPromotion() {
        GregorianCalendar gregC = new GregorianCalendar();
        int weekNumber = gregC.get(Calendar.WEEK_OF_YEAR);
        return promotioncategoryFacade.getPromoByWeekNumber(weekNumber);
    }
    
}
