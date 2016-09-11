import java.util.*;
import java.io.*;
import java.lang.*;
class MyNetwork {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		List<Person> networkUsers = new ArrayList<Person> ();
		networkUsers = Person.ReadDB();
		Person.ReadList(networkUsers);
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
				Person.Register(username);
				Person.ReadList(networkUsers);
			}
			else if(input == 2) {
				System.out.println("Enter the Username to login");
				String username = scanner.next();
				Person temp;
				temp = Person.Login(username);
				if(temp != null) {
					Session = temp;
					break;//only way to break this infinite loop
				}
				else {
					System.out.println("Either Password input Wrong or such username does not exist");
				}
			}
			else
				System.out.println("Wrong Input! Enter valid number");
		}
		//program can reach here only if the user is logged in else it will get stuck in while loop
		Person.ReadList(networkUsers);
		System.out.println(Session.getUserDispName + " logged in now");
	}
}