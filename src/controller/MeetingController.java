package controller;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import model.*;
import view.CalendarFrame;
import view.MeetingSchedule;

public class MeetingController {
    CalendarModel model;
    MeetingSchedule frame;

    private JList<? extends Meeting> list;
    private int idx;

    public MeetingController(CalendarModel cm, MeetingSchedule frame){
        this.model = cm;
        this.frame = frame;
    }

    public void deleteProcess(){
        list = frame.meetingList;
        DefaultListModel<Meeting> lm = (DefaultListModel<Meeting>) list.getModel();
        Meeting selectedM = list.getSelectedValue();
        model.meetings.remove(selectedM);
        lm.remove(idx);

        frame.repaint();
    }

    public void selectItemProcess() {
        list = frame.meetingList;
        idx = list.getSelectedIndex();
        frame.deleteBtn.setEnabled(idx >= 0);
        
    }

    public void showMonSchedule() {
        
    }

    public void showDailySchedule(){

    }

}
