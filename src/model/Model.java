package model;

import java.util.Hashtable;

public class Model {
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

  

    //more methods: sort, return a sorted array, return all calendar as an iterator and so on;
}
