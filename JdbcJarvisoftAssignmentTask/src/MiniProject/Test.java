package MiniProject;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		do {
			Scanner scanner = new Scanner(System.in);
			Methods methods = new MethodsImplementations();
			System.out.println("1. insert");
			System.out.println("2. modify");
			System.out.println("3. delete");
			System.out.println("4. search");
			System.out.println("5. viewAll");
			System.out.println("6. exit");

			System.out.println("select one option from above");
			int selection = scanner.nextInt();
			switch (selection) {
			case 1:
				methods.insert();

				break;

			case 2:
				methods.modify();

				break;
			case 3:
				methods.delete();

				break;
			case 4:
				methods.search();

				break;
			case 5:
				methods.viewAll();

			case 6:
				methods.exit();

				break;

			default:
				System.out.println("enter valid option");
				break;
			}

		} while (true);
	}
}