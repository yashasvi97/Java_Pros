import java.util.*;
import java.lang.*;
class Vehicle {
	int tyres;
	String owner;
	public Vehicle(int wheels,String name) {
		tyres = wheels;
		owner = name;
	}
	public int getWheels() {
		return tyres;
	}
	public String getOwnerName() {
		return owner;
	}
}
class EnginePoweredVehicle extends Vehicle {
	ThirdPartyPolicy policy1;
	PackagePolicy policy2;
	public EnginePoweredVehicle(int wheels, String name, int option, int day, int month, int year) {
		super(wheels,name);
		if(option == 1) {
			policy1 = new ThirdPartyPolicy(day,month,year);
		}
		else {
			policy2 = new PackagePolicy(day,month,year);
		}
	}
	public String getPolicyClass() {
		if(policy1 == null) {
			return policy2.getClasses();
		}
		else if(policy2 == null) {
			return policy1.getClasses();
		}
		return "";
	}
	public float getPolicyOncomingRefund() {
		if(policy1 == null) {
			return policy2.getThirdParty();
		}
		else if(policy2 == null) {
			return policy1.getThirdParty();
		}
		return 0;	
	}
	public float getPolicySelfRefund() {
		if(policy1 == null) {
			return policy2.getSelf();
		}
		else if(policy2 == null) {
			return policy1.getSelf();
		}
		return 0;	
	}
	public String getPolicyExpiry() {
		if(policy1 == null) {
			return policy2.getExpiryDate();
		}
		else if(policy2 == null) {
			return policy1.getExpiryDate();
		}
		return "";	
	}
}
class ManualDriven extends Vehicle {
	public ManualDriven(int wheels,String name) {
		super(wheels,name);
	}
}
class TwoWheeler extends EnginePoweredVehicle {
	public TwoWheeler(String name, int option, int day, int month, int year) {
		super(2,name,option,day,month,year);
	}
}
class FourWheeler extends EnginePoweredVehicle {
	public FourWheeler(String name, int option, int day, int month, int year) {
		super(4,name,option,day,month,year);
	}
}
class Hercules extends ManualDriven {
	String model;
	public Hercules(String name, String modelName) {
		super(2,name);
		model = modelName;
	}
	public String getModel() {
		return model;
	}
}
class BMX extends ManualDriven {
	String model;
	public BMX(String name, String modelName) {
		super(2,name);
		model = modelName;
	}
	public String getModel() {
		return model;
	}
}
class Bajaj extends TwoWheeler {
	String model;
	public Bajaj(String name, String modelName, int option, int day, int month, int year) {
		super(name,option,day,month,year);
		model = modelName;
	}
	public String getModel() {
		return model;
	}
}
class Hero extends TwoWheeler {
	String model;
	public Hero(String name, String modelName, int option, int day, int month, int year) {
		super(name,option,day,month,year);
		model = modelName;
	}
	public String getModel() {
		return model;
	}
}
class Maruti extends FourWheeler {
	String model;
	public Maruti(String name, String modelName, int option, int day, int month, int year) {
		super(name,option,day,month,year);
		model = modelName;
	}
	public String getModel() {
		return model;
	}
}
class Honda extends FourWheeler {
	String model;
	public Honda(String name, String modelName, int option, int day, int month, int year) {
		super(name,option,day,month,year);
		model = modelName;
	}
	public String getModel() {
		return model;
	}
}