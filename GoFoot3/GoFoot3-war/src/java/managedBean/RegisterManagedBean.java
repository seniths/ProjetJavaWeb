/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import ejb.ClientsEJBLocal;
import exception.SaveUserException;
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
@Named(value = "registerManagedBean")
@SessionScoped
public class RegisterManagedBean implements Serializable {
    @EJB
    private ClientsEJBLocal clientsEJB;
    @Inject
    private MessageManagedBean messageMB;
    @Inject
    private InternationalizationManagedBean interMB;
    
    private ClientModel client;
    private int day;
    private int month;
    private int year;
    private String repeatedPassword;

    public String getRepeatedPassword() {
        return repeatedPassword;
    }

    public void setRepeatedPassword(String repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ClientModel getClient() {
        return client;
    }

    public void setClient(ClientModel client) {
        this.client = client;
    }
    /**
     * Creates a new instance of RegisterManagedBean
     */
    public RegisterManagedBean() {
        client = new ClientModel();
    }
    
    public String register()
    {
        try{
            clientsEJB.saveUser(client);
            client = new ClientModel();
            return "connexion";
        } catch(SaveUserException e)
        {
            if(interMB.getLocale().getLanguage().equals("fr"))
                messageMB.setMessage(e.getMessageFr());
            else
                messageMB.setMessage(e.getMessageEn());
            return "message";
        }
        
    }
}
