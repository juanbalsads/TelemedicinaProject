/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import POJOs.UserPassword;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    public static final String STOP = "stop";
    public static final String VALID = "valid";
    public static final String VALID_USERNAME = "validusername";
    public static final String NEWUN = "qwerty";

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

    /*public static boolean checkUserInfo(UserInfo userToCheck, ArrayList<UserInfo> userInfoList) {
        //TRUE if it doesn`t exist;
        String userNameStr = userToCheck.getUserName();
        String loaduserName = null;
        boolean check = true;
        Iterator<UserInfo> it = userInfoList.iterator();
        while (it.hasNext()) {
            loaduserName = it.next().getUserName();
            if (loaduserName.compareTo(userNameStr) == 0) {
                check = false;

            }
        }
        return check;
    }*/
    //CONNECTION with SERVER//TRUE if it doesn`t exist;
    public static boolean checkUNameConection(UserPassword userPassword, Socket socket) {
        BufferedReader bufferedReader = null;
        ObjectOutputStream objectOutputStream = null;
        OutputStream outputStream = null;
        String line = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("Client Conection..checkUNameConection");
            outputStream = socket.getOutputStream();
            objectOutputStream = new ObjectOutputStream(outputStream);
            System.out.println("Connection established...checkUNameConection");
            userPassword = Utils.putCode(userPassword);
            objectOutputStream.writeObject(userPassword);
            System.out.println("Send USerPassword...checkUNameConection");
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.equalsIgnoreCase(Utils.VALID_USERNAME)) {
                    return false;
                } else {
                    return true;
                }
            }

            //Utils.releaseResources(printWriter, socket);
            //System.exit(0);
        } catch (IOException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public static UserPassword putCode(UserPassword userPassword) {
        String userName = userPassword.getUserName() + Utils.NEWUN;
        userPassword.setUserName(userName);
        return userPassword;
    }

    public static boolean checkUserPasswordConection(UserPassword userPassword, Socket socket) {
        BufferedReader bufferedReader = null;
        PrintWriter printWriter = null;
        ObjectOutputStream objectOutputStream = null;
        OutputStream outputStream = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("Client Conection");
            outputStream = socket.getOutputStream();
            objectOutputStream = new ObjectOutputStream(outputStream);
            printWriter = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("Connection established...");
            objectOutputStream.writeObject(userPassword);
            if (!bufferedReader.readLine().equalsIgnoreCase(Utils.VALID)) {
                return false;
            }
            //Utils.releaseResources(printWriter, socket);
            //System.exit(0);
        } catch (IOException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public static void sendUserNameAge(String name, String ageSt, Socket socket) {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("Client Conection");
            printWriter.println("NAME" + name);
            printWriter.println("AGE" + ageSt);
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

    /*public static boolean checkUserName(String userName) {
        //TRUE if it doesn`t exist;
        ArrayList<UserInfo> userInfoList = PersistenceOp.loadUserInfo(DIRECTORY, FILENAME);
        String loaduserName = null;
        boolean check = true;
        Iterator<UserInfo> it = userInfoList.iterator();
        while (it.hasNext()) {
            loaduserName = it.next().getUserName();
            if (loaduserName.compareTo(userName) == 0) {
                check = false;
            }
        }
        return check;
    }*/
    //return index where a PArticular USerNAme is Saved
    /*public static int getArrayIndexUserName(String userName, ArrayList<UserInfo> userInfoList) {
        UserInfo useInfo = null;
        Iterator<UserInfo> it = userInfoList.iterator();
        while (it.hasNext()) {
            useInfo = it.next();
            if (useInfo.getUserName().compareTo(userName) == 0) {
                return userInfoList.indexOf(useInfo);
            }
        }
        return -1;
    }*/
    public static String getRadioButton(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }

    /*public static boolean checkCorrectPassword(String userNametocheck, String passwordtocheck, ArrayList<UserInfo> userInfoList) {
        int index = Utils.getArrayIndexUserName(userNametocheck, userInfoList);
        UserInfo userInfo = userInfoList.get(index);
        if ((userInfo.getUserName().compareTo(userNametocheck) == 0)
                && (userInfo.getPassword().compareTo(passwordtocheck)) == 0) {
            return true;
        } else {
            return false;
        }

    }*/
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
