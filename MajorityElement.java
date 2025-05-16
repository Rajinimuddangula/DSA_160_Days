/*Majority Element II
Difficulty: MediumAccuracy: 48.1%Submissions: 154K+Points: 4Average Time: 15m
You are given an array of integer arr[] where each number represents a vote to a candidate. Return the candidates that have votes greater than one-third of the total votes, If there's not a majority vote, return an empty array. 

Note: The answer should be returned in an increasing format.

Examples:

Input: arr[] = [2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6]
Output: [5, 6]
Explanation: 5 and 6 occur more n/3 times.
Input: arr[] = [1, 2, 3, 4, 5]
Output: []
Explanation: o candidate occur more than n/3 times.
Constraint:
1 <= arr.size() <= 106
-109 <= arr[i] <= 109
*/
import java.util.*;

public class MajorityElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Number of test‐cases
        int t = sc.nextInt();
        sc.nextLine(); // consume the end-of-line

        while (t-- > 0) {
            // Read one line of array elements
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                System.out.println("[]");
                continue;
            }
            String[] parts = line.split("\\s+");
            int[] arr = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                arr[i] = Integer.parseInt(parts[i]);
            }

            // Call your solution
            Solution sol = new Solution();
            List<Integer> ans = sol.findMajority(arr);

            // Print in increasing order (or [] if empty)
            if (ans.isEmpty()) {
                System.out.println("[]");
            } else {
                // prints like: "5 6 "
                for (int num : ans) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        }

        sc.close();
    }
}
class Solution {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(int[] arr) {
        int n = arr.length;
        int count1 = 0, count2 = 0;
        Integer candidate1 = null, candidate2 = null;

        // First pass: find up to two candidates
        for (int num : arr) {
            if (candidate1 != null && num == candidate1) {
                count1++;
            } else if (candidate2 != null && num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Second pass: verify the candidates
        count1 = count2 = 0;
        for (int num : arr) {
            if (candidate1 != null && num == candidate1) count1++;
            else if (candidate2 != null && num == candidate2) count2++;
        }

        List<Integer> res = new ArrayList<>();
        if (count1 > n / 3) res.add(candidate1);
        if (count2 > n / 3) res.add(candidate2);

        Collections.sort(res); // Ensure output is in increasing order
        return res;
    }
}
