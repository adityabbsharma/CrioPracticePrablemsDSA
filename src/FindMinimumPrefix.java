/*
* Problem Description
Given an array nums, return the minimum positive value we can append to the beginning of nums such that the prefix sum array of the resulting array contains numbers that are all greater than or equal to 0.

Input format
There are 2 lines of input

First line will contain a single integer N, size of the array.

Second line will contain N space separated integers representing the array.

Output format
Print the answer in a single line

Constraints
1<=N<=10^5

-10^6<=nums[i]<=10^6

Sample Input 1
5

-4 2 -3 2 6

Sample Output 1
5

Explanation 1
If 5 appended to the beginning of the array.The prefix sum array would be [5, 1, 3, 0, 2, 8]
* */
import java.util.*;
public class FindMinimumPrefix {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int arr[] = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        long res = minimumPrefix(n, arr);

        System.out.println(res);

    }

    static long minimumPrefix(int n, int arr[]) {
        long[] prefixSum = new long[n];
        prefixSum[0] = arr[0];
        long minValuePrefixSum= 0;
        for(int i=1;i<n;i++){
            prefixSum[i] = prefixSum[i-1] + arr[i];
            if(prefixSum[i]<minValuePrefixSum)
                minValuePrefixSum=prefixSum[i];
        }
        return Math.abs(minValuePrefixSum);

    }

}
