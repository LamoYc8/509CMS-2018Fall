package model;

import java.util.Date;

public class Meeting {
    public String personN;
    public String meetingD;
    public String meetingTS;

    public Meeting(String name, String chosenDate, String timeSlot) {
        this.personN = name;
        this.meetingD = chosenDate;
        this.meetingTS = timeSlot;
    }
    
    public String toString() {
    	return personN +"  " + meetingD +" @ " + meetingTS;
    }

    
}


