/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import BITalino.BITalino;
import BITalino.BITalinoException;
import BITalino.BitalinoDemo;
import static BITalino.BitalinoDemo.cal;
import static BITalino.BitalinoDemo.frame;
import POJOs.Phydata;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author juanb
 */
public class RecordFr extends javax.swing.JFrame {

    private Phydata phydata;
    private String macAddress;

    private BITalino bitalino = null;
    int seconds = 0;

    public RecordFr(BITalino bitalino, String macAddress) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.macAddress = macAddress;
        this.bitalino = bitalino;
        initComponents();
        this.setSize(new Dimension(800, 540));
        this.setLocationRelativeTo(null);
        jPanel1.setSize(this.getSize());
        jPanel1.setBackground(new Color(153, 204, 0));

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        EMGButton = new javax.swing.JButton();
        AccButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        EMGButton.setBackground(new java.awt.Color(0, 153, 0));
        EMGButton.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        EMGButton.setForeground(new java.awt.Color(255, 255, 255));
        EMGButton.setText("Rec 1");
        EMGButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EMGButtonActionPerformed(evt);
            }
        });

        AccButton.setBackground(new java.awt.Color(0, 153, 0));
        AccButton.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        AccButton.setForeground(new java.awt.Color(255, 255, 255));
        AccButton.setText("Rec 2");
        AccButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(639, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AccButton, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                    .addComponent(EMGButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(69, 69, 69))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(394, Short.MAX_VALUE)
                .addComponent(EMGButton)
                .addGap(18, 18, 18)
                .addComponent(AccButton)
                .addGap(60, 60, 60))
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

    private void EMGButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EMGButtonActionPerformed

        try {

            int SamplingRate = 10;
            bitalino.open(macAddress, SamplingRate);
            // For example, If you want A1, A3 and A4 you should use {0,2,3}
            int[] channelsToAcquire = {0};//CHANGE this
            bitalino.start(channelsToAcquire);

            //Read in total 10000000 times
            for (int j = 0; j < 100; j++) {

                //Each time read a block of 10 samples
                int block_size = 10;
                frame = bitalino.read(block_size);

                System.out.println("size block: " + frame.length);

                //Print the samples
                for (int i = 0; i < frame.length; i++) {
                    System.out.println((j * block_size + i) + " seq: " + frame[i].seq + " "
                            + frame[i].analog[0] + " "
                    );

                }
                seconds = (block_size * j) / SamplingRate + 1;
                System.out.println("Seconds: " + seconds);

            }
            //stop acquisition
            bitalino.stop();
            cal = Calendar.getInstance();
            phydata = new Phydata(frame, cal);

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

    }//GEN-LAST:event_EMGButtonActionPerformed

    private void AccButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AccButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AccButton;
    private javax.swing.JButton EMGButton;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
