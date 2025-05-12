/*Move All Zeroes to End
Difficulty: EasyAccuracy: 45.51%Submissions: 323K+Points: 2Average Time: 15m
You are given an array arr[] of non-negative integers. Your task is to move all the zeros in the array to the right end while maintaining the relative order of the non-zero elements. The operation must be performed in place, meaning you should not use extra space for another array.

Examples:

Input: arr[] = [1, 2, 0, 4, 3, 0, 5, 0]
Output: [1, 2, 4, 3, 5, 0, 0, 0]
Explanation: There are three 0s that are moved to the end.
Input: arr[] = [10, 20, 30]
Output: [10, 20, 30]
Explanation: No change in array as there are no 0s.
Input: arr[] = [0, 0]
Output: [0, 0]
Explanation: No change in array as there are all 0s.
Constraints:
1 ≤ arr.size() ≤ 105
0 ≤ arr[i] ≤ 105*/
import java.io.*;
class MoveAllZeroesToEnd{
    void pushZerosToEnd(int[] arr) {
        // code here
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                arr[count]=arr[i];
                count+=1;
            }
        }
        while(count<arr.length){
            arr[count++]=0;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" "); // Read space-separated integers

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        MoveAllZeroesToEnd sol=new MoveAllZeroesToEnd();
        sol.pushZerosToEnd(arr);
        for(int num:arr){
            System.out.println(num+"  ");
        }
    }
}