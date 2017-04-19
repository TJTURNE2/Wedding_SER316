/**
 * 
 */
package net.sf.memoranda.psp;

@SuppressWarnings("serial")
public class PSPProjectRequirement implements java.io.Serializable{
	
	private int ID;
	private PSPRequirementType RequirmentType;
	private String Description;
	private int Priority;
	private boolean Completed;

	public PSPProjectRequirement() {

		ID = 1;
		RequirmentType = PSPRequirementType.FUNCTIONAL;
		Description = "None";
		Priority = 1;
		Completed = false;
	}
	
	public PSPProjectRequirement(int iD, PSPRequirementType requirmentType, String description, int priority, boolean complete) {
		super();
		ID = iD;
		RequirmentType = requirmentType;
		Description = description;
		Priority = priority;
		Completed = complete;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public PSPRequirementType getRequirmentType() {
		return RequirmentType;
	}

	public void setRequirmentType(PSPRequirementType requirmentType) {
		RequirmentType = requirmentType;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	/**
	 * @return the priority
	 */
	public int getPriority() {
		return Priority;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(int priority) {
		Priority = priority;
	}

	/**
	 * @return the completed
	 */
	public boolean isCompleted() {
		return Completed;
	}

	/**
	 * @param completed the completed to set
	 */
	public void setCompleted(boolean completed) {
		Completed = completed;
	}

	public enum PSPRequirementType implements java.io.Serializable{

		RESOURCE("Resource"), FUNCTIONAL("Functional"), PERFORMANCE("Performance"), INTERFACE(
				"Interface"), MAINTAINABILITY("Maintainability"), RELIABILITY(
						"Reliability"), SAFETY("Safety"), QUALITY("Quality"), OPERATIONAL("Operational");

		private String name;
		private String description;

		PSPRequirementType(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return name;
		}
	}
	
}
