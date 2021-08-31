/*
* Maximum Product of quadruplet
* Problem Description
You are given an array consisting of n integers. Your task is to find the maximum product of 4 numbers in the array.

Input format
First line contains a single integer n - the number of elements in the array. Second line contains n space-separated integers - the array elements.

Output format
Print the maximum product of 4 numbers in the array.

Sample Input 1
6 -10 3 2 0 1 7

Sample Output 1
42

Explanation
We get the maximum product when we choose the elements {3,2,1,7}.

Constraints
4 <= n <= 10^5 -10^4 <= a[i] <= 10^4

Hints
Brute force solution will not pass the performance test cases. Given the constraints, you have to find a solution in O(N log N) or better.

Sorting takes O(N log N) time - see if sorting can help you ease the process.

If the array is sorted, do you need to check all elements to find the max product? Or would only checking only some of the elements give you an idea.

Note that the array may contain negative elements as well. And the product of two negatives is positive, which can also be the max product, so do not ignore the negatives.
* */
import java.util.*;

class MaxProduct {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        long res = maxProduct(n, arr);

        System.out.println(res);

    }

    static long maxProduct(int n, int arr[]) {
        if(n<4)
            return -1;
        Arrays.sort(arr);
        long firstFourProduct = (long)arr[0]*arr[1]*arr[2]*arr[3];
        long lastFourProduct = (long)arr[n-1]*arr[n-2]*arr[n-3]*arr[n-4];
        long firstTwoLastTwo = (long)arr[0]*arr[1]*arr[n-1]*arr[n-2];
        long max1 = firstFourProduct>=lastFourProduct?firstFourProduct:lastFourProduct;
        long max = max1>=firstTwoLastTwo?max1:firstTwoLastTwo;
        return max;


    }
}
