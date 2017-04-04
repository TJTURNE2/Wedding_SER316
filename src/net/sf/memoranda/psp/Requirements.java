/**
 * 
 */
package net.sf.memoranda.psp;

import net.sf.memoranda.psp.PSPRequirements.PSPRequirementType;

@SuppressWarnings("serial")
public class Requirements implements java.io.Serializable{

	private int ID;
	private PSPRequirementType RequirmentType;
	private String Description;

	public Requirements() {
		ID = PSPRequirements.getNumEntries();
		RequirmentType = PSPRequirementType.FUNCTIONAL;
		Description = "";
		PSPRequirements.setNumEntries(ID+1);
	}
	
	public Requirements(int iD, PSPRequirementType requirmentType, String description) {
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

}
