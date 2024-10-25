package casestydy;

import java.util.Scanner;

public class VowelCountInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		  System.out.println("Enter your string : ");
		  
      String input = sc.nextLine();
      
      int count = 0;
      
      for (int i=0; i<input.length(); i++) {
    	  
          char ch = input.charAt(i);
          
          input = input.toLowerCase();
          
          if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
          {
              count++;
          }
        
      }
      System.out.println(" vowels count is  : " + count );

	}

}
