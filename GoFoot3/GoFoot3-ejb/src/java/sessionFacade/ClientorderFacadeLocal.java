/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionFacade;

import entityBean.Clientorder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Maxime
 */
@Local
public interface ClientorderFacadeLocal {

    void create(Clientorder clientorder);

    void edit(Clientorder clientorder);

    void remove(Clientorder clientorder);

    Clientorder find(Object id);

    List<Clientorder> findAll();

    List<Clientorder> findRange(int[] range);

    int count();
    
    void createOrder(int idClient, Date date, HashMap items);
    
}
