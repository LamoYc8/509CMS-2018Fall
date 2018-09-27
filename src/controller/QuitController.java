package controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class QuitController {
    public boolean confirm(JFrame frame) {
		int c = JOptionPane.showConfirmDialog (frame, "Do you wish to exit Application?");

		if (c == JOptionPane.OK_OPTION) {
			return true;
		}

		// don't exit
		return false;
	}
}
