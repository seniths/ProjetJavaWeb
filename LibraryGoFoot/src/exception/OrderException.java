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
public class OrderException extends CustomException{
    
    public OrderException() {
        setMessageFr("Commande échouée!");
        setMessageEn("Order failed!");
    }
    
}
