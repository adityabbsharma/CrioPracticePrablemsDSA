// input ---
/*
* Search in Sorted Rotated Array
* Problem Description
An array sorted in ascending order is rotated about a pivot unknown to you. Such an array is referred to as a rotated sorted array or a sorted-pivoted array. For example : [1,2,3,4,5] is a sorted array while [3,4,5,1,2] is a rotated sorted array.


You are given a rotated sorted array, and some integer values. You have to find each value’s location in the array. If the value is present, return the index in which it is stored ( 0 based indexing) , otherwise if not found return -1.


Assume the array doesn’t have duplicates.

Input format
There are Q+3 lines of input.

First line will have a single integer N denoting the size of the array.

Second line will contain N space separated integers.

Third line will contain a single integer Q denoting the number of targets to be searched..

Next Q lines will have a single integer,X in each line denoting the target value. You have to search for each of these target values in turn.

Output format
One line per output for each target search, with -1 or the index at which the integer is found.

Function Definition
Complete the function search in the code editor for a language of your choice.

search has the following parameters :

nums : An array of numbers having its values in a rotated sorted order

target : An integer representing the number to be searched in nums

search returns :

int : An integer denoting the index of the target to be searched. If target not present returns -1.

Constraints
1 <= N <= 10^6 where N denotes the size of the input array

1 <= A[i] <= 10^9 where A[i] denotes the ith element of the input array

1 <= Q <= 10^6 where Q denotes the number of targets to be searched

1 <= X <= 10^9 where X denotes the target element to be search

Sample Input 1
7

4 5 6 9 10 2 3

2

3

8

Sample Output 1
6

-1

Explanation 1
The element 3 is found in the array at index 6. Element 8 is not found in the array, thus -1.

Sample Input 2
6

5 6 8 1 3 4

1

0

Sample Output 2
-1

Explanation 2
The element 0 is not found in the array.
* */
import java.io.*;
import java.util.*;
class SearchInRotatedSortedArray {

    // Complete the function implementation below
    // first approach----------------------------------- some test cases not getting passed
//    public int search(int[] nums, int target) {
//        boolean flag = true;
//        int temp =search2(nums,0,nums.length-1,target,flag);
//        int temp2;
//        if(temp>=0){
//            if(nums[temp]==target){
//              return temp;
//            }
//            else{
//                temp2 = search2(nums,0,nums.length-1,target,false);
//                if(nums[temp2]==target)
//                    return temp2;
//                else
//                    return -1;
//            }
//        }
//
//        else
//            return -1;
//    }
//    public static int search2(int arr[], int left, int right, int key,boolean flag) {
//        // Write code here
//        int pivot = searchPivotPoint(arr,0,arr.length-1,flag);
//        //System.out.println("pivot="+pivot);
//        if(pivot==-1)
//            return binSearch(arr,0,arr.length-1,key);
//        if(pivot==key)
//            return pivot;
//        if(arr[0]<=key)
//            return binSearch(arr,0,pivot-1,key);
//        return binSearch(arr,pivot+1,arr.length-1,key);
//
//    }
//    public static int searchPivotPoint(int[] arr,int low,int high,boolean flag){
//        if(high<low)
//            return -1;
//        if(high==low)
//            return low;
//        int mid = low + ((high-low)/2);
//       // System.out.println("mid = "+mid+",low="+low+",high"+high+",arr[mid]="+arr[mid]+",arr[low]="+arr[low]
//                           // +",arr[high]="+arr[high]);
//        if(mid<high && arr[mid]>arr[mid+1])
//            return mid;
//        if(mid>low && arr[mid]<arr[mid-1])
//            return mid-1;
//        if(arr[low]>=arr[mid])
//            return flag==true?searchPivotPoint(arr,low,mid-1,true):searchPivotPoint(arr,low,mid-1,false);
//        return flag==true?searchPivotPoint(arr,mid+1,high,true):searchPivotPoint(arr,low,mid-1,false);
//    }
//    public static int binSearch(int[] arr,int left,int right,int key){
//        int mid = (left + right)/2;
//        //System.out.println("left="+left+",right"+right+",mid="+mid+",arr[mid]="+arr[mid]);
//        if(left>right)
//            return -1;
//        else if(arr[mid]==key)
//            return mid;
//        else if(key>arr[mid]){
//            return binSearch(arr,mid+1,right,key);
//        }
//
//        return binSearch(arr,left,mid-1,key);
//
//    }
    // second approach-----------------------------------
    static int search2(int arr[], int l, int h, int key)
    {
        if (l > h)
            return -1;

        int mid = (l + h) / 2;
        if (arr[mid] == key)
            return mid;
        if (arr[l] <= arr[mid]) {
            if (key >= arr[l] && key <= arr[mid])
                return search2(arr, l, mid - 1, key);
            return search2(arr, mid + 1, h, key);
        }

        if (key >= arr[mid] && key <= arr[h])
            return search2(arr, mid + 1, h, key);

        return search2(arr, l, mid - 1, key);
    }
    public int search(int[] nums, int target){
        return search2(nums,0,nums.length-1,target);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int nums[] = new int[n];
        for(int i = 0 ; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int q = scanner.nextInt();
        while(q > 0) {
            int target = scanner.nextInt();
            int result = new SearchInRotatedSortedArray().search(nums , target);
            System.out.println(result);
            q--;
        }
    }
}
