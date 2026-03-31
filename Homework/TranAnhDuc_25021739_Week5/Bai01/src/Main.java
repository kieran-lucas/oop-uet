public class Main {
	public static String useString() {
		String s = "";
		for (int i = 0; i < 100000; i++) {
			s += "Hello";
			
		}
		return s;

	}
	public static StringBuffer useStringBuffer() {
		StringBuffer s = new StringBuffer();
		for (int i = 0; i < 100000; i++) {
			s.append("Hello");
			
		}
		return s;

	}
	public static String contentAnalysis(String s) {
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);  
        if (c == '.' || c == '?' || c == '!') {
            count++;
        }
    }

    String newS = s.replace("Java", "Python");

    return newS + "\nNumber of sentences: " + count;
}
	public static void main(String[] args) {
		long start1 = System.currentTimeMillis();
		useString();
		long end1 = System.currentTimeMillis();
		System.out.println("Thoi gian chay ham 1 la: " + (end1 - start1) + " ms");
		long start2 = System.currentTimeMillis();
		useStringBuffer();
		long end2 = System.currentTimeMillis();
		System.out.print("Thoi gian chay ham 2 la: " + (end2 - start2) + " ms\n");
		String s = "I like Java, I love Python, Java, Java, C++, Java.";
		System.out.println(s);
		System.out.println("Sau khi thay the: ");
		System.out.println(contentAnalysis(s));



	}
}