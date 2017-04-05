/**
 * 
 */
package net.sf.memoranda.psp;
import java.util.Date;

@SuppressWarnings("serial")
public class PSPPlanSummary implements java.io.Serializable {

	private String Student;
	private String Program;
	private String instructor;
	private Date startDate;
	private Date endDate;
	private String language;

	protected PSPProjectLOCSummary ProgramSize;
	protected PSPProjectLogPhase PhaseTime;
	protected PSPProjectLogPhase PhaseDefects;
	protected PSPProjectLogPhase DefectsRemoved;

	public PSPPlanSummary() {
		Student = "null";
		Program = "null";
		instructor = "null";
		startDate = null;
		endDate = null;
		language = "null";
		ProgramSize = new PSPProjectLOCSummary();
		PhaseTime = new PSPProjectLogPhase();
		PhaseDefects = new PSPProjectLogPhase();
		DefectsRemoved = new PSPProjectLogPhase();
	}

	/**
	 * @param student
	 * @param program
	 * @param instructor
	 * @param startDate
	 * @param endDate
	 * @param language
	 * @param programSize
	 * @param phaseTime
	 * @param phaseDefects
	 * @param defectsRemoved
	 */
	public PSPPlanSummary(String student, String program, String instructor, Date startDate, Date endDate,
			String language, PSPProjectLOCSummary programSize, PSPProjectLogPhase phaseTime, PSPProjectLogPhase phaseDefects,
			PSPProjectLogPhase defectsRemoved) {
		super();
		Student = student;
		Program = program;
		this.instructor = instructor;
		this.startDate = startDate;
		this.endDate = endDate;
		this.language = language;
		ProgramSize = programSize;
		PhaseTime = phaseTime;
		PhaseDefects = phaseDefects;
		DefectsRemoved = defectsRemoved;
	}

	/**
	 * @return the student
	 */
	public String getStudent() {
		return Student;
	}

	/**
	 * @param student
	 *            the student to set
	 */
	public void setStudent(String student) {
		Student = student;
	}

	/**
	 * @return the program
	 */
	public String getProgram() {
		return Program;
	}

	/**
	 * @param program
	 *            the program to set
	 */
	public void setProgram(String program) {
		Program = program;
	}

	/**
	 * @return the instructor
	 */
	public String getInstructor() {
		return instructor;
	}

	/**
	 * @param instructor
	 *            the instructor to set
	 */
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language
	 *            the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @return the programSize
	 */
	public PSPProjectLOCSummary getProgramSize() {
		return ProgramSize;
	}

	/**
	 * @param programSize
	 *            the programSize to set
	 */
	public void setProgramSize(PSPProjectLOCSummary programSize) {
		ProgramSize = programSize;
	}

	/**
	 * @return the phaseTime
	 */
	public PSPProjectLogPhase getPhaseTime() {
		return PhaseTime;
	}

	/**
	 * @param phaseTime
	 *            the phaseTime to set
	 */
	public void setPhaseTime(PSPProjectLogPhase phaseTime) {
		PhaseTime = phaseTime;
	}

	/**
	 * @return the phaseDefects
	 */
	public PSPProjectLogPhase getPhaseDefects() {
		return PhaseDefects;
	}

	/**
	 * @param phaseDefects
	 *            the phaseDefects to set
	 */
	public void setPhaseDefects(PSPProjectLogPhase phaseDefects) {
		PhaseDefects = phaseDefects;
	}

	/**
	 * @return the defectsRemoved
	 */
	public PSPProjectLogPhase getDefectsRemoved() {
		return DefectsRemoved;
	}

	/**
	 * @param defectsRemoved
	 *            the defectsRemoved to set
	 */
	public void setDefectsRemoved(PSPProjectLogPhase defectsRemoved) {
		DefectsRemoved = defectsRemoved;
	}
}
