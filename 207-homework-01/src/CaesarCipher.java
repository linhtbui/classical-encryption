import java.util.Scanner;

public class CaesarCipher {
	/**
	 * @function: encodes input string by using the Caesar Cipher method 
	 * @param input : a string
	 * @param base : an integer
	 * @return: output, a string 
	 */

	public static String encode(String input, int base) {
		int charConst = (int) 'a';
		char data[] = input.toCharArray();
		int len = input.length() - 1;
		for (int i = 0; i <= len; i++) {
			char oldChar = input.charAt(i);
			int codedChar = ((int) oldChar + base - charConst) % 26;
			data[i] = (char) (codedChar + charConst);
		}
		return new String(data);
	}
	/**
	 * @function: decodes input string by using the Caesar Cipher method 
	 * @param input : a string
	 * @param base : an integer
	 * @return: output, a string 
	 */
	

	public static String decode(String input, int base) {
		int charConst = (int) 'a';
		char data[] = input.toCharArray();
		int len = input.length() - 1;
		for (int i = 0; i <= len; i++) {
			char oldChar = input.charAt(i);
			int codedChar = ((int) oldChar - base - charConst);
			if (codedChar < 0) {
				codedChar = (26 + codedChar) % 26;
			} else {
				codedChar = codedChar % 26;
			}
			data[i] = (char) (codedChar + charConst);
		}
		return new String(data);
	}
	/**
	 * Main function takes user input which can either be encode or decode and produces output string accordingly
	 */

	public static void main(String[] args) {

		System.out.println("This program encrypts and decrypts messages using the Caeser Cipher.");
		System.out.println("Would you like to encode or decode a message?");

		Scanner in = new Scanner(System.in);
		String response = in.nextLine();

		try {
			if (response.equals("encode")) {
				System.out.println("Enter the string to encode");
				String input = in.nextLine();
				for (int i = 0; i < 26; i++) {
					System.out.printf("n = %d: %s\n", i, encode(input, i));
				}
			} else if (response.equals("decode")) {
				System.out.println("Enter the string to decode");
				String input = in.nextLine();
				for (int i = 0; i < 26; i++) {
					System.out.printf("n = %d: %s\n", i, decode(input, i));
				}

			}
			else {
				System.out.println("Valid options are \"encode\" or \"decode\"");
			}
		} finally {
			in.close();
		}
	}
}
