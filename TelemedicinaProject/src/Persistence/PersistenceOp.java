/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import POJOs.UserInfo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanb
 */
public class PersistenceOp {

    public int saveUserInfo(String directory, String fileName, UserInfo user) {
        //Save user. (If there is no even file, it creates)
        //if the USERNAME already exists returns -1, if not returns 0;

        Utils utils = new Utils();
        ArrayList<UserInfo> usersInfoList = null;
        File direct = new File(directory);
        /*if (!direct.exists()) {
            direct.mkdir();
        }*/
        File file = null;
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            file = new File(directory, fileName);
            /*if (!file.exists()) {
                file.createNewFile();
            }*/
            //Utils.checkUserInfo(user, usersInfoList);
            usersInfoList = loadUserInfo(directory, fileName);
            if (!utils.checkUserInfo(user, usersInfoList)) {
                return -1;
            }

            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            usersInfoList.add(user);

            Iterator<UserInfo> it = usersInfoList.iterator();
            objectOutputStream.writeObject(usersInfoList.size());
            while (it.hasNext()) {
                UserInfo us = (UserInfo) it.next();
                objectOutputStream.writeObject(us);
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public ArrayList<UserInfo> loadUserInfo(String directory, String fileName) {
        ArrayList<UserInfo> usersInfoList = new ArrayList();
        File file = null;
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        File direct = new File(directory);
        int last = 0;
        if (!direct.exists()) {
            direct.mkdir();
        }
        try {
            file = new File(directory, fileName);
            if (!file.exists()) {
                file.createNewFile();
                return usersInfoList;
            } else {
                if (file.exists()) {
                }
                fileInputStream = new FileInputStream(file);
                objectInputStream = new ObjectInputStream(fileInputStream);
                last = (int) objectInputStream.readObject();
                for (int i = 0; i < last; i++) {
                    usersInfoList.add((UserInfo) objectInputStream.readObject());
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PersistenceOp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PersistenceOp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PersistenceOp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usersInfoList;

    }

}
