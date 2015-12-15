/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

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
    public Boolean saveUser(ClientModel client) {
        try {
            client.setPassword(encrypt(client.getPassword()));
            clientFacade.saveClient(client);
            return true;
        } catch (Exception e) {
            return false;
        }
    }    

    @Override
    public ClientModel getClientByLoginAndPassword(String login, String password) {
        try
        {
            ClientModel client = clientFacade.getClientByLogin(login);
            String decodedPwd = decrypt(client.getPassword());
            if(decodedPwd.equals(password))
                return client;
            return null;
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
    private Key generateKey() throws Exception {
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
