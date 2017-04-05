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

	
	public PSPProject(){
		
		ID = counter;
		counter = counter +1;
		PSP = PSPType.PSP0;
		Phase = PSPProjectPhase.PLANNING;
		ProjectName = "Project " + ID;
		Description = "New Project";
		Summary = new PSPPlanSummary();
		TimeLog = new ArrayList<PSPProjectTimeLogEntry>();
		DefectLog = new ArrayList<PSPProjectDefectEntry>();
		Requirements = new ArrayList<PSPProjectRequirement>();
		
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
	public PSPProjectPhase getPhase() {
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
	 * @param summary the summary to set
	 */
	public void setSummary(PSPPlanSummary summary) {
		Summary = summary;
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
