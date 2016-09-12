 // package socialNetwork;
import java.util.*;
import java.io.*;
import java.lang.*;
// import java.nio.file.*;

class Person {
	String userName;
	String password;
	String displayName;
	int noOfFriends;
	List<String> myFriends;
	int requests;
	List<String> myRequests;
	String status;
	public Person(String handle, String pass, String name) {
		userName = handle;
		password = pass;
		displayName = name;
		noOfFriends = 0;
		myFriends = new ArrayList<String>();
		requests = 0;
		myRequests = new ArrayList<String>();
		status = null;
	}
	public String getUserName() {
		return userName;
	}
	public String getUserPassword() {
		return password;
	}
	public String getUserDispName() {
		return displayName;
	}
	public int getUserFriends() {
		return noOfFriends;
	}
	public int getUserRequests() {
		return requests;
	}
	public String getUserStatus() {
		return status;
	}
	public List<String> getMyFriends() {
		return myFriends;
	}
	public List<String> getMyRequests() {
		return myRequests;
	}
	void setUserFriends(int nof) {
		this.noOfFriends = nof;
	}
	void setUserRequests(int nor) {
		this.requests = nor;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	void addMyFriends(String friend) {
		this.myFriends.add(friend);
	}
	void addMyRequests(String request) {
		this.myRequests.add(request);
	}
	public int checkPassword(String password) {
		String origPassword = this.getUserPassword();
		if(origPassword.equals(password)) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public void readObject() {
		System.out.print(this.getUserName() + "," + this.getUserPassword() + "," + this.getUserDispName() + "," + this.getUserFriends() + ",");
		List<String> friendList = this.getMyFriends();
		if(friendList != null) {
			for (String tempstr : friendList) {
				System.out.print(tempstr + ",");
			}
		}
		else {
			System.out.print("null");
		}
		System.out.print(this.getUserRequests() + "," );
		List<String> requestList = this.getMyRequests();
		if(requestList != null) {
			for (String tempstr : requestList) {
				System.out.print(tempstr + ",");
			}
		}
		else {
			System.out.print("null");
		}
		System.out.print(this.getUserStatus() + "\n");
	}
}