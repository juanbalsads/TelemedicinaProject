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
