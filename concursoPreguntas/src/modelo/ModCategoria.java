/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author 57317
 */
public class ModCategoria {

  private int id_categoria;
  public String nombre_categoria;

  public ModCategoria() {

  }

  public ModCategoria(int id_categoria, String nombre_categoria) {
    this.id_categoria = id_categoria;
    this.nombre_categoria = nombre_categoria;
  }

  public int getId_categoria() {
    return id_categoria;
  }

  public void setId_categoria(int id_categoria) {
    this.id_categoria = id_categoria;
  }

  public String getNombre() {
    return nombre_categoria;
  }

  public void setNombre(String nombre_categoria) {
    this.nombre_categoria = nombre_categoria;
  }

}
