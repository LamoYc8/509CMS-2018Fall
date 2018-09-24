package controller;

import java.text.ParseException;

import javax.swing.DefaultListModel;
import javax.swing.JList;


import model.*;
import view.*;

public class FirstViewController {

    Model model;
    CalendarFrame frame;

    private JList<CalendarModel> list = frame.getCalendarList();
    private int idx = list.getSelectedIndex();

    public FirstViewController(Model m, CalendarFrame frame){
        this.model = m;
        this.frame = frame;
    }

    public void createProcess() throws ParseException {
        
        CreateCalendar ccview = new CreateCalendar();
        CalendarModel newCalendar;

        ccview.setModal(true);
        ccview.setVisible(true);

        if (ccview.wasUpdated()) {
            String tempName = ccview.getNameField().getText();
            String tempSD = ccview.getStartDateField().getText();
            String tempED = ccview.getEndDateField().getText();
            int tempInterval = (int) ccview.getIntervalBox().getSelectedItem();
            newCalendar = new CalendarModel(tempName, tempSD, tempED, tempInterval);

            model.add(newCalendar);

        }

        ccview.dispose();

        frame.repaint();

    }
    
    public void deleteProcess() {
    	if (idx < 0) {
            return;
        }

        DefaultListModel<CalendarModel> lm = (DefaultListModel<CalendarModel>) list.getModel();
        CalendarModel c = list.getSelectedValue();
        model.delete(c.getName());
        lm.remove(idx);

        frame.repaint();
    }

    public void openProcess() {
        CalendarModel c = list.getSelectedValue();
        SingleCalendar scview = new SingleCalendar(c);
        scview.setVisible(true);
        
    }

    public void selectItemProcess() {
        frame.getdeleteBtn().setEnabled(idx >= 0);
        frame.getOpenBtn().setEnabled(idx >= 0);
    }
}
