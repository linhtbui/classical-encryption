import java.util.Scanner;

public class VigenereCipher {
	/**
	 * @function: encodes input string by using the Vigenere Cipher method 
	 * @param input : a string
	 * @param keyword : a string
	 * @return: output, a string 
	 */


	public static String encode(String input, String keyword) {
		int charConst = (int) 'a';
		char data[] = input.toCharArray();
		int lenData = input.length() - 1;
		int lenKey = keyword.length();
		for (int i =0; i <= lenData; i++) {
			char oldChar  = input.charAt(i);
			//repeat the keyword until the end of lenData
			char keyChar = keyword.charAt(i % lenKey);
			//turn the letter into values between 0 and 25
			int codedChar = ((int) oldChar + (int) keyChar  - charConst * 2) % 26;
			data[i] = (char) (codedChar + charConst);		
		}
		return new String(data);
	}

	/**
	 * @function: decodes input string by using the Vigenere Cipher method 
	 * @param input : a string
	 * @param keyword : a string
	 * @return: output, a string 
	 */

	public static String decode(String input, String keyword) {
		int charConst = (int) 'a';
		char data[] = input.toCharArray();
		int lenData = input.length() - 1;
		int lenKey = keyword.length();
		for (int i =0; i <= lenData; i++) {
			char oldChar  = input.charAt(i);
			//repeat the keyword until the end of lenData
			char keychar = keyword.charAt(i % lenKey);
			int codedChar = ((int) oldChar - (int) keychar);
			//turn the letter into values between 0 and 25
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

		System.out.println("This program encrypts and decrypts messages using the Vigenere Cipher");
		System.out.print("Would you like to encode or decode a message? ");

		Scanner in = new Scanner(System.in);
		String response = in.nextLine();

		//options to encode or decode
		if (response.equals("encode")) {

			System.out.print("Enter the string to encode: ");
			response = in.nextLine();

			System.out.print("Enter the key: ");
			String keyCode = in.nextLine();

			System.out.println(encode(response, keyCode));
		}
		else if (response.equals("decode")) {
			System.out.println("Enter the string to decode: ");
			response = in.nextLine();
			System.out.print("Enter the key: ");
			String keyCode = in.nextLine();

			System.out.println(decode(response, keyCode));
		}

		else {
			System.out.println("Valid options are \"encode\" or \"decode\"");
		}
		in.close();
	}
}	 