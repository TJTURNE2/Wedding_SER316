package net.sf.memoranda.psp;

@SuppressWarnings("serial")
public class PSPProjectCodeComponent implements java.io.Serializable{
	
	private  int ID;
	private String Module;
	private PSPProjectComponentType Type;
	private String Purpose;
	private String Function;
	private String Data;

	
	
	public PSPProjectCodeComponent(){
		ID = 1;
		Module = "PSPProject";
		Type = PSPProjectComponentType.CLASS;
		Purpose = "Class to test";
		Function = " Updating Fuctionality of Memoranda";
		Data = "NONE";
		
	}
	
	/**
	 * @param iD
	 * @param module
	 * @param type
	 * @param purpose
	 * @param function
	 * @param data
	 */
	public PSPProjectCodeComponent(int iD, String module, PSPProjectComponentType type, String purpose, String function,
			String data) {
		super();
		ID = iD;
		Module = module;
		Type = type;
		Purpose = purpose;
		Function = function;
		Data = data;
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
	 * @return the module
	 */
	public String getModule() {
		return Module;
	}



	/**
	 * @param module the module to set
	 */
	public void setModule(String module) {
		Module = module;
	}



	/**
	 * @return the type
	 */
	public PSPProjectComponentType getType() {
		return Type;
	}



	/**
	 * @param type the type to set
	 */
	public void setType(PSPProjectComponentType type) {
		Type = type;
	}



	/**
	 * @return the purpose
	 */
	public String getPurpose() {
		return Purpose;
	}



	/**
	 * @param purpose the purpose to set
	 */
	public void setPurpose(String purpose) {
		Purpose = purpose;
	}



	/**
	 * @return the function
	 */
	public String getFunction() {
		return Function;
	}



	/**
	 * @param function the function to set
	 */
	public void setFunction(String function) {
		Function = function;
	}



	/**
	 * @return the data
	 */
	public String getData() {
		return Data;
	}



	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		Data = data;
	}



	public enum PSPProjectComponentType{
		
		PACKAGE,INTERFACE,USERINTERFACE,CLASS,MODULE
	}

}
