/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJOs;

import BITalino.*;
import java.util.Calendar;

/**
 *
 * @author juanb
 */
public class Phydata {

    private static Frame[] frame;
    private Calendar cal;

    public Phydata(Frame[] frame, Calendar cal) {
        this.cal = cal;
        Phydata.frame = frame;
    }

    public static Frame[] getFrame() {
        return frame;
    }

    public static void setFrame(Frame aFrame) {
    }

    public Calendar getCal() {
        return cal;
    }

    public void setCal(Calendar cal) {
        this.cal = cal;
    }

}
