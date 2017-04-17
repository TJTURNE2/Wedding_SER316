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
	protected ArrayList<PSPProjectTimeLogEntry> TimeLog;
	protected ArrayList<PSPProjectDefectEntry> DefectLog;
	protected ArrayList<PSPProjectRequirement> Requirements;
	protected ArrayList<PSPProjectCodeComponent> Components;
	protected ArrayList<PSPProjectTestCase> UserTests;
	protected ArrayList<PSPProjectCodeReview> Reviews;

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
		Components = new ArrayList<PSPProjectCodeComponent>();
		UserTests = new ArrayList<PSPProjectTestCase>();
		Reviews = new ArrayList<PSPProjectCodeReview>();
		
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
	public void setTimeLog(ArrayList<PSPProjectTimeLogEntry> timeLog) {
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

	public void removeTimeEntry(int ID) {
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
	public void setDefectLog(ArrayList<PSPProjectDefectEntry> defectLog) {
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

	public void removeDefectEntry(int ID) {
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
	public void setRequirements(ArrayList<PSPProjectRequirement> requirements) {
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

	public void removeRequirement(int ID) {
		for (int i = 0; i < Requirements.size(); i++) {
			if (Requirements.get(i).getID() == ID) {
				Requirements.remove(i);
			}
		}
	}

	/**
	 * @return the components
	 */
	public List<PSPProjectCodeComponent> getComponents() {
		return Components;
	}

	/**
	 * @param componets
	 *            the components to set
	 */
	public void setComponents(ArrayList<PSPProjectCodeComponent> componets) {
		Components = componets;
	}

	public void addComponents(PSPProjectCodeComponent entry) {
		for (PSPProjectCodeComponent E : Components) {
			if (entry.getID() <= E.getID()) {
				entry.setID(E.getID() + 1);
			}
		}
		Components.add(entry);
	}

	public void removeComponents(int ID) {
		for (int i = 0; i < Components.size(); i++) {
			if (Components.get(i).getID() == ID) {
				Components.remove(i);
			}
		}
	}

	/**
	 * @return the userTests
	 */
	public List<PSPProjectTestCase> getUserTests() {
		return UserTests;
	}

	/**
	 * @param userTests
	 *            the userTests to set
	 */
	public void setUserTests(ArrayList<PSPProjectTestCase> userTests) {
		UserTests = userTests;
	}

	public void addUserTests(PSPProjectTestCase entry) {
		for (PSPProjectTestCase E : UserTests) {
			if (entry.getID() <= E.getID()) {
				entry.setID(E.getID() + 1);
			}
		}
		UserTests.add(entry);

	}

	public void removeUserTests(int ID) {
		for (int i = 0; i < UserTests.size(); i++) {
			if (UserTests.get(i).getID() == ID) {
				UserTests.remove(i);
			}
		}
	}

	
	/**
	 * @return the reviews
	 */
	public ArrayList<PSPProjectCodeReview> getReviews() {
		return Reviews;
	}

	/**
	 * @param reviews the reviews to set
	 */
	public void setReviews(ArrayList<PSPProjectCodeReview> reviews) {
		Reviews = reviews;
	}

	public void addReviews(PSPProjectCodeReview entry) {
		for (PSPProjectCodeReview E : Reviews) {
			if (entry.getID() <= E.getID()) {
				entry.setID(E.getID() + 1);
			}
		}
		Reviews.add(entry);

	}

	public void removeReviews(int ID) {
		for (int i = 0; i < Reviews.size(); i++) {
			if (Reviews.get(i).getID() == ID) {
				Reviews.remove(i);
			}
		}
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
