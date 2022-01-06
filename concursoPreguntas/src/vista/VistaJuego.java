/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ConCategoria;
import controlador.ConPreguntas;
import controlador.ConRespuestas;
import controlador.ConUsuario;
import controlador.conJugador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import modelo.ModCategoria;
import modelo.ModPreguntas;
import modelo.ModRespuestas;
import modelo.ModUsuario;

/**
 *
 * @author 57317
 */
public class VistaJuego extends javax.swing.JFrame {

  /**
   * Creates new form VistaJuego
   */
  ArrayList<ModPreguntas> listapreguntas = new ArrayList();
  ArrayList<ModCategoria> listacateId = new ArrayList();
  ArrayList<ModRespuestas> listarespuestas = new ArrayList();
  public static double txtacumulado;
  public static String respuestacorrecta;
  public static int nivel = 1;
  public int tiempoEnMilisegundos = 0; // Temporizador
  public int lapsoTiempo = 20;

  public VistaJuego() {
    initComponents();
    ocultarlbl();
    traerDatos();
    rondaUbicado();
    acumulado();
    ElegirCategoria();
    start();
  }

  Timer timer = new Timer(1000, new ActionListener() { //Timer para el temporizador
    @Override
    public void actionPerformed(ActionEvent ae) {
      lapsoTiempo = lapsoTiempo;
      tiempoEnMilisegundos = (lapsoTiempo--);
      lblPrueba.setText(Integer.toString(tiempoEnMilisegundos));
      if (tiempoEnMilisegundos == 0) {
        timer.stop();
        JOptionPane.showMessageDialog(null, "Se te acabo el tiempo");
        lblAcumulado.setText("0");
        almacenarAcumulado();
        dispose();
      }
      //JOptionPane.showMessageDialog(null, tiempoEnMilisegundos);
    }
  });

  public void start() { // iniciar el tiempo
    timer.start();
  }

  public void reset() {
    timer.stop();
    tiempoEnMilisegundos = 0; // Temporizador
    lapsoTiempo = 20;
    lblPrueba.setText(Integer.toString(tiempoEnMilisegundos));
  }
  
  public void ocultarlbl(){
    lblNombre.setVisible(false);
    lblApellido.setVisible(false);
    lblCorreo.setVisible(false);
  }

  public void traerDatos() {
    lblidusuario.setText(VistaInicio.textoId);
    lblNombre.setText(VistaInicio.textoNombre);
    lblApellido.setText(VistaInicio.textoApellido);
    lblCorreo.setText(VistaInicio.textoCorreo);
  }

  public void acumulado() {
    conJugador jugador = new conJugador();
    lblAcumulado.setText(jugador.getAcumulado());
  }

  public void rondaUbicado() {
    reset();
    start();
    lblRondaDato.setText(Integer.toString(nivel));
  }

  public void ElegirCategoria() {
    conJugador jugador = new conJugador();
    int elegircategoria = jugador.elegirCategoria();
    //nivel = jugador.getNivel();
    System.out.println("Desde categoria " + nivel);
    ConCategoria concategoria = new ConCategoria();
    listacateId = concategoria.consultaCategoriaId(elegircategoria);
    for (int index = 0; index < listacateId.size(); index++) {
      //System.out.println(listacateId.get(index).getNombre());
      lblDatoCate.setText(listacateId.get(index).getNombre());
    }
    mostrarCategoria(elegircategoria, nivel);
  }

  public void mostrarCategoria(int elegircategoria, int nivel) {
    ConPreguntas conpreguntas = new ConPreguntas();
    listapreguntas = conpreguntas.consultaPregunta(elegircategoria, nivel);
    //System.out.println("jajaja" + listapreguntas.get(1).getId_preguntas());
    for (int index = 0; index < listapreguntas.size(); index++) {
      //System.out.println(listapreguntas.get(index).getId_preguntas());
      lblPregunta.setText(listapreguntas.get(index).getNombre());
      String imgPre = "/imagenes/"+listapreguntas.get(index).getImg();
      lblimgPregunta.setIcon(new ImageIcon(getClass().getResource(imgPre)));
      mostrarOpciones(listapreguntas.get(index).getId_preguntas());
    }
  }

