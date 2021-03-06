package com.revature.eval.java.core;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {

		// create a new array with the length equal to the string
		char[] b = new char[string.length()];

		// we'll define a new variable 'r' and set equal to the string length -
		// 1(subtract 1 because
		// index starts at 0, so if a string has 5 indices, it would be 0,1,2,3,4)
		// r is important because it will be used to count backwards in a for loop. In
		// our for-loop
		// as we count upwards, we'll set the index of our newly created array 'b' equal
		// to the position of r
		// and retrieve the actual character letter using the charAt() method

		// as each index 'i' obtains the character letter at 'r', we have 'r' count down
		// until
		// 'r' is zero (which also means 'i' is no longer less than the string.length().
		// This signifies the end of the for loop.
		int r = (string.length() - 1);
		for (int i = 0; i < string.length(); i++) {
			b[i] = string.charAt(r);
			r--;
		}

		// Now that we've used the for loop to reverse the string/array letters, we'll
		// need to
		// instantiate a new string, which we'll call 'c'. We will give String c the
		// parameter of 'b'
		// which means we're giving String 'c' the reversed order we created above.
		String c = new String(b);

		// return 'c'
		return c;
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {

		// instantiate a new string array with the length of the phrase
		String[] strArr = phrase.split(" |-");
		char[] result = new char[strArr.length];

		for (int i = 0; i < strArr.length; i++) {
			result[i] = strArr[i].charAt(0);

		}

		String acronym = String.valueOf(result);
		acronym = acronym.toUpperCase();
		System.out.println(acronym);

		return acronym;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			if (sideOne == sideTwo && sideOne == sideThree) {
				return true;
			}
			return false;

		}

		public boolean isIsosceles() {
			if (isEquilateral() == true) {
				return true;
			} else if (sideOne == sideTwo && sideOne != sideThree) {
				return true;
			} else if (sideTwo == sideThree && sideTwo != sideOne) {
				return true;
			} else {
				return false;
			}
		}

		public boolean isScalene() {
			if (isIsosceles() != true && isEquilateral() != true) {
				return true;
			} else {
				return false;
			}
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		char[] onePt = { 'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T' };
		char[] twoPt = { 'D', 'G' };
		char[] threePt = { 'B', 'C', 'M', 'P' };
		char[] fourPt = { 'F', 'H', 'V', 'W', 'Y' };
		char[] fivePt = { 'K' };
		char[] eightPt = { 'J', 'X' };
		char[] tenPt = { 'Q', 'Z' };

		int score = 0;
		string = string.toUpperCase();

		// for-loop to test letters in each array
		// this for-loop is not to pass through a particular array
		for (int i = 0; i < string.length(); i++) {

			for (int x = 0; x < onePt.length; x++) {
				if (string.charAt(i) == onePt[x]) {
					score++;
				}

			}
			
			for (int x = 0; x < twoPt.length; x++) {
				if(string.charAt(i) == twoPt[x]) {
					score +=2;
				}
			}
			
			for (int x = 0; x < threePt.length; x++) {
				if(string.charAt(i) == threePt[x]) {
					score +=3;
				}
			}
			
			for (int x = 0; x < fourPt.length; x++) {
				if(string.charAt(i) == fourPt[x]) {
					score +=4;
				}
			}
			
			for (int x = 0; x < fivePt.length; x++) {
				if(string.charAt(i) == fivePt[x]) {
					score +=5;
				}
			}
			
			for (int x = 0; x < eightPt.length; x++) {
				if(string.charAt(i) == eightPt[x]) {
					score +=8;
				}
			}
			
			for (int x = 0; x < tenPt.length; x++) {
				if(string.charAt(i) == tenPt[x]) {
					score +=10;
				}
			}
		}

		return score;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		
		StringBuilder arr = new StringBuilder();
		
		
		for(int i = 0; i < string.length(); i++) {
			if(Character.isDigit(string.charAt(i))) {
				arr.append(string.charAt(i));
			}
			}
		if(arr.charAt(0) =='1') {
			arr = arr.delete(0, 1);
		}
		String num = arr.toString();
		return num;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	
		public Map<String, Integer> wordCount(String string) {
			String[] arr;
			if (string.contains("\n")) {
				arr = string.split(",\\n");
			} else if (string.contains(",")) {
				arr = string.split(",");
			} else {
				arr = string.split(" ");
			}
			Map<String, Integer> map = new HashMap<>();
			for (int i = 0; i < arr.length; i++) {
				Integer count = map.get(arr[i]);
				if (count == null) {
					map.put(arr[i], 1);
				} else {
					map.put(arr[i], ++count);
				}
			}
			return map;
		}		
		
		
		
		
		
		//return null;
	

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			// TODO Write an implementation for this method declaration
			return 0;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}
	}

	

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		
		String [] str = string.split(" ");
		
		for(int i = 0; i < str.length; i++) {
			StringBuilder strb = new StringBuilder(str[i]);
			while(strb.charAt(0) != 'a' && strb.charAt(0) != 'e' && strb.charAt(0) != 'i'
					&& strb.charAt(0) != 'o' && strb.charAt(0) != 'u') {
				if(strb.charAt(0) == 'q') {
					strb.append("qu");
					strb.delete(0, 2);
				}
				else {
					strb.append(strb.charAt(0));
					strb.deleteCharAt(0);
				}
				
			}
			strb.append("ay");
			str[i] = strb.toString();
		}
		
		
		StringBuilder newArr = new StringBuilder(str[0]);
		
		for(int i = 1; i < str.length; i++) {
			newArr.append(" ");
			newArr.append(str[i]);
		}
		String translation = new String(newArr);
		System.out.println(translation);
		return translation;
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9. 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		//need a method that separates each digit before we can multiply
		//each integer by the total number of integers
		
		//separate the digits, multiply each digit individually to the power of
		//the total number of digits, and determine whether or not the sum of those
		//calculations is equal to the actual number
		
		//convert input to a string
		//
		
		String num = String.valueOf(input);
		
		int value = 0;
		for(int i = 0; i < num.length(); i++) {
			value += Math.pow(Character.getNumericValue(num.charAt(i)),num.length());
		}
		
		if(value == input) {
			return true;
		}else {
			return false;
		}
		
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		List<Long> arr = new ArrayList<Long>();
		
		while(l % 2 == 0) {
			l /= 2;
			arr.add(2L);
		}
		
		for(long i = 3L; i <= Math.sqrt(l); i+=2L) {
			while (l % i == 0) {
				arr.add(i);
				l /= i;
			}
			
		}
		
		if(l > 1) {
			arr.add(l);
		}
		
		
		return arr;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			StringBuilder letter = new StringBuilder();
			
			for(int i = 0; i < string.length(); i++) {
				char c = string.charAt(i);
				int n = c;
				if(n >= 65 &&n <= 90) {
					n += key;
					if(n > 90) {
						n-=26;
					}
				}else if(n >= 97 && n <= 122) {
					n  += key;
					if(n > 122) {
						n -= 26;
					}
				}
				c = (char) n;
				
				letter.append(c);
				
				
			}
			
			String answer = new String(letter);
			
			
			return answer;
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		//first calculate whether or not a number is prime
		//once a number has been deemed prime, determine
		//what prime number it is
		List<Integer> nthPrime = new ArrayList<Integer>();
		
		for(int j = 2; nthPrime.size() < i; j++) {
			int c = 0;
			for(int y = 2; y < j; y++) {
				if(j % y ==0) {
					c++;
				}
			}
			if(c == 0) {
				nthPrime.add(j);
			}
		}

		return nthPrime.get(i-1);
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			string = string.toLowerCase();
			StringBuilder atb = new StringBuilder();
			
			String ciph = "zyxwvutsrqponmlkjihgfedcba";
			String abc = "abcdefghijklmnopqrstuvwxyz";
			
			for(int i = 0; i < string.length(); i++) {
				if(Character.isAlphabetic(string.charAt(i))) {
					atb.append(ciph.charAt(abc.indexOf(string.charAt(i))));
				} else if(Character.isDigit(string.charAt(i))) {
					atb.append(string.charAt(i));
				}
			}
			
			for(int j= 5; j <atb.length(); j+= 6) {
				atb.insert(j, " ");
			}
			
			String enc = atb.toString();
			return enc;
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			StringBuilder sb = new StringBuilder();
			
			String abcd = "abcdefghijklmnopqrstuvwxyz";
			String zyxw = "zyxwvutsrqponmlkjihgfedcba";
			
			for (int i = 0; i < string.length(); i++) {
				if (Character.isWhitespace(string.charAt(i)) == false) {
					int ch = zyxw.indexOf(string.charAt(i));
					if (ch != -1) {
						sb.append(abcd.charAt(ch));
					} else if (Character.isDigit(string.charAt(i))) {
						sb.append(string.charAt(i));
					}
				}
			}
			String decode = new String(sb);
			return decode;
			}
		}
			
		
	

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {

		boolean valid = false;
		
		StringBuilder sb = new StringBuilder(string);
		
		while (sb.indexOf("-") != -1) {
			sb.delete(sb.indexOf("-"), sb.indexOf("-") + 1);
		}
		
		string = new String(sb);
		int total = 0;
		for (int i = 0; i < string.length(); i++) {
			if (sb.length() != 10) {
				valid = false;
			} else if (sb.charAt(9) == 'X') {
				int c = 2;
				total += 10;
				for (int x = 9; x > 0; x--) {
					char num = string.charAt(x - 1);

					if (Character.getNumericValue(num) < 10) {
						total += (Character.getNumericValue(num) * (c));
					}
					c++;
				}
			} else {
				int c = 1;
				for (int y = 10; y > 0; y--) {
					char num = string.charAt(y - 1);
					if (Character.getNumericValue(num) < 10) {
						total += ((Character.getNumericValue(num) * (c)));
					}
					c++;
				
				}
			}
		}
		
		
		if (total % 11 == 0) {
			valid = true;
		}
		return valid;

	}
	

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		
		boolean pan = false;
		
		StringBuilder ab = new StringBuilder("abcdefghijklmnopqrstuvwxyz");
		
		string = string.toLowerCase();
		
		for (int i = 0; i < string.length(); i++) {
			for (int x = 0; x < ab.length(); x++) {
				if (string.charAt(i) == ab.charAt(x)) {
					ab.deleteCharAt(x);
				}
			}
		}
		if (ab.length() == 0) 
		{
			pan = true;
		}
		else
		{
			pan = false;
		}
		
		return pan;
	}
	

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		// TODO Write an implementation for this method declaration
		return null;
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		
			HashSet<Integer> hs = new HashSet<Integer>();
			
			int total = 0;
			
			for (int j = 0; j < set.length; j++) {
				int base = set[j];
				for (int y = 1; base < (i - set[j]); y++) {
					base = set[j];
					base *= y;
					hs.add(base);
					
				}
			}
			for (Integer z : hs) {
				total += z;
				
			}

			return total;
		}
	

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {

		StringBuilder sb = new StringBuilder();
		
		boolean luhn = false;
		
		for (int i = 0; i < string.length(); i++) {
			if (Character.isDigit(string.charAt(i))) {
				sb.append(string.charAt(i));
			}
		}
		
		if (sb.length() < 2) {
			luhn = false;
		} else {
			for (int i = 0; i < (sb.length() - 1); i++) {
				i++;
				int j = Character.getNumericValue(sb.charAt(i));
				j *= 2;
				if (j > 9) {
						j -= 9;
				}
				
				sb.setCharAt(i, (char) (j + 48));
			}
			
			int total = 0;
			
			for (int i = 0; i < sb.length(); i++) {
				total += Character.getNumericValue(sb.charAt(i));
			}
			if (total % 10 == 0) {
				luhn = true;
			} else {
				luhn = false;
			}
		}
		return luhn;
	}
		
	

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {

			

			String[] words = string.split(" ");
			int first;
			int second;
			int ans = 0;

			
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < words[2].length(); i++) {
				if (Character.isDigit(words[2].charAt(i))) {
					sb.append(words[2].charAt(i));
				}
			}
			String parse = new String(sb);
			first = Integer.parseInt(parse);
			sb.setLength(0);

			if (words.length == 5) {
				for (int i = 0; i < words[4].length(); i++) {
					if (Character.isDigit(words[4].charAt(i))) {
						sb.append(words[4].charAt(i));
					}
				}
			} else {
				for (int i = 0; i < words[5].length(); i++) {
					if (Character.isDigit(words[5].charAt(i))) {
						sb.append(words[5].charAt(i));
					}
				}
			}
			parse = new String(sb);
			second = Integer.parseInt(parse);

			// make sure negative numbers are negative

			if (words.length == 5) {
				if (words[2].charAt(0) == '-') {
					first *= -1;
				}
				if (words[4].charAt(0) == '-') {
					second *= -1;
				}
			} else {
				if (words[2].charAt(0) == '-') {
					first *= -1;
				}
				if (words[5].charAt(0) == '-') {
					second *= -1;
				}
			}

			// do the math
			switch (words[3]) {
			case "plus":
				ans = (first + second);
				break;
			case "minus":
				ans = (first - second);
				break;
			case "multiplied":
				ans = (first * second);
				break;
			case "divided":
				ans = (first / second);
				break;
			default:
				break;
			}

			return ans;
		}

	}



