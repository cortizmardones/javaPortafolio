/*
 * Portafolio de título
 * Seguros por siempre
 */
package cl.segurosporsiempre.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Raúl Pardo Zurita
 */
public class Conexion implements IConectable{

    private Connection conn = null;

    public Conexion() {
        try {
            Class.forName(NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            if (conn != null) {
                System.out.println("Conexión exitosa");
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Error con el driver");
        } catch (SQLException ex) {
            System.out.println("Error con la conexión");
        }
    }

    /**
     * Método de conexión
     *
     * @return la conexión activa
     */
    public Connection getConnection() {
        return conn;
    }

    public void cerrarConexion() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println("La conexión estaba vacía");
        }
    }
}
