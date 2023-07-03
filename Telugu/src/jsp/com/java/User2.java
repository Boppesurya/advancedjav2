package jsp.com.java;

public class User2 {
	TeluguMatrimony teluguMatrimony;
	public User2(TeluguMatrimony teluguMatrimony) {
		this.teluguMatrimony = teluguMatrimony;
		}
	public static void main(String[] args) {
		User2 u = new User2(new Engineer());
		System.out.println(u.teluguMatrimony.name());
		System.out.println(u.teluguMatrimony.age());
		System.out.println(u.teluguMatrimony.stream());
	}

}
