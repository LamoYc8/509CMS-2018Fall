package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CalendarModel implements Comparable<CalendarModel> {
	String name;
	String startDate;
	String endDate;
	//ArrayList<DateModel> dateList;
	ArrayList<Date> dateList;
	ArrayList<TInterval> timeSlots;

	final String startTime = "10:00";
    final String endTime = "17:00";
	

	public CalendarModel(String name, String sDate, String eDate, int interval) throws ParseException {
		//Give the name to the calendar
		this.name = name;
		this.startDate = sDate;
		this.endDate = eDate;

		//set up dateList based on the inputs of the user
		//Eliminate all the weekdays
		SimpleDateFormat dFormat = new SimpleDateFormat("MMM-d-yyyy");
		Date startDate = dFormat.parse(sDate);
		Date endDate = dFormat.parse(eDate);
		this.dateList = new ArrayList<Date>();

		Calendar tempStartDate = Calendar.getInstance();
		tempStartDate.setTime(startDate);
		Calendar tempEndDate = Calendar.getInstance();
		tempEndDate.setTime(endDate);
		tempEndDate.add(Calendar.DATE, +1); //Include the end date

		while(tempStartDate.before(tempEndDate)){
			if(tempStartDate.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && 
			tempStartDate.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY ){
				this.dateList.add(tempStartDate.getTime());
				tempStartDate.add(Calendar.DAY_OF_YEAR, 1);
			}else{
				tempStartDate.add(Calendar.DAY_OF_YEAR, 1);

			}
		}


		//set up timeSlots from 10:00 to 17:00 based on the input of the interval
		SimpleDateFormat tFormat = new SimpleDateFormat("HH:mm");
        Date sTime = tFormat.parse(this.startTime);
        Date eTime = tFormat.parse(this.endTime);
		
		this.timeSlots = new ArrayList<TInterval>();
		ArrayList<String> timeInterval = new ArrayList<String>();

        while (sTime.getTime() <= eTime.getTime()) {
            timeInterval.add(tFormat.format(sTime));
            Calendar c = Calendar.getInstance();
            c.setTime(sTime);
            c.add(Calendar.MINUTE, interval);
            sTime = c.getTime();
		}
		
		for (int i = 0; i < timeInterval.size()-1; i++) {
			TInterval temp = new TInterval(timeInterval.get(i), timeInterval.get(i+1));
			this.timeSlots.add(temp);
		}


	}

	public String toString() {
		return "Calender: " + this.name + " starts from " + this.startDate + " ends at " + this.endDate;
	}
	

	@Override
	public int compareTo(CalendarModel o) {
		return name.compareTo(o.name);
	}
}
