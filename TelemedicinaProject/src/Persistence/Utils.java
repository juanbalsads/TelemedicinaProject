/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import POJOs.UserInfo;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author juanb
 */
public class Utils {

    /*public void GraphPhydata(Phydata phydata) {
        double[][] values = new double[2][100];
        for (int j = 0; j < 100; j++) {
            int block_size = 10;
                //frame = bitalino.read(block_size);
                for (int i = 0; i < phydata.getFrame().; i++) {
                    values[0][j] = j;
                    values[1][j] = frame[i].analog[0];
                }
            }
        DefaultXYDataset dataset = new DefaultXYDataset();
        dataset.addSeries("hola", values);
        JFreeChart lineChart = ChartFactory.createXYLineChart("EMG", "Seconds", "Volts", dataset, PlotOrientation.VERTICAL, true, true, false);
        ChartFrame panel = new ChartFrame("", lineChart);
        panel.pack();
        panel.setVisible(true);
        centerFrameOnScreen(panel);

    }*/
    public boolean checkUserInfo(UserInfo userToCheck, ArrayList<UserInfo> userInfoList) {
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
    }

}
