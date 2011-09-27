package mycalender;

import java.util.Date;

public class Events {
    public Date startDate;
    public Date endDate;
    public String eventName;
    public void setEvent(Date start, Date end, String name){
    	startDate=start;
    	endDate=end;
    	eventName=name;
    }
    public Events getEvent(){
    	return this;
    }
}
