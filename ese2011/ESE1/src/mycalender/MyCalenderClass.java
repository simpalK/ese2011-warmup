package mycalender;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class MyCalenderClass {
	public String calendarName;
	public Users ownername;
	public ArrayList<Events> calEvents;
	public ArrayList<Users> calUsers;
	private static MyCalenderClass calinstance =null;
	public int eventCount;
	private MyCalenderClass(String calname,Users owname)
	{
		calendarName = calname;
		ownername=owname;
		calEvents = new ArrayList();
		calUsers= new ArrayList();
		eventCount=0;
	}
	public static MyCalenderClass getMyCalenderClassInstance(String calname,Users owname)
	{
		if(calinstance==null){
			calinstance=new MyCalenderClass(calname,owname);
		}
		return calinstance;
	}
	public Object clone()throws CloneNotSupportedException
	{
	    throw new CloneNotSupportedException(); 
	}
		 
	private void addEvent(Date start,Date end,String owner,String eventname){
		Events e=new Events();
		e.setEvent(start, end, eventname);
		calEvents.add(e);
		eventCount++;
	}
   public ArrayList<Events> viewEvent(){
	   return calEvents;
   }
   
}
