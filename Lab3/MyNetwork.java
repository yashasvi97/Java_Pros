// package socialNetwork;
import java.util.*;
import java.io.*;
//import java.lang.*;
class MyNetwork {
	public static void ReadList(List<Person> users) {
		for (final Person temp : users) {
			temp.readObject();
		}
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
		int success = MyNetwork.ifRegistered(handle);
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
			MyNetwork.RegisterInDB(user);
			list.add(user);
			System.out.println("Registration is successful. User " + user.getUserName() + " created.");
			return list;
		}
	}
	public static Person Login(String handle, List<Person> list) throws IOException{
		Scanner scanner = new Scanner(System.in);
		int success = MyNetwork.ifRegistered(handle);
		if(success == 1) {
			//meaning such user exists
			Person foundUser = MyNetwork.findUser(handle,list);//foundUser will never get null as it is already checking 
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
	public static void callSession(Person Session, List<Person> networkUsers) {
		Scanner scanner = new Scanner(System.in);
		int option;
		System.out.println("\n" + Session.getUserDispName() + " logged in now");
		System.out.println(Session.getUserStatus() + "\n");
		while(true) {
			MyNetwork.callSessionMenu();
			option = scanner.nextInt();
			if(option == 1) {
				MyNetwork.callListFriends(Session);
			}
			else if( option == 2) {
				MyNetwork.callSearch(Session, networkUsers);
			}
			else if(option == 3) {
				networkUsers = MyNetwork.callUpdateStatus(Session, networkUsers);
			}
			else if(option == 4) {
				// MyNetwork.callPendingRequests(Session);
			}
			else {
				MyNetwork.callLogout(Session);
				return;
			}
		}
	}
	public static void callSessionMenu() {
		System.out.println("1. List Friends ");
		System.out.println("2. Search ");
		System.out.println("3. Update status ");
		System.out.println("4. Pending request ");
		System.out.println("5. Logout ");
	}
	public static void callLogout(Person Session) {
		System.out.println("User " + Session.getUserName() + " logged out successfully. \n");
		return ;
	}
	public static void callListFriends(Person Session) {
		List<String> userFriends = Session.getMyFriends();
		if(Session.getUserFriends() != 0) {
			System.out.print("Your friends are: ");
			for(int i = 0; i < Session.getUserFriends(); i++) {
				System.out.print(userFriends.get(i) + " ");
			}
			System.out.println("");
		}
		else {
			System.out.println("You do not have any friends now. \n");
		}
	}
	public static List<Person> callUpdateStatus(Person Session, List<Person> networkUsers) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter status:	");
		String status = scanner.nextLine();
		Session.setStatus(status);
		for( Person temp : networkUsers ) {
			if( temp.getUserName().equals(Session.getUserName()) ) {
				temp.setStatus(status);
			}
		}
		//change in file!!!!

		System.out.println("\n Status updated!!!");
		return networkUsers;
	}
	public static boolean ifFriends(Person Session, Person searched) {
		//get logged in user's friend list
		List<String> friendsList = Session.getMyFriends();
		//get the handle's friendlist
//		List<String> searchFriendsList = searched.getMyFriends();
		//
		for( String tempFriendName : friendsList ) {
			if( tempFriendName.equals(searched.getUserName()) ) {
				return true;
			}
		}
		return false;
	}
	public static List<String> findMutualFriends(Person Session, List<String> searchFriendsList) {
		//get loggedin user's friend list
		List<String> friendsList = Session.getMyFriends();
		//get the friend's friendlist
		List<String> Mutual = new ArrayList<String>();
		for (String tempFriend: friendsList ) {
			if(searchFriendsList.contains(tempFriend)) {
				//that friend is mutual
				Mutual.add(tempFriend);
			}
		}
		return Mutual;
	}
	public static List<Person> sendFriendRequest(Person Session, Person searched, List<Person> networkUsers) {
		int nor;
		for (Person temp : networkUsers) {
			if(temp.getUserName().equals(searched.getUserName())) {
				nor = temp.getUserRequests() + 1;
				temp.setUserRequests(nor);
				//no of requests increased by one for the list
				//now need to add in the friend list
				temp.addMyRequests(Session.getUserName());
				System.out.println("Friend Request sent\n");
			}
		}
		return networkUsers;
	}
	public static List<Person> callBackMenu(String option, Person Session, Person searched, List<Person> networkUsers) {
		Scanner scanner = new Scanner(System.in);
		char chr;
		if(option.equals("Friend")) {
			while(true) {
				System.out.println("b.Back");
				//here exception needs to be there to check for a valid input
				chr = scanner.next().charAt(0);
				if(chr == 'b') {
					break;
				}
				else {
					System.out.println("wrong input");
				}
			}
			return networkUsers;
		}
		else if(option.equals("Not Friends")) {
			while(true) {
				System.out.println("1.Send Request");
				System.out.println("b.Back");
				chr = scanner.next().charAt(0);
				if(chr == '1') {
					//send friend request
					networkUsers = MyNetwork.sendFriendRequest(Session, searched, networkUsers);
					MyNetwork.ReadList(networkUsers);
					break;
				}
				else if(chr == 'b') {
					break;
				}
				else {
					//wrong input
					System.out.println("Wrong Input");
				}
			}
			return networkUsers;
		}
		return networkUsers;
	}
	public static void showFriendsMenu(Person Session, Person friend, List<Person> networkUsers) {
		System.out.println("You and " + friend.getUserName() + " are friends.\n");
		System.out.println("Display Name:	" + friend.getUserDispName());
		System.out.println("Status:	" + friend.getUserStatus());
		//show all the friends except the logged in user and mutual friends
		List<String> searchFriendsList = friend.getMyFriends();
		// now we need to make a new list of two types 1. Mutual and 2. Other friends
		//first finding mutual friends
		List<String> mutualFriends = MyNetwork.findMutualFriends(Session, searchFriendsList);
		//now print all the friends except mutual
		System.out.print("Friends:	");
		for (String friends : searchFriendsList) {
			if(!mutualFriends.contains(friends) && !friends.equals(Session.getUserName())) {
				System.out.print(friends + ", ");
			}
		}
		System.out.println();
		//mutual friends logic!!!
		System.out.print("Mutual Friends:		");
		for( String friends : mutualFriends ) {
			System.out.print(friends + ", ");
		}
		System.out.println();
		//show back menu
		MyNetwork.callBackMenu("Friend", Session, friend, networkUsers);
	}
	public static void showNotFriendsMenu(Person Session, Person user, List<Person> networkUsers) {
		System.out.println(user.getUserName() + " is not a friend");
		List<String> searchFriendsList = user.getMyFriends();
		List<String> mutualFriends = MyNetwork.findMutualFriends(Session, searchFriendsList);
		//list only the mutual friends
		System.out.print("Mutual Friends:");
		if(mutualFriends != null) {
			for( String friends : mutualFriends ) {
				System.out.print(friends + ", ");
			}
			System.out.println();
		}
		else {
			System.out.println("No mutual friends");
		}
		//call back menu if not a friend
		MyNetwork.callBackMenu("Not Friends", Session, user, networkUsers);
	}
	public static void callSearch(Person Session, List<Person> networkUsers) {
		System.out.print("Enter name(handle):		");
		Scanner scanner = new Scanner(System.in);
		String searchName = scanner.nextLine();
		Person temp = MyNetwork.findUser(searchName, networkUsers);

		if(temp != null) {
			//user exists in the DB
			
			//now check whether friend or not
			if(MyNetwork.ifFriends(Session, temp) == true) {
				//i.e searchName is user's friend
				MyNetwork.showFriendsMenu(Session, temp, networkUsers);
			}
			else {
				//i.e searchName is not user's friend
				MyNetwork.showNotFriendsMenu(Session, temp, networkUsers);
				//Shortest route logic!!!
			}
		}
		else {
			//if handle not in DB need to show exception
			System.out.println("User " + searchName + " not found!" + "\n");
		}
	}
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		List<Person> networkUsers = new ArrayList<Person> ();
		networkUsers = MyNetwork.ReadDB();
		Person Session;
		//now network users contains all the data fetched from the DB
		int input ;
		while(true) {
			System.out.println("1.Sign Up");
			System.out.println("2.Login");
			input = scanner.nextInt();
			if(input == 1) {
				System.out.println("Enter the Username");
				String username = scanner.next();
				networkUsers = MyNetwork.Register(username, networkUsers);
			}
			else if(input == 2) {
				System.out.println("Enter the Username to login");
				String username = scanner.next();
				Person temp;
				temp = MyNetwork.Login(username, networkUsers);
				if(temp == null) {
					//i.e user not registered
					System.out.println("This username does not exists!!! Register first");
				}
				else if(temp.getUserName().equals("temp")) {
					//i.e password wrong redirect to take password again
					temp = MyNetwork.Login(username, networkUsers);
					while(temp.getUserName().equals("temp")) {
						temp = MyNetwork.Login(username, networkUsers);
					}//will break the loop only when the username attribute is not temp
					Session = temp;
					MyNetwork.callSession(Session, networkUsers);
					Session = null;
				}
				else {
					Session = temp;
					MyNetwork.callSession(Session, networkUsers);
					Session = null;
				}
			}
			else
				System.out.println("Wrong Input! Enter valid number");
		}	
	}
}