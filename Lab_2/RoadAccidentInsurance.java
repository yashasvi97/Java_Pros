import java.util.*;
import java.io.*;
public class RoadAccidentInsurance { 
	public static void main(String[] args) {
		// Scanner sc = new Scanner(System.in);
		String[] modelName = new String[6];
		String[] ownerName = new String[6];
		String[] policyExpiry = new String[4];
		String[] policyType = new String[4];
		int damageSelf, damageOncoming, count = 1;
		int[] option = new int[6];
		int[] wheels = new int[6];
		int[] vehicle = new int[6];
		float[] selfRefund = new float[4];
		float[] onComingRefund = new float[4];
		long[] policyNumber = new long[4];
		int[] day = new int[4];
		int[] month = new int[4];
		int[] year = new int[4];
		Random damage = new Random();
		// hercules data
		System.out.println("Entering Hercules cycle data...");
		Hercules cycle1 = new Hercules("Viraj", "Hercules Speedo");
		
		// bmx data
		System.out.println("Entering BMX cycle data...");
		BMX cycle2 = new BMX("Yashasvi", "BMX JUMP");
		
		// bajaj data
		System.out.println("Entering Bajaj bike data...");
		day[0] = 2;
		month[0] = 11;
		year[0] = 2018;
		Bajaj bike1 = new Bajaj("Parimi", "Bajaj 250CC", 1, day[0], month[0], year[0]);
		
		// Hero data
		System.out.println("Entering Hero bike data...");
		day[1] = 12;
		month[1] = 8;
		year[1] = 2010;
		Hero bike2 = new Hero("Baweja", "Hero 270CC", 1, day[1], month[1], year[1]);
		
		// maruti data
		System.out.println("Entering Maruti car data...");
		day[2] = 24;
		month[2] = 4;
		year[2] = 2020;
		Maruti car1 = new Maruti("Mrinal", "Maruti 800", 2, day[2], month[2], year[2]);	
		
		// honda data
		System.out.println("Entering Honda car data...");
		day[3] = 17;
		month[3] = 12;
		year[3] = 2010;
		Honda car2 = new Honda("Abrol", "Honda City", 2, day[3], month[3], year[3]);
		

		System.out.println("\n" + "      Now all objects have been initialised, fetching data" + "\n");
		System.out.println("------------------------------------------------------------------------");
		//retreiving data in array
		modelName[0] = cycle1.getModel();
		ownerName[0] = cycle1.getOwnerName();
		wheels[0] = cycle1.getWheels();
		vehicle[0] = cycle1.getId();
		option[0] = cycle1.getInsured();
		System.out.println("Model Number: " + vehicle[0] + " | Model: " + modelName[0] + " | Owner: " + ownerName[0] + " | Wheels: " + wheels[0] );
		System.out.println("------------------------------------------------------------------------");
		modelName[1] = cycle2.getModel();
		ownerName[1] = cycle2.getOwnerName();
		wheels[1] = cycle2.getWheels();
		vehicle[1] = cycle2.getId();
		option[1] = cycle2.getInsured();
		System.out.println("Model Number: " + vehicle[1] + " | Model: " + modelName[1] + " | Owner: " + ownerName[1] + " | Wheels: " + wheels[1] );
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		modelName[2] = bike1.getModel();
		ownerName[2] = bike1.getOwnerName();
		wheels[2] = bike1.getWheels();
		vehicle[2] = bike1.getId();
		option[2] = bike1.getInsured();
		policyNumber[0] = bike1.getPolicyNumber();
		policyType[0] = bike1.getPolicyClass();
		policyExpiry[0] = bike1.getPolicyExpiry();
		selfRefund[0] = bike1.getPolicySelfRefund();
		onComingRefund[0] = bike1.getPolicyOncomingRefund();
		System.out.println("Model Number: " + vehicle[2] + " | Model: " + modelName[2] + " | Owner: " + ownerName[2] + " | Wheels: " + wheels[2] + " | Policy Type: " + policyType[0] + " | Policy Expiry: " + policyExpiry[0]);
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		modelName[3] = bike2.getModel();
		ownerName[3] = bike2.getOwnerName();
		wheels[3] = bike2.getWheels();
		vehicle[3] = bike2.getId();
		option[3] = bike2.getInsured();
		policyNumber[1] = bike2.getPolicyNumber();
		policyType[1] = bike2.getPolicyClass();
		policyExpiry[1] = bike2.getPolicyExpiry();
		selfRefund[1] = bike2.getPolicySelfRefund();
		onComingRefund[1] = bike2.getPolicyOncomingRefund();
		System.out.println("Model Number: " + vehicle[3] + " | Model: " + modelName[3] + " | Owner: " + ownerName[3] + " | Wheels: " + wheels[3] + " | Policy Type: " + policyType[1] + " | Policy Expiry: " + policyExpiry[1]);
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		modelName[4] = car1.getModel();
		ownerName[4] = car1.getOwnerName();
		wheels[4] = car1.getWheels();
		vehicle[4] = car1.getId();
		option[4] = car1.getInsured();
		policyNumber[2] = car1.getPolicyNumber();
		policyType[2] = car1.getPolicyClass();
		policyExpiry[2] = car1.getPolicyExpiry();
		selfRefund[2] = car1.getPolicySelfRefund();
		onComingRefund[2] = car1.getPolicyOncomingRefund();
		System.out.println("Model Number: " + vehicle[4] + " | Model: " + modelName[4] + " | Owner: " + ownerName[4] + " | Wheels: " + wheels[4] + " | Policy Type: " + policyType[2] + " | Policy Expiry: " + policyExpiry[2]);
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		modelName[5] = car2.getModel();
		ownerName[5] = car2.getOwnerName();
		wheels[5] = car2.getWheels();
		vehicle[5] = car2.getId();
		option[5] = car2.getInsured();
		policyNumber[3] = car2.getPolicyNumber();
		policyType[3] = car2.getPolicyClass();
		policyExpiry[3] = car2.getPolicyExpiry();
		selfRefund[3] = car2.getPolicySelfRefund();
		onComingRefund[3] = car2.getPolicyOncomingRefund();
		System.out.println("Model Number: " + vehicle[5] + " | Model: " + modelName[5] + " | Owner: " + ownerName[5] + " | Wheels: " + wheels[5] + " ; Policy Type: " + policyType[3] + " | Policy Expiry: " + policyExpiry[3]);
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("\n\n"+"      <!-------COLLISION LOOP IS STARTING-------!>"+"\n\n");
		for(int i = 0; i<6; i++){
			for(int j = 0; j < 6; j++){
				if(vehicle[i] != vehicle[j]){
					System.out.println("\n" + "   <!-------------COLLISION " + count + " PROCEEDING---------------!>" + "\n");
					if(option[i] == 1){
						String str;
						str = policyExpiry[i-2].substring(policyExpiry[i-2].lastIndexOf('-') + 1);
						int YEAR = Integer.parseInt(str);
						if(YEAR < 2016){
							damageSelf = damage.nextInt(10000);
							if(wheels[j]==2 && option[j]==0)
								damageOncoming = damage.nextInt(1000);
							else if(wheels[j]==2 && option[j]!=0)
								damageOncoming = damage.nextInt(10000);
							else if(wheels[j] == 4)
								damageOncoming = damage.nextInt(100000);
							else //if any left out case take average case
								damageOncoming = damage.nextInt(10000);
							System.out.println("	I am < " + modelName[i] + " , " + ownerName[i] + " > , collided with < " + modelName[j] + " , " + ownerName[j] + " > ");
							System.out.println("	Damages self : Rs. " + damageSelf);
							System.out.println("	Damages oncoming : Rs. " + damageOncoming);
							System.out.println("	Settlement details : ");
							// System.out.println("	Policy Number : " + policyNumber[i-2]);
							System.out.println("	Policy Type : " + policyType[i-2]);
							System.out.println("	Sorry, your policy has been expired since " + policyExpiry[i-2] + " and hence cannot do settlements.\n");
						}
						else{
							damageSelf = damage.nextInt(10000);
							if(wheels[j]==2 && option[j]==0)
								damageOncoming = damage.nextInt(1000);
							else if(wheels[j]==2 && option[j]!=0)
								damageOncoming = damage.nextInt(10000);
							else if(wheels[j] == 4)
								damageOncoming = damage.nextInt(100000);
							else //if any left out case take average case
								damageOncoming = damage.nextInt(10000);
							System.out.println("	I am < " + modelName[i] + " , " + ownerName[i] + " > , collided with < " + modelName[j] + " , " + ownerName[j] + " > ");
							System.out.println("	Damages self : " + damageSelf);
							System.out.println("	Damages oncoming : Rs. " + damageOncoming);
							System.out.println("	Settlement details : Rs. ");
							// System.out.println("	Policy Number : " + policyNumber[i-2]);
							System.out.println("	Policy Type : " + policyType[i-2]);
							damageOncoming -= onComingRefund[i-2] * damageOncoming;
							damageSelf -= selfRefund[i-2] * damageSelf;
							System.out.println("	Damages self updated : Rs. " + damageSelf );
							System.out.println("	Damages oncoming updated : Rs. " + damageOncoming + "\n");
						}
					}
					else if (option[i] == 2) {
						String str;
						str = policyExpiry[i-2].substring(policyExpiry[i-2].lastIndexOf('-') + 1);
						int YEAR = Integer.parseInt(str);
						if(YEAR < 2016){
							damageSelf = damage.nextInt(100000);
							if(wheels[j]==2 && option[j]==0)
								damageOncoming = damage.nextInt(1000);
							else if(wheels[j]==2 && option[j]!=0)
								damageOncoming = damage.nextInt(10000);
							else if(wheels[j] == 4)
								damageOncoming = damage.nextInt(100000);
							else //if any left out case take average case
								damageOncoming = damage.nextInt(10000);
							System.out.println("	I am < " + modelName[i] + " , " + ownerName[i] + " > , collided with < " + modelName[j] + " , " + ownerName[j] + " > ");
							System.out.println("	Damages self : Rs. " + damageSelf);
							System.out.println("	Damages oncoming : Rs. " + damageOncoming);
							System.out.println("	Settlement details : ");
							// System.out.println("	Policy Number : " + policyNumber[i-2]);
							System.out.println("	Policy Type : " + policyType[i-2]);
							System.out.println("	Sorry, your policy has been expired since " + policyExpiry[i-2] + " and hence cannot do settlements.\n");
						}
						else{
							damageSelf = damage.nextInt(100000);
							if(wheels[j]==2 && option[j]==0)
								damageOncoming = damage.nextInt(1000);
							else if(wheels[j]==2 && option[j]!=0)
								damageOncoming = damage.nextInt(10000);
							else if(wheels[j] == 4)
								damageOncoming = damage.nextInt(100000);
							else //if any left out case take average case
								damageOncoming = damage.nextInt(10000);
							System.out.println("	I am < " + modelName[i] + " , " + ownerName[i] + " > , collided with < " + modelName[j] + " , " + ownerName[j] + " > ");
							System.out.println("	Damages self : Rs. " + damageSelf);
							System.out.println("	Damages oncoming : Rs. " + damageOncoming);
							System.out.println("	Settlement details : ");
							// System.out.println("	Policy Number : " + policyNumber[i-2]);
							System.out.println("	Policy Type : " + policyType[i-2]);
							damageOncoming -= onComingRefund[i-2] * damageOncoming;
							damageSelf -= selfRefund[i-2] * damageSelf;
							System.out.println("	Damages self updated : Rs. " + damageSelf);
							System.out.println("	Damages oncoming updated : Rs. " + damageOncoming + "\n");
						}
					}
					else{
						damageSelf = damage.nextInt(1000);
						if(wheels[j]==2 && option[j]==0)
							damageOncoming = damage.nextInt(1000);
						else if(wheels[j]==2 && option[j]!=0)
							damageOncoming = damage.nextInt(10000);
						else if(wheels[j] == 4)
							damageOncoming = damage.nextInt(100000);
						else //if any left out case take average case
								damageOncoming = damage.nextInt(10000);
						System.out.println("	I am < " + modelName[i] + " , " + ownerName[i] + " > , collided with < " + modelName[j] + " , " + ownerName[j] + " > ");
						System.out.println("	Damages self : Rs. " + damageSelf);
						System.out.println("	Damages oncoming : Rs. " + damageOncoming);
						System.out.println("	Sorry, you cannot do settlements because policy doesnt exist!\n");
					}
					count = count + 1;
				}
			}
		}
	}
}