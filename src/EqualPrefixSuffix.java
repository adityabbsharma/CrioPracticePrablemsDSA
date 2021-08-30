/*
* Equal prefix and suffix sum
* Problem Description
A proper prefix sum array is a prefix sum array without the entire array sum, that is, with the last element of a normal prefix sum array missing. Thus, for a = [1, 2, 3, 4], the proper prefix sum array, pps = [1, 3, 6].


Similarly, a proper suffix sum array is a suffix sum array without the entire array sum, that is, with the first element of a normal suffix sum array missing. For the above example, the proper suffix sum array, pss = [9, 7, 4].


A magic sum is a non negative sum that’ll exist in both the pps and the pss.


Given an array of size n, you have to find the largest magic sum, that is, the largest non negative element that exists in both the pps and the pss. If no such element exists, return -1.
Note:-


A proper prefix and proper suffix of an array is not equal to the array itself and non - empty.
Input format
First line contains an integer n, the size of the array. Second line contains n space separated integers, representing the elements of the array.

Output format
Print the max magic sum in the array if it exists, else print -1.

Sample Input 1
5

1 2 3 4 10

Sample Output 1
10

Explanation
Proper Prefix Sums are - [1, 3, 6, 10]

Proper Suffix Sums are - [19, 17, 14, 10]

10 is the only common element, thus, 10 is the answer.

Constraints
1 <= n <= 10^5

-10^6 <= array elements <= 10^6

Hints
You’ll first have to create the pps and the pss, this time with the constraint of them having one element lesser than the original array.

pps will have the last element removed, pss will have the first.
* */
import java.util.*;

class EqualPrefixSuffix {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        long res = equalPrefixSuffix(n, arr);

        System.out.println(res);
    }

    static long equalPrefixSuffix(int n, int arr[]) {
        if(n==1)
            return -1;
        long[] pps = new long[n-1];
        long[] pss = new long[n-1];
        HashSet<Long> hSetPPS = new HashSet<>();
        HashSet<Long> hSetPSS = new HashSet<>();
        pps[0] = arr[0];
        hSetPPS.add(pps[0]);
        int[] newArr = new int[n];
        for(int i=0;i<n;i++){
            newArr[i] = arr[n-1-i];
        }
        pss[0] = newArr[0];
        hSetPSS.add(pss[0]);

        for(int i=1;i<n-1;i++){
            pps[i] = arr[i] + pps[i-1];
//            System.out.println("pps[i]="+pps[i]+",i="+i);
            hSetPPS.add(pps[i]);
        }
//        System.out.println(hSetPPS);

        for(int i=1;i<n-1;i++){
            pss[i] = newArr[i] + pss[i-1];
//            System.out.println("pss[i]="+pss[i]+",i="+i);
            hSetPSS.add(pss[i]);
        }
//        System.out.println(hSetPSS);

        long magicSum= Long.MIN_VALUE;
        for(Long element:hSetPPS){
            if(hSetPSS.contains(element) && element>magicSum){
                magicSum = element;
            }
        }
        if(magicSum == Long.MIN_VALUE || magicSum<0)
            return -1;
        else
            return magicSum;

    }
}
