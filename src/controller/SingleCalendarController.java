package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.function.Predicate;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.CalendarModel;
import model.Meeting;
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
        SimpleDateFormat dFormat = new SimpleDateFormat("EEE, MMM-dd-yyyy");
        Object[][] dataVector = new Object[c.dateList.size()][c.timeSlots.size() + 1];
        for (int i = 0; i < c.dateList.size(); i++) {
            for (int j = 0; j < dataVector[i].length; j++) {
                if (j == 0) {
                    dataVector[i][j] = dFormat.format(c.dateList.get(i));
                } else {
                    dataVector[i][j] = c.timeSlots.get(j - 1).startTime;
                }
            }

        }

        return dataVector;
    }

    public static Object[] setColIden(CalendarModel c) {
        Object[] columnIdentifiers = new Object[c.timeSlots.size() + 1];
        for (int i = 0; i < columnIdentifiers.length; i++) {
            if (i == 0) {
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

    public void closeTSProcess() throws ParseException {
        timeSlots = frame.getTimeSlot();

        // Set up closeTimeSlot view
        CloseTimeSlot ctsview = new CloseTimeSlot(this.cmodel);
        ctsview.setModal(true);
        ctsview.setVisible(true);

        // grab back the user input
        if (ctsview.wasUpdated()) {
            SimpleDateFormat dFormat = new SimpleDateFormat("EEE, MMM-dd-yyyy");
            SimpleDateFormat wFormat = new SimpleDateFormat("EEE");

            String timeIT, day;
            if (!ctsview.day.getText().isEmpty()) {
                day = ctsview.day.getText();
                timeIT = (String) ctsview.timeInterval.getSelectedItem();
                for (int i = 0; i < cmodel.dateList.size(); i++) {
                    Date wd = cmodel.dateList.get(i);
                    String tempDay = wFormat.format(wd);
                    for (int j = 0; j < cmodel.timeSlots.size(); j++) {
                        String tempTI = cmodel.timeSlots.get(j).startTime;
                        if (tempDay.equals(day) && tempTI.equals(timeIT)) {
                            timeSlots.setValueAt(null, i, j + 1);
                        } else {
                            continue;
                        }
                    }

                }

            } else {
                if (ctsview.timeInterval.getSelectedItem() == null) {
                    Date selectDate = dFormat.parse((String) ctsview.selectDate.getSelectedItem());
                    cmodel.dateList.remove(selectDate);

                    DefaultTableModel dtm = (DefaultTableModel) timeSlots.getModel();
                    dtm.setDataVector(setDataVector(cmodel), setColIden(cmodel));
                } else if (ctsview.selectDate.getSelectedItem() == null) {
                    timeIT = (String) ctsview.timeInterval.getSelectedItem();
                    cmodel.timeSlots.removeIf(ts -> ts.startTime.equals(timeIT));

                    DefaultTableModel dtm = (DefaultTableModel) timeSlots.getModel();
                    dtm.setDataVector(setDataVector(cmodel), setColIden(cmodel));
                } else {

                    String selectDate = (String) ctsview.selectDate.getSelectedItem();
                    timeIT = (String) ctsview.timeInterval.getSelectedItem();
                    for (int i = 0; i < cmodel.dateList.size(); i++) {
                        Date tempdate = cmodel.dateList.get(i);
                        SimpleDateFormat tempDF = new SimpleDateFormat("EEE, MMM-dd-yyyy");
                        String tempdateS = tempDF.format(tempdate);
                        for (int j = 0; j < cmodel.timeSlots.size(); j++) {
                            String tempTI = cmodel.timeSlots.get(j).startTime;
                            if (tempdateS.contains(selectDate) && tempTI.equals(timeIT)) {
                                timeSlots.setValueAt(null, i, j + 1);
                            } else {
                                continue;
                            }
                        }

                    }

                }
            }
        }

        ctsview.dispose();
        frame.repaint();

    }

    public void createMProcess() {
        timeSlots = frame.getTimeSlot();

        CreateMeeting cmview = new CreateMeeting(this.cmodel);
        cmview.setModal(true);
        cmview.setVisible(true);

        String personN, selectDate, selectTime;
        Meeting newMeeting;
        if (cmview.wasUpdated()) {
            personN = cmview.personN.getText();
            selectDate = (String) cmview.selectDate.getSelectedItem();
            selectTime = (String) cmview.selectTS.getSelectedItem();
            newMeeting = new Meeting(personN, selectDate, selectTime);
            cmodel.meetings.add(newMeeting);
        }

        cmview.dispose();

    }

    public void meetingSchedule() {
        timeSlots = frame.getTimeSlot();

        MeetingSchedule msview = new MeetingSchedule(this.cmodel);
        msview.setVisible(true);
    }

}
