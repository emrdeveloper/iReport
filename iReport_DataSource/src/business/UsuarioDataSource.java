/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entity.Usuario;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author Elvis
 */
public class UsuarioDataSource  implements JRDataSource {

    List<Usuario> listaUsuarios = new ArrayList<Usuario>();
    private int usuarioIndex = -1;
    
    @Override
    public boolean next() throws JRException {
        return ++usuarioIndex < listaUsuarios.size();
    }

    @Override
    public Object getFieldValue(JRField jrField) throws JRException {
        Object valor = null;
        
        if("nombre".equals(jrField.getName())) {
            valor = listaUsuarios.get(usuarioIndex).getNombre();
        } 
        else if("username".equals(jrField.getName())) {
            valor = listaUsuarios.get(usuarioIndex).getUsername();
        }
        else if("password".equals(jrField.getName())) {
            valor = listaUsuarios.get(usuarioIndex).getPassword();
        }
        else if("saldo".equals(jrField.getName())) {
            valor = listaUsuarios.get(usuarioIndex).getSaldo();
        }
        return valor;
    }
    
    public void addUsuario(Usuario usuario) {
        this.listaUsuarios.add(usuario);        
    }
    
}
