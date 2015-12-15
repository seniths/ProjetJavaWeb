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
public abstract class CustomException extends Exception{
    
    private String messageFr;
    private String messageEn;

    public String getMessageFr() {
        return messageFr;
    }

    public String getMessageEn() {
        return messageEn;
    }

    public void setMessageFr(String messageFr) {
        this.messageFr = messageFr;
    }

    public void setMessageEn(String messageEn) {
        this.messageEn = messageEn;
    }

}
