package net.sf.memoranda;

import net.sf.memoranda.util.CurrentStorage;
import nu.xom.Attribute;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;

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
