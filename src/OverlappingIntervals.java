/*
* Check overlapping intervals
* Problem Description
An interval is a pair of values that represents all numbers between those two.


You are given N intervals. You need to print the farthest located interval distance that are non overlapping. If there is no non-overlapping pair of intervals present, return -1


Note: Distance between two intervals is defined by the absolute difference between the end point of the left interval and start point of the right interval.


A distance of 0 means that they’re NOT overlapping. For instance, [1, 3] and [3, 4] are not considered overlapping.

Input format
There are N+1 lines of input

First line contains a single integer N. Next N lines will contain two integers, l and r, representing the start and end point of the interval respectively.

Output format
Print the farthest distance or -1 if no overlapping intervals are present.

Sample Input 1
3

1 2

3 5

6 7

Sample Output 1
4

Explanation
The pair of intervals [1,2] & [6,7] are farthest. And the distance between them will be 6 - 2 = 4

Constraints
1<=N<=10^5

1<=l<=r<=10^6

Hints
What data structure will you use to take input of each pair?

Your job will be to find the maximum possible start[j] - back[i], where start represents the list of starting values and back the list of ending values, and j > i.

If the difference turns out to be negative, make sure you return -1.

Ensure you’re handling the case for just one interval separately, that is N=1.
* */
import java.util.*;

class OverlappingIntervals {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<ArrayList<Integer>> intervals = new ArrayList<ArrayList<Integer>>(n);

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            intervals.add(new ArrayList<Integer>(Arrays.asList(x, y)));
        }

        int result = overlappingIntervals(n, intervals);

        System.out.println(result);
    }

    static int overlappingIntervals(int n, ArrayList<ArrayList<Integer>> intervals) {
        Collections.sort(intervals, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return Integer.compare(o1.get(0),o2.get(0));
            }
        });
//        for(int i=0;i<intervals.size();i++){
//            System.out.println(intervals.get(i).get(0)+","+intervals.get(i).get(1));
//        }
        int maxOverlappingIntervalLength=Integer.MIN_VALUE;
//        for(int i=0;i<intervals.size();i++){
//            //int start= intervals.get(i).get(0);
//            int end = intervals.get(i).get(1);
//            for(int j=i+1;j<intervals.size();j++){
//                    int start2= intervals.get(j).get(0);
//                    //int end2 = intervals.get(j).get(1);
//                    if(start2>=end){
//                        maxOverlappingIntervalLength = Math.max(maxOverlappingIntervalLength,start2-end);
//                    }
//            }
//        }
        HashMap<Integer,Integer> hMap = new HashMap<>();
        for(int i=0;i<intervals.size();i++){
            hMap.put(intervals.get(i).get(0),intervals.get(i).get(1));
        }

        for(int i=0;i<intervals.size();i++){
            //int start= intervals.get(i).get(0);
            int end = intervals.get(i).get(1);
            for(int j=intervals.size()-1;j<intervals.size();j--){
                    int start2= intervals.get(j).get(0);
                    //int end2 = intervals.get(j).get(1);
                    if(start2>=end){
                        maxOverlappingIntervalLength = Math.max(maxOverlappingIntervalLength,start2-end);
                    }
            }
        }
        if(maxOverlappingIntervalLength != Integer.MIN_VALUE)
            return maxOverlappingIntervalLength;
        else
            return -1;
    }
}
