/**
 * 
 */
package net.sf.memoranda.psp;

import java.util.Date;

/**
 * @author Terry Turner
 *
 */
@SuppressWarnings("serial")
public class PSPProjectCodeReview implements java.io.Serializable{
	
	private int ID;
	private String Location;
	private String Description;
	private PSPDefectCatagory Catagory;
	private PSPDefectSeverity Serverity;
	private Date reviewDate;
	
	
	public PSPProjectCodeReview(){
		ID = 1;
		Location = "Line 1: *.java";
		Description = "None";
		Catagory = PSPDefectCatagory.CG;
		Serverity = PSPDefectSeverity.LOW;
		reviewDate = null; /// maybe??

		
	}
	

	/**
	 * @param iD
	 * @param location
	 * @param description
	 * @param catagory
	 * @param serverity
	 */
	public PSPProjectCodeReview(int iD, String location, String description, PSPDefectCatagory catagory,
			PSPDefectSeverity serverity) {
		super();
		ID = iD;
		Location = location;
		Description = description;
		Catagory = catagory;
		Serverity = serverity;
		reviewDate = new Date();
	}

	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return Location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		Location = location;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return Description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		Description = description;
	}

	/**
	 * @return the catagory
	 */
	public PSPDefectCatagory getCatagory() {
		return Catagory;
	}

	/**
	 * @param catagory the catagory to set
	 */
	public void setCatagory(PSPDefectCatagory catagory) {
		Catagory = catagory;
	}

	/**
	 * @return the serverity
	 */
	public PSPDefectSeverity getServerity() {
		return Serverity;
	}

	/**
	 * @param serverity the serverity to set
	 */
	public void setServerity(PSPDefectSeverity serverity) {
		Serverity = serverity;
	}

	public enum PSPDefectCatagory implements java.io.Serializable {
		CS("Code Smell defect"),CG("Violation of a coding guideline"),FD("Functional defect"),MD("Miscellaneous defect");
		
		private String name;

		PSPDefectCatagory(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return name;
		}
	}
	
	public enum PSPDefectSeverity implements java.io.Serializable {
		BR("Blocker"),MJ("Major"),LOW("Low");
		
		private String name;

		PSPDefectSeverity(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return name;
		}
	}
	
}
