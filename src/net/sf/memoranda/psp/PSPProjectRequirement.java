/**
 * 
 */
package net.sf.memoranda.psp;

@SuppressWarnings("serial")
public class PSPProjectRequirement implements java.io.Serializable{
	
    private static int count =0;
	private int ID;
	private PSPRequirementType RequirmentType;
	private String Description;
	private int Priority;

	protected PSPProjectRequirement() {
		count +=1;
		ID = count;
		RequirmentType = PSPRequirementType.FUNCTIONAL;
		Description = "None";
		Priority = 1;
	}
	
	public PSPProjectRequirement(int iD, PSPRequirementType requirmentType, String description, int priority) {
		super();
		ID = iD;
		RequirmentType = requirmentType;
		Description = description;
		Priority = priority;
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
	 * @return the count
	 */
	public static int getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public static void setCount(int count) {
		PSPProjectRequirement.count = count;
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
