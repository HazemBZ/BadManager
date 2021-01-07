package com.esprit.badmanager.utilities;

import com.esprit.badmanager.entities.User;

public class SessionMan {
	
	public static User connectedUser = null;
	
	public  SessionMan() {
		
	}
	public static void connect(User user) {
		SessionMan.connectedUser = user;
	}
	public static User disconnect() {
		return SessionMan.connectedUser;
	}
}
