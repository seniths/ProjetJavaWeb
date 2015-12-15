/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import ejb.ClientsEJBLocal;
import exception.GetUserException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Inject;
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
    @Inject
    private InternationalizationManagedBean interMb;
    
    private ClientModel client;
    private Boolean isLogged;
    private String msgError;

    public String getMsgError() {
        return msgError;
    }

    public void setMsgError(String msgError) {
        this.msgError = msgError;
    }

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
        try{
            msgError = null;
            client = clientsEJB.getClientByLoginAndPassword(client.getLogin(), client.getPassword());
            isLogged = true;
            return "index";
        } catch(GetUserException e)
        {
            if(interMb.getLocale().getLanguage().equals("fr"))
                msgError = e.getMessageFr();
            else
                msgError = e.getMessageEn();
            return "connexion";
        }
    }
}
