/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Local;
import model.ClientModel;

/**
 *
 * @author Maxime
 */
@Local
public interface ClientsEJBLocal {
 
    Boolean saveUser(ClientModel client);
    
    ClientModel getClientByLoginAndPassword(String login, String password);
}
