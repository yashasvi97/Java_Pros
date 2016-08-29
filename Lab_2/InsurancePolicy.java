import java.util.*;
class VehiclePolicy {
	long policyNumber;
	date expiryDate;
	static long count = 1000000L;
	static float policyCoverThirdParty;
	static float policyCoverSelf;
	public VehiclePolicy(int day, int month, int year, float tparty, float self) {
		policyNumber = getPolicyNew();
		policyCoverSelf = self;
		policyCoverThirdParty = tparty;
		expiryDate = new date(day,month,year);
	}
	public static float getThirdParty() {
		return policyCoverThirdParty;
	}
	public static float getSelf() {
		return policyCoverSelf;
	}
	public static long getPolicyNew() {
		count = count + 1;
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
}
/*class expiry_date extends date{
	//receives the date entered as it is and then computes the expiry date as the next year
	public expiry_date(int day, int month, int year){
		int cday,cmonth,cyear;
		//c stands for 'changed'
		cyear = year + 1;
		if(year%4 == 1){
			if(day ==1){
				if(month == 1)
					cday = 31;
				else if(month == 3){
					cday = 28;
				}
				else if(month%2 == 0){
					cday = 31;
				}
				else if(month%2 != 0){
					cday = 30;
				}
				cmonth = month - 1;
			}
			else {

			}
		}
		else if(year%4 == 2){

		}
		else if(year%4 == 3){

		}
		else if(year%4 == 0){

		}
		super(cday,cmonth,cyear);
	}
}*/
class ThirdPartyPolicy extends VehiclePolicy {
	public ThirdPartyPolicy(int day, int month, int year) {
		super(day,month,year,0.8f,0.0f);
	}
	String classes = "Third Party Policy";
	public String getClasses() {
		return classes;
	}
}
class PackagePolicy extends VehiclePolicy {
	public PackagePolicy(int day, int month, int year) {
		super(day,month,year,0.8f,0.5f);
	}
	String classes = "Package Policy";
	public String getClasses() {
		return classes;
	}
}