/**Terry Turner
 * 
 */
package net.sf.memoranda.psp;

import java.util.ArrayList;
import java.util.List;

public class PSPProjectTestCase {

	private int ID;
	private String testTitle;
	private String Description;
	private ArrayList<String> testCaseSteps;
	private ArrayList<String> expectedResults;
	private ArrayList<String> actualResults;
	private enum status{ OPEN, CLOSE, WORKING}
	
	
	/**
	 * @param iD
	 * @param testTitle
	 * @param description
	 * @param testCaseSteps
	 * @param expectedResults
	 * @param actualResults
	 */
	public PSPProjectTestCase(int iD, String testTitle, String description, ArrayList<String> testCaseSteps,
			ArrayList<String> expectedResults, ArrayList<String> actualResults) {
		super();
		ID = iD;
		this.testTitle = testTitle;
		Description = description;
		this.testCaseSteps = testCaseSteps;
		this.expectedResults = expectedResults;
		this.actualResults = actualResults;
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
	 * @return the testTitle
	 */
	public String getTestTitle() {
		return testTitle;
	}


	/**
	 * @param testTitle the testTitle to set
	 */
	public void setTestTitle(String testTitle) {
		this.testTitle = testTitle;
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
	 * @return the testCaseSteps
	 */
	public ArrayList<String> getTestCaseSteps() {
		return testCaseSteps;
	}


	/**
	 * @param testCaseSteps the testCaseSteps to set
	 */
	public void setTestCaseSteps(ArrayList<String> testCaseSteps) {
		this.testCaseSteps = testCaseSteps;
	}


	/**
	 * @return the expectedResults
	 */
	public ArrayList<String> getExpectedResults() {
		return expectedResults;
	}


	/**
	 * @param expectedResults the expectedResults to set
	 */
	public void setExpectedResults(ArrayList<String> expectedResults) {
		this.expectedResults = expectedResults;
	}


	/**
	 * @return the actualResults
	 */
	public ArrayList<String> getActualResults() {
		return actualResults;
	}


	/**
	 * @param actualResults the actualResults to set
	 */
	public void setActualResults(ArrayList<String> actualResults) {
		this.actualResults = actualResults;
	};
	
	
	
}