  public void mostrarOpciones(int id_pregunta) {
    System.out.println("desde opcioones" + id_pregunta);
    ConRespuestas conrespuestas = new ConRespuestas();
    listarespuestas = conrespuestas.consultaRespuestas(id_pregunta);
    jRadioButton1.setText(listarespuestas.get(0).getOpcion());
    jRadioButton2.setText(listarespuestas.get(1).getOpcion());
    jRadioButton3.setText(listarespuestas.get(2).getOpcion());
    jRadioButton4.setText(listarespuestas.get(3).getOpcion());
    for (int index = 0; index < listarespuestas.size(); index++) {
      if (listarespuestas.get(index).isValor_booleano()) {
        respuestacorrecta = listarespuestas.get(index).getOpcion();
      }
      //System.out.println(listarespuestas.get(index).getOpcion());
    }
    System.out.println(respuestacorrecta);
  }

  public void aumentarNivel() {
    conJugador jugador = new conJugador();
    boolean confir = retirarme(); //Pregunta para saber si quiere seguir o no 
    if (confir) {
      if (nivel < 5) {
        nivel++;
        System.out.println("desde aumentar nivel " + nivel);
        jugador.acumulado(nivel);
        lblAcumulado.setText(jugador.getAcumulado());
        rondaUbicado();
        ElegirCategoria();
      } else {
        JOptionPane.showMessageDialog(null, "Felicidades ganaste el gran premio");
        //int id_usuario = Integer.valueOf(lblidusuario.getText());
        almacenarAcumulado();
        dispose();
      }
    } else {
      almacenarAcumulado();
      System.out.println("Me retiro");
      dispose();
    }
  }

  public boolean retirarme() {
    boolean confirmacion;
    int resp = JOptionPane.showConfirmDialog(null, "Quieres continuar tu acumulado es de " + lblAcumulado.getText());
    if (JOptionPane.OK_OPTION == resp) {
      confirmacion = true;
    } else {
      confirmacion = false;
    }
    return confirmacion;
  }

  public void almacenarAcumulado() {
    ConUsuario conusuario = new ConUsuario();
    ModUsuario modusuario = new ModUsuario();
    modusuario.setNombre(lblNombre.getText());
    modusuario.setApellido(lblApellido.getText());
    modusuario.setCorreo(lblCorreo.getText());
    modusuario.setAcumulado(lblAcumulado.getText());
    conusuario.guardar(modusuario);
    //ConUsuario conusuario = new ConUsuario();
    //ModUsuario modusuario = new ModUsuario();
    //modusuario = conusuario.consultUsuario(1);
    //System.out.println(modusuario.getNombre());
    //System.out.println(modusuario.getAcumulado());
    //conusuario.modificar(id_usuario, lblAcumulado.getText());
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    buttonGroupOpciones = new javax.swing.ButtonGroup();
    jPanel1 = new javax.swing.JPanel();
    lblidusuario = new javax.swing.JLabel();
    lblNombreAcumulado = new javax.swing.JLabel();
    lblAcumulado = new javax.swing.JLabel();
    lblNombreCate = new javax.swing.JLabel();
    lblDatoCate = new javax.swing.JLabel();
    lblPregunta = new javax.swing.JLabel();
    jRadioButton1 = new javax.swing.JRadioButton();
    jRadioButton3 = new javax.swing.JRadioButton();
    jRadioButton4 = new javax.swing.JRadioButton();
    jRadioButton2 = new javax.swing.JRadioButton();
    btnValidarOpcion = new javax.swing.JButton();
    lblronda = new javax.swing.JLabel();
    lblRondaDato = new javax.swing.JLabel();
    lblPrueba = new javax.swing.JLabel();
    lblNombre = new javax.swing.JLabel();
    lblApellido = new javax.swing.JLabel();
    lblCorreo = new javax.swing.JLabel();
    lblimgPregunta = new javax.swing.JLabel();
    lblfondo = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    lblidusuario.setText("jLabel1");
    jPanel1.add(lblidusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, -1, -1));

