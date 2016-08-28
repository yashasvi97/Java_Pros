import java.util.*;
class vehicle_policy{
	long policy_no;
	date expiry_date;
	static long count = 1000000L;
	static float policy_cover_tp;
	static float policy_cover_self;
	public vehicle_policy(int day, int month, int year, float tparty, float self){
		policy_no = get_policy_new();
		policy_cover_self = self;
		policy_cover_tp = tparty;
		expiry_date = new date(day,month,year);
	}
	public static float get_tparty(){
		return policy_cover_tp;
	}
	public static float get_self(){
		return policy_cover_self;
	}
	public static long get_policy_new(){
		count = count + 1;
		return count;
	}
}
class date{
	int d,m,y;
	public date(int day, int month, int year){
		d = day;
		m = month;
		y = year;
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
class Third_party_policy extends vehicle_policy{
	public Third_party_policy(int day, int month, int year){
		super(day,month,year,0.8f,0.0f);
	}
}
class Package_policy extends vehicle_policy{
	public Package_policy(int day, int month, int year){
		super(day,month,year,0.8f,0.5f);
	}
}