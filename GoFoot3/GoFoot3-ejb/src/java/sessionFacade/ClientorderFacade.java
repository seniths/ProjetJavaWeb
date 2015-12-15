/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionFacade;

import entityBean.Clientorder;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Maxime
 */
@Stateless
public class ClientorderFacade extends AbstractFacade<Clientorder> implements ClientorderFacadeLocal {
    @PersistenceContext(unitName = "GoFoot3-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientorderFacade() {
        super(Clientorder.class);
    }
    
}
