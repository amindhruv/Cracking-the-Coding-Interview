package Arrays_Strings;

import java.util.Scanner;

public class Compress {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string to compress: ");
        String str = sc.nextLine();
        System.out.println("Compressed version of " + str + ": " + compress(str));
        sc.close();
    }

    private static String compress(String str) {
        if (str.length() < 3)
            return str;
        StringBuilder compressed = new StringBuilder(); // Improve efficiency by defining capacity beforehand
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count++;
            if ((i + 1) >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(count);
                count = 0;
            }
        }
        return compressed.length() < str.length() ? compressed.toString() : str;
    }
}
