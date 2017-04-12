package net.sf.memoranda.psp;

import java.sql.Time;
import java.util.Date;

@SuppressWarnings("serial")
public class PSPProjectDefectEntry implements java.io.Serializable {

	private static int count = 0;
	private int ID;
	private Date dateFound;
	private PSPDefectType defectType;
	private PSPProjectPhase phaseInjected;
	private PSPProjectPhase phaseRemoved;
	private Time lengthFixing;
	private String fileName;
	private String description;
	private int severity;

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		PSPProjectDefectEntry.count = count;
	}

	public PSPProjectDefectEntry() {
		count +=1;
		ID = count;
		dateFound = null;
		defectType = PSPDefectType.TYPE10;
		phaseInjected = PSPProjectPhase.PLANNING;
		phaseRemoved = PSPProjectPhase.PLANNING;
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
	public PSPProjectDefectEntry(int iD, Date dateFound, PSPDefectType defectType, PSPProjectPhase phaseInjected,
			PSPProjectPhase phaseRemoved, Time lengthFixing, String description) {
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
	public PSPProjectPhase getPhaseInjected() {
		return phaseInjected;
	}

	/**
	 * @param phaseInjected
	 *            the phaseInjected to set
	 */
	public void setPhaseInjected(PSPProjectPhase phaseInjected) {
		this.phaseInjected = phaseInjected;
	}

	/**
	 * @return the phaseRemoved
	 */
	public PSPProjectPhase getPhaseRemoved() {
		return phaseRemoved;
	}

	/**
	 * @param phaseRemoved
	 *            the phaseRemoved to set
	 */
	public void setPhaseRemoved(PSPProjectPhase phaseRemoved) {
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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
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

	
	public int getSeverity() {
		return severity;
	}

	public void setSeverity(int severity) {
		this.severity = severity;
	}


	public enum PSPDefectType implements java.io.Serializable {

		TYPE10("Documentation"), TYPE20("Syntax"), TYPE30("Build, Package"), TYPE40("Assignment"), TYPE50(
				"Interface"), TYPE60(
						"Checking"), TYPE70("Data"), TYPE80("Function"), TYPE90("System"), TYPE100("Environment");

		private String name;
		private String description;

		PSPDefectType(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return name;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name
		 *            the name to set
		 */
		public void setName(String name) {
			this.name = name;
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

}