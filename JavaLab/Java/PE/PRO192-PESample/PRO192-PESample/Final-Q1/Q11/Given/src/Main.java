// ======= DO NOT EDIT MAIN FUNCTION ============

import java.io.*;

class Main {

    /**
     * Count the number of words in s that contain at least a vowel letter
     *
     * @param s - an input string
     * @return - number of words in an input string that contain at least a
     * vowel letter
     */
    public static int f1(String s) {
        int count = 0;

        String[] s1 = s.split("\\s+");
        for (String word : s1) {
            int c = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == 'u' || word.charAt(i) == 'U'
                        || word.charAt(i) == 'e' || word.charAt(i) == 'E'
                        || word.charAt(i) == 'o' || word.charAt(i) == 'O'
                        || word.charAt(i) == 'a' || word.charAt(i) == 'A'
                        || word.charAt(i) == 'i' || word.charAt(i) == 'I') {
                    c++;
                }
            }
            if (c >= 1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        System.out.print("Enter a string s: ");
        s = in.readLine();
        System.out.println("OUTPUT:");
        System.out.println(f1(s));
    }
}
