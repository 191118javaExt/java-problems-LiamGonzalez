package runtest;

public class DriverTest {
	
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
		
		for(int j= 5; j <string.length()-1; j+= 6) {
			atb.insert(j, " ");
		}
		
		String enc = atb.toString();
		return enc;
	}


	public static void main(String[] args) {
		System.out.println(encode("The quick brown fox jumps over the lazy dog."));

	}

}
