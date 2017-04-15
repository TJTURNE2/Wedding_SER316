package net.sf.memoranda;

public class UserProfile {
	
	public boolean createUser(String username, String password) {
		// TODO save and create user data.
		return false;
	}
	
	public static boolean authenticate(String username, String password) {
        // hardcoded username and password
        if (username.equals("wedding") && password.equals("abc")) {
            return true;
        }
        return false;
    }

}
