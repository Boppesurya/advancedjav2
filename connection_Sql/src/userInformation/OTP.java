package userInformation;

import java.util.Random;

public class OTP {
public static void main(String[] args) {
	Random r = new Random();
	int otp = r.nextInt(100000);
	int temp =otp;
	int count =0;
	while(otp!=0) {
		otp/=10;
		++count;
	}
	otp=temp;
	if (count>4) {
		System.out.println("your otp :"+otp);
	}
	else {
		System.out.println("Not valied otp");
	}
}
}
