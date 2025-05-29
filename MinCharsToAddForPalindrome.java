/*Min Chars to Add for Palindrome
Difficulty: HardAccuracy: 46.79%Submissions: 90K+Points: 8Average Time: 25m
Given a string s, the task is to find the minimum characters to be added at the front to make the string palindrome.

Note: A palindrome string is a sequence of characters that reads the same forward and backward.

Examples:

Input: s = "abc"
Output: 2
Explanation: Add 'b' and 'c' at front of above string to make it palindrome : "cbabc"
Input: s = "aacecaaaa"
Output: 2
Explanation: Add 2 a's at front of above string to make it palindrome : "aaaacecaaaa"
Constraints:
1 <= s.size() <= 106

*/
import java.util.*;
class MinCharsToAddForPalindrome{
    static void computeLPSArray(String pat, int[] lps){
        int length = 0;
        int i = 1;
        lps[0] = 0;
        while (i < pat.length()){
            if (pat.charAt(i) == pat.charAt(length)){
                length++;
                lps[i] = length;
                i++;
            } 
            else{
                if(length != 0){
                    length = lps[length - 1];
                }
                else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
    public static int minChar(String str){
        String rev = new StringBuilder(str).reverse().toString();
        String concat = str + "$" + rev;
        int[] lps = new int[concat.length()];
        computeLPSArray(concat, lps);
        return str.length() - lps[concat.length() - 1];
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int result = minChar(s);
        System.out.println(result);
    }
}