/*
 * Portafolio de título
 * Seguros por siempre
 */
package cl.segurosporsiempre.Model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Raúl Pardo Zurita
 */
public class Utils {
    public static String MD5(String input)
    {
        try {
            String algoritmo = "MD5";
            MessageDigest md = MessageDigest.getInstance(algoritmo);
            byte[] ab = md.digest(input.getBytes());
            BigInteger bi = new BigInteger(1, ab);
            String hash = bi.toString(16);
            
            while (hash.length() < 32)
            {
                hash = "0"+hash;
            }
            
            return hash;
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }   
    }    
}
