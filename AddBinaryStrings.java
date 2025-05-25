/*Add Binary Strings
Difficulty: MediumAccuracy: 23.25%Submissions: 107K+Points: 4
Given two binary strings s1 and s2 consisting of only 0s and 1s. Find the resultant string after adding the two Binary Strings.
Note: The input strings may contain leading zeros but the output string should not have any leading zeros.

Input: s1 = "1101", s2 = "111"
Output: 10100
Explanation:
 1101
+ 111
10100
Input: s1 = "00100", s2 = "010"
Output: 110
Explanation: 
  100
+  10
  110
Constraints:
1 ≤s1.size(), s2.size()≤ 106*/
import java.util.*;
// User function Template for Java

class AddBinaryStrings{
    static String trimLeadingZeros(String s){
        int firstOne = s.indexOf('1');
        return (firstOne == -1) ? "0": s.substring(firstOne);
    }
    static String addBinary(String s1, String s2){
        s1 = trimLeadingZeros(s1);
        s2 = trimLeadingZeros(s2);
        int n = s1.length();
        int m = s2.length();
        if (n < m){
            return addBinary(s2, s1);
        }
        int j = m - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();
        for (int i = n - 1; i >= 0; i--){
            int bit1 = s1.charAt(i) - '0';
            int sum = bit1 + carry;
            if (j >= 0){
                int bit2 = s2.charAt(j) - '0';
                sum += bit2;
                j--;
            }
            int bit = sum % 2;
            carry = sum / 2;
            result.append((char)(bit + '0'));
        }
        if (carry > 0)
            result.append('1');
        return result.reverse().toString();
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(addBinary(s1, s2));
    }
}