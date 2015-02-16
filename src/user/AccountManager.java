package user;

import java.util.*;

public class AccountManager {
	private HashMap<String,String> users;
	
	public AccountManager(){
		users = new HashMap<String,String>();
	}
	
	public boolean addUser(String username, String password){
		username = username.toLowerCase();
		if(users.containsValue(username)){
			return false;
		}else{
			users.put(username, password);
			return true;
		}
	}
	
	public boolean checkCredentials(String username, String password){
		username = username.toLowerCase();
		if(!users.containsValue(username)){
			return false;
		}
		String storedPassword = users.get(username);
		if(!password.equals(storedPassword)) return false;
		return true;
	}
}
