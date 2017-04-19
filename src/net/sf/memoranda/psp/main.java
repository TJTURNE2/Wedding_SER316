package net.sf.memoranda.psp;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

import net.sf.memoranda.psp.PSPProject.PSPType;
import net.sf.memoranda.psp.PSPProjectDefectEntry.PSPDefectType;
import net.sf.memoranda.psp.PSPProjectCodeComponent.PSPProjectComponentType;
import net.sf.memoranda.psp.PSPProjectCodeReview.PSPDefectCatagory;
import net.sf.memoranda.psp.PSPProjectRequirement.PSPRequirementType;
import net.sf.memoranda.psp.PSPProjectTestCase;
import net.sf.memoranda.psp.PSPProjectTestCase.PSPProjectTestCaseStatus;
import net.sf.memoranda.psp.gui.PSPNewUserTestDialog;

public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// Create new Project File Manager
		PSPProjectManager Manager = new PSPProjectManager();

		// add 20 projects
		// int i = Manager.getAllProjects().size();
		Manager.clearAllProjects();
		
		for (int i = 1; i <= 10; ++i) {
			Manager.newProject("PRoject " + i, "Description " + i, PSPType.PSP1);
		}

		for (PSPProject P : Manager.getAllProjects()) {
			System.out.print(P.getID() + " ");
			System.out.println(P.getProjectName());
			P.setPhase(PSPProjectPhase.POSTMORTEM);
		}

		Manager.saveProjects();
		System.out.println("Saved");

		// Add User TestCAse
		for (PSPProject P : Manager.getAllProjects()) {
			for (int i1 = 1; i1 <= 5; i1++) {
				PSPProjectTestCase entry = new PSPProjectTestCase();
				entry.setModuleName("PSPProject.java");
				entry.setDescription("Testing case " + i1 + " for the Project " + P.getID());
				entry.setDesignedBy("Terry Turner");
				entry.setStatus(PSPProjectTestCaseStatus.FAIL);
				entry.setExpectedResults("1, 2, 3, 4, 5");
				entry.setActualResults("5, 4, 3, 2, 1");
				P.addUserTests(entry);
			}
		}

		Manager.saveProjects();

		System.out.println("Test Case Saved");
		for (PSPProject P : Manager.getAllProjects()) {
			for (PSPProjectTestCase T : P.UserTests) {
				System.out.println(T.getID() + " " + T.getStatus());
			}
		}

		// Add defects
		for (PSPProject P : Manager.getAllProjects()) {
			for (int i1 = 1; i1 <= 5; i1++) {
				PSPProjectDefectEntry entry = new PSPProjectDefectEntry();
				entry.setDateFound(new Date(2017, 4, 11));
				entry.setDefectType(PSPDefectType.TYPE10);
				entry.setDescription("Defect " + i1 + " for Project " + P.getID());
				entry.setFileName("JavaCode" + i1 + ".java");
				entry.setPhaseInjected(PSPProjectPhase.DESIGN);
				entry.setPhaseRemoved(PSPProjectPhase.TEST);
				entry.setSeverity(1);
				// entry.setCount(P.getDefectLog().size());
				P.addDefectEntry(entry);
			}
		}

		Manager.saveProjects();
		System.out.println("Defects Saved");

		for (PSPProject P : Manager.getAllProjects()) {
			for (PSPProjectDefectEntry D : P.DefectLog) {
				System.out.println(D.getID() + " " + D.getDescription());
			}
		}

		// Add Requirments
		for (PSPProject P : Manager.getAllProjects()) {
			for (int i1 = 1; i1 <= 5; i1++) {
				System.out.println("Adding requirment to Project" + P.getID());
				PSPProjectRequirement entry = new PSPProjectRequirement();
				entry.setPriority(1);
				entry.setDescription("Requirment " + i1 + " for project" + P.getID());
				entry.setRequirmentType(PSPRequirementType.QUALITY);
				P.addRequirementEntry(entry);
				System.out.println(entry.getDescription());
			}
		}

		Manager.saveProjects();
		System.out.println("Requirement Saved");

		for (PSPProject P : Manager.getAllProjects()) {
			for (PSPProjectRequirement R : P.Requirements) {
				System.out.println(R.getID() + " " + R.getDescription());
			}
		}

		// Add Time
		for (PSPProject P : Manager.getAllProjects()) {
			for (int i1 = 1; i1 <= 5; i1++) {
				PSPProjectTimeLogEntry entry = new PSPProjectTimeLogEntry();
				entry.setEntryDate(new Date(2017, 04, 11));
				entry.setComments("Log entry " + i1 + " for Project " + P.getID());
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
			for (PSPProjectTimeLogEntry T : P.TimeLog) {
				System.out.println(T.getID() + " " + T.getComments());
			}
		}

		// Add Component
		for (PSPProject P : Manager.getAllProjects()) {
			for (int i1 = 1; i1 <= 5; i1++) {
				PSPProjectCodeComponent entry = new PSPProjectCodeComponent();
				entry.setType(PSPProjectComponentType.CLASS);
				entry.setModule("Test Module " + i1);
				entry.setPurpose("Testing Project " + P.getID());
				P.addComponents(entry);
			}
		}

		Manager.saveProjects();
		System.out.println("Componets Saved");

		for (PSPProject P : Manager.getAllProjects()) {
			for (PSPProjectCodeComponent T : P.Components) {
				System.out.println(T.getID() + " " + T.getType());
			}
		}

		// Add REviews
		for (PSPProject P : Manager.getAllProjects()) {
			for (int i1 = 1; i1 <= 5; i1++) {
				PSPProjectCodeReview entry = new PSPProjectCodeReview();
				entry.setDescription("Code Review for Project "+ P.getID());
				entry.setCatagory(PSPDefectCatagory.CS);
				System.out.println("Review "+ i1 + entry.getDescription());
				P.addReviews(entry);
			}
		}

		Manager.saveProjects();
		System.out.println("Review Saved");

		for (PSPProject P : Manager.getAllProjects()) {
			for (PSPProjectCodeReview R : P.Reviews) {
				System.out.println(R.getID() + " " + R.getDescription());
			}
		}
		 //Manager.clearAllProjects();
	}

}
