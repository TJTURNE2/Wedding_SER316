package net.sf.memoranda.psp;

/**
 * PSP Phase Class
 * 
 */

public enum PSPProjectPhase implements java.io.Serializable{
	PLANNING("Planning"),DESIGN("Design"),DESIGNREVIEW("Design Review"),CODE("Code"),CODEREVIEW("Code Review"),COMPILE("Compile"),TEST("Test"),POSTMORTEM("Post Mortem");
	
	private String name;
	
	PSPProjectPhase(String name){
		this.name = name;
	}
	
	@Override
	public String toString(){
		return name;
	}
}
