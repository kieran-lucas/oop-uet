class MyDate {
	private int year, month, day;
	public int getYear() {
		return year;
	}
	public void setYear(int y ) {
		year = y;
	}
	public MyDate() {
		day = 1;
		month = 1;
		year = 2026;
		System.out.println("A new date created");
	}
	
}