package casestydy;

import java.util.Scanner;

public class GradeEvaluationSystem {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int marks[] = new int[5];
		
		for (int i = 0; i<5; i++) {
		System.out.println(" Subject" + ( i + 1) + " " + ": ");
		marks[i] = sc.nextInt();
		}
		
		int sum = 0;
		for (int mark : marks) {
			sum += mark;
		}
		
		double average = (double) sum / marks.length;
		
		if (average > 90) {
			System.out.println("Grade: A");
		}
		else if (average >= 80) {
            System.out.println("Grade: B");
        }
		else if (average >= 70) {
            System.out.println("Grade: C");
        }
		else if (average >= 60) {
            System.out.println("Grade: D");
        }
		else {
            System.out.println("Grade: F");
        }
		
			System.out.println("Average Marks : " + average);
		
	}

}
