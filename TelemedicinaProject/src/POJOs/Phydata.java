/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJOs;

import BITalino.*;
import java.util.Date;

/**
 *
 * @author juanb
 */
public class Phydata {

    private static Frame[] frame;
    private Date date;

    public Phydata(Frame[] frame, Date date) {
        this.date = date;
        Phydata.frame = frame;
    }

    public static Frame[] getFrame() {
        return frame;
    }

    public static void setFrame(Frame aFrame) {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
