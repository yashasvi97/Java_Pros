/*	
	@author(s) :	
					Yashasvi Baweja		2015116
					Viraj Parimi		2015068
*/
import java.util.*;
import java.io.*;
import java.lang.*;
class MyNetwork {
	public static void ReadList(List<Person> users) {
		for (final Person temp : users) {
			temp.readObject();
		}
	}
	static List<Person> ReadDB() throws IOException, FileNotFoundException {
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
					count = count + 1;
				}
				else {
					for(int i = count + 1; i < count + nof + 1; i++) {
						if(!arr[i].equals("null"))
							temp.addMyFriends(arr[i]);
					}
					count = count + nof + 1;
				}
				//add friend requests
				int nor = Integer.parseInt(arr[count]);
				temp.setUserRequests(nor);
				if(nor == 0) {
					//do nothing
				}
				else {
					for(int i = count + 1; i < count + nor + 1; i++) {
						if(!arr[i].equals("null"))
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
	public static int ifRegistered(String name, int position) throws IOException, FileNotFoundException, UserDoesNotExists, UserExistsInDB {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("input.txt"));
			String line = null;
			while((line= in.readLine()) != null) {
				String[] arr = line.split(",");
				if( arr[0].equals(name) ) {
					if(position == 2) {
						throw new UserExistsInDB("Username already registered!! Please Login");
					}
					else
						return 1;
				}
			}
			if(position == 1) {
				throw new UserDoesNotExists("This Username does not exist!!!!\n");
			}
			else {
				return 0;
			}
		}
		finally {
			if (in != null) {
				in.close();
			}
		}
	}
	public static void RegisterInDB(Person user) throws IOException, FileNotFoundException {
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
			out.print(user.getUserRequests() + "," );
			List<String> requestList = user.getMyRequests();
			if(requestList != null) {
				for (String tempstr : requestList) {
					out.print(tempstr + ",");
				}
			}
			out.print(user.getUserStatus() + "\n");
		}
		finally {
			if (out != null) {
				out.close();
			}
		}
	}
	public static Person findUser(String handle, List<Person> list)  throws UserDoesNotExists {
		for (Person temp : list) {
			if(temp.getUserName().equals(handle)) {
				return temp;
			}
		}
		throw new UserDoesNotExists("The User could not be found!!!!");
	}
	public static void changeDB(List<Person> networkUsers) throws IOException, FileNotFoundException {
		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter("input.txt",false)));
			for( Person user : networkUsers ) {
				out.print(user.getUserName() + "," + user.getUserPassword() + "," + user.getUserDispName() + "," + user.getUserFriends() + ",");
				List<String> friendList = user.getMyFriends();
				if(friendList != null) {
					for (String tempstr : friendList) {
						out.print(tempstr + ",");
					}
				}
				out.print(user.getUserRequests() + "," );
				List<String> requestList = user.getMyRequests();
				if(requestList != null) {
					for (String tempstr : requestList) {
						out.print(tempstr + ",");
					}
				}
				out.print(user.getUserStatus() + "\n");
			}
		}
		finally {
			if (out != null) {
				out.close();
			}
		}
	}
	public static List<Person> Register(String handle, List<Person> list) throws IOException, FileNotFoundException, UserDoesNotExists, UserExistsInDB  {
		Scanner scanner = new Scanner(System.in);
		int success = MyNetwork.ifRegistered(handle,2);
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
	public static Person Login(String handle, List<Person> list) throws IOException, FileNotFoundException, UserDoesNotExists, UserExistsInDB  {
		Scanner scanner = new Scanner(System.in);
		int success = MyNetwork.ifRegistered(handle,1);
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
	public static void takeActionRequest(Person Session, Person requestName, List<Person> networkUsers) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(requestName.getUserDispName());
		System.out.println("	1.Accept");
		System.out.println("	2.Reject");
		int option = scanner.nextInt();
		if(option == 1) {
			//accept
			Session.addMyFriends(requestName.getUserName());
			requestName.addMyFriends(Session.getUserName());
			int nof = Session.getUserFriends() + 1;
			Session.setUserFriends(nof);
			nof = requestName.getUserFriends() + 1;
			requestName.setUserFriends(nof);
			System.out.println("You are now friends with " + requestName.getUserName() + "\n");
		}
		else {
			//reject
			System.out.println("Friend request by " + requestName.getUserName() + " deleted");
		}
	}
	public static void callPendingRequests(Person Session, List<Person> networkUsers) throws IOException, FileNotFoundException, UserDoesNotExists {
		Scanner scanner = new Scanner(System.in);
		char ch ;
		while(true) {
			List<String> localRequest = Session.getMyRequests();
			int i;
			if (localRequest.size() != 0) {
				for ( i = 0; i < localRequest.size() ; ++i) {
					System.out.println((i+1) + "." + localRequest.get(i));
				}
			}
			else {
				System.out.println("No new friend requests");
			}
			System.out.println("	b.Back");
			ch = scanner.next().charAt(0);
			if(ch == 'b') {
				break;
			}
			else if(Character.getNumericValue(ch) <= localRequest.size()) {
				int pos = Character.getNumericValue(ch) - 1;
				//now there is no turning back and either accept the request or delete it
				//so better would be to first reduce the number of request by one
				int nor = Session.getUserRequests() - 1;
				Session.setUserRequests(nor);
				//now we can also remove the name of the person from the request list
				String name = localRequest.get(pos);
				Person requestName = MyNetwork.findUser(name, networkUsers);
				//got the name of the request now remove from the list
				Session.removeMyRequests(name);
				//now we have the name 
				MyNetwork.takeActionRequest(Session, requestName, networkUsers);
				MyNetwork.changeDB(networkUsers);
			}
			else {
				System.out.println("Wrong Input");
			}
		}
		return;
	}
	public static void callSession(Person Session, List<Person> networkUsers) throws IOException, FileNotFoundException, UserDoesNotExists  {
		Scanner scanner = new Scanner(System.in);
		int option;
		System.out.println("\n" + Session.getUserDispName() + " logged in now");
		if(Session.getUserStatus() != null) {
			System.out.println(Session.getUserStatus() + "\n");
		}
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
				/*networkUsers =*/ MyNetwork.callUpdateStatus(Session, networkUsers);
			}
			else if(option == 4) {
				MyNetwork.callPendingRequests(Session, networkUsers);
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
	public static List<Person> callUpdateStatus(Person Session, List<Person> networkUsers) throws IOException, FileNotFoundException  {
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
		MyNetwork.changeDB(networkUsers);
		System.out.println("\n Status updated!!!");
		return networkUsers;
	}
	public static boolean ifFriends(Person Session, Person searched) throws IOException, FileNotFoundException {
		//get logged in user's friend list
		List<String> friendsList = Session.getMyFriends();
		//get the handle's friendlist
//		List<String> searchFriendsList = searched.getMyFriends();
		//
		if(friendsList != null) {
			for( String tempFriendName : friendsList ) {
				if( tempFriendName.equals(searched.getUserName()) ) {
					return true;
				}
			}
		}
		return false;
	}
	public static List<String> findMutualFriends(Person Session, List<String> searchFriendsList) throws IOException, FileNotFoundException  {
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
	public static List<Person> sendFriendRequest(Person Session, Person searched, List<Person> networkUsers) throws IOException, FileNotFoundException {
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
		MyNetwork.changeDB(networkUsers);
		return networkUsers;
	}
	public static List<Person> cancelFriendRequest(Person Session, Person searched, List<Person> networkUsers) throws IOException, FileNotFoundException  {
		int nor;
		for (Person temp : networkUsers) {
			if(temp.getUserName().equals(searched.getUserName())) {
				nor = temp.getUserRequests() - 1;
				temp.setUserRequests(nor);
				//no of requests decreased by one for the list
				//now need to change in the friend list
				temp.removeMyRequests(Session.getUserName());
				System.out.println("Friend Request Cancel\n");
			}
		}
		MyNetwork.changeDB(networkUsers);
		return networkUsers;
	}
	public static char callBackMenu(String option, Person Session, Person searched, List<Person> networkUsers) throws IOException, FileNotFoundException {
		Scanner scanner = new Scanner(System.in);
		char chr = '0';
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
			return chr;
		}
		else if(option.equals("Not Friends")) {
			while(true) {
				if(Session.getMyRequests().contains(searched.getUserName())) {
					//the searched person has already sent FR
					System.out.println(searched.getUserName() + " has already sent you a friend request. Please check your pending requests!");
					break;
				}
				else {
					System.out.println("1.Send Request");
					System.out.println("b.Back");
					chr = scanner.next().charAt(0);
					if(chr == '1') {
						//send friend request
						networkUsers = MyNetwork.sendFriendRequest(Session, searched, networkUsers);
						// MyNetwork.ReadList(networkUsers);
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
			}
			return chr;
		}
		else if(option.equals("Request Sent")) {
			while(true) {
				System.out.println("1.Cancel Request");
				System.out.println("b.Back");
				chr = scanner.next().charAt(0);
				if(chr == '1') {
					//cancel friend request
					networkUsers = MyNetwork.cancelFriendRequest(Session, searched, networkUsers);
					break;
				}
				else if(chr == 'b') {
					break;
				}
				else {
					System.out.println("Wrong Input");
				}
			}
			return chr;
		}
		return chr;
	}
	public static void showFriendsMenu(Person Session, Person friend, List<Person> networkUsers) throws IOException, FileNotFoundException  {
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
		if(mutualFriends.size() != 0) {
			for( String friends : mutualFriends ) {
				System.out.print(friends + ", ");
			}
			System.out.println();
		}
		else {
			System.out.println("No mutual friends");
		}
		//show back menu
		MyNetwork.callBackMenu("Friend", Session, friend, networkUsers);
	}
	public static char showNotFriendsMenu(Person Session, Person user, List<Person> networkUsers, String option) throws IOException, FileNotFoundException {
		System.out.println(user.getUserName() + " is not a friend");
		List<String> searchFriendsList = user.getMyFriends();
		List<String> mutualFriends = MyNetwork.findMutualFriends(Session, searchFriendsList);
		//list only the mutual friends
		// System.out.println(mutualFriends);
		System.out.print("Mutual Friends:");
		if(mutualFriends.size() != 0) {
			for( String friends : mutualFriends ) {
				System.out.print(friends + ", ");
			}
			System.out.println();
		}
		else {
			System.out.println("No mutual friends");
		}
		if(Session.getUserFriends() != 0 && user.getUserFriends() != 0) {
			System.out.print("Shortest Route:	");
			MyNetwork.getShortestPath(Session, user, networkUsers);
		}
		//call back menu if not a friend
		char chr = '0';
		if(option.equals("Not Sent")){
			chr = MyNetwork.callBackMenu("Not Friends", Session, user, networkUsers);
		}
		else if(option.equals("Sent")){
			chr = MyNetwork.callBackMenu("Request Sent", Session, user, networkUsers);
		}
		else{
			//do nothing
		}
		return chr;
	}
	public static void callSearch(Person Session, List<Person> networkUsers) throws IOException, FileNotFoundException, UserDoesNotExists  {
		System.out.print("Enter name(handle):		");
		Scanner scanner = new Scanner(System.in);
		String searchName = scanner.nextLine();
		//Person temp = MyNetwork.findUser(searchName, networkUsers);
		Person temp = null;
		try {
			temp = MyNetwork.findUser(searchName, networkUsers);	
		}
		catch(UserDoesNotExists error) {
			System.out.println(error.getMessage());	
		}
		if(temp != null) {
			//user exists in the DB
			
			//now check whether friend or not
			if(MyNetwork.ifFriends(Session, temp) == true) {
				//i.e searchName is user's friend
				MyNetwork.showFriendsMenu(Session, temp, networkUsers);
			}
			else {
				//i.e searchName is not user's friend
				//check first that FR is already sent or not 
				if(!temp.getMyRequests().contains(Session.getUserName())) {
					char chr = MyNetwork.showNotFriendsMenu(Session, temp, networkUsers, "Not Sent");
					if(chr == '1')
						chr = MyNetwork.showNotFriendsMenu(Session, temp, networkUsers, "Sent");
				}
				else {
					//already FR sent 
					System.out.println("Friend request already sent");
					MyNetwork.showNotFriendsMenu(Session, temp, networkUsers, "Sent");
				}
				//Shortest route logic!!!
			}
		}
		/*else {
			//if handle not in DB need to show exception
			System.out.println("User " + searchName + " not found!" + "\n");
		}*/
		MyNetwork.changeDB(networkUsers);
	}
	public static void getShortestPath(Person Session, Person friend, List<Person> networkUsers) {
		Graph graph = new Graph();
		BreadthFirstSearch bfs = new BreadthFirstSearch();
		ArrayList<String> shortestPath = null;
		for (Person temp : networkUsers ) {
			List<String> myFriends = temp.getMyFriends();
			for (String bro : myFriends) {
				/*System.out.println("ppoooooooooooooooooooooooppppp");
				System.out.println(bro);*/
				graph.addEdge(temp.getUserName(), bro);
			}
		}
		String users = "";
		/*String s = graph.toString();
		System.out.println("woignvoiveoirneoibn");
		System.out.println(s);*/
		shortestPath = bfs.findShortestPath(graph, Session.getUserName(), friend.getUserName());
		for (String user : shortestPath ) {
			users += user + " ";
		}
		users += "\n";
		System.out.println(users);
	}
	public static void main(String[] args) throws IOException, FileNotFoundException, UserDoesNotExists, UserExistsInDB {
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
				try {
					networkUsers = MyNetwork.Register(username, networkUsers);
				}
				catch(UserExistsInDB error) {
					System.out.println(error.getMessage());
				}
				/*networkUsers = MyNetwork.Register(username, networkUsers);*/
			}
			else if(input == 2) {
				System.out.println("Enter the Username to login");
				String username = scanner.next();
				Person temp = null;
				try {
					temp = MyNetwork.Login(username, networkUsers);
					if(temp.getUserName().equals("temp")) {
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
				catch(UserDoesNotExists error) {
					System.out.println(error.getMessage());	
				}
				/*temp = MyNetwork.Login(username, networkUsers);
				if(temp == null) {
					//i.e user not registered
					System.out.println("This username does not exists!!! Register first");

				}*/
			}
			else
				System.out.println("Wrong Input! Enter valid number");
		}	
	}
}
