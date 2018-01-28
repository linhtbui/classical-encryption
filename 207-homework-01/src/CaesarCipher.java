import java.util.Scanner;

public class CaesarCipher {

	public static String encode(String input, int base) {
		int charConst = (int) 'a';
		char data[] = input.toCharArray();
		int len = input.length() - 1;
		for (int i = 0; i <= len; i++) {
			char oldchar = input.charAt(i);
			int codedchar = ((int) oldchar + base - charConst) % 26;
			char newchar = (char) (codedchar + charConst);
			data[i] = newchar;
		}
		return new String(data);
	}

	public static String decode(String input, int base) {
		int charConst = (int) 'a';
		char data[] = input.toCharArray();
		int len = input.length() - 1;
		for (int i = 0; i <= len; i++) {
			char oldchar = input.charAt(i);
			int codedchar = ((int) oldchar - base - charConst);
			if (codedchar < 0) {
				codedchar = (26 + codedchar) % 26;
			} else {
				codedchar = codedchar % 26;
			}
			char newchar = (char) (codedchar + charConst);
			data[i] = newchar;
		}
		return new String(data);
	}

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
