import java.util.Scanner;
import java.util.LinkedHashMap;

class GOT {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String anagram = in.nextLine();
		// String anagram = "cdcdcdcdeeeef";
		// String anagram = "ASDFASD";
		// String anagram = "AAAA";
		LinkedHashMap<Character,Integer> map = new LinkedHashMap<Character,Integer>();
		for (int i = 0,len=anagram.length() ; i < len ; i++ ){
			char c = anagram.charAt(i);
			if (map.containsKey(c)) {
				map.put(c,map.get(c) + 1);
			}else{
				map.put(c,1);
			}
		}
		int count = 0;
		for(Character c : map.keySet()){
			int temp = map.get(c);
			if( temp % 2 == 0){
				continue;
			}else{
				count++;
			}

			if (count > 1) {
				break;
			}
		}
		if (count > 1) {
			System.out.println("NO");
		}else{
			System.out.println("YES");
		}
	}
	// "abcba"
}
