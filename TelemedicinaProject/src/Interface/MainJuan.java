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
import java.util.Iterator;

/**
 *
 * @author juanb
 */
public class MainJuan {

    public static void main(String[] args) {
        PersistenceOp persistence = new PersistenceOp();
        String directory = "data";
        String fileName = "UserInfo.dat";
        Phydata phydata = null;
        ArrayList<Phydata> arrayList = null;
        ArrayList<UserInfo> userInfoList = null;
        UserInfo userInfo = new UserInfo("jbalsads", "0000", "Juan Balsa", 25, arrayList);
        UserInfo userInfo2 = new UserInfo("cristianp", "1111", "Janto", 25, arrayList);
        UserInfo userInfo3 = new UserInfo("messi", "2222", "lionel", 25, arrayList);
        UserInfo userInfo4 = new UserInfo("ronaldo", "3333", "criss", 24, arrayList);

        //userInfoList = persistence.loadUserInfo(directory, fileName);
        System.out.println(persistence.saveUserInfo(directory, fileName, userInfo));
        System.out.println(persistence.saveUserInfo(directory, fileName, userInfo));
        System.out.println(persistence.saveUserInfo(directory, fileName, userInfo2));
        System.out.println(persistence.saveUserInfo(directory, fileName, userInfo3));
        System.out.println(persistence.saveUserInfo(directory, fileName, userInfo4));
        userInfoList = persistence.loadUserInfo(directory, fileName);
        Iterator<UserInfo> it = userInfoList.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }

    }

}
