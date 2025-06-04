/*Insert Interval
Difficulty: MediumAccuracy: 50.61%Submissions: 42K+Points: 4Average Time: 30m
Geek has an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith event and intervals is sorted in ascending order by starti. He wants to add a new interval newInterval= [newStart, newEnd] where newStart and newEnd represent the start and end of this interval.

Help Geek to insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Examples:

Input: intervals = [[1,3], [4,5], [6,7], [8,10]], newInterval = [5,6]
Output: [[1,3], [4,7], [8,10]]
Explanation: The newInterval [5,6] overlaps with [4,5] and [6,7].
Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,9]
Output: [[1,2], [3,10], [12,16]]
Explanation: The new interval [4,9] overlaps with [3,5],[6,7],[8,10].
Constraints:
1 ≤ intervals.size() ≤  105
0 ≤ start[i], end[i] ≤ 109

*/
import java.util.*;
class InsertInterval{
    static ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval){
        ArrayList<int[]> res = new ArrayList<>();
        int i = 0;
        int n = intervals.length;
        while (i < n && intervals[i][1] < newInterval[0]){
            res.add(intervals[i]);
            i++;
        }
        while (i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);
        while (i < n){
            res.add(intervals[i]);
            i++;
        }
        return res;
    }
    public static void main(String[] args){
         Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        int newInterval[]=new int[2];
        newInterval[0]=sc.nextInt(); 
        newInterval[1]=sc.nextInt();
        InsertInterval obj = new InsertInterval();
        ArrayList<int[]> res = obj.insertInterval(arr, newInterval);
        for (int[] interval : res){
            System.out.println(interval[0] + " " + interval[1]);
        }
    }
}