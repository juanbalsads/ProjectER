package ER.POJOS;

public class User {
	public enum UserType {
		DOCTOR, NURSE, DB_MANAGER, ER_ASSISTANT 
	}
	
	private String username;
	private String password;
	private UserType usertype;

}
