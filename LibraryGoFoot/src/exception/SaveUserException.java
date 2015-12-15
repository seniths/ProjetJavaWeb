/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Maxime
 */
public class SaveUserException extends CustomException{

    public SaveUserException() {
        setMessageFr("Erreur lors la création du compte!");
        setMessageEn("Error creating the account!");
    }
    
}
