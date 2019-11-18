/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import BITalino.BITalino;
import BITalino.BITalinoException;
import BITalino.BitalinoDemo;
import static BITalino.BitalinoDemo.frame;
import POJOs.Phydata;
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

/**
 *
 * @author juanb
 */
public class RecordFr extends javax.swing.JFrame {

    private ArrayList<Phydata> phydataList = new ArrayList();
    private int[][] valuesacc;
    private int[][] valueseMG;
    private UserPassword userPassword;
    private String macAddress;
    private int samplingRate;
    private BITalino bitalino = null;
    int time = 0;

    public RecordFr(UserPassword userPassword, BITalino bitalino, String macAddress, int samplingRate, int time) {
        initComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Poner siempre
        this.userPassword= userPassword;
        this.bitalino = bitalino;
        this.macAddress = macAddress;
        this.samplingRate = samplingRate;
        this.time = time;
        this.setSize(new Dimension(800, 540));
        this.setLocationRelativeTo(null);
        jPanel1.setSize(this.getSize());
        jPanel1.setBackground(new Color(153, 204, 0));
        jLabel2.setText(userPassword.getUserName());
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
        jLabel2 = new javax.swing.JLabel();
        secsLab = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        eMGButton.setBackground(new java.awt.Color(0, 153, 0));
        eMGButton.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        eMGButton.setForeground(new java.awt.Color(255, 255, 255));
        eMGButton.setText("EMG");
        eMGButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eMGButtonActionPerformed(evt);
            }
        });

        accButton.setBackground(new java.awt.Color(0, 153, 0));
        accButton.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        accButton.setForeground(new java.awt.Color(255, 255, 255));
        accButton.setText("Accelerometer");
        accButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accButtonActionPerformed(evt);
            }
        });

        sendMeasuresBut.setBackground(new java.awt.Color(0, 153, 0));
        sendMeasuresBut.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        sendMeasuresBut.setForeground(new java.awt.Color(255, 255, 255));
        sendMeasuresBut.setText("Send Measures");
        sendMeasuresBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendMeasuresButActionPerformed(evt);
            }
        });

        repeatMeasuresBut.setBackground(new java.awt.Color(0, 153, 0));
        repeatMeasuresBut.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        repeatMeasuresBut.setForeground(new java.awt.Color(255, 255, 255));
        repeatMeasuresBut.setText("Repeat Measures");
        repeatMeasuresBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repeatMeasuresButActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("WELCOME !");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));

        secsLab.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        secsLab.setForeground(new java.awt.Color(255, 255, 255));
        secsLab.setText("ho");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Time");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(sendMeasuresBut)
                        .addGap(114, 114, 114)
                        .addComponent(repeatMeasuresBut))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(78, 184, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(eMGButton, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(accButton, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(103, 103, 103)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(43, 43, 43)
                            .addComponent(secsLab, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(secsLab, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(eMGButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(accButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sendMeasuresBut)
                    .addComponent(repeatMeasuresBut))
                .addGap(35, 35, 35))
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
            System.out.println(samplingRate + " time:" + time + " ::" + samplingRate * time);

            bitalino.open(macAddress, samplingRate);
            int[] channelsToAcquire = {0};
            bitalino.start(channelsToAcquire);
            for (int j = 0; j < samplingRate * time / 10; j++) {
                //Each time read a block of 10 samples  == frame.length
                int block_size = 10;
                frame = bitalino.read(block_size);
                for (int i = 0; i < frame.length; i++) {
                    valueseMG[0][cont] = cont;
                    valueseMG[1][cont] = frame[i].analog[0];
                    System.out.println("values: " + cont + " , " + valueseMG[1][cont] + ", "
                            + frame.length + ", " + i);
                    cont++;
                }

            }
            bitalino.stop();
            eMGButton.setEnabled(false);
            sendMeasuresBut.setEnabled(true);
            Utils.GraphPhydata(valueseMG);
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
            for (int j = 0; j < samplingRate * time / 10; j++) {
                //Each time read a block of 10 samples
                int block_size = 10;
                frame = bitalino.read(block_size);
                for (int i = 0; i < frame.length; i++) {
                    valuesacc[0][cont] = cont;
                    valuesacc[1][cont] = frame[i].analog[0];
                    System.out.println("values: " + cont + " , " + valuesacc[1][cont]);
                    cont++;

                }
            }
            bitalino.stop();
            accButton.setEnabled(false);
            sendMeasuresBut.setEnabled(true);
            Utils.GraphPhydata(valuesacc);
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
      /*  Date date = new Date(); // this object contains the current date value
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        System.out.println(formatter.format(date));
        Phydata phydata = new Phydata(date, valueseMG, valuesacc);
        phydataList = userInfo.getPhydataArray();
        phydataList.add(phydata);
        System.out.println("tamaño array: " + phydataList.size());
        userInfo.setPhydataArray(phydataList);*/

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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton repeatMeasuresBut;
    private javax.swing.JLabel secsLab;
    private javax.swing.JButton sendMeasuresBut;
    // End of variables declaration//GEN-END:variables
}
