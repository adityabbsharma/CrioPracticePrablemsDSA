/*
* Problem Description
You are given an Array A of size N. You have to pick total B elements from either left or right end of
* the array A to get the maximum sum.

Input format
First line will contain two space separated integers N and B respectively.

Second line will contain N space separated integers array A.

Output format
Print the answer in a single line.

Sample Input 1
5 4

4 -3 1 2 1

Sample Output 1
8

Explanation
4 + 1 + 2 + 1 = 8

We will have the maximum sum for one element from the first side and three elements from the back.

Constraints
1<=N<=1000000

-1000000<=Ai<=1000000

0<=B<=N
* */
import java.util.*;

class PickLargestSum{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int B = sc.nextInt();
        List<Integer> A = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            A.add(sc.nextInt());
        }
        long result = pickLargestSum(N, B, A);
        System.out.println(result);
        sc.close();
    }

    static long pickLargestSum(int N, int B, List<Integer>A){
        long[] prefixSum = new long[N];
        prefixSum[0] = A.get(0);
        for(int i=1;i<N;i++){
            prefixSum[i] = prefixSum[i-1] + A.get(i);
//            System.out.println("prefixSum[i]="+prefixSum[i]+"at i="+i);
        }
        long max= Long.MIN_VALUE;
        if(B!=0){
            if(max<prefixSum[B-1])
                max = prefixSum[B-1];
        }
        if(B==N){
            return prefixSum[N-1];
        }

        for(int i=1;i<=B;i++){
            long temp = prefixSum[i-1]+prefixSum[N-1] - prefixSum[N-1-(B-i)];
            if(max<temp){
                max = temp;
            }
        }
        long temp = prefixSum[N-1] - prefixSum[N-1-B];
        if(max<=temp)
            max = temp;
        return max;
    }
}
