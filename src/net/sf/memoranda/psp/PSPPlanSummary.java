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

	protected ProgramSizeSummary ProgramSize;
	protected TimeInPhase PhaseTime;
	protected PhaseDefectsInjected PhaseDefects;
	protected PhaseDefectsRemoved DefectsRemoved;

	public PSPPlanSummary() {
		Student = "null";
		Program = "null";
		instructor = "null";
		startDate = null;
		endDate = null;
		language = "null";
		ProgramSize = new ProgramSizeSummary();
		PhaseTime = new TimeInPhase();
		PhaseDefects = new PhaseDefectsInjected();
		DefectsRemoved = new PhaseDefectsRemoved();
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
			String language, ProgramSizeSummary programSize, TimeInPhase phaseTime, PhaseDefectsInjected phaseDefects,
			PhaseDefectsRemoved defectsRemoved) {
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
	public ProgramSizeSummary getProgramSize() {
		return ProgramSize;
	}

	/**
	 * @param programSize
	 *            the programSize to set
	 */
	public void setProgramSize(ProgramSizeSummary programSize) {
		ProgramSize = programSize;
	}

	/**
	 * @return the phaseTime
	 */
	public TimeInPhase getPhaseTime() {
		return PhaseTime;
	}

	/**
	 * @param phaseTime
	 *            the phaseTime to set
	 */
	public void setPhaseTime(TimeInPhase phaseTime) {
		PhaseTime = phaseTime;
	}

	/**
	 * @return the phaseDefects
	 */
	public PhaseDefectsInjected getPhaseDefects() {
		return PhaseDefects;
	}

	/**
	 * @param phaseDefects
	 *            the phaseDefects to set
	 */
	public void setPhaseDefects(PhaseDefectsInjected phaseDefects) {
		PhaseDefects = phaseDefects;
	}

	/**
	 * @return the defectsRemoved
	 */
	public PhaseDefectsRemoved getDefectsRemoved() {
		return DefectsRemoved;
	}

	/**
	 * @param defectsRemoved
	 *            the defectsRemoved to set
	 */
	public void setDefectsRemoved(PhaseDefectsRemoved defectsRemoved) {
		DefectsRemoved = defectsRemoved;
	}
	
//	public class ProgramSizeSummary implements java.io.Serializable{
//		private PSPLogEntry Base;
//		private PSPLogEntry Deleted;
//		private PSPLogEntry Modified;
//		private PSPLogEntry Added;
//		private PSPLogEntry Reused;
//		private PSPLogEntry AddedModified;
//		private PSPLogEntry Total;
//		private PSPLogEntry NewReused;
//
//		public ProgramSizeSummary() {
//			Base = new PSPLogEntry();
//			Deleted = new PSPLogEntry();
//			Modified = new PSPLogEntry();
//			Added = new PSPLogEntry();
//			Reused = new PSPLogEntry();
//			AddedModified = new PSPLogEntry();
//			Total = new PSPLogEntry();
//			NewReused = new PSPLogEntry();
//		}
//
//		/**
//		 * @param base
//		 * @param deleted
//		 * @param modified
//		 * @param added
//		 * @param reused
//		 * @param addedModified
//		 * @param total
//		 * @param newReused
//		 */
//		public ProgramSizeSummary(PSPLogEntry base, PSPLogEntry deleted, PSPLogEntry modified, PSPLogEntry added,
//				PSPLogEntry reused, PSPLogEntry addedModified, PSPLogEntry total, PSPLogEntry newReused) {
//			super();
//			Base = base;
//			Deleted = deleted;
//			Modified = modified;
//			Added = added;
//			Reused = reused;
//			AddedModified = addedModified;
//			Total = total;
//			NewReused = newReused;
//		}
//
//		/**
//		 * @return the base
//		 */
//		public PSPLogEntry getBase() {
//			return Base;
//		}
//
//		/**
//		 * @param base
//		 *            the base to set
//		 */
//		public void setBase(PSPLogEntry base) {
//			Base = base;
//		}
//
//		/**
//		 * @return the deleted
//		 */
//		public PSPLogEntry getDeleted() {
//			return Deleted;
//		}
//
//		/**
//		 * @param deleted
//		 *            the deleted to set
//		 */
//		public void setDeleted(PSPLogEntry deleted) {
//			Deleted = deleted;
//		}
//
//		/**
//		 * @return the modified
//		 */
//		public PSPLogEntry getModified() {
//			return Modified;
//		}
//
//		/**
//		 * @param modified
//		 *            the modified to set
//		 */
//		public void setModified(PSPLogEntry modified) {
//			Modified = modified;
//		}
//
//		/**
//		 * @return the added
//		 */
//		public PSPLogEntry getAdded() {
//			return Added;
//		}
//
//		/**
//		 * @param added
//		 *            the added to set
//		 */
//		public void setAdded(PSPLogEntry added) {
//			Added = added;
//		}
//
//		/**
//		 * @return the reused
//		 */
//		public PSPLogEntry getReused() {
//			return Reused;
//		}
//
//		/**
//		 * @param reused
//		 *            the reused to set
//		 */
//		public void setReused(PSPLogEntry reused) {
//			Reused = reused;
//		}
//
//		/**
//		 * @return the addedModified
//		 */
//		public PSPLogEntry getAddedModified() {
//			return AddedModified;
//		}
//
//		/**
//		 * @param addedModified
//		 *            the addedModified to set
//		 */
//		public void setAddedModified(PSPLogEntry addedModified) {
//			AddedModified = addedModified;
//		}
//
//		/**
//		 * @return the total
//		 */
//		public PSPLogEntry getTotal() {
//			return Total;
//		}
//
//		/**
//		 * @param total
//		 *            the total to set
//		 */
//		public void setTotal(PSPLogEntry total) {
//			Total = total;
//		}
//
//		/**
//		 * @return the newReused
//		 */
//		public PSPLogEntry getNewReused() {
//			return NewReused;
//		}
//
//		/**
//		 * @param newReused
//		 *            the newReused to set
//		 */
//		public void setNewReused(PSPLogEntry newReused) {
//			NewReused = newReused;
//		}
//
//	}

//	public class TimeInPhase implements java.io.Serializable{
//
//		private PSPLogEntry Planning;
//		private PSPLogEntry Design;
//		private PSPLogEntry Code;
//		private PSPLogEntry Compile;
//		private PSPLogEntry Testing;
//		private PSPLogEntry Postmortem;
//		private int totalAcutal, totalTodate;
//
//		public TimeInPhase() {
//			Planning = new PSPLogEntry();
//			Design = new PSPLogEntry();
//			Code = new PSPLogEntry();
//			Compile = new PSPLogEntry();
//			Testing = new PSPLogEntry();
//			Postmortem = new PSPLogEntry();
//			totalAcutal = 0;
//			totalTodate = 0;
//		}
//
//		/**
//		 * @param planning
//		 * @param design
//		 * @param code
//		 * @param compile
//		 * @param testing
//		 * @param postmortem
//		 * @param totalAcutal
//		 * @param totalTodate
//		 */
//		public TimeInPhase(PSPLogEntry planning, PSPLogEntry design, PSPLogEntry code, PSPLogEntry compile,
//				PSPLogEntry testing, PSPLogEntry postmortem, int totalAcutal, int totalTodate) {
//			super();
//			Planning = planning;
//			Design = design;
//			Code = code;
//			Compile = compile;
//			Testing = testing;
//			Postmortem = postmortem;
//			this.totalAcutal = totalAcutal;
//			this.totalTodate = totalTodate;
//		}
//
//		/**
//		 * @return the planning
//		 */
//		public PSPLogEntry getPlanning() {
//			return Planning;
//		}
//
//		/**
//		 * @param planning
//		 *            the planning to set
//		 */
//		public void setPlanning(PSPLogEntry planning) {
//			Planning = planning;
//		}
//
//		/**
//		 * @return the design
//		 */
//		public PSPLogEntry getDesign() {
//			return Design;
//		}
//
//		/**
//		 * @param design
//		 *            the design to set
//		 */
//		public void setDesign(PSPLogEntry design) {
//			Design = design;
//		}
//
//		/**
//		 * @return the code
//		 */
//		public PSPLogEntry getCode() {
//			return Code;
//		}
//
//		/**
//		 * @param code
//		 *            the code to set
//		 */
//		public void setCode(PSPLogEntry code) {
//			Code = code;
//		}
//
//		/**
//		 * @return the compile
//		 */
//		public PSPLogEntry getCompile() {
//			return Compile;
//		}
//
//		/**
//		 * @param compile
//		 *            the compile to set
//		 */
//		public void setCompile(PSPLogEntry compile) {
//			Compile = compile;
//		}
//
//		/**
//		 * @return the testing
//		 */
//		public PSPLogEntry getTesting() {
//			return Testing;
//		}
//
//		/**
//		 * @param testing
//		 *            the testing to set
//		 */
//		public void setTesting(PSPLogEntry testing) {
//			Testing = testing;
//		}
//
//		/**
//		 * @return the postmortem
//		 */
//		public PSPLogEntry getPostmortem() {
//			return Postmortem;
//		}
//
//		/**
//		 * @param postmortem
//		 *            the postmortem to set
//		 */
//		public void setPostmortem(PSPLogEntry postmortem) {
//			Postmortem = postmortem;
//		}
//
//		/**
//		 * @return the totalAcutal
//		 */
//		public int getTotalAcutal() {
//			return totalAcutal;
//		}
//
//		/**
//		 * @param totalAcutal
//		 *            the totalAcutal to set
//		 */
//		public void setTotalAcutal(int totalAcutal) {
//			this.totalAcutal = totalAcutal;
//		}
//
//		/**
//		 * @return the totalTodate
//		 */
//		public int getTotalTodate() {
//			return totalTodate;
//		}
//
//		/**
//		 * @param totalTodate
//		 *            the totalTodate to set
//		 */
//		public void setTotalTodate(int totalTodate) {
//			this.totalTodate = totalTodate;
//		}
//
//	}

//	public class PhaseDefectsInjected implements java.io.Serializable{
//		private PSPLogEntry Planning;
//		private PSPLogEntry Design;
//		private PSPLogEntry Code;
//		private PSPLogEntry Compile;
//		private PSPLogEntry Testing;
//		private PSPLogEntry Postmortem;
//		private int totalAcutal, totalTodate;
//
//		public PhaseDefectsInjected() {
//			Planning = new PSPLogEntry();
//			Design = new PSPLogEntry();
//			Code = new PSPLogEntry();
//			Compile = new PSPLogEntry();
//			Testing = new PSPLogEntry();
//			Postmortem = new PSPLogEntry();
//			totalAcutal = 0;
//			totalTodate = 0;
//		}
//
//		/**
//		 * @param planning
//		 * @param design
//		 * @param code
//		 * @param compile
//		 * @param testing
//		 * @param postmortem
//		 * @param totalAcutal
//		 * @param totalTodate
//		 */
//		public PhaseDefectsInjected(PSPLogEntry planning, PSPLogEntry design, PSPLogEntry code, PSPLogEntry compile,
//				PSPLogEntry testing, PSPLogEntry postmortem, int totalAcutal, int totalTodate) {
//			super();
//			Planning = planning;
//			Design = design;
//			Code = code;
//			Compile = compile;
//			Testing = testing;
//			Postmortem = postmortem;
//			this.totalAcutal = totalAcutal;
//			this.totalTodate = totalTodate;
//		}
//
//		/**
//		 * @return the planning
//		 */
//		public PSPLogEntry getPlanning() {
//			return Planning;
//		}
//
//		/**
//		 * @param planning
//		 *            the planning to set
//		 */
//		public void setPlanning(PSPLogEntry planning) {
//			Planning = planning;
//		}
//
//		/**
//		 * @return the design
//		 */
//		public PSPLogEntry getDesign() {
//			return Design;
//		}
//
//		/**
//		 * @param design
//		 *            the design to set
//		 */
//		public void setDesign(PSPLogEntry design) {
//			Design = design;
//		}
//
//		/**
//		 * @return the code
//		 */
//		public PSPLogEntry getCode() {
//			return Code;
//		}
//
//		/**
//		 * @param code
//		 *            the code to set
//		 */
//		public void setCode(PSPLogEntry code) {
//			Code = code;
//		}
//
//		/**
//		 * @return the compile
//		 */
//		public PSPLogEntry getCompile() {
//			return Compile;
//		}
//
//		/**
//		 * @param compile
//		 *            the compile to set
//		 */
//		public void setCompile(PSPLogEntry compile) {
//			Compile = compile;
//		}
//
//		/**
//		 * @return the testing
//		 */
//		public PSPLogEntry getTesting() {
//			return Testing;
//		}
//
//		/**
//		 * @param testing
//		 *            the testing to set
//		 */
//		public void setTesting(PSPLogEntry testing) {
//			Testing = testing;
//		}
//
//		/**
//		 * @return the postmortem
//		 */
//		public PSPLogEntry getPostmortem() {
//			return Postmortem;
//		}
//
//		/**
//		 * @param postmortem
//		 *            the postmortem to set
//		 */
//		public void setPostmortem(PSPLogEntry postmortem) {
//			Postmortem = postmortem;
//		}
//
//		/**
//		 * @return the totalAcutal
//		 */
//		public int getTotalAcutal() {
//			return totalAcutal;
//		}
//
//		/**
//		 * @param totalAcutal
//		 *            the totalAcutal to set
//		 */
//		public void setTotalAcutal(int totalAcutal) {
//			this.totalAcutal = totalAcutal;
//		}
//
//		/**
//		 * @return the totalTodate
//		 */
//		public int getTotalTodate() {
//			return totalTodate;
//		}
//
//		/**
//		 * @param totalTodate
//		 *            the totalTodate to set
//		 */
//		public void setTotalTodate(int totalTodate) {
//			this.totalTodate = totalTodate;
//		}
//
//	}

//	public class PhaseDefectsRemoved implements java.io.Serializable{
//		private PSPLogEntry Planning;
//		private PSPLogEntry Design;
//		private PSPLogEntry Code;
//		private PSPLogEntry Compile;
//		private PSPLogEntry Testing;
//		private PSPLogEntry Postmortem;
//		private int totalAcutal, totalTodate;
//
//		public PhaseDefectsRemoved() {
//			Planning = new PSPLogEntry();
//			Design = new PSPLogEntry();
//			Code = new PSPLogEntry();
//			Compile = new PSPLogEntry();
//			Testing = new PSPLogEntry();
//			Postmortem = new PSPLogEntry();
//			totalAcutal = 0;
//			totalTodate = 0;
//		}
//
//		/**
//		 * @param planning
//		 * @param design
//		 * @param code
//		 * @param compile
//		 * @param testing
//		 * @param postmortem
//		 * @param totalAcutal
//		 * @param totalTodate
//		 */
//		public PhaseDefectsRemoved(PSPLogEntry planning, PSPLogEntry design, PSPLogEntry code, PSPLogEntry compile,
//				PSPLogEntry testing, PSPLogEntry postmortem, int totalAcutal, int totalTodate) {
//			super();
//			Planning = planning;
//			Design = design;
//			Code = code;
//			Compile = compile;
//			Testing = testing;
//			Postmortem = postmortem;
//			this.totalAcutal = totalAcutal;
//			this.totalTodate = totalTodate;
//		}
//
//		/**
//		 * @return the planning
//		 */
//		public PSPLogEntry getPlanning() {
//			return Planning;
//		}
//
//		/**
//		 * @param planning
//		 *            the planning to set
//		 */
//		public void setPlanning(PSPLogEntry planning) {
//			Planning = planning;
//		}
//
//		/**
//		 * @return the design
//		 */
//		public PSPLogEntry getDesign() {
//			return Design;
//		}
//
//		/**
//		 * @param design
//		 *            the design to set
//		 */
//		public void setDesign(PSPLogEntry design) {
//			Design = design;
//		}
//
//		/**
//		 * @return the code
//		 */
//		public PSPLogEntry getCode() {
//			return Code;
//		}
//
//		/**
//		 * @param code
//		 *            the code to set
//		 */
//		public void setCode(PSPLogEntry code) {
//			Code = code;
//		}
//
//		/**
//		 * @return the compile
//		 */
//		public PSPLogEntry getCompile() {
//			return Compile;
//		}
//
//		/**
//		 * @param compile
//		 *            the compile to set
//		 */
//		public void setCompile(PSPLogEntry compile) {
//			Compile = compile;
//		}
//
//		/**
//		 * @return the testing
//		 */
//		public PSPLogEntry getTesting() {
//			return Testing;
//		}
//
//		/**
//		 * @param testing
//		 *            the testing to set
//		 */
//		public void setTesting(PSPLogEntry testing) {
//			Testing = testing;
//		}
//
//		/**
//		 * @return the postmortem
//		 */
//		public PSPLogEntry getPostmortem() {
//			return Postmortem;
//		}
//
//		/**
//		 * @param postmortem
//		 *            the postmortem to set
//		 */
//		public void setPostmortem(PSPLogEntry postmortem) {
//			Postmortem = postmortem;
//		}
//
//		/**
//		 * @return the totalAcutal
//		 */
//		public int getTotalAcutal() {
//			return totalAcutal;
//		}
//
//		/**
//		 * @param totalAcutal
//		 *            the totalAcutal to set
//		 */
//		public void setTotalAcutal(int totalAcutal) {
//			this.totalAcutal = totalAcutal;
//		}
//
//		/**
//		 * @return the totalTodate
//		 */
//		public int getTotalTodate() {
//			return totalTodate;
//		}
//
//		/**
//		 * @param totalTodate
//		 *            the totalTodate to set
//		 */
//		public void setTotalTodate(int totalTodate) {
//			this.totalTodate = totalTodate;
//		}
//
//	}

//	// class to hold info for Phases
//	public class PSPLogEntry implements java.io.Serializable{
//
//		private int planSize;
//		private int actualSize;
//		private int toDateSize;
//		private double toDatePercent;
//
//		public PSPLogEntry() {
//			planSize = 0;
//			actualSize = 0;
//			toDateSize = 0;
//			toDatePercent = 0;
//		}
//
//		public PSPLogEntry(int planSize, int actualSize, int toDateSize, double toDatePercent) {
//			super();
//			this.planSize = planSize;
//			this.actualSize = actualSize;
//			this.toDateSize = toDateSize;
//			this.toDatePercent = toDatePercent;
//		}
//
//		protected int getPlanSize() {
//			return planSize;
//		}
//
//		protected void setPlanSize(int planSize) {
//			this.planSize = planSize;
//		}
//
//		protected int getActualSize() {
//			return actualSize;
//		}
//
//		protected void setActualSize(int actualSize) {
//			this.actualSize = actualSize;
//		}
//
//		protected int getToDateSize() {
//			return toDateSize;
//		}
//
//		protected void setToDateSize(int toDateSize) {
//			this.toDateSize = toDateSize;
//		}
//
//		protected double getToDatePercent() {
//			return toDatePercent;
//		}
//
//		protected void setToDatePercent(double toDatePercent) {
//			this.toDatePercent = toDatePercent;
//		}
//
//	}
}
