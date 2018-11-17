import java.util.Scanner;


public class Solution {

	// Don't modify this method.
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String cases = scan.nextLine();

		switch (cases) {
		case "loadDictionary":
			// input000.txt and output000.txt
			BinarySearchST<String, Integer> hash = loadDictionary("/Files/t9.csv");
			while (scan.hasNextLine()) {
				String key = scan.nextLine();
				System.out.println(hash.get(key));
			}
			break;

		case "getAllPrefixes":
			// input001.txt and output001.txt
			T9 t9 = new T9(loadDictionary("/Files/t9.csv"));
			while (scan.hasNextLine()) {
				String prefix = scan.nextLine();
				for (String each : t9.getAllWs(prefix)) {
					System.out.println(each);
				}
			}
			break;

		case "potentialWs":
			// input002.txt and output002.txt
			t9 = new T9(loadDictionary("/Files/t9.csv"));
			int count = 0;
			while (scan.hasNextLine()) {
				String t9Signature = scan.nextLine();
				for (String each : t9.potentialWs(t9Signature)) {
					count++;
					System.out.println(each);
				}
			}
			if (count == 0) {
				System.out.println("No valid ws found.");
			}
			break;

		case "topK":
			// input003.txt and output003.txt
			t9 = new T9(loadDictionary("/Files/t9.csv"));
			Bag<String> bag = new Bag<String>();
			int k = Integer.parseInt(scan.nextLine());
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				bag.add(line);
			}
			for (String each : t9.getSuggestions(bag, k)) {
				System.out.println(each);
			}

			break;

		case "t9Signature":
			// input004.txt and output004.txt
			t9 = new T9(loadDictionary("/Files/t9.csv"));
			bag = new Bag<String>();
			k = Integer.parseInt(scan.nextLine());
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				for (String each : t9.t9(line, k)) {
					System.out.println(each);
				}
			}
			break;

		default:
			break;

		}
	}

	// Don't modify this method.
	public static String[] toReadFile(String file) {
		In in = new In(file);
		return in.readAllStrings();
	}

	public static BinarySearchST<String, Integer> loadDictionary(String file) {
		BinarySearchST<String, Integer>  st = new BinarySearchST<String, Integer>();
		// your code goes here
		// int a = 1;
		// for(String w : toReadFile(file)) {
		// 	if(! st.contains(w)) {
		// 		st.put(w, a);
		// 	}else{
		// 		st.put(w, a++);
		// 	}
		// }
		//
		int j = 1;
		String[] tokens = toReadFile(file);
		int length = tokens.length;
		for(int i = 0; i < length; i++){
			String s = tokens[i].toLowerCase();
			if(! st.contains(s)) {
				st.put(s, j);
			}else{
				st.put(s, st.get(s)+1);
			}
		}
		return st;
	}

}

class T9 {
	private TST<Integer> tst;
	public T9(BinarySearchST<String, Integer> st) {
		// your code goes here
		this.tst=new TST<Integer>();
		for(String w: st.keys()){
			tst.put(w, st.get(w));
		}

	}

	// get all the prefixes that match with given prefix.
	public Iterable<String> getAllWs(String prefix) {
		// your code goes here
		return tst.keysWithPrefix(prefix);
	}

	public Iterable<String> potentialWs(String t9Signature) {
		// your code goes here
		return null;
	}

	// return all possibilities(ws), find top k with highest frequency.
	public Iterable<String> getSuggestions(Iterable<String> ws, int k) {
		// your code goes here
		return null;
	}

	// final output
	// Don't modify this method.
	public Iterable<String> t9(String t9Signature, int k) {
		return getSuggestions(potentialWs(t9Signature), k);
	}
}