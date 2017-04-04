/**
 * 
 */
package net.sf.memoranda.psp;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author TJTurne2
 *
 */

@SuppressWarnings("serial")
public class ZZZPSPDefectLog implements java.io.Serializable {

//	private static int count = 0;
//	private List<DefectEntry> Entries = new ArrayList<>();
//
//	/**
//	 * @param entries
//	 */
//	public PSPDefectLog() {
//		Entries = new ArrayList<>();
//		count = Entries.size();
//	}
//
//	/**
//	 * @param entries
//	 */
//	public PSPDefectLog(List<DefectEntry> entries) {
//		super();
//		Entries = entries;
//		count = Entries.size();
//	}
//	
//	public void addEntry(DefectEntry entry) {
//		for (int i = 0; i < Entries.size(); i++) {
//			if (Entries.get(i).getID() != i) {
//				entry.setID(i);
//			}
//		}
//		Entries.add(entry);
//		count += 1;
//	}
//
//	public void addEntry(int iD, Date dateFound, PSPDefectType defectType, PSPPhase phaseInjected,
//			PSPPhase phaseRemoved, Time lengthFixing, String description) {
//		DefectEntry entry = new DefectEntry(iD,dateFound,defectType,phaseInjected,phaseRemoved,lengthFixing,description);
//		
//				Entries.add(entry);
//	}
//	
//	public void updateEntry(int iD, Date dateFound, PSPDefectType defectType, PSPPhase phaseInjected,
//			PSPPhase phaseRemoved, Time lengthFixing, String description) {
//		DefectEntry entry = new DefectEntry(iD,dateFound,defectType,phaseInjected,phaseRemoved,lengthFixing,description);
//		for (int i = 0; i < Entries.size(); i++) {
//			if (Entries.get(i).getID() == entry.getID()) {
//				Entries.set(i, entry);
//			}
//		}
//	}
//
//	/**
//	 * @return the count
//	 */
//	public static int getCount() {
//		return count;
//	}
//
//	/**
//	 * @param count
//	 *            the count to set
//	 */
//	public static void setCount(int count) {
//		PSPDefectLog.count = count;
//	}
//
//	/**
//	 * @return the entries
//	 */
//	public List<DefectEntry> getEntries() {
//		return Entries;
//	}
//
//	/**
//	 * @param entries
//	 *            the entries to set
//	 */
//	public void setEntries(List<DefectEntry> entries) {
//		Entries = entries;
//	}
//
////	public class DefectEntry implements java.io.Serializable{
////
////		private int ID;
////		private Date dateFound;
////		private PSPDefectType defectType;
////		private PSPPhase phaseInjected;
////		private PSPPhase phaseRemoved;
////		private Time lengthFixing;
////		private String description;
////		
////		public DefectEntry() {
////			ID = 0;
////			dateFound = null;
////			defectType = PSPDefectType.TYPE10;
////			phaseInjected = PSPPhase.PLANNING;
////			phaseRemoved = PSPPhase.PLANNING;
////			lengthFixing = null;
////			description = "";
////		}
////		
////		/**
////		 * @param iD
////		 * @param dateFound
////		 * @param defectType
////		 * @param phaseInjected
////		 * @param phaseRemoved
////		 * @param lengthFixing
////		 * @param description
////		 */
////		public DefectEntry(int iD, Date dateFound, PSPDefectType defectType, PSPPhase phaseInjected,
////				PSPPhase phaseRemoved, Time lengthFixing, String description) {
////			super();
////			ID = iD;
////			this.dateFound = dateFound;
////			this.defectType = defectType;
////			this.phaseInjected = phaseInjected;
////			this.phaseRemoved = phaseRemoved;
////			this.lengthFixing = lengthFixing;
////			this.description = description;
////		}
////
////		/**
////		 * @return the iD
////		 */
////		protected int getID() {
////			return ID;
////		}
////
////		/**
////		 * @param iD
////		 *            the iD to set
////		 */
////		protected void setID(int iD) {
////			ID = iD;
////		}
////
////		/**
////		 * @return the dateFound
////		 */
////		protected Date getDateFound() {
////			return dateFound;
////		}
////
////		/**
////		 * @param dateFound
////		 *            the dateFound to set
////		 */
////		protected void setDateFound(Date dateFound) {
////			this.dateFound = dateFound;
////		}
////
////		/**
////		 * @return the defectType
////		 */
////		protected PSPDefectType getDefectType() {
////			return defectType;
////		}
////
////		/**
////		 * @param defectType
////		 *            the defectType to set
////		 */
////		protected void setDefectType(PSPDefectType defectType) {
////			this.defectType = defectType;
////		}
////
////		/**
////		 * @return the phaseInjected
////		 */
////		protected PSPPhase getPhaseInjected() {
////			return phaseInjected;
////		}
////
////		/**
////		 * @param phaseInjected
////		 *            the phaseInjected to set
////		 */
////		protected void setPhaseInjected(PSPPhase phaseInjected) {
////			this.phaseInjected = phaseInjected;
////		}
////
////		/**
////		 * @return the phaseRemoved
////		 */
////		protected PSPPhase getPhaseRemoved() {
////			return phaseRemoved;
////		}
////
////		/**
////		 * @param phaseRemoved
////		 *            the phaseRemoved to set
////		 */
////		protected void setPhaseRemoved(PSPPhase phaseRemoved) {
////			this.phaseRemoved = phaseRemoved;
////		}
////
////		/**
////		 * @return the lengthFixing
////		 */
////		protected Time getLengthFixing() {
////			return lengthFixing;
////		}
////
////		/**
////		 * @param lengthFixing
////		 *            the lengthFixing to set
////		 */
////		protected void setLengthFixing(Time lengthFixing) {
////			this.lengthFixing = lengthFixing;
////		}
////
////		/**
////		 * @return the description
////		 */
////		protected String getDescription() {
////			return description;
////		}
////
////		/**
////		 * @param description
////		 *            the description to set
////		 */
////		protected void setDescription(String description) {
////			this.description = description;
////		}
////
////	}
//
//	public enum PSPDefectType implements java.io.Serializable{
//
//		TYPE10("Documentation"), TYPE20("Syntax"), TYPE30("Build, Package"), TYPE40("Assignment"), TYPE50(
//				"Interface"), TYPE60(
//						"Checking"), TYPE70("Data"), TYPE80("Function"), TYPE90("System"), TYPE100("Environment");
//
//		private String name;
//		private String description;
//
//		PSPDefectType(String name) {
//			this.name = name;
//		}
//
//		@Override
//		public String toString() {
//			return name;
//		}
//
//		/**
//		 * @return the name
//		 */
//		public String getName() {
//			return name;
//		}
//
//		/**
//		 * @param name
//		 *            the name to set
//		 */
//		public void setName(String name) {
//			this.name = name;
//		}
//
//		/**
//		 * @return the description
//		 */
//		public String getDescription() {
//			return description;
//		}
//
//		/**
//		 * @param description
//		 *            the description to set
//		 */
//		public void setDescription(String description) {
//			this.description = description;
//		}
//
//	}

}
