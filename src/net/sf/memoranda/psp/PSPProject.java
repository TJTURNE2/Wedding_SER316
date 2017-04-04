/**
 * 
 */
package net.sf.memoranda.psp;

/**
 * @author Terry Turner
 *
 */
@SuppressWarnings("serial")
public class PSPProject implements java.io.Serializable {
	/**
	 * 
	 */
	
	private static int counter = 0;
			
	private int ID;
	private String ProjectName;
	private String Description;
	private PSPType PSP;
	private PSPPhase Phase;
	
	protected PSPPlanSummary Summary;
	protected PSPTimeLog TimeLog;
	protected PSPDefectLog DefectLog;
	protected PSPRequirements Requirements;

	
	public PSPProject(){
		ID = counter;
		counter = counter +1;
		PSP = PSPType.PSP0;
		Phase = PSPPhase.PLANNING;
		ProjectName = "Project " + ID;
		Description = "New Project";
		Summary = new PSPPlanSummary();
		TimeLog = new PSPTimeLog();
		DefectLog = new PSPDefectLog();
		Requirements = new PSPRequirements();
		
	}
	
	/**
	 * @return the counter
	 */
	public static int getCounter() {
		return counter;
	}

	/**
	 * @param counter the counter to set
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
	public PSPPhase getPhase() {
		return Phase;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}
	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		Description = description;
	}
	/**
	 * @param pSP the pSP to set
	 */
	public void setPSP(PSPType pSP) {
		PSP = pSP;
	}
	/**
	 * @param phase the phase to set
	 */
	public void setPhase(PSPPhase phase) {
		Phase = phase;
	}

	/**
	 * @return the summary
	 */
	public PSPPlanSummary getSummary() {
		return Summary;
	}

	/**
	 * @param summary the summary to set
	 */
	public void setSummary(PSPPlanSummary summary) {
		Summary = summary;
	}

	/**
	 * @return the timeLog
	 */
	public PSPTimeLog getTimeLog() {
		return TimeLog;
	}

	/**
	 * @param timeLog the timeLog to set
	 */
	public void setTimeLog(PSPTimeLog timeLog) {
		TimeLog = timeLog;
	}

	/**
	 * @return the defectLog
	 */
	public PSPDefectLog getDefectLog() {
		return DefectLog;
	}

	/**
	 * @param defectLog the defectLog to set
	 */
	public void setDefectLog(PSPDefectLog defectLog) {
		DefectLog = defectLog;
	}

	/**
	 * @return the requirments
	 */
	public PSPRequirements getRequirments() {
		return Requirements;
	}

	/**
	 * @param requirments the requirements to set
	 */
	public void setRequirments(PSPRequirements requirments) {
		Requirements = requirments;
	}

	/**
	 * Class for PSP Type
	 */
	public enum PSPType implements java.io.Serializable{
		PSP0("PSP0"), PSP01("PSP0.1"), PSP1("PSP1"), PSP11("PSP1.1"), PSP2("PSP2"), PSP21("PSP2.1"), PSP3("PSP3");

		private String name;
		
		PSPType(String name){
			this.name = name;
		}
		
		@Override
		public String toString(){
			return name;
		}
	}
	
	
	
}
