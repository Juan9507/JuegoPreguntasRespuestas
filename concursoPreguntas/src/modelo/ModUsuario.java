/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Juan David Rivera
 */
public class ModUsuario {
  private int id_jugador;
  public String nombre;
  public String apellido;
  public String correo;
  public String acumulado;
  
  public ModUsuario(){
    
  }
  
  public ModUsuario(int id_jugador, String nombre, String apellido, String correo, String acumulado){
    this.id_jugador = id_jugador;
    this.nombre = nombre;
    this.apellido = apellido;
    this.correo = correo;
    this.acumulado = acumulado;
  }

  public int getId_jugador() {
    return id_jugador;
  }

  public void setId_jugador(int id_jugador) {
    this.id_jugador = id_jugador;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public String getCorreo() {
    return correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  public String getAcumulado() {
    return acumulado;
  }

  public void setAcumulado(String acumulado) {
    this.acumulado = acumulado;
  }
  
  
}
