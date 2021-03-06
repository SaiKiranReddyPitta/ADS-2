import java.util.Scanner;
import java.util.TreeSet;

/**
 * Class for solution.
 */
public class Solution {

    /**
     * Don't modify this method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String cases = scan.nextLine();

        switch (cases) {
        case "loadDictionary":
            // input000.txt and output000.txt
            BinarySearchST<String, Integer> hash =
            loadDictionary("/Files/t9.csv");
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

    /**
     * Don't modify this method.
     *
     * @param      file  The file
     *
     * @return     { description_of_the_return_value }
     */
    public static String[] toReadFile(final String file) {
        In in = new In(file);
        return in.readAllStrings();
    }

    /**
     * Loads a dictionary.
     *
     * @param      file  The file
     *
     * @return     { description_of_the_return_value }
     */
    public static BinarySearchST<String, Integer> loadDictionary(final String file) {
        BinarySearchST<String, Integer>  st =
            new BinarySearchST<String, Integer>();
        // your code goes here
        int j = 1;
        String[] tokens = toReadFile(file);
        int length = tokens.length;
        for (int i = 0; i < length; i++) {
            String s = tokens[i].toLowerCase();
            if (!st.contains(s)) {
                st.put(s, j);
            } else {
                st.put(s, st.get(s) + 1);
            }
        }
        return st;
    }

}

/**
 * Class for t 9.
 */
class T9 {
    /**
     * { var_description }
     */
    private TST<Integer> tst;
    /**
     * Constructs the object.
     *
     * @param      st    { parameter_description }
     */
    public T9(BinarySearchST<String, Integer> st) {
        // your code goes here
        this.tst = new TST<Integer>();
        for (String w: st.keys()) {
            tst.put(w, st.get(w));
        }

    }

    /**
     * get all the prefixes that match with given prefix.
     *
     * @param      prefix  The prefix
     *
     * @return     All ws.
     */
    public Iterable<String> getAllWs(final String prefix) {
        // your code goes here
        return tst.keysWithPrefix(prefix);
    }

    /**.
     * { function_description }
     *
     * @param      t9Signature  The t 9 signature
     *
     * @return     { description_of_the_return_value }
     */
    public Iterable<String> potentialWords(final String t9Signature) {
        // your code goes here
        //TreeSet<String> ts = new TreeSet<>();
        TreeSet<String> ts = new TreeSet<>();
        for (String strInput : tst.keys()) {
            String[] t = strInput.split("");
            String sum = "";
            for (String word : t) {
                if (word.equals("a") || word.equals("b") ||
                    word.equals("c")) {
                    sum = sum + "2";

                } else if (word.equals("d") || word.equals("e") ||
                    word.equals("f")) {
                    sum = sum + "3";

                } else if (word.equals("g") || word.equals("h") ||
                    word.equals("i")) {
                    sum = sum + "4";

                } else if (word.equals("j") || word.equals("k") ||
                    word.equals("l")) {
                    sum = sum + "5";

                } else if (word.equals("m") || word.equals("n") ||
                    word.equals("o")) {
                    sum = sum + "6";

                } else if (word.equals("p") || word.equals("q") ||
                           word.equals("r") || word.equals("s")) {
                    sum = sum + "7";

                } else if (word.equals("t") || word.equals("u") ||
                    word.equals("v")) {
                    sum = sum + "8";

                } else if (word.equals("w") || word.equals("x") ||
                           word.equals("y") || word.equals("z")) {
                    sum = sum + "9";
                }

            }
            if (sum.equals(t9Signature)) {
                ts.add(strInput);
            }
        }
        return ts;
    }

    /**
     * return all possibilities(ws), find top k with highest frequency.
     *
     * @param      words  The words
     * @param      k      { parameter_description }
     *
     * @return     The suggestions.
     */
    public Iterable<String> getSuggestions(
        final Iterable<String> words, final  int k) {
        // your code goes here
        // Hashmap<Integer, String> hash = new Hashmap();
        TreeSet<String> ts = new TreeSet<>();
        //BinarySearchST<String, Integer> bst = new BinarySearchST<>();
        MaxPQ<Integer> mPQ = new MaxPQ<>();
        for (String word : words) {
            mPQ.insert(tst.get(word));
        }
        for (int a = 0; a < k; a++) {
            int i = mPQ.delMax();
            for (String word : words) {
                if (i == tst.get(word)) {
                    ts.add(word);
                }
            }
        }
        return ts;
    }

    /**
     * final output Don't modify this method.
     *
     * @param      t9Signature  The t 9 signature
     * @param      k            { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Iterable<String> t9(final String t9Signature, final int k) {

        return getSuggestions(potentialWords(t9Signature), k);
    }
}




