/*Smallest Positive Missing
Difficulty: MediumAccuracy: 25.13%Submissions: 419K+Points: 4
You are given an integer array arr[]. Your task is to find the smallest positive number missing from the array.

Note: Positive number starts from 1. The array can have negative integers too.

Examples:

Input: arr[] = [2, -3, 4, 1, 1, 7]
Output: 3
Explanation: Smallest positive missing number is 3.
Input: arr[] = [5, 3, 2, 5, 1]
Output: 4
Explanation: Smallest positive missing number is 4.
Input: arr[] = [-8, 0, -1, -4, -3]
Output: 1
Explanation: Smallest positive missing number is 1.
Constraints:  
1 <= arr.size() <= 105
-106 <= arr[i] <= 106*/
import java.util.*;
class SmallestPositiveMissing{
    static int missingNumber(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n; i++){ 
            while (arr[i] >= 1 && arr[i] <= n && arr[i] != arr[arr[i] - 1]){
                int temp = arr[i];
                arr[i] = arr[arr[i] - 1];
                arr[temp - 1] = temp;
            }
        }
        for (int i = 1; i <= n; i++){
            if (i != arr[i - 1]){
                return i;
            }
        }
        return n + 1;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)  arr[i]=sc.nextInt();
        int res=missingNumber(arr);
        System.out.println(res);
    }
}