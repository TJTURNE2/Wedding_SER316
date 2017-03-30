package net.sf.memoranda;

public class TimeLog {
	String date;
	String startTime;
	String endTime;
	String interruptTime;
	String phase;
	String comments;
	
	public TimeLog(String date, String startTime, String endTime, String interruptTime, String phase, String comments) {
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.interruptTime = interruptTime;
		this.phase = phase;
		this.comments = comments;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getInterruptTime() {
		return interruptTime;
	}

	public void setInterruptTime(String interruptTime) {
		this.interruptTime = interruptTime;
	}

	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public String[] getValuesArray() {
		String[] values = {date, startTime, endTime, interruptTime, phase, comments};
		return values;
	}
	
	public String toString() {
		return date + " " + startTime + " " + endTime + " " + phase;
	}
}
