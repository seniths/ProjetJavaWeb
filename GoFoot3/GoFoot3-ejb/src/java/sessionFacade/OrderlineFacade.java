/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionFacade;

import entityBean.Orderline;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
}
