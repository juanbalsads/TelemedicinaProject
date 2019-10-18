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
import POJOs.UserInfo;
import Persistence.Utils;
import java.awt.Color;
import java.awt.Dimension;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import static org.jfree.chart.ui.UIUtils.centerFrameOnScreen;
import org.jfree.data.xy.DefaultXYDataset;

/**
 *
 * @author juanb
 */
public class RecordFr extends javax.swing.JFrame {

    private Utils utils = new Utils();
    ArrayList<Phydata> phydataList = new ArrayList();
    UserInfo user = new UserInfo("Juan", "123", "jbalsads", 12, phydataList);
    private Phydata phydata;
    private String macAddress;
    private int SamplingRate;
    private BITalino bitalino = null;
    int seconds = 0;
    private FileOutputStream fileOutputStream = null;
    private ObjectOutputStream objectOutputStream = null;

    public RecordFr(BITalino bitalino, String macAddress, int SamplingRate) {
        initComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Poner siempre
        this.macAddress = macAddress;
        this.bitalino = bitalino;
        this.SamplingRate = SamplingRate;
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
        EMGButton.setText("EMG");
        EMGButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EMGButtonActionPerformed(evt);
            }
        });

        AccButton.setBackground(new java.awt.Color(0, 153, 0));
        AccButton.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        AccButton.setForeground(new java.awt.Color(255, 255, 255));
        AccButton.setText("Accelerometer");
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
                .addContainerGap(574, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EMGButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AccButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(66, 66, 66))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(429, Short.MAX_VALUE)
                .addComponent(EMGButton)
                .addGap(18, 18, 18)
                .addComponent(AccButton)
                .addGap(25, 25, 25))
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
        double[][] values = new double[2][100];
        try {
            DefaultXYDataset dataset = new DefaultXYDataset();
            bitalino.open(macAddress, SamplingRate);
            int[] channelsToAcquire = {0};
            bitalino.start(channelsToAcquire);
            for (int j = 0; j < 100; j++) {
                //Each time read a block of 10 samples
                int block_size = 10;
                frame = bitalino.read(block_size);
                for (int i = 0; i < frame.length; i++) {
                    values[0][j] = j;
                    values[1][j] = frame[i].analog[0];
                }
            }
            dataset.addSeries("hola", values);
            bitalino.stop();
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            String dateS = formatter.format(date);
            phydata = new Phydata(frame, date);
            user.saveMeasure(phydata);

            JFreeChart lineChart = ChartFactory.createXYLineChart("EMG", "Seconds", "Volts", dataset, PlotOrientation.VERTICAL, true, true, false);
            ChartFrame panel = new ChartFrame("", lineChart);
            panel.pack();
            panel.setVisible(true);
            centerFrameOnScreen(panel);

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

        try {

            bitalino.open(macAddress, SamplingRate);
            int[] channelsToAcquire = {4};//CHANGE this
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
            System.out.println("se fini");

            //stop acquisition
            bitalino.stop();
            Date date = new Date();
            phydata = new Phydata(frame, date);

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

    }//GEN-LAST:event_AccButtonActionPerformed

    private void graphicator() {

        JFreeChart grafico = null;

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AccButton;
    private javax.swing.JButton EMGButton;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