    lblNombreAcumulado.setFont(new java.awt.Font("Ebrima", 2, 18)); // NOI18N
    lblNombreAcumulado.setForeground(new java.awt.Color(255, 255, 255));
    lblNombreAcumulado.setText("ACUMULADO:");
    jPanel1.add(lblNombreAcumulado, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 130, 30));

    lblAcumulado.setFont(new java.awt.Font("Ebrima", 2, 18)); // NOI18N
    lblAcumulado.setForeground(new java.awt.Color(255, 255, 255));
    lblAcumulado.setText("0");
    jPanel1.add(lblAcumulado, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 130, 30));

    lblNombreCate.setFont(new java.awt.Font("Ebrima", 2, 18)); // NOI18N
    lblNombreCate.setForeground(new java.awt.Color(255, 255, 255));
    lblNombreCate.setText("Categoria:");
    jPanel1.add(lblNombreCate, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, -1));

    lblDatoCate.setFont(new java.awt.Font("Ebrima", 2, 18)); // NOI18N
    lblDatoCate.setForeground(new java.awt.Color(255, 255, 255));
    lblDatoCate.setText("Buscando");
    jPanel1.add(lblDatoCate, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 150, -1));

    lblPregunta.setFont(new java.awt.Font("Ebrima", 3, 14)); // NOI18N
    lblPregunta.setForeground(new java.awt.Color(255, 255, 255));
    lblPregunta.setText("pregunta");
    lblPregunta.setAutoscrolls(true);
    lblPregunta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jPanel1.add(lblPregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 550, 30));

    buttonGroupOpciones.add(jRadioButton1);
    jRadioButton1.setFont(new java.awt.Font("Ebrima", 3, 14)); // NOI18N
    jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
    jRadioButton1.setText("opcion1");
    jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jRadioButton1ActionPerformed(evt);
      }
    });
    jPanel1.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 390, -1));

    buttonGroupOpciones.add(jRadioButton3);
    jRadioButton3.setFont(new java.awt.Font("Ebrima", 3, 14)); // NOI18N
    jRadioButton3.setForeground(new java.awt.Color(255, 255, 255));
    jRadioButton3.setText("opcion3");
    jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jRadioButton3ActionPerformed(evt);
      }
    });
    jPanel1.add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 420, 390, -1));

    buttonGroupOpciones.add(jRadioButton4);
    jRadioButton4.setFont(new java.awt.Font("Ebrima", 3, 14)); // NOI18N
    jRadioButton4.setForeground(new java.awt.Color(255, 255, 255));
    jRadioButton4.setText("opcion4");
    jPanel1.add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 470, 390, -1));

    buttonGroupOpciones.add(jRadioButton2);
    jRadioButton2.setFont(new java.awt.Font("Ebrima", 3, 14)); // NOI18N
    jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
    jRadioButton2.setText("opcion2");
    jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jRadioButton2ActionPerformed(evt);
      }
    });
    jPanel1.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 390, -1));

    btnValidarOpcion.setText("RESPONDER");
    btnValidarOpcion.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnValidarOpcionActionPerformed(evt);
      }
    });
    jPanel1.add(btnValidarOpcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 520, -1, -1));

    lblronda.setFont(new java.awt.Font("Ebrima", 3, 14)); // NOI18N
    lblronda.setForeground(new java.awt.Color(255, 255, 255));
    lblronda.setText("Ronda:");
    jPanel1.add(lblronda, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 69, 60, 30));

    lblRondaDato.setForeground(new java.awt.Color(255, 255, 255));
    lblRondaDato.setText("0");
    jPanel1.add(lblRondaDato, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 76, -1, 20));

    lblPrueba.setForeground(new java.awt.Color(255, 255, 255));
    lblPrueba.setText("0");
    jPanel1.add(lblPrueba, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, 20, -1));

    lblNombre.setText("nombre");
    jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, -1, -1));

    lblApellido.setText("apellido");
    jPanel1.add(lblApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, -1, -1));

    lblCorreo.setText("correo");
    jPanel1.add(lblCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, -1, -1));
    jPanel1.add(lblimgPregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 390, 70));

    lblfondo.setBackground(new java.awt.Color(255, 255, 255));
    lblfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/preguntasfondo_1.jpg"))); // NOI18N
    jPanel1.add(lblfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 560));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_jRadioButton1ActionPerformed

  private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_jRadioButton3ActionPerformed

  private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_jRadioButton2ActionPerformed

  private void btnValidarOpcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidarOpcionActionPerformed

    if (jRadioButton1.isSelected()) {
      if (jRadioButton1.getText().equals(respuestacorrecta)) {
        timer.stop();
        JOptionPane.showMessageDialog(null, "Respuesta correcta");
        aumentarNivel();
      }else{
        JOptionPane.showMessageDialog(null, "Respuesta Incorrecta");
        lblAcumulado.setText("0");
        almacenarAcumulado();
        dispose();
      }
    } else if (jRadioButton2.isSelected()) {
      if (jRadioButton2.getText().equals(respuestacorrecta)) {
        timer.stop();
        JOptionPane.showMessageDialog(null, "Respuesta correcta");
        aumentarNivel();
      }else{
        JOptionPane.showMessageDialog(null, "Respuesta Incorrecta");
        lblAcumulado.setText("0");
        almacenarAcumulado();
        dispose();
      }
    } else if (jRadioButton3.isSelected()) {
      if (jRadioButton3.getText().equals(respuestacorrecta)) {
        timer.stop();
        JOptionPane.showMessageDialog(null, "Respuesta correcta");
        aumentarNivel();
      }else{
        JOptionPane.showMessageDialog(null, "Respuesta Incorrecta");
        lblAcumulado.setText("0");
        almacenarAcumulado();
        dispose();
      }
    } else if (jRadioButton4.isSelected()) {
      if (jRadioButton4.getText().equals(respuestacorrecta)) {
        timer.stop();
        JOptionPane.showMessageDialog(null, "Respuesta correcta");
        aumentarNivel();
      }else{
        JOptionPane.showMessageDialog(null, "Respuesta Incorrecta");
        lblAcumulado.setText("0");
        almacenarAcumulado();
        dispose();
      }
    }
  }//GEN-LAST:event_btnValidarOpcionActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(VistaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(VistaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(VistaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(VistaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new VistaJuego().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnValidarOpcion;
  private javax.swing.ButtonGroup buttonGroupOpciones;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JRadioButton jRadioButton1;
  private javax.swing.JRadioButton jRadioButton2;
  private javax.swing.JRadioButton jRadioButton3;
  private javax.swing.JRadioButton jRadioButton4;
  private javax.swing.JLabel lblAcumulado;
  private javax.swing.JLabel lblApellido;
  private javax.swing.JLabel lblCorreo;
  private javax.swing.JLabel lblDatoCate;
  private javax.swing.JLabel lblNombre;
  private javax.swing.JLabel lblNombreAcumulado;
  private javax.swing.JLabel lblNombreCate;
  private javax.swing.JLabel lblPregunta;
  private javax.swing.JLabel lblPrueba;
  private javax.swing.JLabel lblRondaDato;
  private javax.swing.JLabel lblfondo;
  private javax.swing.JLabel lblidusuario;
  private javax.swing.JLabel lblimgPregunta;
  private javax.swing.JLabel lblronda;
  // End of variables declaration//GEN-END:variables
}
