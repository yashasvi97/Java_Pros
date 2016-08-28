import java.util.*;
import java.lang.*;
class Vehicle{
	int tyres;
	String owner;
	public Vehicle(int wheels,String name){
		tyres = wheels;
		owner = name;
		// owner = owner.copyValueOf( name );
	}
	public void show(){
		System.out.println("tyres : " + tyres + " ; owner : " + owner);
	}
	/*public static void main(String args[]){
		Vehicle veh = new Vehicle(1,"yb_veh");
		veh.show();
	}*/
}
class Engine_powered_vehicle extends Vehicle{
	public Engine_powered_vehicle(int wheels,String name){
		super(wheels,name);
	}
	/*public static void main(String args[]){
		Engine_powered_vehicle car = new Engine_powered_vehicle(4,"yb_eng_veh");
		car.show();
	}*/
}
class Manual_driven extends Vehicle{
	public Manual_driven(int wheels,String name){
		super(wheels,name);
	}
	/*public static void main(String[] args) {
		Manual_driven cycle = new Manual_driven(2,"yb_man_veh");
		cycle.show();
	}*/
}
class Two_wheeler extends Engine_powered_vehicle{
	public Two_wheeler(String name){
		super(2,name);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name;
		name = sc.nextLine();
		Two_wheeler twowlr = new Two_wheeler(name);
		twowlr.show();
	}
}
class Four_wheeler extends Engine_powered_vehicle{
	public Four_wheeler(String name){
		super(4,name);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name;
		name = sc.nextLine();
		Four_wheeler frwlr = new Four_wheeler(name);
		frwlr.show();
	}
}
/*
	now the classes for manual and engine powered are ready and different classes are to be made of the products they will have (like WagonR, Pulsar,etc)
*/