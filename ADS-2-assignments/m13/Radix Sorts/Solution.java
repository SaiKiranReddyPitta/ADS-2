import java.util.Scanner;
/**
 * Solution class.
 */
final class Solution {
    /**
     * default constructor.
     */
    private Solution() {

    }
    /**
     * main method.
     * Complexity is O(N).
     * @param args String.
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        LSD lsd = new LSD();
        String[] inp = new String[count];
        int len;
        for (int i = 0; i < count; i++) {
            inp[i] = sc.nextLine();
            len = inp[i].length();
        }
        len = inp[0].length();
        // lsd.sort(inp, len);
        // String[] result = new String[count];
        lsd.sort(inp, len);
        System.out.println(lsd);

    }
}

