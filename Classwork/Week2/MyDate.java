class MyDate {
	private int year, mon, day;
	public int getYear() {
		return year;
	}
	public void setYear(int y ) {
		year = y;
	}
	public static void main(String[] args) {
		MyDate d = new MyDate();
		d.year = 2025;
		d.setYear(2025);
		System.out.println(d.getYear());
	}
}