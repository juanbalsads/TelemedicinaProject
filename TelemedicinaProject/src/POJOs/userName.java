/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJOs;

import java.util.ArrayList;

/**
 *
 * @author juanb
 */
public class userName {

    private String name;
    private String password;
    private String userName;
    private int age;
    private ArrayList phydataArray;

    public userName(String name, String password, String userName, int age, ArrayList phydataArray) {
        this.name = name;
        this.password = password;
        this.userName = userName;
        this.age = age;
        this.phydataArray = phydataArray;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList getPhydataArray() {
        return phydataArray;
    }

    public void setPhydataArray(ArrayList phydataArray) {
        this.phydataArray = phydataArray;
    }

}
