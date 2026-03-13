package caesarCipher;

import java.util.*;

public class CaesarCipherMethods {

	public static void main(String[] args) {
		//get user input to know which method
		System.out.println("Hello! Welcome to my Caesar cipher program!");
		System.out.println("Before we begin, please know that only capital letters will be encrypted/decrypted.");
		System.out.println("All lowercase letters and numbers will remian as they are.");
		System.out.println("Would you like to encrypt a message (ENCRYPT) or to decrypt a message (DECRYPT)?");
		
		Scanner scan1 = new Scanner(System.in);
		String choice = scan1.nextLine(); //obtain the user choice

		try
		{
			if (choice.isBlank() == true)
			{
				throw new IllegalArgumentException();
			}
			
			if (choice.compareTo("ENCRYPT") != 0 && choice.compareTo("DECRYPT") != 0)
			{
				throw new IllegalArgumentException();
			}
		}
		
		catch (Exception e)
		{
			System.out.println("You have to enter one of the two choices!");
		}
		
		if (choice.compareTo("ENCRYPT") == 0) 
		{
			//run the makeCipher program
			System.out.println(encrypt());	
		}
		
		if (choice.compareTo("DECRYPT") == 0)
		{
			//run the decipher program
			System.out.println(decrypt());
		}	
	}
	
	//take input string and decodes it
	public static String decrypt() {
		
		//ask the user for a string
		Scanner scan2 = new Scanner(System.in);
		
		System.out.println("Enter a phrase to be deciphered: ");
		String cipher = scan2.nextLine(); //read the user input
		
		System.out.println("Enter the number of shifts the cipher has: ");
		int shift = scan2.nextInt(); // read the number of shifts needed
		
		scan2.close(); //close the scanner
		
		String decryptStr = "";
		int newInt = 0;
		
		for (int i = 0; i < cipher.length(); i++)
		{
			if (cipher.charAt(i) >= 65 && cipher.charAt(i) <= 90) //only change capital letters
			{
				int oldInt = (int) cipher.charAt(i);
				newInt = ((oldInt - 65) - shift) % 26;
				
				if (newInt < 0) //if the newInt is less than 0
				{
					newInt = newInt + 26; 
				}
				
				newInt = newInt + 65;
				decryptStr = decryptStr + (char) newInt;
			}
			
			else
			{
				decryptStr = decryptStr + cipher.charAt(i);
			}
		}
		
		return decryptStr;
		
	}
	
	public static String encrypt() {
		Scanner scan3 = new Scanner(System.in);

		System.out.println("Enter the phrase that you wish to encode: ");
		String phrase = scan3.nextLine();
		
		System.out.println("Enter the number of shifts you want your cipher to have: ");	
		int shift = scan3.nextInt();
		
		scan3.close(); //close the scanner
		
		String encryptStr = "";
		int sum = 0;
		
		for (int i = 0; i < phrase.length(); i++)
		{
			if (phrase.charAt(i) >= 65 && phrase.charAt(i) <= 90) //only change the capital letters
			{
				sum = (int) phrase.charAt(i);
				sum = ((sum - 65) + shift) % 26;
				
				if (sum > 26) //if the sum is greater than 26
				{
					sum = sum - 26;
				}
				
				sum = sum + 65;
				encryptStr = encryptStr + (char) sum;
			}
			
			else
			{
				encryptStr = encryptStr + phrase.charAt(i);
			}
		}
				
		return encryptStr;
	}
}

