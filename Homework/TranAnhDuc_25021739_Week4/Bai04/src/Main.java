interface IDate {
	void show();
}
class DataManager implements IDate {
	public void show() {
		System.out.println("Show Data");
	}
}
public class Main {
	public static void main(String[] args) {
		IDate data = new DataManager();
		data.show();
	}

}