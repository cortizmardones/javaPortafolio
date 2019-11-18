/*
 * Portafolio de título
 * Seguros por siempre
 */
package cl.segurosporsiempre.Model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Raúl Pardo Zurita
 */
public class Utils {

    public static String MD5(String input) {
        try {
            String algoritmo = "MD5";
            MessageDigest md = MessageDigest.getInstance(algoritmo);
            byte[] ab = md.digest(input.getBytes());
            BigInteger bi = new BigInteger(1, ab);
            String hash = bi.toString(16);

            while (hash.length() < 32) {
                hash = "0" + hash;
            }

            return hash;

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static String FECHATRANSFORMADA(String fecha) {

        String dia = fecha.substring(8, 10);
        String mes = fecha.substring(5, 7);
        String anio = fecha.substring(0, 4);
        String hora = fecha.substring(11);

        return dia + "-" + mes + "-" + anio + " " + hora;

    }
    
    
    public static boolean enviarCorreo(String de, String clave, String para, String mensaje, String asunto) {
        boolean enviado = false;
        try {

            String host = "smtp.gmail.com";

            Properties prop = System.getProperties();

            prop.put("mail.smtp.starttls.enable", "true");
            prop.put("mail.smtp.host", host);
            prop.put("mail.smtp.user", de);
            prop.put("mail.smtp.password", clave);
            prop.put("mail.smtp.port", 587);
            prop.put("mail.smtp.auth", "true");

            Session sesion = Session.getDefaultInstance(prop, null);

            MimeMessage message = new MimeMessage(sesion);

            message.setFrom(new InternetAddress(de));

            message.setRecipient(Message.RecipientType.TO, new InternetAddress(para));

            message.setSubject(asunto);
            message.setText(mensaje);

            Transport transport = sesion.getTransport("smtp");

            transport.connect(host, de, clave);

            transport.sendMessage(message, message.getAllRecipients());

            transport.close();

            enviado = true;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return enviado;
    }
    
    
    public static String rGen ()
    {
        Random rnd = new Random();
        String abc = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        String cadena = "";
        int m, posicion, numero;
        m = 0;
        posicion = 0;
        while (m < 1)
        {
            posicion = (int) (rnd.nextDouble() * abc.length()-1+0);
            numero = (int) (rnd.nextDouble() * 9999 + 1000);
            cadena = cadena + abc.charAt(posicion)+numero;
            posicion = (int) (rnd.nextDouble() * abc.length()-1+0);   
            cadena = cadena + abc.charAt(posicion);   
            m++;
        }
        
        return cadena;
    }
}