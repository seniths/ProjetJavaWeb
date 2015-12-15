/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import exception.GetUserException;
import exception.SaveUserException;
import java.security.Key;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.ClientModel;
import sessionFacade.ClientFacadeLocal;

/**
 *
 * @author Maxime
 */
@Stateless
public class ClientsEJB implements ClientsEJBLocal {
    @EJB
    private ClientFacadeLocal clientFacade;

    private static final String ALGORITHM = "AES";
    private static final byte[] keyValue = new byte[] { 'G', 'o', 'F', 'o', 'o', 'T', '3', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y' };
    
    @Override
    public void saveUser(ClientModel client) throws SaveUserException {
        try {
            client.setPassword(encrypt(client.getPassword()));
            clientFacade.saveClient(client);
        } catch (Exception e) {
            throw new SaveUserException();
        }
    }    

    @Override
    public ClientModel getClientByLoginAndPassword(String login, String password) throws GetUserException{
        try
        {
            ClientModel client = clientFacade.getClientByLogin(login);
            String decodedPwd = decrypt(client.getPassword());
            if(decodedPwd.equals(password))
                return client;
            else
                throw new GetUserException();
        }
        catch(Exception e)
        {
            throw new GetUserException();
        }
    }
    
    private Key generateKey() throws IllegalArgumentException {
        Key key = new SecretKeySpec(keyValue, ALGORITHM);
        return key;
    }
    
    public String encrypt(String valueToEnc) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encValue = c.doFinal(valueToEnc.getBytes());
        String encryptedValue = Base64.getEncoder().encodeToString(encValue);
        return encryptedValue;
    }
    
    public String decrypt(String encryptedValue) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = Base64.getDecoder().decode(encryptedValue);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }
    
}
