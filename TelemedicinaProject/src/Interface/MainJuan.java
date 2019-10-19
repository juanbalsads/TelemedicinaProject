/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import POJOs.Phydata;
import POJOs.UserInfo;
import Persistence.*;
import java.util.ArrayList;

/**
 *
 * @author juanb
 */
public class MainJuan {

    public static void main(String[] args) {
        ArrayList<Phydata> arrayList = null;
        //ArrayList<UserInfo> userInfoList = null;
        UserInfo userInfo = new UserInfo("jbalsads", "Juan Balsa", "000", 25, arrayList);
        UserInfo userInfo2 = new UserInfo("cristianp", "Janto", "1111", 25, arrayList);
        UserInfo userInfo3 = new UserInfo("messi", "lionel", "3333", 25, arrayList);
        UserInfo userInfo4 = new UserInfo("ronaldo", "criss", "5555", 24, arrayList);
        //userInfoList = persistence.loadUserInfo(directory, fileName);
        /*System.out.println(persistence.saveUserInfo(directory, fileName, userInfo));
        System.out.println(persistence.saveUserInfo(directory, fileName, userInfo));
        System.out.println(persistence.saveUserInfo(directory, fileName, userInfo2));
        System.out.println(persistence.saveUserInfo(directory, fileName, userInfo3));
        System.out.println(persistence.saveUserInfo(directory, fileName, userInfo4));
        userInfoList = persistence.loadUserInfo(directory, fileName);
        Iterator<UserInfo> it = userInfoList.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }*/
        System.out.println(PersistenceOp.saveUserInfo(Utils.DIRECTORY, Utils.FILENAME, userInfo));
        //System.out.println(PersistenceOp.saveUserInfo("data", "UserInfo.dat", userInfo));

    }

}
