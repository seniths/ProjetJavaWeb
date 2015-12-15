/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionFacade;

import entityBean.Clientorder;
import entityBean.Orderline;
import java.util.List;
import javax.ejb.Local;
import model.ItemModel;

/**
 *
 * @author Maxime
 */
@Local
public interface OrderlineFacadeLocal {

    void create(Orderline orderline);

    void edit(Orderline orderline);

    void remove(Orderline orderline);

    Orderline find(Object id);

    List<Orderline> findAll();

    List<Orderline> findRange(int[] range);

    int count();
    
    void createOrderLine(Clientorder idOrder, ItemModel item);
}
