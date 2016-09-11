import java.util.*;
import java.io.*;
import java.lang.*;
class MyNetwork {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		List<Person> networkUsers = new ArrayList<Person> ();
		networkUsers = Person.ReadDB();
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
				networkUsers = Person.Register(username, networkUsers);
			}
			else if(input == 2) {
				System.out.println("Enter the Username to login");
				String username = scanner.next();
				Person temp;
				temp = Person.Login(username, networkUsers);
				if(temp == null) {
					//i.e user not registered
					System.out.println("This username does not exists!!! Register first");
				}
				else if(temp.getUserName().equals("temp")) {
					//i.e password wrong redirect to take password again
					temp = Person.Login(username, networkUsers);
					while(temp.getUserName().equals("temp")) {
						temp = Person.Login(username, networkUsers);
					}//will break the loop only when the username attribute is not temp
					Session = temp;
					Session.callSession(networkUsers);
					Session = null;
				}
				else {
					Session = temp;
					Session.callSession(networkUsers);
					Session = null;
				}
			}
			else
				System.out.println("Wrong Input! Enter valid number");
		}	
	}
}