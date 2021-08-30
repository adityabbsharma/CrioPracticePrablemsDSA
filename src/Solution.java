/*
* First and last position of element in sorted array
* Problem Description
Given an array of integers of length n sorted in ascending order and Q number of queries, for each query you have to find the first and last position (0-based indexed) of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Input format
First line has an integer denoting the size of array (n)

Second line contains n space separated integers denoting the array(nums).

Third line contains an integer representing the value of Q.

In the next Q lines, each line will contain an integer K (target value).

Output format
Two integers representing the first and last position of the target value from the corresponding query given in the input.

Constraints
1 <= n <= 100000

-1000000000 <= nums[i] <= 1000000000

1 <= Q <= 50000

-1000000000 <= target <= 1000000000

Sample Input 1
5

1 2 2 3 4

3

1

2

5

Sample Output 1
0 0

1 2

-1 -1

Explanation 1
The first and last occurrence of 1 is at index 0, so returning 0 0. The first and last occurrence of 2 are at index 1 and 2. The target 5 is not found in the array, so returning -1 -1.
* */
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = scanner.nextInt();
        }
        int Q = scanner.nextInt();
//        System.out.println("i m here");
        for(int i=0;i<Q;i++){
            int query = scanner.nextInt();
//            System.out.println("i m here 3");
            int[] newArr = solution.findFirstAndLastPositionOfElementInSortedArray(nums,query);
            System.out.print(newArr[0]+" "+newArr[1]);
            System.out.println();
        }
    }

    public int[] findFirstAndLastPositionOfElementInSortedArray(int[] nums, int target) {
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
    public  int binarySearch(int[] nums,int target){
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
