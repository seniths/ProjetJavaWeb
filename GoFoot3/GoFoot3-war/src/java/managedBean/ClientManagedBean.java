/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import ejb.ClientsEJBLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import model.ClientModel;

/**
 *
 * @author Maxime
 */
@Named(value = "clientManagedBean")
@SessionScoped
public class ClientManagedBean implements Serializable {
    @EJB
    private ClientsEJBLocal clientsEJB;
    
    private ClientModel client;
    private Boolean isLogged;

    public Boolean getIsLogged() {
        return isLogged;
    }

    public void setIsLogged(Boolean isLogged) {
        this.isLogged = isLogged;
    }

    public ClientModel getClient() {
        return client;
    }

    public void setClient(ClientModel client) {
        this.client = client;
    }
    
    /**
     * Creates a new instance of ClientManagedBean
     */
    public ClientManagedBean() {
        client = new ClientModel();
        isLogged = false;
    }
    
    public String login()
    {
        client = clientsEJB.getClientByLoginAndPassword(client.getLogin(), client.getPassword());
        if(client != null)
        {
            isLogged = true;
            return "index";
        }
        else 
        {
            return "connexion";
        }
    }
}
