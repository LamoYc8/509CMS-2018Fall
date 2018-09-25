package controller;

import java.text.ParseException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.CalendarModel;
import model.Model;
import view.*;

public class SingleCalendarController {

    SingleCalendar frame;
    CalendarModel cmodel;
    // Further type modify.
    JTable timeSlots;

    public SingleCalendarController(CalendarModel cm, SingleCalendar frame) {
        this.cmodel = cm;
        this.frame = frame;
    }

    public static Object[][] setDataVector(CalendarModel c) {
        Object[][] dataVector = new Object[c.dateList.size()][c.timeSlots.size()+1];
		for (int i = 0; i < c.dateList.size(); i++) {
			for (int j = 0; j < dataVector[i].length; j++) {
				if (j==0) {
					dataVector[i][j] = c.dateList.get(i).toString();
				} else {
					dataVector[i][j] = c.timeSlots.get(j-1).startTime;
				}
			}

        }
        
        return dataVector;
    }

    public static Object[] setColIden(CalendarModel c) {
        Object[] columnIdentifiers = new Object[c.timeSlots.size()+1];
		for (int i = 0; i < columnIdentifiers.length; i++) {
			if (i ==0) {
				columnIdentifiers[i] = "Date";
			} else {
				columnIdentifiers[i] = "Start Time";
			}
        }
        return columnIdentifiers;
    }

    public void modifyCProcess() throws ParseException {

        timeSlots = frame.getTimeSlot();
        ModifyCalendar mcview = new ModifyCalendar(this.cmodel);
        mcview.setModal(true);
        mcview.setVisible(true);

        String newEndDate = mcview.getEndDate().getText();
        if (mcview.wasUpdated()) {

            if (cmodel.getEndDate().equals(newEndDate)) {
                ;
            } else {
                cmodel.modifyDateList(newEndDate);
            }
        }

         // JTable update content
        DefaultTableModel dtm = (DefaultTableModel) timeSlots.getModel();
        dtm.setDataVector(setDataVector(cmodel), setColIden(cmodel));
        
        mcview.dispose();
        frame.repaint();

    }

    public void closeTSProcess() {
        timeSlots = frame.getTimeSlot();

        CloseTimeSlot ctsview = new CloseTimeSlot(this.cmodel);
        ctsview.setModal(true);
        ctsview.setVisible(true);

    }

    public void createMProcess() {
        timeSlots = frame.getTimeSlot();

        CreateMeeting cmview = new CreateMeeting(this.cmodel);
        cmview.setModal(true);
        cmview.setVisible(true);
    }

    public void meetingSchedule() {
        timeSlots = frame.getTimeSlot();

    }

}
