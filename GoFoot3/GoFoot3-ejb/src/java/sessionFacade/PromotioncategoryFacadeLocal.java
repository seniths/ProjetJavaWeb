/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionFacade;

import entityBean.Promotioncategory;
import java.util.List;
import javax.ejb.Local;
import model.PromotionModel;

/**
 *
 * @author Maxime
 */
@Local
public interface PromotioncategoryFacadeLocal {

    void create(Promotioncategory promotioncategory);

    void edit(Promotioncategory promotioncategory);

    void remove(Promotioncategory promotioncategory);

    Promotioncategory find(Object id);

    List<Promotioncategory> findAll();

    List<Promotioncategory> findRange(int[] range);

    int count();
    
    List<PromotionModel> getPromoByWeekNumber(int weekNumber);
    
    PromotionModel getPromoByWeekNumberAndCatId(int weekNumber, int catId);
}
