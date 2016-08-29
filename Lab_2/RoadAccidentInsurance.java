import java.util.*;
public class RoadAccidentInsurance { 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] modelName = new String[6];
		String[] ownerName = new String[6];
		String[] vehicle = new String[6];
		String[] policyExpiry = new String[4];
		String[] policyType = new String[4];
		int damageSelf, damageOncoming, count = 1;
		int[] option = new int[6];
		int[] wheels = new int[6];
		int[] day = new int[4];
		int[] month = new int[4];
		int[] year = new int[4];
		Random damage = new Random();
		vehicle[0] = "Hercules";
		vehicle[1] = "BMX";
		vehicle[2] = "Bajaj";
		vehicle[3] = "Hero";
		vehicle[4] = "Maruti";
		vehicle[5] = "Honda";
		// hercules data
		System.out.println("Entering Hercules cycle data...");
		Hercules cycle1 = new Hercules("Viraj", "Hercules");
		// bmx data
		System.out.println("Entering BMX cycle data...");
		BMX cycle2 = new BMX("Yashasvi", "BMX");
		// bajaj data
		System.out.println("Entering Bajaj bike data...");
		day[0] = 2;
		month[0] = 11;
		year[0] = 2018;
		Bajaj bike1 = new Bajaj("Parimi", "Bajaj", 1, day[0], month[0], year[0]);	
		// Hero data
		System.out.println("Entering Hero bike data...");
		day[1] = 12;
		month[1] = 8;
		year[1] = 2010;
		Hero bike2 = new Hero("Baweja", "Hero", 1, day[1], month[1], year[1]);
		// maruti data
		System.out.println("Entering Maruti car data...");
		day[2] = 24;
		month[2] = 4;
		year[2] = 2020;
		Maruti car1 = new Maruti("Mrinal", "Maruti", 2, day[2], month[2], year[2]);	
		// honda data
		System.out.println("Entering Honda car data...");
		day[3] = 17;
		month[3] = 12;
		year[3] = 2010;
		Honda car2 = new Honda("Abrol", "Honda", 2, day[3], month[3], year[3]);	
		modelName[0] = cycle1.getModel();
		ownerName[0] = cycle1.getOwnerName();
		wheels[0] = cycle1.getWheels();
		System.out.println("Model : " + modelName[0] + " ; Owner : " + ownerName[0] + " ; Wheels : " + wheels[0]);
		modelName[1] = cycle2.getModel();
		ownerName[1] = cycle2.getOwnerName();
		wheels[1] = cycle2.getWheels();
		System.out.println("Model : " + modelName[1] + " ; Owner : " + ownerName[1] + " ; Wheels : " + wheels[1]);
		modelName[2] = bike1.getModel();
		ownerName[2] = bike1.getOwnerName();
		wheels[2] = bike1.getWheels();
		policyType[0] = bike1.getPolicyClass();
		policyExpiry[0] = bike1.getPolicyExpiry();
		System.out.println("Model : " + modelName[2] + " ; Owner : " + ownerName[2] + " ; Wheels : " + wheels[2] + " ; Policy Type : " + policyType[0] + " ; Policy Expiry " + policyExpiry[0]);
		modelName[3] = bike2.getModel();
		ownerName[3] = bike2.getOwnerName();
		wheels[1] = bike2.getWheels();
		policyType[1] = bike2.getPolicyClass();
		policyExpiry[1] = bike2.getPolicyExpiry();
		System.out.println("Model : " + modelName[3] + " ; Owner : " + ownerName[3] + " ; Wheels : " + wheels[3] + " ; Policy Type : " + policyType[1] + " ; Policy Expiry " + policyExpiry[1]);
		modelName[4] = car1.getModel();
		ownerName[4] = car1.getOwnerName();
		wheels[2] = car1.getWheels();
		policyType[2] = car1.getPolicyClass();
		policyExpiry[2] = car1.getPolicyExpiry();
		System.out.println("Model : " + modelName[4] + " ; Owner : " + ownerName[4] + " ; Wheels : " + wheels[4] + " ; Policy Type : " + policyType[2] + " ; Policy Expiry " + policyExpiry[2]);
		modelName[5] = car2.getModel();
		ownerName[5] = car2.getOwnerName();
		wheels[3] = car2.getWheels();
		policyType[3] = car2.getPolicyClass();
		policyExpiry[3] = car2.getPolicyExpiry();
		System.out.println("Model : " + modelName[5] + " ; Owner : " + ownerName[5] + " ; Wheels : " + wheels[5] + " ; Policy Type : " + policyType[3] + " ; Policy Expiry " + policyExpiry[3]);
		System.out.println("<!-------Collision loop is starting-------!>");
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 6; j++) {
				if( !vehicle[i].equals(vehicle[j]) ) {
					System.out.println("<!-------------Collision " + count + " proceeding---------------!>");
					// hercules settlements
					if (vehicle[i].equals("Hercules") && vehicle[j].equals("BMX")) {
						count += 1;
						damageSelf = damage.nextInt(1000);
						damageOncoming = damage.nextInt(1000);
						System.out.println("I am < " + modelName[0] + " , " + ownerName[0] + " > , collided with < " + modelName[1] + " , " + ownerName[1] + " > ");
						System.out.println("Damages self : " + damageSelf);
						System.out.println("Damages oncoming : " + damageOncoming);
						System.out.println("Sorry, you cannot do settlements.\n");
					}
					else if (vehicle[i].equals("Hercules") && vehicle[j].equals("Bajaj")) {
						count += 1;
						damageSelf = damage.nextInt(1000);
						damageOncoming = damage.nextInt(10000);
						System.out.println("I am < " + modelName[0] + " , " + ownerName[0] + " > , collided with < " + modelName[2] + " , " + ownerName[2] + " > ");
						System.out.println("Damages self : " + damageSelf);
						System.out.println("Damages oncoming : " + damageOncoming);
						System.out.println("Sorry, you cannot do settlements.\n");
					}
					else if (vehicle[i].equals("Hercules") && vehicle[j].equals("Hero")) {
						count += 1;
						damageSelf = damage.nextInt(1000);
						damageOncoming = damage.nextInt(10000);
						System.out.println("I am < " + modelName[0] + " , " + ownerName[0] + " > , collided with < " + modelName[3] + " , " + ownerName[3] + " > ");
						System.out.println("Damages self : " + damageSelf);
						System.out.println("Damages oncoming : " + damageOncoming);
						System.out.println("Sorry, you cannot do settlements.\n");
					}
					else if (vehicle[i].equals("Hercules") && vehicle[j].equals("Maruti")) {
						count += 1;
						damageSelf = damage.nextInt(1000);
						damageOncoming = damage.nextInt(100000);
						System.out.println("I am < " + modelName[0] + " , " + ownerName[0] + " > , collided with < " + modelName[4] + " , " + ownerName[4] + " > ");
						System.out.println("Damages self : " + damageSelf);
						System.out.println("Damages oncoming : " + damageOncoming);
						System.out.println("Sorry, you cannot do settlements.\n");
					}
					else if (vehicle[i].equals("Hercules") && vehicle[j].equals("Honda")) {
						count += 1;
						damageSelf = damage.nextInt(1000);
						damageOncoming = damage.nextInt(100000);
						System.out.println("I am < " + modelName[0] + " , " + ownerName[0] + " > , collided with < " + modelName[5] + " , " + ownerName[5] + " > ");
						System.out.println("Damages self : " + damageSelf);
						System.out.println("Damages oncoming : " + damageOncoming);
						System.out.println("Sorry, you cannot do settlements.\n");
					}
					// bmx settlements
					else if (vehicle[i].equals("BMX") && vehicle[j].equals("Hercules")) {
						count += 1;
						damageSelf = damage.nextInt(1000);
						damageOncoming = damage.nextInt(1000);
						System.out.println("I am < " + modelName[1] + " , " + ownerName[1] + " > , collided with < " + modelName[0] + " , " + ownerName[0] + " > ");
						System.out.println("Damages self : " + damageSelf);
						System.out.println("Damages oncoming : " + damageOncoming);
						System.out.println("Sorry, you cannot do settlements.\n");
					}
					else if (vehicle[i].equals("BMX") && vehicle[j].equals("Bajaj")) {
						count += 1;
						damageSelf = damage.nextInt(1000);
						damageOncoming = damage.nextInt(10000);
						System.out.println("I am < " + modelName[1] + " , " + ownerName[1] + " > , collided with < " + modelName[2] + " , " + ownerName[2] + " > ");
						System.out.println("Damages self : " + damageSelf);
						System.out.println("Damages oncoming : " + damageOncoming);
						System.out.println("Sorry, you cannot do settlements.\n");
					}
					else if (vehicle[i].equals("BMX") && vehicle[j].equals("Hero")) {
						count += 1;
						damageSelf = damage.nextInt(1000);
						damageOncoming = damage.nextInt(10000);
						System.out.println("I am < " + modelName[1] + " , " + ownerName[1] + " > , collided with < " + modelName[3] + " , " + ownerName[3] + " > ");
						System.out.println("Damages self : " + damageSelf);
						System.out.println("Damages oncoming : " + damageOncoming);
						System.out.println("Sorry, you cannot do settlements.\n");
					}
					else if (vehicle[i].equals("BMX") && vehicle[j].equals("Maruti")) {
						count += 1;
						damageSelf = damage.nextInt(1000);
						damageOncoming = damage.nextInt(100000);
						System.out.println("I am < " + modelName[1] + " , " + ownerName[1] + " > , collided with < " + modelName[4] + " , " + ownerName[4] + " > ");
						System.out.println("Damages self : " + damageSelf);
						System.out.println("Damages oncoming : " + damageOncoming);
						System.out.println("Sorry, you cannot do settlements.\n");
					}
					else if (vehicle[i].equals("BMX") && vehicle[j].equals("Honda")) {
						count += 1;
						damageSelf = damage.nextInt(1000);
						damageOncoming = damage.nextInt(100000);
						System.out.println("I am < " + modelName[1] + " , " + ownerName[1] + " > , collided with < " + modelName[5] + " , " + ownerName[5] + " > ");
						System.out.println("Damages self : " + damageSelf);
						System.out.println("Damages oncoming : " + damageOncoming);
						System.out.println("Sorry, you cannot do settlements.\n");
					}
					// bajaj settlements
					else if (vehicle[i].equals("Bajaj") && vehicle[j].equals("Hercules")) {
						count += 1;
						damageSelf = damage.nextInt(10000);
						damageOncoming = damage.nextInt(1000);
						System.out.println("I am < " + modelName[2] + " , " + ownerName[2] + " > , collided with < " + modelName[0] + " , " + ownerName[0] + " > ");
						System.out.println("Damages self : " + damageSelf);
						System.out.println("Damages oncoming : " + damageOncoming);
						System.out.println("Settlement details : ");
						damageOncoming -= bike1.getPolicyOncomingRefund() * damageOncoming;
						System.out.println("	Damages oncoming updated : " + damageOncoming);
						System.out.println("	Damages self updated : " + damageSelf + "\n");
					}
					else if (vehicle[i].equals("Bajaj") && vehicle[j].equals("BMX")) {
						count += 1;
						damageSelf = damage.nextInt(10000);
						damageOncoming = damage.nextInt(1000);
						System.out.println("I am < " + modelName[2] + " , " + ownerName[2] + " > , collided with < " + modelName[1] + " , " + ownerName[1] + " > ");
						System.out.println("Damages self : " + damageSelf);
						System.out.println("Damages oncoming : " + damageOncoming);
						System.out.println("Settlement details : ");
						damageOncoming -= bike1.getPolicyOncomingRefund() * damageOncoming;
						System.out.println("	Damages oncoming updated : " + damageOncoming);
						System.out.println("	Damages self updated : " + damageSelf + "\n");
					}
					else if (vehicle[i].equals("Bajaj") && vehicle[j].equals("Hero")) {
						count += 1;
						damageSelf = damage.nextInt(10000);
						damageOncoming = damage.nextInt(10000);
						System.out.println("I am < " + modelName[2] + " , " + ownerName[2] + " > , collided with < " + modelName[3] + " , " + ownerName[3] + " > ");
						System.out.println("Damages self : " + damageSelf);
						System.out.println("Damages oncoming : " + damageOncoming);
						System.out.println("Settlement details : ");
						damageOncoming -= bike1.getPolicyOncomingRefund() * damageOncoming;
						System.out.println("	Damages oncoming updated : " + damageOncoming);
						System.out.println("	Damages self updated : " + damageSelf + "\n");
					}
					else if (vehicle[i].equals("Bajaj") && vehicle[j].equals("Maruti")) {
						count += 1;
						damageSelf = damage.nextInt(10000);
						damageOncoming = damage.nextInt(100000);
						System.out.println("I am < " + modelName[2] + " , " + ownerName[2] + " > , collided with < " + modelName[4] + " , " + ownerName[4] + " > ");
						System.out.println("Damages self : " + damageSelf);
						System.out.println("Damages oncoming : " + damageOncoming);
						System.out.println("Settlement details : ");
						damageOncoming -= bike1.getPolicyOncomingRefund() * damageOncoming;
						System.out.println("	Damages oncoming updated : " + damageOncoming);
						System.out.println("	Damages self updated : " + damageSelf + "\n");
					}
					else if (vehicle[i].equals("Bajaj") && vehicle[j].equals("Honda")) {
						count += 1;
						damageSelf = damage.nextInt(10000);
						damageOncoming = damage.nextInt(100000);
						System.out.println("I am < " + modelName[2] + " , " + ownerName[2] + " > , collided with < " + modelName[5] + " , " + ownerName[5] + " > ");
						System.out.println("Damages self : " + damageSelf);
						System.out.println("Damages oncoming : " + damageOncoming);
						System.out.println("Settlement details : ");
						damageOncoming -= bike1.getPolicyOncomingRefund() * damageOncoming;
						System.out.println("	Damages oncoming updated : " + damageOncoming);
						System.out.println("	Damages self updated : " + damageSelf + "\n");
					}
					// hero settlements
					else if (vehicle[i].equals("Hero") && vehicle[j].equals("Hercules")) {
						count += 1;
						damageSelf = damage.nextInt(10000);
						damageOncoming = damage.nextInt(1000);
						System.out.println("I am < " + modelName[3] + " , " + ownerName[3] + " > , collided with < " + modelName[0] + " , " + ownerName[0] + " > ");
						System.out.println("Damages self : " + damageSelf);
						System.out.println("Damages oncoming : " + damageOncoming);
						System.out.println("Sorry, your policy has been expired since " + policyExpiry[1] + " and hence cannot do settlements.\n");
					}
					else if (vehicle[i].equals("Hero") && vehicle[j].equals("BMX")) {
						count += 1;
						damageSelf = damage.nextInt(10000);
						damageOncoming = damage.nextInt(1000);
						System.out.println("I am < " + modelName[3] + " , " + ownerName[3] + " > , collided with < " + modelName[1] + " , " + ownerName[1] + " > ");
						System.out.println("Damages self : " + damageSelf);
						System.out.println("Damages oncoming : " + damageOncoming);
						System.out.println("Sorry, your policy has been expired since " + policyExpiry[1] + " and hence cannot do settlements.\n");
					}
					else if (vehicle[i].equals("Hero") && vehicle[j].equals("Bajaj")) {
						count += 1;
						damageSelf = damage.nextInt(10000);
						damageOncoming = damage.nextInt(10000);
						System.out.println("I am < " + modelName[3] + " , " + ownerName[3] + " > , collided with < " + modelName[2] + " , " + ownerName[2] + " > ");
						System.out.println("Damages self : " + damageSelf);
						System.out.println("Damages oncoming : " + damageOncoming);
						System.out.println("Sorry, your policy has been expired since " + policyExpiry[1] + " and hence cannot do settlements.\n");
					}
					else if (vehicle[i].equals("Hero") && vehicle[j].equals("Maruti")) {
						count += 1;
						damageSelf = damage.nextInt(10000);
						damageOncoming = damage.nextInt(100000);
						System.out.println("I am < " + modelName[3] + " , " + ownerName[3] + " > , collided with < " + modelName[4] + " , " + ownerName[4] + " > ");
						System.out.println("Damages self : " + damageSelf);
						System.out.println("Damages oncoming : " + damageOncoming);
						System.out.println("Sorry, your policy has been expired since " + policyExpiry[1] + " and hence cannot do settlements.\n");
					}
					else if (vehicle[i].equals("Hero") && vehicle[j].equals("Honda")) {
						count += 1;
						damageSelf = damage.nextInt(10000);
						damageOncoming = damage.nextInt(100000);
						System.out.println("I am < " + modelName[3] + " , " + ownerName[3] + " > , collided with < " + modelName[5] + " , " + ownerName[5] + " > ");
						System.out.println("Damages self : " + damageSelf);
						System.out.println("Damages oncoming : " + damageOncoming);
						System.out.println("Sorry, your policy has been expired since " + policyExpiry[1] + " and hence cannot do settlements.\n");
					}
					// maruti settlements
					else if (vehicle[i].equals("Maruti") && vehicle[j].equals("Hercules")) {
						count += 1;
						damageSelf = damage.nextInt(100000);
						damageOncoming = damage.nextInt(1000);
						System.out.println("I am < " + modelName[4] + " , " + ownerName[4] + " > , collided with < " + modelName[0] + " , " + ownerName[0] + " > ");
						System.out.println("Damages self : " + damageSelf);
						System.out.println("Damages oncoming : " + damageOncoming);
						System.out.println("Settlement details : ");
						damageOncoming -= car1.getPolicyOncomingRefund() * damageOncoming;
						damageSelf -= car1.getPolicySelfRefund() * damageSelf;
						System.out.println("	Damages oncoming updated : " + damageOncoming);
						System.out.println("	Damages self updated : " + damageSelf + "\n");
					}
					else if (vehicle[i].equals("Maruti") && vehicle[j].equals("BMX")) {
						count += 1;
						damageSelf = damage.nextInt(100000);
						damageOncoming = damage.nextInt(1000);
						System.out.println("I am < " + modelName[4] + " , " + ownerName[4] + " > , collided with < " + modelName[1] + " , " + ownerName[1] + " > ");
						System.out.println("Damages self : " + damageSelf);
						System.out.println("Damages oncoming : " + damageOncoming);
						System.out.println("Settlement details : ");
						damageOncoming -= car1.getPolicyOncomingRefund() * damageOncoming;
						damageSelf -= car1.getPolicySelfRefund() * damageSelf;
						System.out.println("	Damages oncoming updated : " + damageOncoming);
						System.out.println("	Damages self updated : " + damageSelf + "\n");
					}
					else if (vehicle[i].equals("Maruti") && vehicle[j].equals("Bajaj")) {
						count += 1;
						damageSelf = damage.nextInt(100000);
						damageOncoming = damage.nextInt(10000);
						System.out.println("I am < " + modelName[4] + " , " + ownerName[4] + " > , collided with < " + modelName[2] + " , " + ownerName[2] + " > ");
						System.out.println("Damages self : " + damageSelf);
						System.out.println("Damages oncoming : " + damageOncoming);
						System.out.println("Settlement details : ");
						damageOncoming -= bike1.getPolicyOncomingRefund() * damageOncoming;
						damageSelf -= car1.getPolicySelfRefund() * damageSelf;
						System.out.println("	Damages oncoming updated : " + damageOncoming);
						System.out.println("	Damages self updated : " + damageSelf + "\n");
					}
					else if (vehicle[i].equals("Maruti") && vehicle[j].equals("Hero")) {
						count += 1;
						damageSelf = damage.nextInt(100000);
						damageOncoming = damage.nextInt(100000);
						System.out.println("I am < " + modelName[4] + " , " + ownerName[4] + " > , collided with < " + modelName[3] + " , " + ownerName[3] + " > ");
						System.out.println("Damages self : " + damageSelf);
						System.out.println("Damages oncoming : " + damageOncoming);
						System.out.println("Settlement details : ");
						damageOncoming -= bike1.getPolicyOncomingRefund() * damageOncoming;
						damageSelf -= car1.getPolicySelfRefund() * damageSelf;
						System.out.println("	Damages oncoming updated : " + damageOncoming);
						System.out.println("	Damages self updated : " + damageSelf + "\n");
					}
					else if (vehicle[i].equals("Maruti") && vehicle[j].equals("Honda")) {
						count += 1;
						damageSelf = damage.nextInt(100000);
						damageOncoming = damage.nextInt(100000);
						System.out.println("I am < " + modelName[4] + " , " + ownerName[4] + " > , collided with < " + modelName[5] + " , " + ownerName[5] + " > ");
						System.out.println("Damages self : " + damageSelf);
						System.out.println("Damages oncoming : " + damageOncoming);
						System.out.println("Settlement details : ");
						damageOncoming -= bike1.getPolicyOncomingRefund() * damageOncoming;
						System.out.println("	Damages oncoming updated : " + damageOncoming);
						System.out.println("	Damages self updated : " + damageSelf + "\n");
					}
					// honda settlements
					else if (vehicle[i].equals("Honda") && vehicle[j].equals("Hercules")) {
						count += 1;
						damageSelf = damage.nextInt(100000);
						damageOncoming = damage.nextInt(1000);
						System.out.println("I am < " + modelName[5] + " , " + ownerName[5] + " > , collided with < " + modelName[0] + " , " + ownerName[0] + " > ");
						System.out.println("Damages self : " + damageSelf);
						System.out.println("Damages oncoming : " + damageOncoming);
						System.out.println("Sorry, your policy has been expired since " + policyExpiry[3] + " and hence cannot do settlements.\n");
					}
					else if (vehicle[i].equals("Honda") && vehicle[j].equals("BMX")) {
						count += 1;
						damageSelf = damage.nextInt(100000);
						damageOncoming = damage.nextInt(1000);
						System.out.println("I am < " + modelName[5] + " , " + ownerName[5] + " > , collided with < " + modelName[1] + " , " + ownerName[1] + " > ");
						System.out.println("Damages self : " + damageSelf);
						System.out.println("Damages oncoming : " + damageOncoming);
						System.out.println("Sorry, your policy has been expired since " + policyExpiry[3] + " and hence cannot do settlements.\n");
					}
					else if (vehicle[i].equals("Honda") && vehicle[j].equals("Bajaj")) {
						count += 1;
						damageSelf = damage.nextInt(100000);
						damageOncoming = damage.nextInt(10000);
						System.out.println("I am < " + modelName[5] + " , " + ownerName[5] + " > , collided with < " + modelName[2] + " , " + ownerName[2] + " > ");
						System.out.println("Damages self : " + damageSelf);
						System.out.println("Damages oncoming : " + damageOncoming);
						System.out.println("Sorry, your policy has been expired since " + policyExpiry[3] + " and hence cannot do settlements.\n");
					}
					else if (vehicle[i].equals("Honda") && vehicle[j].equals("Hero")) {
						count += 1;
						damageSelf = damage.nextInt(100000);
						damageOncoming = damage.nextInt(100000);
						System.out.println("I am < " + modelName[5] + " , " + ownerName[5] + " > , collided with < " + modelName[3] + " , " + ownerName[3] + " > ");
						System.out.println("Damages self : " + damageSelf);
						System.out.println("Damages oncoming : " + damageOncoming);
						System.out.println("Sorry, your policy has been expired since " + policyExpiry[3] + " and hence cannot do settlements.\n");
					}
					else if (vehicle[i].equals("Honda") && vehicle[j].equals("Maruti")) {
						count += 1;
						damageSelf = damage.nextInt(100000);
						damageOncoming = damage.nextInt(100000);
						System.out.println("I am < " + modelName[5] + " , " + ownerName[5] + " > , collided with < " + modelName[4] + " , " + ownerName[4] + " > ");
						System.out.println("Damages self : " + damageSelf);
						System.out.println("Damages oncoming : " + damageOncoming);
						System.out.println("Sorry, your policy has been expired since " + policyExpiry[3] + " and hence cannot do settlements.\n");
					}	
				}
			}
		}
	}
}