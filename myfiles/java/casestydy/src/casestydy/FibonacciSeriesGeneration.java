package casestydy;

import java.util.Scanner;

public class FibonacciSeriesGeneration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter your number:");
		int n= sc.nextInt();
		 int a=0,b=1;
		 
		 if(n>=a) {
			 System.out.println(a);
		 }
		 if(n>=b) {
			 System.out.println(b);
		 }
		 while (true) {
		 int x=a+b;
		 
		 if(x>n) {
			 break;
			 
		 }
		 System.out.println(x);
		 a=b;
		 b=x;
		 
		}

	}

}
