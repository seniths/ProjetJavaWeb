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
public class GetUserException extends CustomException{

    public GetUserException() {
        setMessageFr("Combinaison login/mot de passse incorrecte!");
        setMessageEn("Combination login / password incorrect!");
    }
    
}
