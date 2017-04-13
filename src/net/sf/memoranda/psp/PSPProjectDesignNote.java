package net.sf.memoranda.psp;

public class PSPProjectDesignNote {
	
	private  int ID;
	private String Description;
	private int Priority;
	
	
	
	public PSPProjectDesignNote(){
		ID = 1;
		Description = "";
		Priority = 1;
	}
	
	
	/**
	 * @param iD
	 * @param description
	 * @param priority
	 */
	public PSPProjectDesignNote(int iD, String description, int priority) {
		super();
		ID = iD;
		Description = description;
		Priority = priority;
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
	
	
	
	

}
