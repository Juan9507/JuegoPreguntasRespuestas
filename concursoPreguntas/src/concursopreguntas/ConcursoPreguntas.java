/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concursopreguntas;

/**
 *
 * @author Juan David Rivera
 */
import conexion.Conexion;
import java.util.ArrayList;
import modelo.ModCategoria;
import controlador.ConCategoria;
import controlador.ConPreguntas;
import controlador.ConRespuestas;
import controlador.ConUsuario;
import controlador.conJugador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.System.console;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import modelo.ModPreguntas;
import modelo.ModRespuestas;
import modelo.ModUsuario;
import vista.VistaInicio;
import vista.VistaJuego;

public class ConcursoPreguntas {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    VistaInicio abrir = new VistaInicio();
    abrir.setVisible(true);
    //VistaInicio inicio = new VistaInicio();
    //inicio.setVisible(true);
    /**ArrayList<ModPreguntas> listapreguntas = new ArrayList();
    ArrayList<ModRespuestas> listarespuestas = new ArrayList();
    conJugador jugador = new conJugador();
    int elegircategoria = jugador.elegirCategoria();
    System.out.println(elegircategoria);
    int nivel = jugador.getNivel();
    System.out.println(nivel);
    ConPreguntas conpreguntas = new ConPreguntas();
    listapreguntas = conpreguntas.consultaPregunta(elegircategoria, nivel);
    for (int index = 0; index < listapreguntas.size(); index++) {
      System.out.println(listapreguntas.get(index).getNombre());
    }
    jugador.aumentarNivel();
    nivel = jugador.getNivel();
    jugador.aumentarNivel();
    nivel = jugador.getNivel();
    jugador.aumentarNivel();
    nivel = jugador.getNivel();
    jugador.acumulado(nivel);
    System.out.println("VALIDANDO NIVEL " + nivel);
    System.out.println(jugador.getAcumulado());

    ConRespuestas conrespuestas = new ConRespuestas();
    listarespuestas = conrespuestas.consultaRespuestas(listapreguntas.get(0).getId_preguntas());
    for (int index = 0; index < listarespuestas.size(); index++) {
      System.out.println(listarespuestas.get(index).getOpcion());
    }*/

    //ConUsuario conusuario = new ConUsuario();
    //ModUsuario modusuario = new ModUsuario();
    //modusuario = conusuario.consultUsuario(1);
    //System.out.println(modusuario.getNombre());
    //System.out.println(modusuario.getAcumulado());

  }

}
