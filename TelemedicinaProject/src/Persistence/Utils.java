/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import POJOs.Answer;
import POJOs.SocketUtils;
import POJOs.UserPassword;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import static org.jfree.chart.ui.UIUtils.centerFrameOnScreen;
import org.jfree.data.xy.DefaultXYDataset;

/**
 *
 * @author juanb
 */
public final class Utils extends Object {

    public static void GraphPhydata(int[][] dataRec, boolean type) {

        int row = dataRec.length;
        int col = dataRec[0].length;
        double[][] values = new double[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                values[i][j] = Double.valueOf(dataRec[i][j]);
            }
        }
        DefaultXYDataset dataset = new DefaultXYDataset();
        if (type) {
            dataset.addSeries("EMG values", values);
            JFreeChart lineChart = ChartFactory.createXYLineChart("EMG", "Samples", "Volts", dataset, PlotOrientation.VERTICAL, true, true, false);
            ChartFrame panel = new ChartFrame("", lineChart);
            panel.pack();
            panel.setVisible(true);
            centerFrameOnScreen(panel);
        } else {
            dataset.addSeries("ACC values", values);
            JFreeChart lineChart = ChartFactory.createXYLineChart("ACCELEROMETER", "Samples", "Volts", dataset, PlotOrientation.VERTICAL, true, true, false);
            ChartFrame panel = new ChartFrame("", lineChart);
            panel.pack();
            panel.setVisible(true);
            centerFrameOnScreen(panel);
        }

    }

    //CONNECTION with SERVER//TRUE if it doesn`t exist;
    public static boolean checkUNameConection(UserPassword userPassword, SocketUtils socketUtils) {
        Object tmp;
        Answer answerClient;
        userPassword = Utils.putCode(userPassword);
        socketUtils.writeObject(userPassword);
        tmp = socketUtils.readObject();
        answerClient = (Answer) tmp;
        if (!answerClient.getAnswer().equalsIgnoreCase(Answer.VALID_USERNAME)) {
            return false;
        } else {
            return true;
        }
    }

    public static UserPassword putCode(UserPassword userPassword) {
        String userName = userPassword.getUserName() + Answer.NEWUN;
        userPassword.setUserName(userName);
        return userPassword;
    }

    public static boolean checkUserPasswordConection(UserPassword userPassword, SocketUtils socketUtils) {
        Object tmp;
        Answer answerClient;
        socketUtils.writeObject(userPassword);
        tmp = socketUtils.readObject();
        answerClient = (Answer) tmp;
        if (!answerClient.getAnswer().equalsIgnoreCase(Answer.VALID)) {
            return false;
        }

        return true;
    }

    public static String getRadioButton(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }

    public static String charToString(char[] chain) {
        String password = "";
        for (int i = 0; i < chain.length; i++) {
            password = password + chain[i];
        }
        return password;
    }

    //TRUE if it is only String
    public static boolean checkString(String chain) {
        boolean check = true;
        if (chain == null) {
            return false;
        }
        char prof;
        chain = chain.replace(" ", "");
        for (int i = 0; i < chain.length(); i++) {
            prof = chain.charAt(i);
            if (!Character.isAlphabetic(prof)) {
                check = false;
            }
        }
        return check;
    }

    //TRUE if it is only numbers
    public static boolean checkNum(String numStr) {
        int num;
        if (numStr == null) {
            return false;
        }
        char prof;
        for (int i = 0; i < numStr.length(); i++) {
            prof = numStr.charAt(i);
            if (Character.isAlphabetic(prof)) {
                return false;
            }
        }
        return true;
    }
    public static String getMD5(String password) {

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(password.getBytes());

            StringBuffer sb = new StringBuffer();

            for (int i = 0; i < messageDigest.length; i++) {
                sb.append(Integer.toHexString(0xff & messageDigest[i]));
            }
            return sb.toString();

        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }

    }

}
