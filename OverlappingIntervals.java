/*Overlapping Intervals
Difficulty: MediumAccuracy: 57.41%Submissions: 104K+Points: 4
Given an array of Intervals arr[][], where arr[i] = [starti, endi]. The task is to merge all of the overlapping Intervals.

Examples:

Input: arr[][] = [[1,3],[2,4],[6,8],[9,10]]
Output: [[1,4], [6,8], [9,10]]
Explanation: In the given intervals we have only two overlapping intervals here, [1,3] and [2,4] which on merging will become [1,4]. Therefore we will return [[1,4], [6,8], [9,10]].
Input: arr[][] = [[6,8],[1,9],[2,4],[4,7]]
Output: [[1,9]]
Explanation: In the given intervals all the intervals overlap with the interval [1,9]. Therefore we will return [1,9].
Constraints:
1 ≤ arr.size() ≤ 105
0 ≤ starti ≤ endi ≤ 105
*/
import java.util.*;
class OverlappingIntervals{
    public List<int[]> mergeOverlap(int[][] arr){
        if (arr == null || arr.length == 0){
            return new ArrayList<>();
        }
        Arrays.sort(arr, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            }
        });
        List<int[]> mergedIntervals = new ArrayList<>();
        mergedIntervals.add(arr[0]);
        for (int i = 1; i < arr.length; i++){
            int[] lastMergedInterval = mergedIntervals.get(mergedIntervals.size() - 1);
            int currentStart = arr[i][0];
            int currentEnd = arr[i][1];
            if (currentStart <= lastMergedInterval[1]){
                lastMergedInterval[1] = Math.max(lastMergedInterval[1], currentEnd);
            } else {
                mergedIntervals.add(arr[i]);
            }
        }
        return mergedIntervals;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        OverlappingIntervals obj = new OverlappingIntervals();
        List<int[]> mergedResult = obj.mergeOverlap(arr);
        for (int[] interval : mergedResult) {
            System.out.println(Arrays.toString(interval));
        }

    }
}