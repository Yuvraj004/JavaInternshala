import java.util.Scanner;
public class Main2 {
	public static void main(String[] args){
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter your name: ");
		String name;
		name= scanner.nextLine();
		System.out.println("Hey "+name+" , it's my birthday this weekend and you are invited to the party at my place. Bring gifts!!!");
		scanner.close();
	}


}

