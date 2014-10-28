/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.rodriguez.entity;

/**
 *
 * @author Elvis
 */
public class Jugador {
    private Integer id;
    private String nombre;
    private String consola;

    public Jugador(Integer id, String nombre, String consola) {
        this.id = id;
        this.nombre = nombre;
        this.consola = consola;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getConsola() {
        return consola;
    }

    public void setConsola(String consola) {
        this.consola = consola;
    }
    
}
