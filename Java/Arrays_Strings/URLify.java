package Arrays_Strings;

import java.util.Scanner;

public class URLify {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        int trueLength = str.trim().length();
        urlify(str.toCharArray(), trueLength);
        sc.close();
    }

    private static void urlify(char[] str, int trueLength) {
        int leftIndex = trueLength - 1, rightIndex = str.length - 1;
        while (leftIndex >= 0) {
            if (str[leftIndex] != ' ') {
                str[rightIndex--] = str[leftIndex--];
            } else {
                str[rightIndex--] = '0';
                str[rightIndex--] = '2';
                str[rightIndex--] = '%';
                leftIndex--;
            }
        }
        System.out.println(str);
    }
}
