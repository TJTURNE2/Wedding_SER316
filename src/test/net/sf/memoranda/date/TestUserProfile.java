package test.net.sf.memoranda.date;

import static org.junit.Assert.*;

import org.junit.Test;

import net.sf.memoranda.UserProfile;

public class TestUserProfile {
	@Test
	public void testUserCreation() {
		assertTrue(UserProfile.createUser("test", "test"));
		assertTrue(UserProfile.createUser("test2", "test2"));
		assertTrue(UserProfile.createUser("_test_", "Test123"));
		
		assertTrue(!UserProfile.createUser("test3", null));
		assertTrue(!UserProfile.createUser(null, null));
	}
	
	@Test
	public void testUserAuthentication() {
		assertTrue(UserProfile.authenticate("test", "test"));
		assertTrue(UserProfile.createUser("test2", "test2"));
		assertTrue(UserProfile.createUser("_test_", "Test123"));
		
		assertTrue(!UserProfile.createUser("test3", null));
		assertTrue(!UserProfile.createUser(null, null));
	}
}
