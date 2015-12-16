/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionFacade;

import entityBean.Client;
import exception.GetUserException;
import exception.SaveUserException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.ClientModel;

/**
 *
 * @author Maxime
 */
@Stateless
public class ClientFacade extends AbstractFacade<Client> implements ClientFacadeLocal {
    @PersistenceContext(unitName = "GoFoot3-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientFacade() {
        super(Client.class);
    }

    @Override
    public void saveClient(ClientModel client) throws SaveUserException{
        try
        {
            Client newClient = new Client();
            newClient.setFirstname(client.getFirstname());
            newClient.setLastname(client.getLastname());
            newClient.setLogin(client.getLogin());
            newClient.setPassword(client.getPassword());
            newClient.setAddLocality(client.getLocality());
            newClient.setAddNumber(client.getNumber());
            newClient.setAddPosatlcode((short)client.getPostalCode());
            newClient.setAddStreet(client.getStreet());
            newClient.setBirthdate(client.getBirthdate());
            newClient.setGender(client.getGender());
            newClient.setMail(client.getMail());
            newClient.setTelnumber(client.getPhone());

            create(newClient);
        } catch(Exception e)
        {
            throw new SaveUserException();
        }
    }

    @Override
    public ClientModel getClientByLogin(String login) throws GetUserException {
        try
        {
            ClientModel client = new ClientModel();
        
            Query query = em.createNamedQuery("Client.findByLogin");
            query.setParameter("login", login);
            Client clientDB = (Client)query.getSingleResult();

            client.setBirthdate(clientDB.getBirthdate());
            client.setFirstname(clientDB.getFirstname());
            client.setGender(clientDB.getGender());
            client.setId(clientDB.getIdclient());
            client.setLastname(clientDB.getLastname());
            client.setLocality(clientDB.getAddLocality());
            client.setLogin(clientDB.getLogin());
            client.setMail(clientDB.getMail());
            client.setNumber(clientDB.getAddNumber());
            client.setPassword(clientDB.getPassword());
            client.setPhone(clientDB.getTelnumber());
            client.setPostalCode(clientDB.getAddPosatlcode());
            client.setStreet(clientDB.getAddStreet());

            return client;
        } catch(Exception e)
        {
            throw new GetUserException();
        }   
    }

    @Override
    public Boolean loginIsAvailable(String login) {
        try {
            Query query = em.createNamedQuery("Client.findByLogin");
            query.setParameter("login", login);
            Client entityClient = (Client)query.getSingleResult();
            return false;
        } catch (Exception e) {
            return true;
        }
    }
    
}
