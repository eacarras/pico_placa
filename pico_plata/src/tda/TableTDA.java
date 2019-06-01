package tda;

public class TableTDA {
		 
	private final String day;
    private final String digits;
 
    public TableTDA(String day, String digit) {
    	this.day = day;
        this.digits = digit;  
    }

	public String getDay() {
		return day;
	}

	public String getDigits() {
		return digits;
	}
}
