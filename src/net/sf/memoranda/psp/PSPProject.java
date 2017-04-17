/**
 * 
 */
package net.sf.memoranda.psp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Terry Turner
 *
 */
@SuppressWarnings("serial")
public class PSPProject implements java.io.Serializable {

	private static int counter = 0;
	private int ID;
	private String ProjectName;
	private String Description;
	private PSPType PSP;
	private PSPProjectPhase Phase;

	protected PSPPlanSummary Summary;
	protected List<PSPProjectTimeLogEntry> TimeLog;
	protected List<PSPProjectDefectEntry> DefectLog;
	protected List<PSPProjectRequirement> Requirements;
	protected List <PSPProjectDesignComponent> Components;
	protected List <PSPProjectTestCase> UserTests;

	public PSPProject() {
		ID = counter;
		counter = counter + 1;
		PSP = PSPType.PSP0;
		Phase = PSPProjectPhase.PLANNING;
		ProjectName = "Project " + ID;
		Description = "New Project";
		Summary = new PSPPlanSummary();
		TimeLog = new ArrayList<PSPProjectTimeLogEntry>();
		DefectLog = new ArrayList<PSPProjectDefectEntry>();
		Requirements = new ArrayList<PSPProjectRequirement>();
		Components = new ArrayList<PSPProjectDesignComponent>();

	}

	/**
	 * @return the counter
	 */
	public static int getCounter() {
		return counter;
	}

	/**
	 * @param counter
	 *            the counter to set
	 */
	public static void setCounter(int counter) {
		PSPProject.counter = counter;
	}

	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return ProjectName;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return Description;
	}

	/**
	 * @return the pSP
	 */
	public PSPType getPSP() {
		return PSP;
	}

	/**
	 * @return the phase
	 */
	public PSPProjectPhase getPhase() {
		return Phase;
	}

	/**
	 * @param iD
	 *            the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * @param projectName
	 *            the projectName to set
	 */
	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		Description = description;
	}

	/**
	 * @param pSP
	 *            the pSP to set
	 */
	public void setPSP(PSPType pSP) {
		PSP = pSP;
	}

	/**
	 * @param phase
	 *            the phase to set
	 */
	public void setPhase(PSPProjectPhase phase) {
		Phase = phase;
	}

	/**
	 * @return the summary
	 */
	public PSPPlanSummary getSummary() {
		return Summary;
	}

	/**
	 * @param summary
	 *            the summary to set
	 */
	public void setSummary(PSPPlanSummary summary) {
		Summary = summary;
	}

	/**
	 * @return the timeLog
	 */
	public List<PSPProjectTimeLogEntry> getTimeLog() {
		return TimeLog;
	}

	/**
	 * @param timeLog
	 *            the timeLog to set
	 */
	public void setTimeLog(List<PSPProjectTimeLogEntry> timeLog) {
		TimeLog = timeLog;
	}

	public void addTimeEntry(PSPProjectTimeLogEntry entry) {

		for (PSPProjectTimeLogEntry E : TimeLog) {
			if (entry.getID() <= E.getID()) {
				entry.setID(E.getID() + 1);
			}
		}
		TimeLog.add(entry);
	}
	public void removeTimeEntry(int ID){
		for (int i = 0; i < TimeLog.size(); i++) {
			if (TimeLog.get(i).getID() == ID) {
				TimeLog.remove(i);
			}
		}
	}

	/**
	 * @return the defectLog
	 */
	public List<PSPProjectDefectEntry> getDefectLog() {
		return DefectLog;
	}

	/**
	 * @param defectLog
	 *            the defectLog to set
	 */
	public void setDefectLog(List<PSPProjectDefectEntry> defectLog) {
		DefectLog = defectLog;
	}

	public void addDefectEntry(PSPProjectDefectEntry entry) {
		
		for (PSPProjectDefectEntry E : DefectLog) {
			if (entry.getID() <= E.getID()) {
				entry.setID(E.getID() + 1);
			}
		}
		DefectLog.add(entry);
	}
	public void removeDefectEntry(int ID){
		for (int i = 0; i < DefectLog.size(); i++) {
			if (DefectLog.get(i).getID() == ID) {
				DefectLog.remove(i);
			}
		}
	}

	/**
	 * @return the requirements
	 */
	public List<PSPProjectRequirement> getRequirements() {
		return Requirements;
	}

	/**
	 * @param requirements
	 *            the requirements to set
	 */
	public void setRequirements(List<PSPProjectRequirement> requirements) {
		Requirements = requirements;
	}

	public void addRequirementEntry(PSPProjectRequirement entry) {
		for (PSPProjectRequirement E : Requirements) {
			if (entry.getID() <= E.getID()) {
				entry.setID(E.getID() + 1);
			}
		}
		Requirements.add(entry);

	}

	public void removeRequirement(int ID){
//		for (PSPProjectRequirement E : Requirements) {
//			if (E.getID() == ID) {
//				Requirements.remove(E);
//			}
//		}
//		
		for (int i = 0; i < Requirements.size(); i++) {
			if (Requirements.get(i).getID() == ID) {
				Requirements.remove(i);
			}
		}
	}
	
	
	/**
	 * @return the components
	 */
	public List<PSPProjectDesignComponent> getComponents() {
		return Components;
	}

	/**
	 * @param componets the components to set
	 */
	public void setComponents(List<PSPProjectDesignComponent> componets) {
		Components = componets;
	}


	/**
	 * @return the userTests
	 */
	public List<PSPProjectTestCase> getUserTests() {
		return UserTests;
	}

	/**
	 * @param userTests the userTests to set
	 */
	public void setUserTests(List<PSPProjectTestCase> userTests) {
		UserTests = userTests;
	}



	/**
	 * Class for PSP Type
	 */
	public enum PSPType implements java.io.Serializable {
		PSP0("PSP0"), PSP01("PSP0.1"), PSP1("PSP1"), PSP11("PSP1.1"), PSP2("PSP2"), PSP21("PSP2.1"), PSP3("PSP3");

		private String name;

		PSPType(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return name;
		}
	}

}