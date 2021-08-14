/*
* Merge overlapping intervals
* Problem Description
An interval is a range, with a starting value and ending value. [1, 3] indicates elements 1, 2, 3 and so on.

Given a collection of intervals, merge all overlapping intervals. The result should only have mutually exclusive intervals - meaning that no number should be common between two intervals, in the result.

Note: The merged intervals should be printed in increasing order of start value.

Input format
There are N+1 lines of input.

First line contains N, the number of intervals

Next N lines contain 2 space separated integers A and B, which represent the start and end of an interval

Output format
For the X merged intervals, print each interval (the start and end being space separated) on a separate line

Constraints
1 <= N <= 50000

0 <= A, B <= 1e9

B >= A

Sample Input 1
4

1 3

2 6

8 10

15 18

Sample Output 1
1 6

8 10

15 18

Explanation 1
Since intervals [1 3] and [2 6] overlap, merge them into [1 6]

Sample Input 2
2

1 4

4 5

Sample Output 2
1 5

Explanation 2
Intervals [1 4] and [4 5] overlap and get merged into [1 5]
* */
import java.util.*;

class MergeIntervals {

    public int[][] mergeIntervals(int[][] intervals) {
        // method 1 using prefix sum technique------------------------------------------
//        Arrays.sort(intervals, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] a,
//                               int[] b) {
//
//                return Integer.compare(a[0],b[0]);
//            }
//        });  // End of function call sort().
//        int noOfIntervals = intervals.length;
////        HashMap<Integer,Integer> hMap = new HashMap<>();
//        HashSet<Integer> hSet = new HashSet<>();
//        HashSet<Integer> hSet2 = new HashSet<>();
//        int len = intervals[noOfIntervals-1][intervals[noOfIntervals-1].length-1];
//        int[] arr = new int[len+2];
//        arr[0] =0;
//        for(int i=0;i<noOfIntervals;i++){
//            if(intervals[i][0] == 0)
//                arr[1] = 1;
//            else{
//                if(i>0){
//                    if(intervals[i][0] == intervals[i-1][1] + 1){
//                        hSet2.add(intervals[i-1][1]);
//                        hSet.add(intervals[i][0]);
////                        System.out.println("i m here");
//                    }
//                }
//
//                arr[intervals[i][0]] = 1;
//            }
//
//            arr[intervals[i][1] + 1] = -1;
////            hMap.put(intervals[i][0],intervals[i][1]);
//        }
////        System.out.println(hMap);
////        for(int i=0;i<arr.length;i++){
////            System.out.print(arr[i]+" ");
////        }
////        System.out.println();
//        for(int i=1;i<arr.length;i++){
//            arr[i] = arr[i] + arr[i-1];
//        }
////        for(int i=0;i<arr.length;i++){
////            System.out.print(arr[i]+" ");
////        }
////        System.out.println();
//        int noOfNewIntervals=0,flagStartOfAnInterVal=0;
//        Queue<Integer> newIntervalsStartEndPoints = new LinkedList<>();
//        for(int i=0;i<arr.length;i++){
//            if(arr[i] !=0 && flagStartOfAnInterVal ==0 && !hSet.contains(i) ){
//                flagStartOfAnInterVal = 1;
//                noOfNewIntervals++;
//                newIntervalsStartEndPoints.add(i);
////                System.out.println("noOfNewIntervals here1="+noOfNewIntervals);
//            }
//            if(arr[i] !=0  && hSet.contains(i)){
//                noOfNewIntervals++;
//                flagStartOfAnInterVal = 1;
//                newIntervalsStartEndPoints.add(i);
////                System.out.println("noOfNewIntervals here2="+noOfNewIntervals);
//            }
//            if(arr[i] ==0 && flagStartOfAnInterVal==1){
//                flagStartOfAnInterVal =0;
//                newIntervalsStartEndPoints.add(i-1);
////                System.out.println("noOfNewIntervals here3="+noOfNewIntervals);
//            }
//            if(arr[i] !=0 && hSet2.contains(i)){
//                flagStartOfAnInterVal =0;
//                newIntervalsStartEndPoints.add(i);
////                System.out.println("noOfNewIntervals here4="+noOfNewIntervals);
//            }
//
//            if(flagStartOfAnInterVal==1 && i==arr.length-1){
//                if(arr[i]!=0){
//                    newIntervalsStartEndPoints.add(i-1);
////                    System.out.println("noOfNewIntervals here5="+noOfNewIntervals);
//                }
//            }
//        }
////        System.out.println("noOfNewIntervals="+noOfNewIntervals);
//        int[][] newArr = new int[noOfNewIntervals][2];
//        for(int i=0;i<noOfNewIntervals;i++){
//            newArr[i][0] = newIntervalsStartEndPoints.remove();
////            System.out.println(newArr[i][0] );
//            newArr[i][1] = newIntervalsStartEndPoints.remove();
////            System.out.println(newArr[i][1]);
//        }
//        return newArr;
        // method 2 using array and sorted array
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a,
                               int[] b) {

                return Integer.compare(a[0],b[0]);
            }
        });
        Stack<Integer> stack = new Stack<>();
        stack.push(intervals[0][0]);
        stack.push(intervals[0][1]);
        for(int i=1;i< intervals.length;i++){
            if(stack.peek()<intervals[i][0]){
                stack.push(intervals[i][0]);
                stack.push(intervals[i][1]);
            }
            else if(stack.peek()<intervals[i][1]){
                stack.pop();
                stack.push(intervals[i][1]);
            }
        }
        Stack<Integer> q = new Stack<>();
        while(!stack.isEmpty()){
            q.push(stack.pop());
        }
        int[][] newIntervals = new int[q.size()/2][2];
        for(int i =0;i< newIntervals.length;i++){
            newIntervals[i][0]=q.pop();
            newIntervals[i][1]=q.pop();
        }
        return newIntervals;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] nums = new int[n][2];

        for(int i = 0 ; i < n ;i++) {
            nums[i][0] = scanner.nextInt();
            nums[i][1] = scanner.nextInt();
        }

        int[][] results = new MergeIntervals().mergeIntervals(nums);

        for (int i = 0; i < results.length; ++i) {
            System.out.printf("%d %d\n", results[i][0], results[i][1]);
        }
    }
}
