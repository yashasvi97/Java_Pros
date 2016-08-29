import java.util.*;
import java.lang.*;
class Vehicle {
	int tyres,modelNumber,insured;
	String owner;
	static int uniqueId = 0;
	public Vehicle(int wheels,String name) {
		tyres = wheels;
		owner = name;
		insured = 0;
		modelNumber = getNewId();
	}
	public int getWheels() {
		return tyres;
	}
	public String getOwnerName() {
		return owner;
	}
	public static int getNewId() {
		uniqueId = uniqueId + 1;
		return uniqueId;
	}
	public int getId() {
		return modelNumber;
	}
	public void setInsured(int option) {
		insured = option;
	}
	public int getInsured() {
		return insured;
	}
}
class EnginePoweredVehicle extends Vehicle {
	VehiclePolicy policy;
	public EnginePoweredVehicle(int wheels, String name, int op, int day, int month, int year) {
		super(wheels,name);
		setInsured(op);
		if(op == 1) {
			policy = new ThirdPartyPolicy(day,month,year);
		}
		else {
			policy = new PackagePolicy(day,month,year);
		}
	}
	public String getPolicyClass() {
		return policy.getClasses();
	}
	public float getPolicyOncomingRefund() {
		return policy.getThirdParty();
	}
	public float getPolicySelfRefund() {
		return policy.getSelf();	
	}
	public String getPolicyExpiry() {
		return policy.getExpiryDate();
	}
	public long getPolicyNumber() {
		return policy.getPolicy();
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