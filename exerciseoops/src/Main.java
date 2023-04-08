import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Reactangle rec =new Reactangle();
		Scanner scan =new Scanner(System.in);
		System.out.println("Ennter the breadth: ");
		float breadth = scan.nextFloat();
		System.out.println("enter the length");
		float  len  = scan.nextFloat();
		rec.setBreadth(breadth);
		rec.setLength(len);
		System.out.println(rec.area());
//		System.out.println("Hello world!");
	}
}