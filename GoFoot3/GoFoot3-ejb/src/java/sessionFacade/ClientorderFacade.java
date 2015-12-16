/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionFacade;

import entityBean.Client;
import entityBean.Clientorder;
import exception.OrderException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.ItemModel;

/**
 *
 * @author Maxime
 */
@Stateless
public class ClientorderFacade extends AbstractFacade<Clientorder> implements ClientorderFacadeLocal {
    @EJB
    private OrderlineFacadeLocal orderlineFacade;
    
    @PersistenceContext(unitName = "GoFoot3-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientorderFacade() {
        super(Clientorder.class);
    }

    @Override
    public void createOrder(int idClient, Date date, HashMap items) throws OrderException{
        try {
            Clientorder order = new Clientorder();
            Client client = new Client(idClient);
            order.setDate(date);
            order.setIdclient(client);

            create(order);
            em.flush();

            Set set = items.entrySet();
            Iterator it = set.iterator();
            while (it.hasNext()){
                Map.Entry me = (Map.Entry)it.next();
                ItemModel im = (ItemModel)me.getValue();
                orderlineFacade.createOrderLine(order, im);
            }
        } catch (Exception e) {
            throw new OrderException();
        }
    }
    
}
