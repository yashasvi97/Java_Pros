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
	public static Person findUser(String handle, List<Person> list) {
		for (Person temp : list) {
			if(temp.getUserName().equals(handle)) {
				return temp;
			}
		}
		return null;
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
	/*public int changeStatus(String status, String name) {
		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter("input.txt",true)));
			String line = null;
			while((line= out.readLine()) != null) {
				String[] arr = line.split(",");
				if(arr[0].equals(name)) {

				}
		}
		finally {
			if (out != null) {
				out.close();
			}
		}
	}*/
	public static List<Person> Register(String handle, List<Person> list) throws IOException{
		Scanner scanner = new Scanner(System.in);
		int success = Person.ifRegistered(handle);
		if(success == 1){
			System.out.println("Username already registered!! Please Login");
			return list;
		}
		else {
			System.out.println("Enter the Password");
			String password = scanner.next();
			System.out.println("Enter the Display Name");
			String displayname = scanner.next();
			Person user = new Person(handle, password, displayname);
			Person.RegisterInDB(user);
			list.add(user);
			System.out.println("Registration is successful. User " + user.getUserName() + " created.");
			return list;
		}
	}
	public static Person Login(String handle, List<Person> list) throws IOException{
		Scanner scanner = new Scanner(System.in);
		int success = Person.ifRegistered(handle);
		if(success == 1) {
			//meaning such user exists
			Person foundUser = Person.findUser(handle,list);//foundUser will never get null as it is already checking 
			System.out.println("Enter the Password");
			String password = scanner.next();
			int authorised = foundUser.checkPassword(password);
			if(authorised == 1) {
				//i.e the password matches the given, now need to login
				return foundUser;
			}
			else {
				//password wrong
				System.out.println("Password does not match");
				Person temp = new Person("temp","temp123","temp");
				return temp;
			}
		}
		else {
			//i.e not registered. 
			return null;
		}
	}
	public void callSession(List<Person> networkUsers) {
		Scanner scanner = new Scanner(System.in);
		int option;
		System.out.println("\n" + this.getUserDispName() + " logged in now");
		System.out.println(this.getUserStatus() + "\n");
		while(true) {
			this.callSessionMenu();
			option = scanner.nextInt();
			if(option == 1) {
				this.callListFriends();
			}
			else if( option == 2) {
				this.callSearch(networkUsers);
			}
			else if(option == 3) {
				networkUsers = this.callUpdateStatus(networkUsers);
			}
			else if(option == 4) {
				// this.callPendingRequests();
			}
			else {
				this.callLogout();
				return;
			}
		}
	}
	private void callSessionMenu() {
		System.out.println("1. List Friends ");
		System.out.println("2. Search ");
		System.out.println("3. Update status ");
		System.out.println("4. Pending request ");
		System.out.println("5. Logout ");
	}
	private void callLogout() {
		System.out.println("User " + this.getUserName() + " logged out successfully. \n");
		return ;
	}
	private void callListFriends() {
		List<String> userFriends = this.getMyFriends();
		if(this.getUserFriends() != 0) {
			System.out.print("Your friends are: ");
			for(int i = 0; i < this.getUserFriends(); i++) {
				System.out.print(userFriends.get(i) + " ");
			}
			System.out.println("");
		}
		else {
			System.out.println("You do not have any friends now. \n");
		}
	}
	private List<Person> callUpdateStatus(List<Person> networkUsers) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter status:	");
		String status = scanner.nextLine();
		this.setStatus(status);
		for( Person temp : networkUsers ) {
			if( temp.getUserName().equals(this.getUserName()) ) {
				temp.setStatus(status);
			}
		}
		//change in file!!!!

		System.out.println("\n Status updated!!!");
		return networkUsers;
	}
	private void callSearch(List<Person> networkUsers) {
		System.out.println("Enter name(handle):		");
		Scanner scanner = new Scanner(System.in);
		String searchName = scanner.nextLine();
		Person temp = Person.findUser(searchName, networkUsers);

		if(temp != null) {
			List<String> friendsList = this.getMyFriends();
			List<String> searchFriendsList = temp.getMyFriends();
			for( String tempFriend : friendsList ) {
				if( tempFriend.equals(searchName) ) {
					
					//if searchName is user's friend

					System.out.println("You and " + searchName + " are friends.\n");
					System.out.println("Display Name:	" + temp.getUserDispName());
					System.out.println("Status:	" + temp.getUserStatus());
					System.out.print("Friends:	");
					for( String friends : searchFriendsList ) {
						if( !friends.equals(this.getUserName()) ) {
							System.out.print(friends + ", ");
						}
 					}
 					System.out.println();

 					//mutual friends logic!!!
 					System.out.println("Mutual Friends:		");

 					//back logic!!!!
				}
				else {
					
					//if searchName is not user's friend

					System.out.println(searchName + " is not a friend");

					//mutual friends logic!!!
 					System.out.println("Mutual Friends:		");

 					//shotest route logic!!!

 					//send request logic!!!
 					System.out.println("	1. Send Request");
 					
 					//back logic!!!
				}
			} 
		}
		else {

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