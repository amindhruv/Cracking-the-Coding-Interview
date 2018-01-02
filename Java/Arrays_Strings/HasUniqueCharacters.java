package Arrays_Strings;

import java.util.Scanner;

public class HasUniqueCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        System.out.println(str + " is " + (hasUniqueCharacters(str) ? "" : "not ") + "having unique characters.");
        sc.close();
    }

    private static boolean hasUniqueCharacters(String str) {
        if (str.length() > 128) return false;
        boolean[] chars = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (chars[val]) return false;
            chars[val] = true;
        }
        return true;
    }
}
