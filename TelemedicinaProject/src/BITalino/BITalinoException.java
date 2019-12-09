package BITalino;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class BITalinoException extends java.lang.Exception {

    private static final long serialVersionUID = 1L;

    public BITalinoException(BITalinoErrorTypes errorType) {
        super(errorType.getName());
        code = errorType.getValue();
        JOptionPane.showMessageDialog(new JFrame(), "Bluetooth Connection Lost\nPlease, Try Later"
                + "", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public int code;

}
