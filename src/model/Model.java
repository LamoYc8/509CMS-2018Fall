package model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Hashtable;

public class Model implements Serializable  {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Hashtable<String, CalendarModel> calendars = new Hashtable<>();

    public CalendarModel add(CalendarModel calendar){
        CalendarModel oldC = calendars.get(calendar.getName());
        calendars.put(calendar.name, calendar);
        return oldC;
    }

    public CalendarModel delete(String calendarName){
        CalendarModel oldC = calendars.get(calendarName);
        calendars.remove(calendarName);
        return oldC;
    }

    public CalendarModel[] getArray(){
        CalendarModel[] array = calendars.values().toArray(new CalendarModel[0]);
		Arrays.sort(array);
		return array;
    }

  

    //more methods: sort, return a sorted array, return all calendar as an iterator and so on;
}
