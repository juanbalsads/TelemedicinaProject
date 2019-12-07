/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import BITalino.BITalino;
import BITalino.BITalinoException;
import BITalino.BitalinoDemo;
import POJOs.Answer;
import POJOs.Phydata;
import POJOs.SocketUtils;
import POJOs.UserPassword;
import Persistence.Utils;
import java.awt.Color;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author juanb
 */
public class RecordFr extends javax.swing.JFrame {

    private SocketUtils socketUtils;
    private ArrayList<Phydata> phydataList = new ArrayList();
    private int[][] valuesacc;
    private int[][] valueseMG;
    private UserPassword userPassword;
    private String macAddress;
    private int samplingRate;
    private BITalino bitalino = null;
    int time = 0;
    private String symptons;

    public RecordFr(UserPassword userPassword, BITalino bitalino, String macAddress, int samplingRate, int time, SocketUtils socketUtils, String symptons) {
        initComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Poner siempre
        this.userPassword = userPassword;
        this.bitalino = bitalino;
        this.socketUtils = socketUtils;
        this.macAddress = macAddress;
        this.samplingRate = samplingRate;
        this.time = time;
        this.setSize(new Dimension(800, 540));
        this.setLocationRelativeTo(null);
        this.symptons = symptons;
        jPanel1.setSize(this.getSize());
        jPanel1.setBackground(new Color(173, 216, 230));
        sendMeasuresBut.setEnabled(false);

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        eMGButton = new javax.swing.JButton();
        accButton = new javax.swing.JButton();
        sendMeasuresBut = new javax.swing.JButton();
        repeatMeasuresBut = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        eMGButton.setBackground(new java.awt.Color(70, 130, 180));
        eMGButton.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        eMGButton.setForeground(new java.awt.Color(255, 255, 255));
        eMGButton.setText("EMG");
        eMGButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eMGButtonActionPerformed(evt);
            }
        });

        accButton.setBackground(new java.awt.Color(70, 130, 180));
        accButton.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        accButton.setForeground(new java.awt.Color(255, 255, 255));
        accButton.setText("Accelerometer");
        accButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accButtonActionPerformed(evt);
            }
        });

        sendMeasuresBut.setBackground(new java.awt.Color(70, 130, 180));
        sendMeasuresBut.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        sendMeasuresBut.setForeground(new java.awt.Color(255, 255, 255));
        sendMeasuresBut.setText("Send Measures");
        sendMeasuresBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendMeasuresButActionPerformed(evt);
            }
        });

        repeatMeasuresBut.setBackground(new java.awt.Color(70, 130, 180));
        repeatMeasuresBut.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        repeatMeasuresBut.setForeground(new java.awt.Color(255, 255, 255));
        repeatMeasuresBut.setText("Repeat Measures");
        repeatMeasuresBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repeatMeasuresButActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Starting To measure");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/hospital (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(sendMeasuresBut)
                        .addGap(133, 133, 133)
                        .addComponent(repeatMeasuresBut))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(138, 138, 138)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(accButton, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(eMGButton, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(0, 201, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addComponent(eMGButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(accButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sendMeasuresBut)
                    .addComponent(repeatMeasuresBut))
                .addGap(79, 79, 79))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eMGButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eMGButtonActionPerformed

        int cont = 0;
        valueseMG = new int[2][samplingRate * time];
        try {
            bitalino.open(macAddress, samplingRate);
            int[] channelsToAcquire = {0};
            bitalino.start(channelsToAcquire);
            bitalino.stop();
            eMGButton.setEnabled(false);
            sendMeasuresBut.setEnabled(true);
            boolean type = true;
            Utils.GraphPhydata(valueseMG, type);
        } catch (BITalinoException ex) {
            Logger.getLogger(BitalinoDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(BitalinoDemo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                //close bluetooth connection
                if (bitalino != null) {
                    bitalino.close();
                }
            } catch (BITalinoException ex) {
                Logger.getLogger(BitalinoDemo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_eMGButtonActionPerformed

    private void accButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accButtonActionPerformed
        int cont = 0;
        valuesacc = new int[2][samplingRate * time];
        try {
            bitalino.open(macAddress, samplingRate);
            int[] channelsToAcquire = {4};
            bitalino.start(channelsToAcquire);
            bitalino.stop();
            accButton.setEnabled(false);
            sendMeasuresBut.setEnabled(true);
            boolean type = false;
            Utils.GraphPhydata(valuesacc, type);
        } catch (BITalinoException ex) {
            Logger.getLogger(BitalinoDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(BitalinoDemo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                //close bluetooth connection
                if (bitalino != null) {
                    bitalino.close();
                }
            } catch (BITalinoException ex) {
                Logger.getLogger(BitalinoDemo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_accButtonActionPerformed

    private void sendMeasuresButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendMeasuresButActionPerformed
        int input = 0;
        Date date = new Date(); // this object contains the current date value
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        System.out.println(formatter.format(date));
        Phydata phydata = new Phydata(date, valueseMG, valuesacc, symptons);
        socketUtils.writeObject(phydata);
        String[] options = new String[2];
        options[0] = new String("Yes");
        options[1] = new String("No");
        input = JOptionPane.showOptionDialog(null, "Measures send\\nDo you wat to exit?",
                "Confirm Exit", 0, JOptionPane.INFORMATION_MESSAGE, null, options, null);
        if (input == 0) {
            System.out.println("Exit...");
            this.setVisible(false);
            Answer answerclose = new Answer(Answer.CLOSE);
            socketUtils.writeObject(answerclose);
            socketUtils.releaseResources();
            System.exit(0);

        } else {
            System.out.println("Repeating measure...");
            Answer repeat = new Answer(Answer.REPEAT);
            socketUtils.writeObject(repeat);
            sendMeasuresBut.setEnabled(false);
            repeatMeasuresBut.setEnabled(true);
            accButton.setEnabled(true);
            eMGButton.setEnabled(true);

        }

    }//GEN-LAST:event_sendMeasuresButActionPerformed

    private void repeatMeasuresButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repeatMeasuresButActionPerformed
        sendMeasuresBut.setEnabled(false);
        repeatMeasuresBut.setEnabled(true);
        accButton.setEnabled(true);
        eMGButton.setEnabled(true);

    }//GEN-LAST:event_repeatMeasuresButActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accButton;
    private javax.swing.JButton eMGButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton repeatMeasuresBut;
    private javax.swing.JButton sendMeasuresBut;
    // End of variables declaration//GEN-END:variables
}
