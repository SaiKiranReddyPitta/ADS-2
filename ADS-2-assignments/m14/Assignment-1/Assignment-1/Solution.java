import java.util.Scanner;
/**
 This is the Solution class.
 */
final class Solution {
    /**
     *This is the default constructor.
     */
    private Solution() {
      //unused.
    }
    /**
     *This is main method.
     * @param args String.
     */
    public static void main(final String[] args) {
        String[] words = loadWords();
        // Your code goes here...
        // System.out.println(Arrays.toString(words));
        TST tst = new TST();
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        for (int i = 0; i < words.length; i++) {
            String[] tokens = new String[words[i].length()];
            for (int j = 0; j < words[i].length(); j++) {
                tokens[j] = words[i].substring(j, words[i].length());
                tst.put(tokens[j], 0);
            }
        }
        System.out.println(tst.keysWithPrefix(input));
    }
/**
 * loadwords method.
 * @return String array.
 */
    public static String[] loadWords() {
        In in = new In("/Files/dictionary-algs4.txt");
        String[] words = in.readAllStrings();
        // System.out.println(words);
        return words;
    }
}
