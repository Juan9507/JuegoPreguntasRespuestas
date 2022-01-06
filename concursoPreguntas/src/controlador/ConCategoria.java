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
import modelo.ModCategoria;

/**
 *
 * @author Juan David Rivera
 */
public class ConCategoria {

  public ArrayList<ModCategoria> consultaCategoria() {
    Conexion con = new Conexion();
    ArrayList<ModCategoria> listacate = new ArrayList();
    String sql = "select * from categoria";
    ResultSet rs;
    try {
      rs = con.consultar(sql);
      while(rs.next()){
        ModCategoria cate = new ModCategoria();
        cate.setId_categoria(rs.getInt("id_categoria"));
        cate.setNombre(rs.getString("nombre_categoria"));
        
        listacate.add(cate);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("Error en la consulta : " + e);
    }
    return listacate;
  }
  
  public ArrayList<ModCategoria> consultaCategoriaId(int id) {
    Conexion con = new Conexion();
    ArrayList<ModCategoria> listacateId = new ArrayList();
    String sql = "select * from categoria where id_categoria = '" + id + "'";
    ResultSet rs;
    try {
      rs = con.consultar(sql);
      while(rs.next()){
        ModCategoria cateid = new ModCategoria();
        cateid.setId_categoria(rs.getInt("id_categoria"));
        cateid.setNombre(rs.getString("nombre_categoria"));
        listacateId.add(cateid);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("Error en la consulta : " + e);
    }
    return listacateId;
  }
}
