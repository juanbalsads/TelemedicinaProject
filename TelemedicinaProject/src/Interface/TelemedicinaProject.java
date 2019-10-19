/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import POJOs.Phydata;
import POJOs.UserInfo;
import Persistence.PersistenceOp;
import Persistence.Utils;
import java.util.ArrayList;

/**
 *
 * @author juanb
 *
 *
 */
public class TelemedicinaProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //UserFr intro = new UserFr();
        //intro.setVisible(true);
        ArrayList<Phydata> arrayList = null;
        UserInfo userInfo = new UserInfo("jbalsads", "Juan Balsa", "000", 25, arrayList);
        System.out.println(PersistenceOp.saveUserInfo(Utils.DIRECTORY, Utils.FILENAME, userInfo));
        //System.out.println(PersistenceOp.saveUserInfo(Utils.DIRECTORY, Utils.FILENAME, userInfo));

    }

}
