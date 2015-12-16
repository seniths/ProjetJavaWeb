/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import managedBean.ClientManagedBean;
import managedBean.InternationalizationManagedBean;

/**
 *
 * @author Maxime
 */
@FacesValidator("loginValidator")
public class LoginValidator implements Validator{

    @Inject
    private ClientManagedBean clientMB;
    @Inject
    private InternationalizationManagedBean interMB;
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String login = value.toString();
        ResourceBundle currentBundle = ResourceBundle.getBundle("language.lang",interMB.getLocale());
        
        if(login.length() < 5)
        {
            throw new ValidatorException(new FacesMessage(currentBundle.getString("wrongSizedLogin")));
        }
        
        if(clientMB.loginIsAvailable(login))
            return;
        else
        {
            throw new ValidatorException(new FacesMessage(currentBundle.getString("loginTaken")));
        }
    }
    
}
