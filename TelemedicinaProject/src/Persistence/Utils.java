/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import POJOs.AgeName;
import POJOs.Answer;
import POJOs.Phydata;
import POJOs.SocketUtils;
import POJOs.UserPassword;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        // try {
        //bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        /*inputStream = socketUtils.getInputStream();
            outputStream = socketUtils.getOutputStream();
            objectOutputStream = socketUtils.getObjectOutputStream();
            objectInputStream = socketUtils.getObjectInputStream();*/
        System.out.println("Connection established...");
        socketUtils.writeObject(userPassword);
        tmp = socketUtils.readObject();
        answerClient = (Answer) tmp;
        if (!answerClient.getAnswer().equalsIgnoreCase(Answer.VALID)) {
            return false;
        }

        /*} catch (IOException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        return true;
    }

    public static void sendUserNameAge(AgeName ageName, SocketUtils socketUtils) {
        /*ObjectOutputStream objectOutputStream = null;
        OutputStream outputStream = null;*/
        //try {

        /*outputStream = socketUtils.getOutputStream();
            objectOutputStream = socketUtils.getObjectOutputStream();*/
        System.out.println("Client Conection");
        socketUtils.writeObject(ageName);
        /*} catch (IOException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }*/

    }

    public static void SendPhydata(Phydata phydata, SocketUtils socketUtils) {
        System.out.println("SENDING PHYDATA");

        socketUtils.writeObject(phydata);
    }

    private static void releaseResources(PrintWriter printWriter, Socket socket) {

        printWriter.close();

        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            num = Integer.parseInt(numStr);
            return true;

        } catch (NumberFormatException ex) {
            return false;
        }

    }

}
