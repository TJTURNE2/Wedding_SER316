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

	protected PSPProjectRequirement() {
		count +=1;
		ID = 0;
		RequirmentType = PSPRequirementType.FUNCTIONAL;
		Description = "None";
	}
	
	public PSPProjectRequirement(int iD, PSPRequirementType requirmentType, String description) {
		super();
		ID = iD;
		RequirmentType = requirmentType;
		Description = description;
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
