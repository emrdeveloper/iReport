/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entity.Usuario;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author Elvis
 */
public class IReport_demo {

    public static void main(String[] args) throws Exception {
        UsuarioDataSource dataSource = new UsuarioDataSource();

        for (int i = 1; i <= 150; i++) {
            Usuario usuario = new Usuario("Nombre " + i, "Username " + i, "Password " + i, i + 100);
            dataSource.addUsuario(usuario);
        }
        
        JasperReport reporte = (JasperReport) JRLoader.loadObject("reportDataSource.jasper");
        JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, dataSource);

        JRExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("dataSourcePersonalizado.pdf"));
        exporter.exportReport();
    }
}
