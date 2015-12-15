/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import sessionFacade.ClientorderFacadeLocal;

/**
 *
 * @author Maxime
 */
@Stateless
public class OrderEJB implements OrderEJBLocal {
    @EJB
    private ClientorderFacadeLocal clientorderFacade;

    @Override
    public void createOrder(int idClient, HashMap items) {
        GregorianCalendar g = new GregorianCalendar();
        Date date = g.getTime();
        clientorderFacade.createOrder(idClient, date, items);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
