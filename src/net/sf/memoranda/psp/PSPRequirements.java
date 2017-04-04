/**
 * 
 */
package net.sf.memoranda.psp;

import java.util.ArrayList;
import java.util.List;

import net.sf.memoranda.psp.Requirements;
/**
 * @author TRON
 *
 */
@SuppressWarnings("serial")
public class PSPRequirements implements java.io.Serializable{

	private static int numEntries = 0;
	public List<Requirements> Requirements;

	/**
	 * @param requirements
	 */
	public PSPRequirements() {
		Requirements  = new ArrayList<>();
		numEntries = Requirements.size();
	}
	
	/**
	 * @param requirements
	 */
	public PSPRequirements(List<Requirements> requirements) {
		super();
		Requirements = requirements;
		numEntries = Requirements.size();
	}

	/**
	 * @return the numEntries
	 */
	public static int getNumEntries() {
		return numEntries;
	}

	/**
	 * @param numEntries the numEntries to set
	 */
	public static void setNumEntries(int numEntries) {
		PSPRequirements.numEntries = numEntries;
	}

	/**
	 * @return the requirements
	 */
	public List<Requirements> getRequirements() {
		return Requirements;
	}

	/**
	 * @param requirements the requirements to set
	 */
	public void setRequirements(List<Requirements> requirements) {
		Requirements = requirements;
	}
	
	public boolean addRequirements(Requirements requirements) {
		Requirements.add(requirements);
		numEntries +=1;
		return true;
	}
	
//	public class Requirements implements java.io.Serializable{
//
//		private int ID;
//		private PSPRequirementType RequirmentType;
//		private String Description;
//
//		public Requirements() {
//			ID = numEntries;
//			RequirmentType = PSPRequirementType.FUNCTIONAL;
//			Description = "";
//			numEntries += 1;
//		}
//		
//		public Requirements(int iD, PSPRequirementType requirmentType, String description) {
//			super();
//			ID = iD;
//			RequirmentType = requirmentType;
//			Description = description;
//		}
//
//		public int getID() {
//			return ID;
//		}
//
//		public void setID(int iD) {
//			ID = iD;
//		}
//
//		public PSPRequirementType getRequirmentType() {
//			return RequirmentType;
//		}
//
//		public void setRequirmentType(PSPRequirementType requirmentType) {
//			RequirmentType = requirmentType;
//		}
//
//		public String getDescription() {
//			return Description;
//		}
//
//		public void setDescription(String description) {
//			Description = description;
//		}
//
//	}


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
