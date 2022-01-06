/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.Random;
import modelo.ModCategoria;

/**
 *
 * @author 57317
 */
public class conJugador {
  
  public int nivel = 1;
  public String acumulado = "0";

  public conJugador() {

  }

  public int elegirCategoria() {
    ArrayList<ModCategoria> listacate = new ArrayList();
    ConCategoria consucategoria = new ConCategoria();
    listacate = consucategoria.consultaCategoria();
    Random aleatorio = new Random();
    int ramdomIndex = aleatorio.nextInt(listacate.size());
    return listacate.get(ramdomIndex).getId_categoria();
    //for(int index = 0; index < listacate.size(); index ++){
    //System.out.println(listacate.get(index).getNombre());
    //}
  }

  public void acumulado(int nivel) {
    switch (nivel) {
      case 1:
        this.acumulado = "0";
        break;
      case 2:
        this.acumulado = "500000";
        break;
      case 3:
        this.acumulado = "1500000";
        break;
      case 4:
        this.acumulado = "5000000";
        break;
      case 5:
        this.acumulado = "20000000";
        break;
    }
  }
  
  public void aumentarNivel() {
    this.nivel++;
  }

  public void reiniciarNivel() {
    this.nivel = 1;
  }

  public int getNivel() {
    return nivel;
  }

  public void setNivel(int nivel) {
    this.nivel = nivel;
  }

  public String getAcumulado() {
    return acumulado;
  }

  public void setAcumulado(String acumulado) {
    this.acumulado = acumulado;
  }

}
