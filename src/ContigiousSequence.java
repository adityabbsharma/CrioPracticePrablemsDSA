/*
* Find the largest sum contiguous subarray
* Problem Description
Given an array, find a non-empty contiguous subarray with the largest sum.

Input format
There are 2 lines of input.

First line contains N, the number of elements in the array.

Second line contains N space separated numbers, representing the array elements.

Output format
A single integer which is the maximum possible contiguous subarray sum

Constraints
1 ≤ N ≤ 10^5

-10^9 ≤ A[i] ≤ 10^9

Sample Input 1
8

-2 -3 4 -1 -2 1 5 -3

Sample Output 1
7

Explanation 1
The subarray [4 -1 -2 1 5] has sum 7, which is the maximum possible.
* */
import java.io.*;
import java.util.Scanner;
public class  ContigiousSequence {
    public static  long contigiousSequence(int arr[] , int n) {
        //Brute Force Approach------------
//        long[] prefixSum = new long[n];
//        prefixSum[0] = arr[0];
//        long max = Long.MIN_VALUE;
//        if(max<=prefixSum[0])
//            max=prefixSum[0];
//        for(int i=1;i<n;i++){
//            prefixSum[i] = prefixSum[i-1] + arr[i];
////            System.out.println("prefixSum[i]="+prefixSum[i]+"at i="+i);
//            if(max <= prefixSum[i])
//                max = prefixSum[i];
//        }
//
//        for(int i=1;i<n;i++){
//            long temp = prefixSum[n-1] - prefixSum[i-1];
//            if(max<=temp)
//                max = temp;
//            int j=0;
//            while(((n-1)-j)>i){
//                long temp1 = prefixSum[n-1-j] - prefixSum[i];
//                if(max<=temp1)
//                    max = temp1;
//                j++;
//            }
//        }
//        for(int i=0;i<n;i++){
//            if(max<=arr[i])
//                max = arr[i];
//        }
//        return max;
        // Kadane Algorithm approach----------
        int size = arr.length;
        long max_so_far = Long.MIN_VALUE, max_ending_here = 0;

        for (int i = 0; i < size; i++)
        {
            max_ending_here = max_ending_here + arr[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        if(max_so_far==0){
            for(int i=0;i<n;i++){
                if(arr[i]>=0)
                    return max_so_far;
            }
            max_so_far = arr[0];
            for(int i=0;i<n;i++){
                if(max_so_far < arr[i])
                    max_so_far = arr[i];
            }
            return max_so_far;
        }

        return max_so_far;

    }
    public static void  main (String args []) {

        Scanner sc =  new  Scanner (System.in);

        int n = sc.nextInt();
        int arr [] = new int[n + 5];
        for ( int i = 0 ; i < n; i++)
            arr[i] = sc.nextInt();

        long max = contigiousSequence(arr, n);
        System.out.println(max);

    }
}

