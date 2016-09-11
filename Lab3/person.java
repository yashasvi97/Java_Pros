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
	private void setUserFriends(int nof) {
		this.noOfFriends = nof;
	}
	private void setUserRequests(int nor) {
		this.requests = nor;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private void addMyFriends(String friend) {
		this.myFriends.add(friend);
	}
	private void addMyRequests(String request) {
		this.myRequests.add(request);
	}
	public static void ReadList(List<Person> users) {
		for (final Person temp : users) {
			temp.readObject();
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
	public static List<Person> ReadDB() throws IOException {
		System.out.println("Reading Database...");
		List<Person> networkUsers = new ArrayList<Person>();
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("input.txt"));
			String line = null;
			Person temp;
			while((line = in.readLine()) != null) {
				int count = 0;
				String[] arr = line.split(",");
				//add user name
				String handle = arr[count++];
				//add password
				String pass = arr[count++];
				//add display name
				String name = arr[count++];
				//make a new object
				temp = new Person(handle, pass, name);
				//add no of friends
				int nof = Integer.parseInt(arr[count]);
				temp.setUserFriends(nof);
				if(nof == 0) {
					String tempstr = null;
					temp.addMyFriends(tempstr);
				}
				else {
					for(int i = count + 1; i < count + nof + 1; i++) {
						temp.addMyFriends(arr[i]);
					}
				}
				count = count + nof + 1;
				//add friend requests
				int nor = Integer.parseInt(arr[count]);
				temp.setUserRequests(nor);
				if(nor == 0) {
					String tempstr = null;
					temp.addMyRequests(tempstr);
				}
				else {
					for(int i = count + 1; i < count + nor + 1; i++) {
						temp.addMyRequests(arr[i]);
					}					
				}
				count = count + nor + 1;
				//add the status
				temp.setStatus(arr[count]);
				//add the object added into list
				networkUsers.add(temp);
			}
			System.out.println("Network is ready!");
			// return the list
			return networkUsers;
		}
		finally {
			if (in != null) {
				in.close();
			}
		}
	}
	public static int ifRegistered(String name) throws IOException {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("input.txt"));
			String line = null;
			while((line= in.readLine()) != null) {
				String[] arr = line.split(",");
				if( arr[0].equals(name) )
					return 1;
			}
			return 0;
		}
		finally {
			if (in != null) {
				in.close();
			}
		}
	}
	public static void RegisterInDB(Person user) throws IOException {
		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter("input.txt",true)));
			out.print(user.getUserName() + "," + user.getUserPassword() + "," + user.getUserDispName() + "," + user.getUserFriends() + ",");
			List<String> friendList = user.getMyFriends();
			if(friendList != null) {
				for (String tempstr : friendList) {
					out.print(tempstr + ",");
				}
			}
			// else {
			// 	out.print(friendList);
			// }
			out.print(user.getUserRequests() + "," );
			List<String> requestList = user.getMyRequests();
			if(requestList != null) {
				for (String tempstr : requestList) {
					out.print(tempstr + ",");
				}
			}
			// else {
			// 	out.print(user.getMyRequests());
			// }
			out.print(user.getUserStatus() + "\n");
		}
		finally {
			if (out != null) {
				out.close();
			}
		}
	}
	/*public static Person findUser(String handle) {
		Person user;
		//only structure
		return user;
	}
	public int checkPassword(String password) {
		int c;
		//only structure 
		return c;
	}*/
	public static void Register(String handle) {
		Scanner scanner = new Scanner(System.in);
		int success = Person.ifRegistered(handle);
		if(success == 1){
			System.out.println("Username already registered!! Please Login");
			return ;
		}
		else {
			System.out.println("Enter the Password");
			String password = scanner.next();
			System.out.println("Enter the Display Name");
			String displayname = scanner.next();
			Person user = new Person(handle, password, displayname);
			Person.RegisterInDB(user);
			System.out.println("Registration is successful. User " + user.getUserName() + " created.");
		}
	}
	public static Person Login(String handle) {
		Scanner scanner = new Scanner(System.in);
		int success = Person.ifRegistered(handle);
		if(success == 1) {
			//meaning such user exists
			Person foundUser = Person.findUser(handle);
			System.out.println("Enter the Password");
			String password = scanner.next();
			int authorised = foundUser.checkPassword(password);
			if(authorised == 1) {
				//i.e the password matches the given, now need to login
				return foundUser;
			}
			else {
				System.out.println("Password does not match");
				return null;
			}
		}
		else {
			//i.e not registered. 
			System.out.println("This username does not exists!!! Register first");
			return null;
		}
	}
	/*public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter the option");
		int opt = scanner.nextInt();
		if (opt == 1) {
			System.out.println("Enter the Username");
			String username = scanner.next();
			int success = Person.ifRegistered(username);
			if(success == 1)
				System.out.println("Username already registered!! Please Login");
			else {
				System.out.println("Enter the Password");
				String password = scanner.next();
				System.out.println("Enter the Display Name");
				String displayname = scanner.next();
				Person user = new Person(username, password, displayname);
				Person.RegisterInDB(user);
			}
		}
		else if (opt == 2) {
			List<Person> nusers = new ArrayList<Person> ();
			nusers = Person.ReadDB();
			Person.ReadList(nusers);
		}
		else if (opt == 3) {
			System.out.println("Enter the username to login!");
			String username = scanner.next();
			int success = Person.ifRegistered(username);
			if(success == 1) {
				//means the user is already registered in the DB

			}
			else {
				System.out.println("Username does not exists!! Please Register");
			}
		}
	}*/
}