/**
 * @file: DefectLog.java
 * @author: josephwicker
 * @date: April 8, 2017
 * 
 * @description: Instances of the Defect Log class will store data
 * 		relative to each defect log created by the user. There will be
 * 		one defect log object for each defect log created by the user.
 */
package net.sf.memoranda;

import java.util.Locale;

/**
 * @class DefectLog
 * 
 * @description: Defines a class for creating Defect Logs, including getters
 * 		and setters used for editing the Defect Log, and a method used
 * 		when saving the defect log to a file.
 */
public class DefectLog {
	
	private enum Type {
		NONE("None"),
		DOCUMENTATION("Documentation"),		// Comments, messages
		SYNTAX("Syntax"),					// Spelling, punctuation, typos, instruction formats
		BUILD("Build"),						// Change management, library, version control
		ASSIGNMENT("Assignment"),			// Declaration, duplicate names, scope, limits
		INTERFACE("Interface"),				// Procedure calls and references, I/O, user formats
		CHECKING("Checking"),				// Error messages, inadequate checks
		DATA("Data"),						// Structure, content
		FUNCTION("Function"),				// Logic, pointers, loops, recursion, computation, function defects
		SYSTEM("System"),					// Configuration, timing, memory
		ENVIRONMENT("Encvironment");		// Design, compile, test, or other support system problems

		private String _value;

		private Type(String value) {
			_value = value;
		}
		
		@Override
		public String toString() {
			return _value;
		}
	};


	private String _date;
	private int _defectNum;
	private Type _type;
	private String _inject;
	private String _remove;
	private int _fixTime;
	private int _refNum;
	private String _description;
	private boolean _isActive;
	private static final String _DELIMITER = "*^*";

	public DefectLog(String date, int defectNum, String type, String inject, String remove,
			int fixTime, int refNum, String description, boolean isActive) {
		_date = date;
		_defectNum = defectNum;
		_type = Type.valueOf(type.toUpperCase(Locale.ENGLISH));
		_inject = inject;
		_remove = remove;
		_fixTime = fixTime;
		_refNum = refNum;
		_description = description;
		_isActive = isActive;
	}

	public String getDate() {
		return _date;
	}

	public void setDate(String date) {
		_date = date;
	}

	public int getDefectNum() {
		return _defectNum;
	}

	public void setDefectNum(int defectNum) {
		_defectNum = defectNum;
	}

	public String getType() {
		return _type.toString();
	}

	public void setType(String type) {
		_type = Type.valueOf(type.toUpperCase(Locale.ENGLISH));
	}

	public String getInject() {
		return _inject;
	}

	public void setInject(String inject) {
		_inject = inject;
	}

	public String getRemove() {
		return _remove;
	}

	public void setRemove(String remove) {
		_remove = remove;
	}

	public int getFixTime() {
		return _fixTime;
	}

	public void setFixTime(int fixTime) {
		_fixTime = fixTime;
	}

	public int getRefNum() {
		return _refNum;
	}

	public void setRefNum(int refNum) {
		_refNum = refNum;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}
	
	public void setIsActive(boolean isActive) {
		_isActive = isActive;
	}
	
	public boolean isActive() {
		return _isActive;
	}
	
	@Override
	public String toString() {
		return _defectNum + " " + _date + " " + _type + " " + _isActive;
	}
	
	/**
	 * @method: getValuesArray
	 * @inputs: none
	 * @returns: String[] containing all attributes
	 * 
	 * @description: method converts all attributes to string and then
	 * adds them to an array to be used for populating the dialog box
	 * when editing a defect log
	*/
	public String[] getValuesArray() {
		String[] array = {_date, String.valueOf(_defectNum), _type.toString(),
				_inject, _remove, String.valueOf(_fixTime), String.valueOf(_refNum),
				_description, String.valueOf(_isActive)};
		return array;
	}

	/**
	 * @method: toFile
	 * @inputs: none
	 * @returns: String to be written to a file
	 * 
	 * @description: Formats a string with all of the defect log's attributes,
	 * with a label telling which attribute, separated by the specified delimiter.
	 * The delimiter will be used when reading from the text file, a regular space
	 * cannot be used since the description may contain spaces.
	*/
	public String toFile() {
		return ("date" + (_date.equals("") ? "null" : _date) +
				_DELIMITER + "defectNum" + _DELIMITER + (_defectNum < 1 ? "null" : _defectNum) +
				_DELIMITER + "type" + _DELIMITER + _type +
				_DELIMITER + "inject" + _DELIMITER + (_inject.equals("") ? "null" : _inject) +
				_DELIMITER + "remove" + _DELIMITER + (_remove.equals("") ? "null" : _remove) +
				_DELIMITER + "fixTime" + _DELIMITER + _fixTime +
				_DELIMITER + "refNum" + _DELIMITER + _refNum +
				_DELIMITER + "description" + _DELIMITER + (_description.equals("") ? "null" : _description) +
				_DELIMITER + "isActive" + _DELIMITER + _isActive);
	}	
}