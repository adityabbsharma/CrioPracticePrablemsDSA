/*
* Problem Description
* Container with most water
You are given an array of N non-negative integers where each represents the height of a line. N vertical lines are drawn at points marked 1 to n on the x axis as shown in the diagram. Find two lines, which together with the x axis forms a container, such that the container holds the most water. Assume the width of lines to be negligible.

Note: You may not slant the container and n is at least 2.
* Input format
The first line consists of an integer, N, denoting the size of the array.

The second line consists of N space separated integers which denote the elements of the array,

Output format
Single integer denoting the capacity of the largest container.

Constraints
2 <= N <= 10^6

Sample Input 1
9

1 8 6 2 5 4 8 3 7

Sample Output 1
49

Explanation 1
The lines of length 8 and 7 form a container that can hold 7*7=49 units of water.
* Here, the first 7 is the minimum of the two line heights and the second 7 is the number of units
* they are apart. This is the largest container that can be formed with the given input.
* */
import java.io.*;
import java.util.*;

class ContainerWithMostWater {

    // Complete the function implementation below
    public int maxArea(int[] height) {
        int answer = 0;
        // O(n^2) approach
//        for(int i=0;i<height.length-1;i++){
//            for(int j=i+1;j<height.length;j++){
//                if(height[i]<height[j]){
//                    int cSize = height[i]*(j-i);
//                    answer = Math.max(answer,cSize);
//                }
//                else{
//                    int cSize = height[j]*(j-i);
//                    answer = Math.max(answer,cSize);
//                }
//            }
//        }
        //--------------- o(n) approach
        int lPointer=0,rPointer =height.length-1;
        while(lPointer<rPointer){
            answer = Math.max(answer,Math.min(height[lPointer],height[rPointer]) * (rPointer-lPointer));
            if(height[lPointer]>height[rPointer]){
                rPointer -= 1;
            }
            else{
                lPointer += 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int height[] = new int[n];
        for(int i = 0 ; i < n ; i++) {
            height[i] = scanner.nextInt();
        }
        scanner.close();
        int result = new ContainerWithMostWater().maxArea(height);
        System.out.println(result);
    }
}