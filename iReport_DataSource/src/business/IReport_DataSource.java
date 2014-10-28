/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entity.Usuario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author Elvis
 */
public class IReport_DataSource {

    
    public static void main(String[] args) throws Exception {
        
        List listaUsuarios = new ArrayList();

        for (int i = 1; i <= 100; i++) 
        {
            Usuario user = new Usuario("Nombre " + i, "Username " + i, "Password " + i, i+100);
            listaUsuarios.add(user);
        } 

        Map<String, Object> parametros = new HashMap<>();
        parametros.put("autor", "Elvis Maldonado");
        parametros.put("titulo", "Lista de Usuarios Conectados");

        JasperReport reporte = (JasperReport) JRLoader.loadObject("reportDataSource.jasper");

        JasperPrint jasperPrint;
        jasperPrint = JasperFillManager.fillReport(reporte, parametros, new JRBeanCollectionDataSource(listaUsuarios));

        JRExporter exporter = new JRPdfExporter(); 
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("dataSourceDirecto.pdf")); 
        exporter.exportReport();
    }
    
}
