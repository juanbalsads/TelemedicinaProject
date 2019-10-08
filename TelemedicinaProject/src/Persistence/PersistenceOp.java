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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanb
 */
public class PersistenceOp {

    public void saveUserInfo(String directory, String fileName, UserInfo user) {
        ArrayList<UserInfo> usersInfoList = new ArrayList();
        File file = null;
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            usersInfoList = loadUserInfo(directory, fileName);

            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            usersInfoList.add(user);

            objectOutputStream.writeObject(usersInfoList);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<UserInfo> loadUserInfo(String directory, String fileName) {
        ArrayList<UserInfo> usersInfoList = new ArrayList();
        File file = null;
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        file = new File(directory, fileName);

        if (!file.exists()) {
            return usersInfoList;
        } else {
            try {
                fileInputStream = new FileInputStream(file);
                objectInputStream = new ObjectInputStream(fileInputStream);
                usersInfoList = (ArrayList<UserInfo>) objectInputStream.readObject();

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

}