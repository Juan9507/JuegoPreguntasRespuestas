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
public class ModPreguntas {

  private int id_preguntas;
  public String nombre;
  public String img;
  private int id_categoria;
  private int id_nivel;

  public ModPreguntas() {

  }

  public ModPreguntas(int id_preguntas, String nombre, String img, int id_categoria, int id_nivel) {
    this.id_preguntas = id_preguntas;
    this.nombre = nombre;
    this.img = img;
    this.id_categoria = id_categoria;
    this.id_nivel = id_nivel;
  }

  public int getId_preguntas() {
    return id_preguntas;
  }

  public void setId_preguntas(int id_preguntas) {
    this.id_preguntas = id_preguntas;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getImg() {
    return img;
  }

  public void setImg(String img) {
    this.img = img;
  }

  public int getId_categoria() {
    return id_categoria;
  }

  public void setId_categoria(int id_categoria) {
    this.id_categoria = id_categoria;
  }

  public int getId_nivel() {
    return id_nivel;
  }

  public void setId_nivel(int id_nivel) {
    this.id_nivel = id_nivel;
  }

}
