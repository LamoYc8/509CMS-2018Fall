package calender;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.DefaultListModel;

import controller.*;
import model.CalendarModel;
import model.Model;
import view.CalendarFrame;
import storage.*;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		String filePath = "./calendar.txt";
		File file = new File(filePath);
		Model m = new Model();
		Storage st = new Storage("calendar.txt");
		
		if (file.exists() && file.length() != 0) {
			m = st.getObjectFromFile();} 
		else {

		}

		DefaultListModel<CalendarModel> dlm = new DefaultListModel<CalendarModel>();
		CalendarModel[] savedCalendar = m.getArray();
		for (CalendarModel cmodel : savedCalendar) {
			dlm.addElement(cmodel);

		}

		CalendarFrame cf = new CalendarFrame(m);
		cf.getCalendarList().setModel(dlm);
		cf.setVisible(true);
		
		final Model innerM = m;
		cf.addWindowListener (new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				 if (new QuitController().confirm(cf)) {
					 st.saveToFile(innerM);
                     cf.dispose();
             }
			}
		});
		

		
	}

}
