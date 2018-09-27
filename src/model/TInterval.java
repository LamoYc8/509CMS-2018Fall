package model;

import java.io.Serializable;

public class TInterval implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String startTime;
    public String endTime;

    public  TInterval(String sTime, String eTime) {
        this.startTime = sTime;
        this.endTime = eTime; 
        
    }

    public String toString(){
        return startTime + " - " + endTime;
    }

    
}
