package user;

import static org.junit.Assert.*;
import org.junit.*;

public class AccountManagerTest {

	@Test
	public void testGivenUsers(){
		AccountManager am = new AccountManager();
		assertFalse(am.addUser("Patrick","1234"));
		assertFalse(am.addUser("Patrick ","1234"));
		assertFalse(am.addUser(" PATRICK ","1234"));
		assertFalse(am.addUser("Molly","FloPup"));
		assertTrue(am.checkCredentials("Patrick","1234"));
		assertTrue(am.checkCredentials("PATRICK","1234"));
		assertTrue(am.checkCredentials("Molly","FloPup"));
		assertTrue(am.checkCredentials("MOLLY","FloPup"));
	}
	
	@Test
	public void testAddUsers(){
		AccountManager am = new AccountManager();
		assertTrue(am.addUser("Cleo","password"));
		assertFalse(am.addUser("cleo","password"));
	}

	@Test
	public void testCheckCredentials(){
		AccountManager am = new AccountManager();
		assertTrue(am.addUser("Cleo","password"));
		assertTrue(am.checkCredentials("Cleo","password"));
		assertFalse(am.checkCredentials("Cleo","wronge_password"));
	}
}
