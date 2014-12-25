import java.util.*;

class Keypad {
	public static HashMap<Character,Integer> keypad = new HashMap<Character,Integer>();

	public static int getDecimal(String str){
		int answer = 0;
		str = str.toLowerCase();

		for(int i=0,n=str.length();i < n ; i++){
			int key = keypad.get(str.charAt(i));
			answer  = answer * 10 + key;
		}
		return answer;
	}
	public static void main(String[] args) {

		keypad.put('a',2);
		keypad.put('b',2);
		keypad.put('c',2);

		keypad.put('d',3);
		keypad.put('e',3);
		keypad.put('f',3);

		keypad.put('g',4);
		keypad.put('h',4);
		keypad.put('i',4);

		keypad.put('j',5);
		keypad.put('k',5);
		keypad.put('l',5);

		keypad.put('m',6);
		keypad.put('n',6);
		keypad.put('o',6);

		keypad.put('p',7);
		keypad.put('q',7);
		keypad.put('r',7);
		keypad.put('s',7);

		keypad.put('t',8);
		keypad.put('u',8);
		keypad.put('v',8);

		keypad.put('w',9);
		keypad.put('x',9);
		keypad.put('y',9);
		keypad.put('z',9);

		System.out.println(getDecimal("Microsoft"));
		System.out.println(getDecimal("facebook"));
		System.out.println(getDecimal("Amazon"));
		System.out.println(getDecimal("aA"));
		System.out.println(getDecimal("Bb"));

	}
}