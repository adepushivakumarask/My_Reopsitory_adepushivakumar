package casestydy;

public class TransposeOfMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] matrix = {
	            {5,6,2},
	            {5,1,0},
	            {8,9,6}
	        };
		
	        int[][] transpose = transposeMatrix(matrix);
	        
	        System.out.println("Original matrix:");
	        
	        printMatrix(matrix);
	        
	        System.out.println("Transpose matrix:");
	        
	        printMatrix(transpose);
	    }

	    static int[][] transposeMatrix(int[][] matrix) {
	        
	    	int rows = matrix.length;
	        int cols = matrix[0].length;
	        
	        int[][] transpose = new int[cols][rows];

	        for (int i=0; i<rows; i++) {
	        	
	            for (int j=0; j<cols; j++) {
	            
	            	transpose[j][i] = matrix[i][j];
	            }
	        }

	        return transpose;
	    }

	    static void printMatrix(int[][] matrix) {
	    	
	        for (int i=0; i<matrix.length; i++) {
	        
	        	for (int j=0; j <matrix[0].length; j++) {
	            
	        		System.out.print(matrix[i][j] + " ");
	            }
	            
	        	System.out.println();
	        }

	}

}
