/*
* Count occurrences of an integer
* Problem Description
Given a sorted integer array of length n with possible duplicate elements. Find the number of occurrences of an integer k using binary search.

Input format
There are 2 lines of input.

First line contains 2 space separated integers n, k - Number of elements, the integer k.

Second line contains n space separated integers - The integer array.

Output format
Print the number of occurrences of the integer k.

Sample Input 1
5 2

-1 2 2 4 7

Sample Output 1
2

Explanation 1
The integer 2 occurs 2 times in the given array.

Constraints
1 <= n <= 10^6

-10^9 <= k <= 10^9

-10^9 <= A[i] <= 10^9

Resource
Count number of occurrences (or frequency) in a sorted array

Video : Count occurrences of a number in a sorted array with duplicates using Binary Search
* */
import java.util.*;

class CountOccurrences {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int a[] = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        int res = countOccurrences(n, k, a);

        System.out.println(res);
    }

    static int countOccurrences(int n, int k, int a[]) {
        if(n==1 && a[0]==k){
            return 1;
        }
        else if(n==1 && a[0]!=k)
            return 0;
        else{
            int[] rangeArr = findFirstAndLastPositionOfElementInSortedArray(a,k);
            if(rangeArr[0]!=-1){
                return Math.abs(rangeArr[1]-rangeArr[0])+1;
            }
            else
                return 0;
        }

    }
    public static int[] findFirstAndLastPositionOfElementInSortedArray(int[] nums, int target) {
        int[] answer = new int[2];
        if(nums[0]==nums[nums.length-1] && nums[0]==target){
            answer[0] = 0;
            answer[1] = nums.length-1;
            return answer;
        }
        if(nums[0]==nums[nums.length-1] && nums[0]!=target){
            answer[0] = -1;
            answer[1] = -1;
            return answer;
        }

        int midValue = binarySearch(nums,target);
//        System.out.println("i m here 2");
        if(midValue==-1){
            answer[0] = -1;
            answer[1] = -1;
        }
        else{
            int left = midValue;
            while(nums[left]==target){
                answer[0] = left;
                left--;
                if(left<0)
                    break;
            }
            int right = midValue;
            while(nums[right]==target){
                answer[1] = right;
                right++;
                if(right==nums.length)
                    break;
            }
        }
        return answer;
    }
    public static int binarySearch(int[] nums,int target){
        int left = 0,right = nums.length-1;
        int mid = left + (right-left)/2;
//        System.out.println("i m here 4");

        while(left<=right){
            mid = left + (right-left)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid]>target){
                right = mid-1;
            }
            else{
                left = mid +1;
            }
        }
        return -1;
    }

}

