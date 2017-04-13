package net.sf.memoranda;

public class ReminderLog {

	String date;
	String reminder;
	
	public ReminderLog(String date, String reminder) {
		this.date = date;
		this.reminder = reminder;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	public String getReminder() {
		return reminder;
	}

	public void setReminder(String reminder) {
		this.reminder = reminder;
	}
	
	public String[] getValuesArray() {
		String[] values = {date, reminder};
		return values;
	}
	
	public String toString() {
		return date + " " + reminder;
	}

	public String toFile() {
		return ("date*^*" + (date.equals("") ? "null" : date) +
				"*^*reminder*^*" + (reminder.equals("") ? "null" : reminder));
	}

}
