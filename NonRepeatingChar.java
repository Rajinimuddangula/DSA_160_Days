/*Non Repeating Character
Difficulty: EasyAccuracy: 40.43%Submissions: 291K+Points: 2Average Time: 30m
Given a string s consisting of lowercase English Letters. Return the first non-repeating character in s.
If there is no non-repeating character, return '$'.
Note: When you return '$' driver code will output -1.

Examples:

Input: s = "geeksforgeeks"
Output: 'f'
Explanation: In the given string, 'f' is the first character in the string which does not repeat.
Input: s = "racecar"
Output: 'e'
Explanation: In the given string, 'e' is the only character in the string which does not repeat.
Input: s = "aabbccc"
Output: -1
Explanation: All the characters in the given string are repeating.
Constraints:
1 ≤ s.size() ≤ 105

*/
import java.util.*;
public class NonRepeatingChar{
    private static final int MAX_CHAR = 26;  
    public static char nonRepeatingChar(String s){
        int[] freq = new int[MAX_CHAR];
        for (char c : s.toCharArray()){
            freq[c - 'a']++;
        }
        for (char c : s.toCharArray()){
            if (freq[c - 'a'] == 1){
                return c;
            }
        }
        return '$';
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s = sc.next();
        char ans=new NonRepeatingChar().nonRepeatingChar(s);
        System.out.println(ans);
    }
}