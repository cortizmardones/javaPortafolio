package cl.segurosporsiempre.Data;

import cl.segurosporsiempre.Connection.Conexion;
import cl.segurosporsiempre.Model.ContadorVisita;

public class PruebasDao {

    public static void main(String[] args) {

        Conexion conn = new Conexion();
        VisitaDAO vDto = new VisitaDAO(conn);

        //System.out.println(vDto.obtenerCantidadVisitasAlternativo());
        for (ContadorVisita i : vDto.obtenerCantidadVisitasRealizadas()) {
            System.out.println(i.getContador());
        }
    }

}
