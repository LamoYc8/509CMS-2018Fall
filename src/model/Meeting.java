package model;

import java.util.Date;

public class Meeting {
    public String personN;
    public Date meetingD;
    public TInterval meetingTS;

    public Meeting(String name, Date chosenDate, TInterval timeSlot) {
        this.personN = name;
        this.meetingD = chosenDate;
        this.meetingTS = timeSlot;
    }

    
}


