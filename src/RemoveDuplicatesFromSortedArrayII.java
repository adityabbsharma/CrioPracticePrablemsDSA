/*
*Remove duplicates such that each element occurs at most twice
* Problem Description
Given a sorted array, remove the duplicates in-place, such that each element in the array appears at most
* twice, and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with
* O(1) extra memory.

Input format
There are two lines of input.

First line contains an integer n - Number of elements.

Second line contains n space separated integers - The array nums.

Output format
Print the new length in the first line.

In the second line print the nums array upto the new length.

Sample Input 1
7

2 2 2 3 4 4 9

Sample Output 1
6

2 2 3 4 4 9

Explanation 1
Your function should return 6 as the element 2 can only be present at most 2 times.
* So the first 6 elements of array nums should be modified to [2, 2, 3, 4, 4, 9].

Constraints
1 <= n <= 10^5

0 <= nums[i] <= 10^6
* */
import java.util.*;

class RemoveDuplicatesFromSortedArrayII {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int res = removeDuplicatesFromSortedArrayII(n, arr);

        System.out.println(res);

        for (int i = 0; i < res; i++)
            System.out.print(arr[i] + " ");

    }

    static int removeDuplicatesFromSortedArrayII(int n, int[] arr) {
        int t =0,i=0,res=0;
        while(i<n-1-res){
            t=0;
            int k = i+1;
            while(arr[i]==arr[k]){
                t++;
                k++;
                //System.out.println("t="+t+"k="+k+"i="+i);
                if(k==n-res){
                    break;
                }

            }
            if(k!=(i+1)){
                if(t>=2) {
                    res += t - 1;
                    //System.out.println("t=" + t + " k=" + k + " res=" + res + " i=" + i);
                    t =2;
                    int j = i + t;
                    while (k < n ) {
                        arr[j] = arr[k];
                        k++;
                        j++;
                    }
                    i=i+t;
                }
                else{
                    i = i+t +1;
                }
            }
            else{
                i++;
            }

//            for(int p=0;p<n;p++)
//                System.out.print(arr[p]+",");
//            System.out.println();
        }
        return arr.length-res;
    }

}
