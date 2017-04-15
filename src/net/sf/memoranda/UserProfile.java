package net.sf.memoranda;

public class UserProfile {
	public static boolean authenticate(String username, String password) {
        // hardcoded username and password
        if (username.equals("wedding") && password.equals("abc")) {
            return true;
        }
        return false;
    }

}
