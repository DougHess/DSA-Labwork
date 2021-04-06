
public class Calendar
{
	private String Event;
	private String date;
	private String year;
	private String month;
	
	public Calendar(String Event, String date, String month, String year){
	this.Event=Event;
	this.setDate(date);
	this.setYear(year);
	this.month=month;
	}

	public String getEvent() {
		return Event;
	}

	public void setEvent(String event) {
		Event = event;
	}



	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	public String toString() {
		return "Event "+getEvent()+" is on "+getDate()+" "+getMonth()+" of "+getYear();
	}

	
	
}