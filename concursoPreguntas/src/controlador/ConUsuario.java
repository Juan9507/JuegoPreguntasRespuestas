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
import javax.swing.JOptionPane;
import modelo.ModCategoria;
import modelo.ModUsuario;

/**
 *
 * @author Juan David Rivera
 */
public class ConUsuario {

  public void guardar(ModUsuario usuario) {
    String sql = "insert into jugador(nombre,apellido,correo,acumulado)"
            + "values ('" + usuario.getNombre() + "','" + usuario.getApellido() + "','" + usuario.getCorreo() + "'," + usuario.getAcumulado() + ")";
    Conexion con = new Conexion();
    try {
      if (con.ejecutar(sql)) {
        JOptionPane.showMessageDialog(null, "Sus datos fueron guardados satisfactoriamente");
      } else {
        JOptionPane.showMessageDialog(null, "Error sus datos NO fueron guardados");
      }

    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Error en guardar : " + e);
    }
  }

  public ArrayList<ModUsuario> consultUsuario() {
    Conexion con = new Conexion();
    ArrayList<ModUsuario> listausuario = new ArrayList();
    String sql = "select * from jugador";
    ResultSet rs;
    try {
      rs = con.consultar(sql);
      while (rs.next()) {
        ModUsuario modusuario = new ModUsuario();
        modusuario.setId_jugador(rs.getInt("id_jugador"));
        modusuario.setNombre(rs.getString("nombre"));
        modusuario.setApellido(rs.getString("apellido"));
        modusuario.setCorreo(rs.getString("correo"));
        modusuario.setAcumulado(rs.getString("acumulado"));
        listausuario.add(modusuario);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("Error en la consulta : " + e);
    }
    return listausuario;
  }

  public ModUsuario consultUsuario(int id_usuario) {
    Conexion con = new Conexion();
    ModUsuario modusuario = new ModUsuario();
    ConUsuario conusuario = new ConUsuario();
    String sql = "select * from jugador where id_jugador=" + id_usuario;
    ResultSet rs;
    try {
      rs = con.consultar(sql);
      if (rs.next()) {
        modusuario.setId_jugador(rs.getInt("id_jugador"));
        modusuario.setNombre(rs.getString("nombre"));
        modusuario.setApellido(rs.getString("apellido"));
        modusuario.setCorreo(rs.getString("correo"));
        modusuario.setAcumulado(rs.getString("acumulado"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("Error en la consulta : " + e);
    }
    return modusuario;
  }

  public void modificar(int id_usuario, String acumulado) {
    String sql = "update jugador set acumulado='" + acumulado + "'" + "where id_jugador = " + id_usuario;
    Conexion con = new Conexion();
    try {
      if (con.ejecutar(sql)) {
        JOptionPane.showMessageDialog(null, "Sus acumulado se almaceno en su usuario");
      } else {
        JOptionPane.showMessageDialog(null, "Error sus datos NO fueron actualizados");
      }

    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Error en Modificar : " + e);
    }
  }
}
