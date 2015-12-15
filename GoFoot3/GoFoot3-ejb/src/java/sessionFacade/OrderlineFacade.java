/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionFacade;

import entityBean.Clientorder;
import entityBean.Item;
import entityBean.Orderline;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.ItemModel;

/**
 *
 * @author Maxime
 */
@Stateless
public class OrderlineFacade extends AbstractFacade<Orderline> implements OrderlineFacadeLocal {
    @PersistenceContext(unitName = "GoFoot3-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrderlineFacade() {
        super(Orderline.class);
    }

    @Override
    public void createOrderLine(Clientorder order, ItemModel item) {
        Orderline line = new Orderline();
        Item entityItem = new Item(item.getId());
        line.setIditem(entityItem);
        line.setIdorder(order);
        if(item.getReducedPrice() != null)
            line.setPrice(BigDecimal.valueOf(item.getReducedPrice()));
        else
            line.setPrice(BigDecimal.valueOf(item.getPrice()));
        line.setQuantity(item.getQuantity());
        line.setSize(item.getSize());
        create(line);
    }
    
}
