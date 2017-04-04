package net.sf.memoranda.psp;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

@SuppressWarnings("serial")
public class TimeEntry implements java.io.Serializable{

	private int ID;
	private Date entryDate;
	private Time StartingTime, stoppingTime, interruptionTime;
	private PSPPhase Phase;
	private String comments;

	public TimeEntry() {
		ID = 0;
		entryDate = Calendar.getInstance().getTime();
		StartingTime = null;
		stoppingTime = null;
		interruptionTime = null;
		Phase = PSPPhase.DESIGN;
		comments = "";

	}

	/**
	 * @param iD
	 * @param entryDate
	 * @param startingTime
	 * @param stoppingTime
	 * @param interruptionTime
	 * @param phase
	 * @param comments
	 */
	public TimeEntry(int iD, Date entryDate, Time startingTime, Time stoppingTime, Time interruptionTime,
			PSPPhase phase, String comments) {
		super();
		ID = iD;
		this.entryDate = entryDate;
		StartingTime = startingTime;
		this.stoppingTime = stoppingTime;
		this.interruptionTime = interruptionTime;
		Phase = phase;
		this.comments = comments;
	}

	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @param iD
	 *            the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * @return the entryDate
	 */
	public Date getEntryDate() {
		return entryDate;
	}

	/**
	 * @param entryDate
	 *            the entryDate to set
	 */
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	/**
	 * @return the startingTime
	 */
	public Time getStartingTime() {
		return StartingTime;
	}

	/**
	 * @param startingTime
	 *            the startingTime to set
	 */
	public void setStartingTime(Time startingTime) {
		StartingTime = startingTime;
	}

	/**
	 * @return the stoppingTime
	 */
	public Time getStoppingTime() {
		return stoppingTime;
	}

	/**
	 * @param stoppingTime
	 *            the stoppingTime to set
	 */
	public void setStoppingTime(Time stoppingTime) {
		this.stoppingTime = stoppingTime;
	}

	/**
	 * @return the interruptionTime
	 */
	public Time getInterruptionTime() {
		return interruptionTime;
	}

	/**
	 * @param interruptionTime
	 *            the interruptionTime to set
	 */
	public void setInterruptionTime(Time interruptionTime) {
		this.interruptionTime = interruptionTime;
	}

	/**
	 * @return the phase
	 */
	public PSPPhase getPhase() {
		return Phase;
	}

	/**
	 * @param phase
	 *            the phase to set
	 */
	public void setPhase(PSPPhase phase) {
		Phase = phase;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments
	 *            the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

}