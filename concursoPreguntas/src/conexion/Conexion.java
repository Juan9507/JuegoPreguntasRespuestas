/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

/**
 *
 * @author Juan David Rivera
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion implements Configuracion {

  private static Connection con = null; //VARIABLE PARA LA CONEXION
  //CONECTAR DIRECTAMENTE

  static {
    try {
      Class.forName(DRIVER); // LE PASAMOS EL NOMBRE DE ESPACIO QUE TRAE EL CONECTOR PARA MYSQL (SE CARGA MEDIANTE EL METODO forName() DE LA CLASE  java.lang.Class)
      con = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);// SINTAXIS PARA REALIZAR LA CONEXION
      if (con != null) {
        System.out.println("Conexion exitosa");
      } else {
        System.out.println("Conexion fallida");
      }
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
      System.out.println("Error en conexión : " + e);
    }
  }

  public static Connection getConnection() {//METODO DE TIPO CONNECTION PARA RETONAR LA CONEXION 
    return con;
  }

  public void Cerrar() {
    try {
      con.close();
      System.out.println("Desconectado");
    } catch (SQLException e) {
      System.out.println("Error en cerrar : " + e);
    }

  }

  public boolean ejecutar(String sql) { // METODO PARA EJECUTAR SENTENCIAS INSERT, UPDATE, DELETE
    boolean var; //VARIABLE PARA RETORNAR TRUE O FALSE AL EJECUTAR INSERT, UPDATE, DELETE
    try {
      Statement sentencia; // SIRVE PARA PROCESAR UNA SENTENCIA SQL ESTATICA Y OBTENER LOS RESULTADOS PRODUCIDOS
      sentencia = getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY); // CREA UN OBJETO STATEMENT PARA CREAR UN OBJETO RESULTSET DE SOLO LECTURA Y ENVIO
      if (sentencia.executeUpdate(sql) == 0) { // EXECUTEUPDATE NOS DEVUELVE UN ENTERO QUE NOS DICE EL NUMERO DE REGISTROS A LOS QUE HA AFECTADO LA OPERACION EN CASO DE SENTENCIAS INSERT, UPDATE, DELETE
        var = false;

      } else {
        var = true;
      }

    } catch (SQLException e) {
      e.printStackTrace(); //printStackTrace() ayuda al programador a comprender dónde ocurrió el problema real
      System.out.println("Error en ejecución : " + e);
      var = false;
    }
    return var;
  }
  
  public ResultSet consultar(String sql){ // METODO PARA EJECUTAR SENTENCIAS SELECT
    ResultSet resultado; // VARIABLE RESULTSET DONDE SE ALACENA LA LISTA DE EL RESULTADO DE LA CONSULTA
    try {
      Statement sentencia;
      sentencia= getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
      resultado = sentencia.executeQuery(sql);
    } catch (SQLException e){
      e.printStackTrace();
      System.out.println("Error en la consulta : "+e);
      resultado = null;
    }
    return resultado;
  }
}
