import java.io.InputStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

//		System.out.println("------------------------------------");
		Scanner scanner =new Scanner(System.in);
		String name;
		String bloodGroup;
		String colorGroup;
		int age;
		System.out.println("Enter your name: ");
		name= scanner.nextLine();
		System.out.println("Enter your age: ");
		age= scanner.nextInt();
		System.out.println("Enter your Blood Group: ");
		bloodGroup=scanner.next();
		//looping for deciding the color group
		if(age>=20) colorGroup="RED";
		else if (age>=15 && age<20) {
			colorGroup="BLUE";
		}
		else{
			colorGroup="YELLOW";
		}
		System.out.println("Following is the student ID card ");
		System.out.println("------------------------------------");
		System.out.println("Name: "+name);
		System.out.println("Age: "+age);
		System.out.println("Blood Group: "+bloodGroup);
		System.out.println("------------------------------------");
		System.out.println("Your group is "+colorGroup);
		System.out.println("------------------------------------");

	}
}