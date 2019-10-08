/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJOs;

/**
 *
 * @author inesu
 */
public class User {

    private String nombre;
    private int edad;
    private String usuario;
    private String contraseña;
    
    public User (String _usuario,String _contraseña, String _nombre, int _edad){
    usuario = _usuario;
    contraseña = _contraseña;
    nombre = _nombre;
    edad = _edad;
    
    }
         
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
    
    @Override
    public String toString() {
        return "Patient{" + "nombre=" + nombre + ", edad=" + edad + ", usuario=" + usuario + ", contrase\u00f1a=" + contraseña + '}';
    }
}
