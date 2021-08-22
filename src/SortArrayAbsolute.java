/*
*Sort based on absolute values
* Problem Description
Given an array of integers, sort the array based on the absolute value of the elements.

Input format
First line contains an integer n - The number of elements.

Second line contains n space separated integers - The array nums.

Output format
For each test case print the minimum changes required on a separate line.

Sample Input 1
5

2 -5 1 -2 4

Sample Output 1
1 2 -2 4 -5

Explanation 1
Absolute values of elements are [2,5,1,2,4] respectively, so in the sorted order based on
* absolute values elements will be [1,2,-2,4,-5] or [1,-2,2,4,-5]. Both are accepted answers.

Constraints
1 <= n <= 10^5

-10^9 <= nums[i] <= 10^9
* */
import java.util.*;

class SortArrayAbsolute {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int res[] = sortArrayAbsolute(n, arr);

        for (int j : res)
            System.out.print(j + " ");
    }

    static int[] sortArrayAbsolute(int n, int arr[]) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            arrayList.add(arr[i]);
        }
        Collections.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1)==Math.abs(o2))
                    return 0;
                else if(Math.abs(o1)>Math.abs(o2))
                    return 1;
                else
                    return -1;
            }
        });
        for(int i=0;i<n;i++){
            arr[i] = arrayList.get(i);
        }
        return arr;
    }
}

