/*
 * Portafolio de título
 * Seguros por siempre
 */
package cl.segurosporsiempre.Connection;

/**
 *
 * @author Raúl Pardo Zurita
 */
public interface IConectable {
    
    static final String NAME = "oracle.jdbc.driver.OracleDriver";  
    static final String URL = "jdbc:oracle:thin:@SERVIDOR:PUERTO:XE";
    static final String USER = "USUARIO";
    static final String PASSWORD = "CONSTRASEÑA";
}
