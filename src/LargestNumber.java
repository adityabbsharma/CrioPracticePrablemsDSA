/*
* Rearrange to form largest number
* Problem Description
Given an array of non negative integers, arrange the elements, such that if made into a number, they form the largest number.


For instance,

Given the array [1, 3, 10] , this should be arranged to [3, 1, 10] - since the largest possible number formed by these numbers is 3110.

Input format
There are 2 lines of input

First-line contains n, the size of the array.

Next line contains n space-separated integers.

Output format
Print the largest number formed by arranging these numbers in the list.

Sample Input 1
2

10 2

Sample Output 1
210

Sample Input 2
5

3 30 34 5 9

Sample Output 2
9534330

Constraints
0<= n <=50000

0<= a[i] <= 10^4
* */
import java.util.*;
import java.util.Scanner;

class LargestNumber {
    public String largestNumber(int[] nums) {
        ArrayList<String> numArrayList = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            String string = Integer.toString(nums[i]);
            numArrayList.add(string);
        }
        Collections.sort(numArrayList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // first append Y at the end of X
                String XY = o1 + o2;

                // then append X at the end of Y
                String YX = o2 + o1;

                // Now see which of the two
                // formed numbers
                // is greater
                return XY.compareTo(YX) > 0 ? -1 : 1;
            }
        });
        Iterator it = numArrayList.iterator();
        String newString="";
        while (it.hasNext())
            newString += it.next();
        return newString;
    }

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int nums[] = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        String result = new LargestNumber().largestNumber(nums);

        System.out.println(result);
    }

}

