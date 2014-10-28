/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.rodriguez.ui;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import pe.edu.rodriguez.entity.Jugador;

/**
 *
 * @author Elvis
 */
public class Program {
    
    
    public static void main(String[] args) throws Exception {
        List jugadores = new ArrayList();      
    
        for (int i = 1; i <= 3; i++)     
        {         
            jugadores.add(new Jugador(i, "Jugador " + i, "Wii"));     
        }      

        for (int i = 4; i <= 5; i++)     
        {         
            jugadores.add(new Jugador(i, "Jugador " + i, "XBox"));     
        }
        
        for (int i = 6; i <= 10; i++)     
        {         
            jugadores.add(new Jugador(i, "Jugador " + i, "PS3"));     
        }      

        JasperReport reporte = (JasperReport) JRLoader.loadObject("reporteGrupo.jasper");
        JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(jugadores));      

        JRExporter exporter = new JRPdfExporter();     
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);     
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new File("reporteGrupo.pdf"));      

        exporter.exportReport();
    }
}
