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
public class GetCategoriesException extends CustomException{

    public GetCategoriesException() {
        setMessageFr("Erreur lors de la récupération des catégories!");
        setMessageEn("Error retrieving categories!");
    }
    
}
