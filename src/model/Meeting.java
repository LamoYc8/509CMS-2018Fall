package model;

import java.util.Date;

public class Meeting {
    String personN;
    Date meetingD;
    TInterval meetingTS;

    public Meeting(String name, Date chosenDate, TInterval timeSlot) {
        this.personN = name;
        this.meetingD = chosenDate;
        this.meetingTS = timeSlot;
    }

    
}


