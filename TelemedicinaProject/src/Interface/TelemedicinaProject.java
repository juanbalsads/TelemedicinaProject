/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author juanb
 */
public class TelemedicinaProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //MatchDeviceFr intro = new MatchDeviceFr();
        //intro.setVisible(true);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String dateS = formatter.format(date);
        System.out.println(dateS);

    }

}
