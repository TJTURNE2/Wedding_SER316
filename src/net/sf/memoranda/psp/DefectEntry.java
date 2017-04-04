package net.sf.memoranda.psp;

import java.sql.Time;
import java.util.Date;

import net.sf.memoranda.psp.PSPDefectLog.PSPDefectType;


@SuppressWarnings("serial")
public class DefectEntry implements java.io.Serializable{

	private int ID;
	private Date dateFound;
	private PSPDefectType defectType;
	private PSPPhase phaseInjected;
	private PSPPhase phaseRemoved;
	private Time lengthFixing;
	private String description;
	
	public DefectEntry() {
		ID = 0;
		dateFound = null;
		defectType = PSPDefectType.TYPE10;
		phaseInjected = PSPPhase.PLANNING;
		phaseRemoved = PSPPhase.PLANNING;
		lengthFixing = null;
		description = "";
	}
	
	/**
	 * @param iD
	 * @param dateFound
	 * @param defectType
	 * @param phaseInjected
	 * @param phaseRemoved
	 * @param lengthFixing
	 * @param description
	 */
	public DefectEntry(int iD, Date dateFound, PSPDefectType defectType, PSPPhase phaseInjected,
			PSPPhase phaseRemoved, Time lengthFixing, String description) {
		super();
		ID = iD;
		this.dateFound = dateFound;
		this.defectType = defectType;
		this.phaseInjected = phaseInjected;
		this.phaseRemoved = phaseRemoved;
		this.lengthFixing = lengthFixing;
		this.description = description;
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
	 * @return the dateFound
	 */
	public Date getDateFound() {
		return dateFound;
	}

	/**
	 * @param dateFound
	 *            the dateFound to set
	 */
	public void setDateFound(Date dateFound) {
		this.dateFound = dateFound;
	}

	/**
	 * @return the defectType
	 */
	public PSPDefectType getDefectType() {
		return defectType;
	}

	/**
	 * @param defectType
	 *            the defectType to set
	 */
	public void setDefectType(PSPDefectType defectType) {
		this.defectType = defectType;
	}

	/**
	 * @return the phaseInjected
	 */
	public PSPPhase getPhaseInjected() {
		return phaseInjected;
	}

	/**
	 * @param phaseInjected
	 *            the phaseInjected to set
	 */
	public void setPhaseInjected(PSPPhase phaseInjected) {
		this.phaseInjected = phaseInjected;
	}

	/**
	 * @return the phaseRemoved
	 */
	public PSPPhase getPhaseRemoved() {
		return phaseRemoved;
	}

	/**
	 * @param phaseRemoved
	 *            the phaseRemoved to set
	 */
	public void setPhaseRemoved(PSPPhase phaseRemoved) {
		this.phaseRemoved = phaseRemoved;
	}

	/**
	 * @return the lengthFixing
	 */
	public Time getLengthFixing() {
		return lengthFixing;
	}

	/**
	 * @param lengthFixing
	 *            the lengthFixing to set
	 */
	public void setLengthFixing(Time lengthFixing) {
		this.lengthFixing = lengthFixing;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}