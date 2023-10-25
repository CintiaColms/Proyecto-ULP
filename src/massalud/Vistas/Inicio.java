/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package massalud.Vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicProgressBarUI;

/**
 *
 * @author Cintia
 */
public class Inicio extends javax.swing.JFrame {

  private Timer tiempo;
  int cont = 0;
  public final static int TWO_SECOND = 100;
  private javax.swing.JLabel cargandoLabel; // Etiqueta para mostrar "Cargando..."

  /**
   * Creates new form Inicio
   */
  public Inicio() {
    initComponents();
    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
     setIconImage(new ImageIcon(getClass().getResource("/massalud/Recursos/icon.png")).getImage());
    setLocationRelativeTo(null);
   

    // Inicializar el temporizador y comenzarlo
    tiempo = new Timer(TWO_SECOND, new timerListener());
    tiempo.start();

    // Configurar la barra de progreso
    Barra.setMinimum(0);
    Barra.setMaximum(100);
    Barra.setValue(0);
    // Cambia el color de carga
    Barra.setUI(new BasicProgressBarUI() {
        });
        
    // Configurar la etiqueta "Cargando..."
    cargandoLabel = new javax.swing.JLabel("Cargando...");
    cargandoLabel.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));    
    cargandoLabel.setForeground(new Color(0, 153, 153));
    cargandoLabel.setBounds(520, 630, 250, 40); // Establece la posición de la etiqueta
    inicio.add(cargandoLabel); // Agrega la etiqueta al JDesktopPane
    cargandoLabel.setVisible(true); // Asegura que la etiqueta sea visible inicialmente
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    ImageIcon icono=new ImageIcon(getClass().getResource("/massalud/Recursos/fini.png"));
    Image imagen=icono.getImage();
    inicio = new javax.swing.JDesktopPane(){
      public void paintComponent(Graphics g){
        g.drawImage(imagen,0,0,getWidth(),getHeight(),this);
      }
    }
    ;
    Barra = new javax.swing.JProgressBar();
    jLabel1 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setResizable(false);
    addWindowListener(new java.awt.event.WindowAdapter() {
      public void windowClosing(java.awt.event.WindowEvent evt) {
        formWindowClosing(evt);
      }
    });

    Barra.setBackground(new java.awt.Color(204, 102, 0));
    Barra.setForeground(new java.awt.Color(0, 153, 153));
    Barra.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 204, 153), new java.awt.Color(255, 102, 0), new java.awt.Color(102, 255, 255), new java.awt.Color(0, 255, 255)));
    Barra.setRequestFocusEnabled(false);

    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/massalud/Recursos/logoini.gif"))); // NOI18N

    jLabel3.setFont(new java.awt.Font("Segoe UI Black", 2, 36)); // NOI18N
    jLabel3.setForeground(new java.awt.Color(0, 204, 204));
    jLabel3.setText("La mutual que Más te cuida");

    jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
    jLabel2.setForeground(new java.awt.Color(204, 102, 0));
    jLabel2.setText("© Creado y Diseñado |G17~CDJL|");

    inicio.setLayer(Barra, javax.swing.JLayeredPane.DEFAULT_LAYER);
    inicio.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
    inicio.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
    inicio.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

    javax.swing.GroupLayout inicioLayout = new javax.swing.GroupLayout(inicio);
    inicio.setLayout(inicioLayout);
    inicioLayout.setHorizontalGroup(
      inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(inicioLayout.createSequentialGroup()
        .addGap(254, 254, 254)
        .addComponent(jLabel1)
        .addContainerGap(236, Short.MAX_VALUE))
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inicioLayout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inicioLayout.createSequentialGroup()
            .addGroup(inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
              .addComponent(Barra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(320, 320, 320))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inicioLayout.createSequentialGroup()
            .addComponent(jLabel2)
            .addGap(457, 457, 457))))
    );
    inicioLayout.setVerticalGroup(
      inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(inicioLayout.createSequentialGroup()
        .addGap(30, 30, 30)
        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel3)
        .addGap(52, 52, 52)
        .addComponent(Barra, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
        .addComponent(jLabel2)
        .addGap(58, 58, 58))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(inicio)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(inicio)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    // TODO add your handling code here:
     Object[] opciones = {"Si", "NO"};
    String nombre = "¿Está saliendo de MAS SALUD?";
    UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 18));
    UIManager.put("OptionPane.messageForeground", new Color(204, 102, 0));
// UIManager.put("OptionPane.buttonFont", new Font("Segoe UI", Font.BOLD, 16));
//    UIManager.put("OptionPane.buttonForeground", new Color(204, 204, 0));
    ImageIcon icono = new ImageIcon(getClass().getResource("/massalud/Recursos/icob.png"));
    int seleccion = JOptionPane.showOptionDialog(this, nombre, "Salir ", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icono, opciones, opciones[1]);

    if (seleccion == JOptionPane.YES_OPTION) {
      this.dispose();
    } else {
    }
  }//GEN-LAST:event_formWindowClosing

  /**
   * @param args the command line arguments
   */
  class timerListener implements ActionListener {

    public void actionPerformed(ActionEvent e) {
      cont++;
      Barra.setValue(cont);
      cargandoLabel.setText("Cargando... " + cont + "%");
      if (cont == 100) {
        tiempo.stop();
        esconderB();
        Login log = new Login();
        log.setVisible(true);
        setVisible(false);

      }
    }
  }

  public void esconderB() {
    this.setVisible(false);
  }

  public void activarB() {
    tiempo.start();
  }

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
      java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new Inicio().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JProgressBar Barra;
  private javax.swing.JDesktopPane inicio;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  // End of variables declaration//GEN-END:variables
}
