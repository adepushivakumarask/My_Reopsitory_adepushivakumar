package casestydy;

public class StringCompression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String input = "aaabbcccc";
        System.out.println("Original string: " + input);
        System.out.println("Compressed string: " + compressString(input));
    }

    public static String compressString(String str) {
        if (str.isEmpty()) {
            return str;
        }

        StringBuilder compressed = new StringBuilder();
        char currentChar = str.charAt(0);
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == currentChar) {
                count++;
            } else {
                compressed.append(currentChar);
                compressed.append(count);
                currentChar = str.charAt(i);
                count = 1;

	}

}
        compressed.append(currentChar);
        compressed.append(count);

        return compressed.toString();
    }
}

