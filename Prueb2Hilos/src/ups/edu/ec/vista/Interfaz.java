/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.vista;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import ups.edu.ec.controlador.Controlador;
import ups.edu.ec.modelo.Cliente;
import ups.edu.ec.modelo.CuentaBancaria;
import ups.edu.ec.modelo.Recepcion;

/**
 *
 * @author japch
 */
public class Interfaz extends javax.swing.JFrame {
    
private static final int numCajeras = 3;
    /**
     * Creates new form Interfaz
     */
    public Interfaz() throws InterruptedException {
        initComponents();
                
        CuentaBancaria cuenta = new CuentaBancaria(100);
        Controlador cn= new Controlador();
        Random r = new Random();
    
        final int Nopciones_100 = 41; // son 40        
        final int Nopciones_50  = 21;//20
        final int Nopciones_20  = 61;//60
       
        int v1=100;
        int v11=-100;
        int v2=50;
        int v22=-50;
        int v3=20;
        int v33=-20;
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        
        Thread[] hilosIngresan100 = new Thread[Nopciones_100];
        Thread[] hilosRetiran100  = new Thread[Nopciones_100];
        Thread[] hilosIngresan50  = new Thread[Nopciones_50];
        Thread[] hilosRetiran50   = new Thread[Nopciones_50];
        Thread[] hilosIngresan20  = new Thread[Nopciones_20];
        Thread[] hilosRetiran20   = new Thread[Nopciones_20];

        /* Arrancamos todos los hilos*/
        
        for (int i=1; i<Nopciones_100;i++){
             int Low = 5;
	     int High = 10;
	     int Result = r.nextInt(High-Low) + Low;
                Cliente ingresa = new Cliente(cuenta, v1, "Cliente "+i, new int[] { Result });
               Cliente retira = new Cliente(cuenta, v11, "Cliente "+i, new int[] { Result });
               clientes.add(new Cliente(cuenta, v1, "Cliente "+i, new int[] { Result }));
               
            hilosIngresan100[i]= new Thread(ingresa);
            hilosRetiran100[i] = new Thread(retira);
         //   System.out.println("Cuenta "+"decliente: "+i+" "+cuenta.getSaldo());
              hilosIngresan100[i].start();
              hilosRetiran100[i].start();
        }

        
        
        
            /*
            ///////////*/
           System.out.println("------------------->Los que depositaran 50<---------------");
           /* ///////////
            */
        for (int i=1; i<Nopciones_50;i++){
             int Low = 5;
	     int High = 10;
	     int Result = r.nextInt(High-Low) + Low;   
               Cliente ingresa = new Cliente(cuenta, v2, "Cliente "+i, new int[] { Result });
               Cliente retira = new Cliente(cuenta, v22, "Cliente "+i, new int[] { Result });
               clientes.add(new Cliente(cuenta, v2, "Cliente "+i, new int[] { Result }));

            hilosIngresan50[i]= new Thread(ingresa);
            hilosRetiran50[i] = new Thread(retira);

            hilosIngresan50[i].start();
            hilosRetiran50[i].start();
            
        }
            /*
            ///////////*/
           System.out.println("------------------->Los que depositaran 20<---------------");
           /* ///////////
            */

        for (int i=1; i<Nopciones_20;i++){
            int Low = 5;
	     int High = 10;
	     int Result = r.nextInt(High-Low) + Low;   
               Cliente ingresa = new Cliente(cuenta, v3, "Cliente "+i, new int[] { Result });
               Cliente retira = new Cliente(cuenta, v33, "Cliente "+i, new int[] { Result });
               clientes.add(new Cliente(cuenta, v3, "Cliente "+i, new int[] { Result }));

            hilosIngresan20[i]= new Thread(ingresa);
            hilosRetiran20[i] = new Thread(retira);

            hilosIngresan20[i].start();
            hilosRetiran20[i].start();
        }
        
            long init = System.currentTimeMillis();  // Instante inicial del procesamiento
            ExecutorService executor = Executors.newFixedThreadPool(numCajeras);
            for (Cliente cliente: clientes) {
                Runnable cajera = new Recepcion(cliente, init, cuenta);
                executor.execute(cajera);
            }
            executor.shutdown();	// Cierro el Executor
            while (!executor.isTerminated()) {
                    // Los precesos deben terminar de ejecutarsee
            }
            long fin = System.currentTimeMillis();	// Instante final del procesamiento
            System.out.println("Tiempo total de procesamiento: "+(fin-init)/1000+" Segundos");
        /* En este punto todos los hilos están arrancados,
        ahora toca esperarlos */

            for (int i=1; i<Nopciones_100;i++){
              //  System.out.println("valor "+i);
                hilosIngresan100[i].join();
                hilosRetiran100[i].join();
            }

            for (int i=1; i<Nopciones_50;i++){
                hilosIngresan50[i].join();
                hilosRetiran50[i].join();
            }

            for (int i=1; i<Nopciones_20;i++){
                hilosIngresan20[i].join();
                hilosRetiran20[i].join();
            }
        
            if (cuenta.esSimulacionCorrecta()){
                System.out.println("La simulación fue correcta");
            } else {
                System.out.println("La simulación falló ");
                System.out.println("La cuenta tiene:"+
                        cuenta.getSaldo());
                System.out.println("Revise sus synchronized");
            }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton12 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();

        jButton12.setText("jButton2");

        jButton11.setText("jButton2");

        jButton10.setText("jButton2");

        jButton9.setText("jButton2");

        jButton13.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/persona1.jpg"))); // NOI18N
        jLabel1.setText("Recepcion1");

        jButton1.setText("Cajera1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/persona1.jpg"))); // NOI18N
        jLabel2.setText("Recepcion1");

        jButton4.setText("Cajera2");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/persona1.jpg"))); // NOI18N
        jLabel3.setText("Recepcion1");

        jButton5.setText("Cajera3");

        jButton2.setText("P5");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("P3");

        jButton6.setText("P2");

        jButton7.setText("P1");

        jButton8.setText("P4");

        jButton14.setText("P6");

        jButton15.setText("P9");

        jButton16.setText("P10");

        jButton17.setText("P8");

        jButton18.setText("P7");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 252, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(85, 85, 85))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Interfaz().setVisible(true);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
