import java.util.Scanner;

public class TaxCalculator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Tax Calculator App");
		System.out.println("----- WELCOME -----");

		// Get total person count
		System.out.print("Enter total person count: ");
		int personCount = scanner.nextInt();

		// Create arrays to store names and incomes
		String[] names = new String[personCount];
		long[] incomes = new long[personCount];

		// Get all the person names along with their income
		for (int i = 0; i < personCount; i++) {
			System.out.print("\nEnter name " + (i+1) + ": ");
			names[i] = scanner.next();
			System.out.print("Enter " + names[i] + "'s Annual Income: ");
			incomes[i] = scanner.nextLong();
		}

		// Calculate tax for each person
		for (int i = 0; i < personCount; i++) {
			calculateTax(names[i], incomes[i]);
		}

		scanner.close();
	}

	public static void calculateTax(String name, long income) {
		double tax = 0;
		if (income >= 300000) {
			tax = income * 0.2;
		} else if (income >= 100000) {
			tax = income * 0.1;
		}

		System.out.println("\n" + name + " : Rs " + (long)tax + " tax");
		System.out.println("------------------------");
	}
}
