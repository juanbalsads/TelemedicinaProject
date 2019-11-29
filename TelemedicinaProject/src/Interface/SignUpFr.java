/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import POJOs.AgeName;
import POJOs.SocketUtils;
import POJOs.UserPassword;
import Persistence.Utils;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

/**
 *
 * @author juanb
 */
public class SignUpFr extends javax.swing.JFrame {

    UserPassword userPassword = null;
    AgeName userAgeName = null;
    private SocketUtils socketUtils = null;
    String name = null;
    int age = 0;
    String ageSt = null;
    char[] passwordChar = null;
    String password = null;
    String userName = null;

    /**
     * Creates new form SignUpFr
     */
    public SignUpFr(SocketUtils socketUtils) {
        initComponents();
        this.socketUtils = socketUtils;
        this.setSize(new Dimension(800, 540));
        this.setLocationRelativeTo(null);
        jPanel1.setSize(this.getSize());
        jPanel1.setBackground(new Color(153, 204, 0));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jTextField2 = new javax.swing.JTextField();
        SignUpBut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Name");

        jLabel2.setText("Age");

        jLabel3.setText("Username");

        jLabel4.setText("Password");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        SignUpBut.setBackground(new java.awt.Color(0, 153, 0));
        SignUpBut.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        SignUpBut.setForeground(new java.awt.Color(255, 255, 255));
        SignUpBut.setText("Sign Up");
        SignUpBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignUpButActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(SignUpBut, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(305, 305, 305))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(139, 139, 139))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(158, 158, 158)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                    .addComponent(jTextField2)
                    .addComponent(jTextField3)
                    .addComponent(jPasswordField1))
                .addGap(274, 274, 274))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(122, 122, 122)
                .addComponent(SignUpBut, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
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

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void SignUpButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignUpButActionPerformed

        jTextField1.setBorder(new LineBorder(Color.white, 2));
        jTextField2.setBorder(new LineBorder(Color.white, 2));
        jTextField3.setBorder(new LineBorder(Color.white, 2));
        password = Utils.charToString(jPasswordField1.getPassword());
        name = jTextField1.getText();
        ageSt = jTextField2.getText();
        age = Integer.parseInt(ageSt);
        userName = jTextField3.getText();
        userPassword = new UserPassword(userName, password);
        userAgeName = new AgeName(age, name);
        System.out.println(userPassword.toString());

        boolean UNchecked = Utils.checkUNameConection(userPassword, socketUtils);
        System.out.println("en el sighn up:" + UNchecked);
        if (!Utils.checkString(name) || !Utils.checkNum(ageSt) || !UNchecked
                || jTextField1.getText().isEmpty() || jTextField2.getText().isEmpty()
                || jTextField3.getText().isEmpty()) {
            if (!Utils.checkString(name) || jTextField1.getText().isEmpty()) {
                jTextField1.setBorder(new LineBorder(Color.red, 2));
            }
            if (!Utils.checkNum(ageSt) || jTextField2.getText().isEmpty()) {
                jTextField2.setBorder(new LineBorder(Color.red, 2));
            }
            if (!UNchecked || jTextField3.getText().isEmpty()) {
                jTextField3.setBorder(new LineBorder(Color.red, 2));
            }
            JOptionPane.showMessageDialog(new JFrame(), "User already exists or Incorrect values\nPlease change red Fields "
                    + "", "Error", JOptionPane.ERROR_MESSAGE);
        } else {

            System.out.println("aalready send..SignUpFR");
            Utils.sendUserNameAge(userAgeName, socketUtils);
            JOptionPane.showMessageDialog(new JFrame(), "New User Succesfully created"
                    + "", "Information", JOptionPane.INFORMATION_MESSAGE);
            this.setVisible(false);
            MatchDeviceFr matchDeviceFr = new MatchDeviceFr(userPassword, socketUtils);
            matchDeviceFr.setVisible(true);

            //}
        }

    }//GEN-LAST:event_SignUpButActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SignUpBut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}

/*

        jTextField1.setBorder(new LineBorder(Color.white, 2));
        jTextField2.setBorder(new LineBorder(Color.white, 2));
        jTextField3.setBorder(new LineBorder(Color.white, 2));
        password = Utils.charToString(jPasswordField1.getPassword());
        name = jTextField1.getText();
        ageSt = jTextField2.getText();
        userName = jTextField3.getText();
        userPassword = new UserPassword(userName, password);
        System.out.println(userPassword.toString());

        boolean UNchecked = Utils.checkUNameConection(userPassword, socket);
        if (!Utils.checkString(name) || !Utils.checkNum(ageSt) || !UNchecked
                || jTextField1.getText().isEmpty() || jTextField2.getText().isEmpty()
                || jTextField3.getText().isEmpty()) {
            if (!Utils.checkString(name) || jTextField1.getText().isEmpty()) {
                jTextField1.setBorder(new LineBorder(Color.red, 2));
            }
            if (!Utils.checkNum(ageSt) || jTextField2.getText().isEmpty()) {
                jTextField2.setBorder(new LineBorder(Color.red, 2));
            }
            if (!UNchecked || jTextField3.getText().isEmpty()) {
                jTextField3.setBorder(new LineBorder(Color.red, 2));
            }
            JOptionPane.showMessageDialog(new JFrame(), "User already exists or Incorrect values\nPlease change red Fields "
                    + "", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            System.out.println("aalready send..SignUpFR");
            Utils.sendUserNameAge(name, ageSt, socket);
            JOptionPane.showMessageDialog(new JFrame(), "New User Succesfully created"
                    + "", "Information", JOptionPane.INFORMATION_MESSAGE);
            this.setVisible(false);
            MatchDeviceFr matchDeviceFr = new MatchDeviceFr(userPassword, socket);
            matchDeviceFr.setVisible(true);

            //}
        }
 */
