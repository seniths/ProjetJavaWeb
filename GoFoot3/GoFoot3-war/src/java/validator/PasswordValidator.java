/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Maxime
 */
@FacesValidator("pwdValidator")
public class PasswordValidator implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String pwd = value.toString();
        
        UIInput uiInput = (UIInput)component.getAttributes().get("confirm");
        String confirmPassword = uiInput.getSubmittedValue().toString();
        
        if(pwd == null || pwd.isEmpty() || confirmPassword == null || confirmPassword.isEmpty())
            return;
        
        if(pwd.length() < 5 || pwd.length() > 20){
            uiInput.setValid(false);
            throw new ValidatorException(new FacesMessage("Veuillez entrer un mot de passe de 5 à 20 caractères!"));
        }
        
        if(!pwd.equals(confirmPassword)){
            uiInput.setValid(false);
            throw new ValidatorException(new FacesMessage("Les mots de passe doivent être identiques!"));
        }
    }
    
}
