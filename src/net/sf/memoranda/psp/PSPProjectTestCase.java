/**Terry Turner
 * 
 */
package net.sf.memoranda.psp;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class PSPProjectTestCase implements java.io.Serializable {

	private int ID;
	private String moduleName;
	private String testTitle;
	private String Description;
	private String designedBy;
	private String preConditions;
	private String Dependencies;
	private ArrayList<String> testCaseSteps;
	private String expectedResults;
	private String actualResults;
	private PSPProjectTestCaseStatus status;
	private String Notes;

	
	public PSPProjectTestCase() {

		ID = 0;
		moduleName = "Name Here";
		testTitle = "Title Here";
		Description = "Description";
		designedBy = "Deigned By";
		preConditions = "None";
		Dependencies = "None";
		testCaseSteps = new ArrayList<String>();
		expectedResults = "True";
		actualResults = "False";
		status = PSPProjectTestCaseStatus.FAIL;
		Notes = "None";

	}

	/**
	 * @param iD
	 * @param moduleName
	 * @param testTitle
	 * @param description
	 * @param designedBy
	 * @param preConditions
	 * @param dependencies
	 * @param testCaseSteps
	 * @param expectedResults
	 * @param actualResults
	 * @param notes
	 */
	public PSPProjectTestCase(int iD, String moduleName, String testTitle, String description, String designedBy,
			String preConditions, String dependencies, ArrayList<String> testCaseSteps, String expectedResults,
			String actualResults, String notes) {
		super();
		ID = iD;
		this.moduleName = moduleName;
		this.testTitle = testTitle;
		Description = description;
		this.designedBy = designedBy;
		this.preConditions = preConditions;
		Dependencies = dependencies;
		this.testCaseSteps = testCaseSteps;
		this.expectedResults = expectedResults;
		this.actualResults = actualResults;
		Notes = notes;
	}

	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @param iD
	 *            the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * @return the moduleName
	 */
	public String getModuleName() {
		return moduleName;
	}

	/**
	 * @param moduleName
	 *            the moduleName to set
	 */
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	/**
	 * @return the testTitle
	 */
	public String getTestTitle() {
		return testTitle;
	}

	/**
	 * @param testTitle
	 *            the testTitle to set
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
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		Description = description;
	}

	/**
	 * @return the designedBy
	 */
	public String getDesignedBy() {
		return designedBy;
	}

	/**
	 * @param designedBy
	 *            the designedBy to set
	 */
	public void setDesignedBy(String designedBy) {
		this.designedBy = designedBy;
	}

	/**
	 * @return the preConditions
	 */
	public String getPreConditions() {
		return preConditions;
	}

	/**
	 * @param preConditions
	 *            the preConditions to set
	 */
	public void setPreConditions(String preConditions) {
		this.preConditions = preConditions;
	}

	/**
	 * @return the dependencies
	 */
	public String getDependencies() {
		return Dependencies;
	}

	/**
	 * @param dependencies
	 *            the dependencies to set
	 */
	public void setDependencies(String dependencies) {
		Dependencies = dependencies;
	}

	/**
	 * @return the testCaseSteps
	 */
	public ArrayList<String> getTestCaseSteps() {
		return testCaseSteps;
	}

	/**
	 * @param testCaseSteps
	 *            the testCaseSteps to set
	 */
	public void setTestCaseSteps(ArrayList<String> testCaseSteps) {
		this.testCaseSteps = testCaseSteps;
	}

	/**
	 * @return the expectedResults
	 */
	public String getExpectedResults() {
		return expectedResults;
	}

	/**
	 * @param expectedResults
	 *            the expectedResults to set
	 */
	public void setExpectedResults(String expectedResults) {
		this.expectedResults = expectedResults;
	}

	/**
	 * @return the actualResults
	 */
	public String getActualResults() {
		return actualResults;
	}

	/**
	 * @param actualResults
	 *            the actualResults to set
	 */
	public void setActualResults(String actualResults) {
		this.actualResults = actualResults;
	}

	/**
	 * @return the notes
	 */
	public String getNotes() {
		return Notes;
	}

	/**
	 * @param notes
	 *            the notes to set
	 */
	public void setNotes(String notes) {
		Notes = notes;
	}

	/**
	 * @return the status
	 */
	public PSPProjectTestCaseStatus getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(PSPProjectTestCaseStatus status) {
		this.status = status;
	}

	public enum PSPProjectTestCaseStatus implements java.io.Serializable {
		PASS("Pass"), FAIL("Fail");

		private String name;

		PSPProjectTestCaseStatus(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return name;
		}

	}
}
