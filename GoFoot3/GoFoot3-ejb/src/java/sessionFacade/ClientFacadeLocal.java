/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionFacade;

import entityBean.Client;
import exception.GetUserException;
import exception.SaveUserException;
import java.util.List;
import javax.ejb.Local;
import model.ClientModel;

/**
 *
 * @author Maxime
 */
@Local
public interface ClientFacadeLocal {

    void create(Client client);

    void edit(Client client);

    void remove(Client client);

    Client find(Object id);

    List<Client> findAll();

    List<Client> findRange(int[] range);

    int count();
    
    void saveClient(ClientModel client) throws SaveUserException;
    
    ClientModel getClientByLogin(String login) throws GetUserException;
    
    Boolean loginIsAvailable(String login);
}
