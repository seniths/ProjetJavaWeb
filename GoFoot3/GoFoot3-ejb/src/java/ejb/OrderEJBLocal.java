/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.HashMap;
import javax.ejb.Local;

/**
 *
 * @author Maxime
 */
@Local
public interface OrderEJBLocal {
 
    void createOrder(int idClient, HashMap items);
    
}