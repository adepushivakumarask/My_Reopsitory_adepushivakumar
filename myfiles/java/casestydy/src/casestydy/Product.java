package casestydy;



public class Product {

	private String name;
	private int quantity;
	private int threshold;
	
	public Product( String name, int quantity, int threshold) {
		this.name = name;
		this.quantity = quantity;
		this.threshold = threshold;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getThreshold() {
		return threshold;
	}

	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}
	
	@override
	public String toString() {
		return String.format("Product{ name=%s, quantity=%d, thresold=%d}",name, quantity, threshold);
	}
	



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
