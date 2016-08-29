import java.util.*;
class VehiclePolicy {
	long policyNumber;
	date expiryDate;
	String classes;
<<<<<<< HEAD:Lab_2/InsurancePolicy.java
	static long count = 1000000L;
	static float policyCoverThirdParty;
	static float policyCoverSelf;
=======
	long count = 1000000L;
	float policyCoverThirdParty;
	float policyCoverSelf;
>>>>>>> a63751469bf370e08a546c1e38483a4c631d9102:Lab_2/InsurancePolicyModel.java
	public VehiclePolicy(int day, int month, int year, float tparty, float self) {
		policyNumber = getPolicyNew();
		policyCoverSelf = self;
		policyCoverThirdParty = tparty;
		expiryDate = new date(day,month,year);
		if(self == 0.0f)
			classes = "Third Party Policy";
		else
			classes = "Package Policy";
<<<<<<< HEAD:Lab_2/InsurancePolicy.java
	}
	public String getClasses() {
		return classes;
=======
>>>>>>> a63751469bf370e08a546c1e38483a4c631d9102:Lab_2/InsurancePolicyModel.java
	}
	public String getClasses() {
		return classes;
	}
	public float getThirdParty() {
		return policyCoverThirdParty;
	}
	public float getSelf() {
		return policyCoverSelf;
	}
	public long getPolicyNew() {
		count = count + 1;
		return count;
	}
	public long getPolicy() {
		return count;
	}
	public String getExpiryDate() {
		String exp = "";
		exp = Integer.toString(expiryDate.getDay()) + "-" + Integer.toString(expiryDate.getMonth()) + "-" + Integer.toString(expiryDate.getYear());
		return exp;
	}

}
class date {
	int d, m, y;
	public date(int day, int month, int year) {
		d = day;
		m = month;
		y = year;
	}
	public int getDay() {
		return d;
	}
	public int getMonth() {
		return m;
	}
	public int getYear() {
		return y;
	}
	/*public void setDay(int day) {
		d = day;
	}
	public void setMonth(int month) {
		m = month;
	}
	public void setYear(int year) {
		y = year;
	}*/
}
class ThirdPartyPolicy extends VehiclePolicy {
	public ThirdPartyPolicy(int day, int month, int year) {
		super(day,month,year,0.8f,0.0f);
	}
	
	
}
class PackagePolicy extends VehiclePolicy {
	public PackagePolicy(int day, int month, int year) {
		super(day,month,year,0.8f,0.5f);
	}
}