package tda;

public class UserCar {
	
	private String license;
	private String day_of_the_week;
	private String hour;
	
	private int last_digit;
	private String[] hours;
	
	public UserCar(String license, String day_of_the_week, String hour) {
		this.license = license;
		this.day_of_the_week = day_of_the_week;
		this.hour = hour;
		
		hours = this.hour.split(":");
		getLastDigit();
	}
	
	public boolean can_drive() {
		if(Integer.parseInt(hours[0]) < 7 || ((Integer.parseInt(hours[0]) > 9 
			)) && Integer.parseInt(hours[0]) < 16) return true;
		else if((Integer.parseInt(hours[0]) == 19 && Integer.parseInt(hours[1]) > 30) || 
				Integer.parseInt(hours[0]) > 19) return true;
		
		if(day_of_the_week.toLowerCase().equals("saturday")  || day_of_the_week.toLowerCase().equals("sunday")) return true;
		
		if((last_digit == 1 || last_digit == 2) && day_of_the_week.toLowerCase().equals("monday")) return false;
		else if((last_digit == 3 || last_digit == 4) && day_of_the_week.toLowerCase().equals("tuesday")) return false;
		else if((last_digit == 5 || last_digit == 6) && day_of_the_week.toLowerCase().equals("wednesday")) return false;
		else if((last_digit == 7 || last_digit == 8) && day_of_the_week.toLowerCase().equals("thursday")) return false;
		else return false;
	}
	
	private int getLastDigit() {
		this.last_digit = license.charAt(license.length() - 1);
		return last_digit;
	}
}
