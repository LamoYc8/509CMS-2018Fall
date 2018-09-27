package model;

import java.io.Serializable;

public class Meeting implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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


