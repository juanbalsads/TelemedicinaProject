/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import POJOs.AgeName;
import POJOs.Answer;
import POJOs.SocketUtils;
import POJOs.UserPassword;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
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

    public static void GraphPhydata(int[][] dataRec) {
        int row = dataRec.length;
        int col = dataRec[0].length;
        double[][] values = new double[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                values[i][j] = Double.valueOf(dataRec[i][j]);
            }
        }
        DefaultXYDataset dataset = new DefaultXYDataset();
        dataset.addSeries("hola", values);
        JFreeChart lineChart = ChartFactory.createXYLineChart("EMG", "Seconds", "Volts", dataset, PlotOrientation.VERTICAL, true, true, false);
        ChartFrame panel = new ChartFrame("", lineChart);
        panel.pack();
        panel.setVisible(true);
        centerFrameOnScreen(panel);

    }

    //CONNECTION with SERVER//TRUE if it doesn`t exist;
    public static boolean checkUNameConection(UserPassword userPassword, SocketUtils socketUtils) {
        System.out.println("ENTRA");
        /*ObjectOutputStream objectOutputStream = null;
        OutputStream outputStream = null;
        InputStream inputStream = null;
        ObjectInputStream objectInputStream = null;*/
        Object tmp;
        Answer answerClient;

        // try {

        /*inputStream = socketUtils.getInputStream();
            outputStream = socketUtils.getOutputStream();
            objectOutputStream = socketUtils.getObjectOutputStream();
            objectInputStream = socketUtils.getObjectInputStream();*/
        userPassword = Utils.putCode(userPassword);
        //objectOutputStream.writeObject(userPassword);
        socketUtils.writeObject(userPassword);
        //tmp = objectInputStream.readObject();
        tmp = socketUtils.readObject();
        answerClient = (Answer) tmp;
        System.out.println("ha recibbido el mensaje:" + answerClient.getAnswer());
        System.out.println("falsetrue:" + !answerClient.getAnswer().equalsIgnoreCase(Answer.VALID_USERNAME));

        if (!answerClient.getAnswer().equalsIgnoreCase(Answer.VALID_USERNAME)) {
            return false;
        } else {
            return true;
        }
        /*} catch (IOException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;*/
    }

    public static UserPassword putCode(UserPassword userPassword) {
        String userName = userPassword.getUserName() + Answer.NEWUN;
        userPassword.setUserName(userName);
        return userPassword;
    }

    public static boolean checkUserPasswordConection(UserPassword userPassword, SocketUtils socketUtils) {
        //BufferedReader bufferedReader = null;
        ObjectOutputStream objectOutputStream = null;
        OutputStream outputStream = null;
        InputStream inputStream = null;
        ObjectInputStream objectInputStream = null;
        Object tmp;
        Answer answerClient;
        try {
            //bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("Client Conection");
            inputStream = socketUtils.getInputStream();
            outputStream = socketUtils.getOutputStream();
            objectOutputStream = socketUtils.getObjectOutputStream();
            objectInputStream = socketUtils.getObjectInputStream();
            System.out.println("Connection established...");
            objectOutputStream.writeObject(userPassword);
            tmp = objectInputStream.readObject();
            answerClient = (Answer) tmp;
            if (!answerClient.getAnswer().equalsIgnoreCase(Answer.VALID)) {
                return false;
            }

        } catch (IOException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public static void sendUserNameAge(AgeName ageName, SocketUtils socketUtils) {
        ObjectOutputStream objectOutputStream = null;
        OutputStream outputStream = null;
        try {

            outputStream = socketUtils.getOutputStream();
            objectOutputStream = socketUtils.getObjectOutputStream();

            System.out.println("Client Conection");
            objectOutputStream.writeObject(ageName);
        } catch (IOException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }

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
