/*Sort 0s, 1s and 2s
Difficulty: MediumAccuracy: 50.58%Submissions: 774K+Points: 4Average Time: 10m
Given an array arr[] containing only 0s, 1s, and 2s. Sort the array in ascending order.

You need to solve this problem without utilizing the built-in sort function.

Examples:

Input: arr[] = [0, 1, 2, 0, 1, 2]
Output: [0, 0, 1, 1, 2, 2]
Explanation: 0s 1s and 2s are segregated into ascending order.
Input: arr[] = [0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1]
Output: [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2]
Explanation: 0s 1s and 2s are segregated into ascending order.

Follow up: Could you come up with a one-pass algorithm using only constant extra space?
Constraints:
1 <= arr.size() <= 106
0 <= arr[i] <= 2*/
import java.util.*;
class Sort0s1s2s{
    static void sort012(int[] arr){
        int n = arr.length;
        int lo = 0;
        int hi = n - 1;
        int mid = 0, temp = 0;
        while (mid <= hi){
            if (arr[mid] == 0){
                swap(arr, mid, lo);
                lo++;
                mid++;
            }
            else if (arr[mid] == 1){
                mid++;
            }
            else{
                swap(arr, mid, hi);
                hi--;
            }
        }
    }
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        sort012(arr);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}