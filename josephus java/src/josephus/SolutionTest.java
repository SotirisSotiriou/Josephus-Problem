package josephus;

import java.util.Scanner;

public class SolutionTest {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Number of soldiers(>0): ");
		int numOfSoldiers = keyboard.nextInt();
		if(numOfSoldiers <= 0) {
			do {
				System.out.println("Please type a valid number");
				System.out.print("Number of soldiers(>0): ");
				numOfSoldiers = keyboard.nextInt();
			} while(numOfSoldiers<=0);
		}
		
		System.out.print("Jump of kills(>0): ");
		int jump = keyboard.nextInt();
		if(jump <= 0) {
			do {
				System.out.println("Please type a valid number");
				System.out.print("Jump of kills(>0): ");
				jump = keyboard.nextInt();
			} while(jump <= 0);
		}
		
		System.out.printf("First killer(>=0 and <= %d: ", numOfSoldiers-1);
		int firstkiller = keyboard.nextInt();
		if(firstkiller < 0 || firstkiller >= numOfSoldiers) {
			do {
				System.out.println("Please type a valid number");
				System.out.printf("First killer(>=0 and <= %d: ", numOfSoldiers-1);
				firstkiller = keyboard.nextInt();
			} while(firstkiller < 0 || firstkiller >= numOfSoldiers);
		}
		
		keyboard.close();
		
		Problem p = new Problem(firstkiller, jump, numOfSoldiers);
		
		int solution = p.solve();
		System.out.println(solution);
	}

	
}
