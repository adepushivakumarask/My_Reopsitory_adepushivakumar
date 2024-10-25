package casestydy;

public class matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[][]={{3,5,7},{6,6,8},{1,4,0}};    
		int b[][]={{8,0,9},{2,1,7},{9,4,3}};   
		
		int c[][]=new int[3][3];
		
		for(int i=0; i<3; i++){  
			
			 for(int j=0; j<3; j++){    
			   c[i][j]=0;      
		  for(int k=0; k<3; k++)      
		 {      
			c[i][j]+=a[i][k]*b[k][j];      
	     	}
			
			System.out.print(c[i][j]+" ");
			} 
			System.out.println();

		}

	}

}
