import java.util.Scanner;
import java.util.TreeSet;

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

		case "potentialWords":
			// input002.txt and output002.txt
			t9 = new T9(loadDictionary("/Files/t9.csv"));
			int count = 0;
			while (scan.hasNextLine()) {
				String t9Signature = scan.nextLine();
				for (String each : t9.potentialWords(t9Signature)) {
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

	public Iterable<String> potentialWords(String t9Signature) {
		// your code goes here
		//TreeSet<String> ts = new TreeSet<>();
		TreeSet<String> ts = new TreeSet<>();
		for (String strInput : tst.keys()) {
			String[] t = strInput.split("");
			String sum = "";
			for (String word : t) {
				if(word.equals("a") || word.equals("b") || word.equals("c")) {
					sum = sum + "2";	
					
				} else if (word.equals("d") || word.equals("e") || word.equals("f")) {
					sum = sum + "3";	
					
				} else if (word.equals("g") || word.equals("h") || word.equals("i")) {
					sum = sum + "4";	
					
				} else if (word.equals("j") || word.equals("k") || word.equals("l")) {
					sum = sum + "5";	
					
				} else if (word.equals("m") || word.equals("n") || word.equals("o")) {
					sum = sum + "6";	
					
				} else if (word.equals("p") || word.equals("q") || word.equals("r") || word.equals("s")) {
					sum = sum + "7";	
					
				} else if (word.equals("t") || word.equals("u") || word.equals("v")) {
					sum = sum + "8";	
					
				} else if (word.equals("w") || word.equals("x") || word.equals("y") || word.equals("z")) {
					sum = sum + "9";	
					
				} 

			}
			if(sum.equals(t9Signature)) {
				ts.add(strInput);
			}
		} 
		return ts;
	}

	// return all possibilities(ws), find top k with highest frequency.
	public Iterable<String> getSuggestions(Iterable<String> words, int k) {
		// your code goes here
		// Hashmap<Integer, String> hash = new Hashmap();
		TreeSet<String> ts = new TreeSet<>();
		//BinarySearchST<String, Integer> bst = new BinarySearchST<>();
		MaxPQ<Integer> mPQ = new MaxPQ<>();
		for(String word : words){
			mPQ.insert(tst.get(word));
		}
		for(int a = 0 ; a < k; a++) {
			int i = mPQ.delMax();
			for(String word : words){
				if (i == tst.get(word)){
					ts.add(word);
				}
			}
		}
		return ts;
	}

	// final output
	// Don't modify this method.
	public Iterable<String> t9(String t9Signature, int k) {

		return getSuggestions(potentialWords(t9Signature), k);
	}
}
