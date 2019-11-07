/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

//import POJOs.Phydata;
//import POJOs.UserInfo;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanb
 */

public class MainJuan {

    public static void main(String[] args) throws IOException {
        
        System.out.println("Starting Client...");
        Socket socket = new Socket("localhost", 9009);
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
        System.out.println("Connection established... sending text");
        printWriter.println("Name");
        printWriter.println("password");
        System.out.println("Sending stop command");
        printWriter.println("Stop");
        releaseResources(printWriter, socket);
        System.exit(0);
        
        //ArrayList<Phydata> arrayList = new ArrayList();
        /*//ArrayList<UserInfo> userInfoList = null;
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
        }
        //System.out.println(PersistenceOp.saveUserInfo(Utils.DIRECTORY, Utils.FILENAME, userInfo));
        //System.out.println(PersistenceOp.saveUserInfo("data", "UserInfo.dat", userInfo));
        int[][] valueseMG = new int[2][100];
        int[][] valuesacc = new int[2][100];
        for (int i = 0; i < 100; i++) {
            valueseMG[0][i] = 12;
            valueseMG[1][i] = 12;
            valuesacc[0][i] = 112;
            valuesacc[1][i] = 112;
        }
        Date date = new Date(); // this object contains the current date value
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        System.out.println(formatter.format(date));
        Phydata phydata = new Phydata(date, valueseMG, valuesacc);
        System.out.println("dale papi");
        if (userInfo.getPhydataArray() == null) {
            System.out.println("si es null");
        }
        arrayList = userInfo.getPhydataArray();

        System.out.println("dale papi2");
        arrayList.add(phydata);
        System.out.println("ahora si");*/
    }
    
    
    private static void releaseResources(PrintWriter printWriter, Socket socket) {

        printWriter.close();
 
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(MainJuan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
