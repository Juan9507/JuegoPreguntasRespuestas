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
import modelo.ModPreguntas;

/**
 *
 * @author Juan David Rivera
 */
public class ConPreguntas {

  public ArrayList<ModPreguntas> consultaPregunta(int id_categoria, int id_nivel) {
    Conexion con = new Conexion();
    ArrayList<ModPreguntas> listapregun = new ArrayList();
    String sql = "SELECT * FROM preguntas WHERE id_categoria = '" + id_categoria + "' and id_nivel = '" + id_nivel + "' ";
    ResultSet rs;
    try {
      rs = con.consultar(sql);
      while (rs.next()) {
        ModPreguntas pregun = new ModPreguntas();
        pregun.setId_preguntas(rs.getInt("id_preguntas"));
        pregun.setNombre(rs.getString("nombre"));
        pregun.setImg(rs.getString("img"));
        pregun.setId_categoria(rs.getInt("id_categoria"));
        pregun.setId_nivel(rs.getInt("id_nivel"));
        listapregun.add(pregun);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("Error en la consulta : " + e);
    }
    return listapregun;
  }
}
