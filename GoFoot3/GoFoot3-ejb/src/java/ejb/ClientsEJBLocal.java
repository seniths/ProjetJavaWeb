/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import exception.GetUserException;
import exception.SaveUserException;
import javax.ejb.Local;
import model.ClientModel;

/**
 *
 * @author Maxime
 */
@Local
public interface ClientsEJBLocal {
 
    void saveUser(ClientModel client) throws SaveUserException;
    
    ClientModel getClientByLoginAndPassword(String login, String password) throws GetUserException;
    
    Boolean loginIsAvailable(String login);
}
