package casestydy;

public class FindMaximumElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] value = new int[] {12, 34, 56, 78, 90, 23, 45, 67};
		
		int maxvalue = value[0];
		
		for (int i=0; i<value.length; i++) {
		
			if (value[i]>maxvalue)
			
				maxvalue = value[i];
		}
		System.out.println("the maximum value is "+ maxvalue);

	}

}
