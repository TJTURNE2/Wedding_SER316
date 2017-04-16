/*
  File:	UserProfile.java
  Author:	Tomas Vartija
  Date:	4/16/2017
  
  Description:  Manages the user login and creation of a user in memoranda
*/

package net.sf.memoranda;

import net.sf.memoranda.util.CurrentStorage;
import nu.xom.Attribute;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;

/**
Class:	UserProfile

Description:  Creates and maintains user information in memoranda.
*/
public class UserProfile {
	private String username;
	
	public static Document _doc = null;
	static Element _root = null;

	static {
		CurrentStorage.get().openUserProfileManager();
		if (_doc == null) {
			_root = new Element("userlist");
			_doc = new Document(_root);
			Element el = new Element("user");
			el.addAttribute(new Attribute("username", "default"));
			el.addAttribute(new Attribute("password", "default"));
			_root.appendChild(el);
			CurrentStorage.get().storeUserProfileManager();
		} else {
			_root = _doc.getRootElement();
		}
	}
	
	/**
	  Method: createUser
	  Inputs: 
	  	@param String username - profile username
	  		   String password - profile password
	  Returns:  boolean - if creation was successful or not.

	  Description: Creates a user in memoranda's .userprofile file.
	*/
	public static boolean createUser(String username, String password) {
		if(username != null && password != null) {
			Element el = new Element("user");
			el.addAttribute(new Attribute("username", username));
			el.addAttribute(new Attribute("password", password));
			_root.appendChild(el);
			CurrentStorage.get().storeUserProfileManager();
			return true;
		}
		return false;
	}
	
	/**
	  Method: authenticate
	  Inputs: 
	  	@param String username - profile username
	  		   String password - profile password 
	  Returns: boolean - if user exists in memoranda's .userprofile file.

	  Description: Checks if a username and password combination exists in memoranda.
	*/
	public static boolean authenticate(String username, String password) {
		Elements els = _root.getChildElements("user");
		for (int i = 0; i < els.size(); i++) {
			Element se = els.get(i);
			if (se.getAttribute("username").getValue().equals(username) && se.getAttribute("password").getValue().equals(password)) {
				return true;
			}
		}
        return false;
    }
}
