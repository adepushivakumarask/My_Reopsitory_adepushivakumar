package casestydy;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 int[] array = {9, 8, 7, 6, 4, 3, 0};
	        int target = 2;
	        int position = binarySearch(array, target);
	        if (position != -1) {
	            System.out.println("position of searched element in the array is " + position);
	        } else {
	            System.out.println("searched elemen not found in the array");
	        }
	    }

	    static int binarySearch(int[] array, int target) {
	        int low = 0;
	        int high = array.length - 1;

	        while (low <= high) {
	            int mid = (low + high) / 2;
	            if (array[mid] == target) {
	                return mid;
	            } else if (array[mid] < target) {
	                low = mid + 1;
	            } else {
	                high = mid - 1;
	            }
	        }

	        return -1;

	}

}
