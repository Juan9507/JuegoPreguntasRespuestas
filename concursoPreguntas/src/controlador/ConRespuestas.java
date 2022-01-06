/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.ModRespuestas;

/**
 *
 * @author Juan David Rivera
 */
public class ConRespuestas {
  public ArrayList<ModRespuestas> consultaRespuestas(int id_preguntas){
    Conexion con = new Conexion();
    ArrayList<ModRespuestas> listaRespuesta = new ArrayList();
    String sql = "select * from respuestas where id_preguntas = '" + id_preguntas + "'";
    ResultSet rs;
    try{
      rs = con.consultar(sql);
      while(rs.next()){
        ModRespuestas modrespuestas = new ModRespuestas();
        modrespuestas.setId_respuestas(rs.getInt("id_respuestas"));
        modrespuestas.setOpcion(rs.getString("opcion"));
        modrespuestas.setValor_booleano(rs.getBoolean("valor_booleano"));
        modrespuestas.setId_preguntas(rs.getInt("id_preguntas"));
        listaRespuesta.add(modrespuestas);
      }
    }catch (SQLException e) {
      e.printStackTrace();
      System.out.println("Error en la consulta : " + e);
    }
    return listaRespuesta;
  }
}
