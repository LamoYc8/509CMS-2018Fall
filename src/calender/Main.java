package calender;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultListModel;

import model.CalendarModel;
import model.Model;
import view.CalendarFrame;

public class Main {

	public static void main(String[] args) {
		Model m = new Model();

		//load from JSON file or txt file

		//set up model
		DefaultListModel<CalendarModel> dlm = new DefaultListModel<CalendarModel>();

		CalendarFrame cf = new CalendarFrame(m);
		cf.getCalendarList().setModel(dlm);

		cf.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				//storage 

				cf.dispose();
			}
		} );

		cf.setVisible(true);
	}

}
