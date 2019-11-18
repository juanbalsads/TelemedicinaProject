/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

//import POJOs.Phydata;
//import POJOs.UserInfo;
import POJOs.Phydata;
import POJOs.UserInfo;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanb
 */
public class MainEnrique {

    public static void main(String[] args) throws IOException {

        System.out.println("Starting Client...");
        Socket socket = new Socket("localhost", 9000);
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
        System.out.println("Connection established... sending text");
        printWriter.println("Name");
        releaseResources(printWriter, socket);
        System.exit(0);

        ArrayList<Phydata> arrayList = new ArrayList();
        ArrayList<UserInfo> userInfoList = null;
        UserInfo userInfo = new UserInfo("enrique", "tunon", "555", 21, arrayList);
        userInfoList = persistence.loadUserInfo(directory, fileName);
        System.out.println(persistence.saveUserInfo(directory, fileName, userInfo));
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
            valueseMG[0][i] = 35;
            valueseMG[1][i] = 56;
            valuesacc[0][i] = 1233;
            valuesacc[1][i] = 902;
        }
        Date date = new Date(); // this object contains the current date value
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        System.out.println(formatter.format(date));
        Phydata phydata = new Phydata(date, valueseMG, valuesacc);
        System.out.println("gogo");
        if (userInfo.getPhydataArray() == null) {
            System.out.println("es null");
        }
        arrayList = userInfo.getPhydataArray();

        System.out.println("go");
        arrayList.add(phydata);

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
