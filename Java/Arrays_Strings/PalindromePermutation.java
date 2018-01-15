package Arrays_Strings;

import java.util.Scanner;

public class PalindromePermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine().toLowerCase();
        System.out.println(str + " is " + (isPalindromePermutation(str) ? "" : "not ") + "a permutation of palindrome.");
        sc.close();
    }

    private static boolean isPalindromePermutation(String str) {
        int[] letters = new int[26];
        int singles = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if (val < 0 || val > 25) continue;
            letters[val]++;
            if (letters[val] % 2 == 1)
                singles++;
            else
                singles--;
        }
        return singles < 2;
    }
}
