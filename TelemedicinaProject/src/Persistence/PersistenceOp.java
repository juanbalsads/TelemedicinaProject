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
public final class PersistenceOp {

    public static int saveUserInfo(String directory, String fileName, UserInfo user) {
        //Save user. (If there is no even file, it creates)
        //if the USERNAME already exists returns -1, if not returns 0;
        ArrayList<UserInfo> usersInfoList = null;
        File direct = new File(directory);
        File file = null;
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            file = new File(directory, fileName);
            usersInfoList = loadUserInfo(directory, fileName);
            if (!Utils.checkUserName(user.getUserName(), usersInfoList)) {
                System.out.println("index: " + Utils.getArrayIndexUserName(user.getUserName(), usersInfoList));
                usersInfoList.remove(Utils.getArrayIndexUserName(user.getUserName(), usersInfoList));
                usersInfoList.add(user);
                return 1;
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
            objectOutputStream.close();
            fileOutputStream.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return 1;
    }

    public static ArrayList<UserInfo> loadUserInfo(String directory, String fileName) {
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
                fileInputStream = new FileInputStream(file);
                objectInputStream = new ObjectInputStream(fileInputStream);
                last = (int) objectInputStream.readObject();
                for (int i = 0; i < last; i++) {
                    usersInfoList.add((UserInfo) objectInputStream.readObject());
                }
            }
            objectInputStream.close();
            fileInputStream.close();
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
