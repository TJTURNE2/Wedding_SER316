package net.sf.memoranda.psp;

import java.io.IOException;
import net.sf.memoranda.psp.PSPProject.PSPType;

public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//Create new Project File Manager
		PSPProjectManager Manager = new PSPProjectManager();
		
		//add 20 projects
		int i = Manager.getAllProjects().size();
		for(;i < 20 ; i++){
		Manager.newProject("PRoject "+i, "Description "+i, PSPType.PSP1);
		}
		
		//DefectEntry entry = new DefectEntry();
		//Manager.getProject(1).DefectLog.addEntry(entry);
		
		for (PSPProject P : Manager.getAllProjects()) {
			System.out.println(P.getID());
		}
		Manager.saveProjects();
//		i = 11;
//		System.out.println("Removing PRoject " + i);
//		Manager.deleteProject(i);
//		Manager.saveProjects();
		for (PSPProject P : Manager.getAllProjects()) {
			System.out.println(P.getProjectName());
		}
		System.out.println("Saved");
		
		
		
		
		//Manager.clearAllProjects();
	}

}
