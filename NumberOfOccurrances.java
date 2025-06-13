/*Number of occurrence
Difficulty: EasyAccuracy: 59.34%Submissions: 331K+Points: 2Average Time: 20m
Given a sorted array, arr[] and a number target, you need to find the number of occurrences of target in arr[]. 

Examples :

Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 2
Output: 4
Explanation: target = 2 occurs 4 times in the given array so the output is 4.
Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 4
Output: 0
Explanation: target = 4 is not present in the given array so the output is 0.
Input: arr[] = [8, 9, 10, 12, 12, 12], target = 12
Output: 3
Explanation: target = 12 occurs 3 times in the given array so the output is 3.
Constraints:
1 ≤ arr.size() ≤ 106
1 ≤ arr[i] ≤ 106
1 ≤ target ≤ 106

*/
import java.util.*;
class NumberOfOccurrances{
    static int lowerBound(int[] arr, int target){
        int res = arr.length;
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] >= target){
                res = mid;
                hi = mid - 1;
            } 
          	else{
                lo = mid + 1;
            }
        }
        return res;
    }
    static int upperBound(int[] arr, int target){
        int res = arr.length;
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] > target){
                res = mid;
                hi = mid - 1;
            } 
          	else{
                lo = mid + 1;
            }
        }
        return res;
    }
    static int countFreq(int[] arr, int target){
        return upperBound(arr, target) - lowerBound(arr, target);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int target=sc.nextInt();
        System.out.println(countFreq(arr, target));
    }
}