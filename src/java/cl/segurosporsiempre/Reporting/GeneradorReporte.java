/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.segurosporsiempre.Reporting;

import cl.segurosporsiempre.Connection.Conexion;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author raulp
 */
public class GeneradorReporte {
    
    public static final String PATH_BASE_FUENTE_SERVIDOR = "/opt/apache-tomcat-8.5.45/webapps/ROOT/sourceRepo/CapacitacionesPrincipal.jasper";
    public static final String PATH_BASE_FUENTE_SERVIDOR_W = "C:\\Users\\raulp\\Documents\\NetBeansProjects\\web-segurosporsiempre\\web\\sourceRepo\\CapacitacionesPrincipal.jasper";
    public static final String PATH_BASE_REPORTES_SERVIDOR = "/opt/apache-tomcat-8.5.45/webapps/ROOT/reports";
    
    public static JasperPrint generarReporteCapacitaciones(Long idCapacitacion){
        
        try {
            
            HashMap<String, Object> params = new HashMap<>();
            params.put("idCapacitacion", idCapacitacion);
            
            Conexion c = new Conexion();
            JasperPrint reporteLleno = JasperFillManager.fillReport(PATH_BASE_FUENTE_SERVIDOR, params, c.getConnection());
            
            c.cerrarConexion();
            
            return reporteLleno;
            
        } catch (JRException ex) {
            
            Logger.getLogger(GeneradorReporte.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return null;
    }
    
    /*
    Generar desde el controlador     
  
        JasperPrint reporteLeno = ReportGenerator.generarReporteCapacitaciones();
        JasperExportManager.exportReportToPdfFile(reporteLeno,"reports/ReporteMaestroCapacitaciones.pdf");
    
        String url = "https://www.segurosporsiempre.cl/reports/ReporteMaestroCapacitaciones.pdf";
        
    */
}
