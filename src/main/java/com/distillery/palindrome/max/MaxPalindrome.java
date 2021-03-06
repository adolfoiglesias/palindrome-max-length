/**
 * 
 */
package com.distillery.palindrome.max;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author amich
 * Step to execute the program
 * 1- mvn package  
 * 2- java -jar <dir/jar-file>
 *  Ex: java -jar ./target/com.distillery.palindrome.max-1.jar
 *  
 */
public class MaxPalindrome {

	public static void main(String args[]) {
	
		  Scanner scanner = new Scanner(System.in);
		  System.out.println("Please enter a text or enter 1 to exit");
		  
		  while(scanner.hasNextLine()) {
			  
			  String text = scanner.nextLine(); 			  
			  if(text.equalsIgnoreCase("1")) {
				  scanner.close();
				  System.exit(0);
			  }
			  System.out.println("Result: " + findMaxPalindrome(text));
			  System.out.println("Enter the next text");
		  }
	}
	
	/**
	 * Find max palindrome given a text
	 * @param text
	 * @return
	 * Complex 
	 *     - O(n^2) - times
	 *     - O(1) -> space 
	 */
	public static String  findMaxPalindrome(String text) {
		
		
		if(text == null 
				|| !text.matches("([a-zA-Z]|\\s)+")) {
			return "there is no palindrome word";
		}
		
		if(text.length() == 1 || text.isEmpty())  {
			return text; 
		}
		
		
		List<String> listCharacters =    new ArrayList<String>(Arrays.asList(text.split(""))) ;
		
		StringBuffer buffer = new StringBuffer();
		
		String noPair = null;		
		int posPalindrome = -1;
		
		for (int i = 0; i < listCharacters.size(); i++) {
			
			boolean hasPair = false;			
			String objectI = listCharacters.get(i);
			
			for (int j = i+1 ; j < listCharacters.size(); j++) {
				
				String objectJ = listCharacters.get(j);
				
				if(objectI.equalsIgnoreCase(objectJ) ) {
					posPalindrome++;
					buffer.insert(posPalindrome, objectI);
					buffer.insert(posPalindrome+1, listCharacters.remove(j));
					hasPair = true;					
					break;
				}
			}
			
			if(!hasPair && noPair == null) {
				noPair = objectI;
			}
		}
		
		if(noPair != null) {
			buffer.insert(posPalindrome+1, noPair);
		}		 
		
		return buffer.toString();		
	}
	
	
}
