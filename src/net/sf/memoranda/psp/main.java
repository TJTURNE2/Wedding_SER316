package net.sf.memoranda.psp;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

import net.sf.memoranda.psp.PSPProject.PSPType;
import net.sf.memoranda.psp.PSPProjectDefectEntry.PSPDefectType;
import net.sf.memoranda.psp.PSPProjectRequirement.PSPRequirementType;

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
		
		for (PSPProject P : Manager.getAllProjects()) {
			System.out.print(P.getID() + " ");
			System.out.println(P.getProjectName());
			P.setPhase(PSPProjectPhase.POSTMORTEM);
		}
		
		Manager.saveProjects();
		System.out.println("Saved");
		
		
		//Add defects
		for (PSPProject P : Manager.getAllProjects()) {
			for(int i1 = 0 ;i1 < 5; i1++){
			PSPProjectDefectEntry entry = new PSPProjectDefectEntry();
			entry.setDateFound(new Date(2017,4,11));
			entry.setDefectType(PSPDefectType.TYPE10);
			entry.setDescription("This thing is broke " + i1);
			entry.setFileName("JavaCode"+i1+".java");
			entry.setPhaseInjected(PSPProjectPhase.DESIGN);
			entry.setPhaseRemoved(PSPProjectPhase.TEST);
			entry.setSeverity(1);
			//entry.setCount(P.getDefectLog().size());
			P.addDefectEntry(entry);
			}
		}
		Manager.saveProjects();
		System.out.println("Defects Saved");
		
		for (PSPProject P : Manager.getAllProjects()) {
			for(PSPProjectDefectEntry D : P.DefectLog){
				System.out.println(D.getID() +" "+D.getDescription());
			}
		}
		
		//Add Requirments
		for (PSPProject P : Manager.getAllProjects()) {
			for(int i1 = 0 ;i1 < 5; i1++){
			PSPProjectRequirement entry = new PSPProjectRequirement();
			entry.setPriority(1);
			entry.setDescription("Requirment "+ i1 +" for project" + P.getID());
			entry.setRequirmentType(PSPRequirementType.QUALITY);
			P.addRequirementEntry(entry);
			}
		}
		Manager.saveProjects();
		System.out.println("Requirement Saved");
		
		for (PSPProject P : Manager.getAllProjects()) {
			for(PSPProjectRequirement R : P.Requirements){
				System.out.println(R.getID() +" "+R.getDescription());
			}
		}
		
		//Add Time
		for (PSPProject P : Manager.getAllProjects()) {
			for(int i1 = 0 ;i1 < 5; i1++){
			PSPProjectTimeLogEntry entry = new PSPProjectTimeLogEntry();
			entry.setEntryDate(new Date(2017,04,11));
			entry.setComments("Log entry "+i1+ " for project " + P.getID());
			entry.setPhase(PSPProjectPhase.DESIGN);
			entry.setStartingTime(new Time(1, 5, 0));
			entry.setStoppingTime(new Time(5, 3, 0));
			entry.setInterruptionTime(new Time(1, 6, 48));
			P.addTimeEntry(entry);
			}
		}
		Manager.saveProjects();
		System.out.println("Time log Saved");
		
		for (PSPProject P : Manager.getAllProjects()) {
			for(PSPProjectTimeLogEntry T : P.TimeLog){
				System.out.println(T.getID() +" "+T.getComments());
			}
		}
		
		
		//Manager.clearAllProjects();
	}

}
