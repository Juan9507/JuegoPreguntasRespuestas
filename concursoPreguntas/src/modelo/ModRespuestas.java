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
public class ModRespuestas {
  private int id_respuestas;
  public String opcion;
  public boolean valor_booleano;
  private int id_preguntas;
  
  public ModRespuestas(){
    
  }
  
  public ModRespuestas(int id_respuestas, String opcion, boolean valor_booleano, int id_preguntas){
    this.id_preguntas = id_preguntas;
    this.opcion = opcion;
    this.valor_booleano = valor_booleano;
    this.id_respuestas = id_respuestas;
  }

  public int getId_respuestas() {
    return id_respuestas;
  }

  public void setId_respuestas(int id_respuestas) {
    this.id_respuestas = id_respuestas;
  }

  public String getOpcion() {
    return opcion;
  }

  public void setOpcion(String opcion) {
    this.opcion = opcion;
  }

  public boolean isValor_booleano() {
    return valor_booleano;
  }

  public void setValor_booleano(boolean valor_booleano) {
    this.valor_booleano = valor_booleano;
  }

  public int getId_preguntas() {
    return id_preguntas;
  }

  public void setId_preguntas(int id_preguntas) {
    this.id_preguntas = id_preguntas;
  }
  
  
}
