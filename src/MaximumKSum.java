/*
* Maximum K Sum
* Problem Description
Given an array(need not be sorted), find the maximum possible sum using any k elements of the array.
Input format
There are Q+2 lines of input.

First line will contain two space separated integers - N the size of the array, and Q, the number of queries

Second line will contain N space separated integers representing array A.

Following Q lines will contain a single integer K for each query..

Output format
Print the maximum sum obtained for each query in single line

Sample Input 1
4 2

4 2 4 1

2

3

Sample Output 1
8

10

Explanation 1
For first query 4 + 4 = 8

Similarly for second query top 3 elements will be 4,4 and 2 which sums to 10

Constraints
1<=N<=10^5

1<=Q<=N

1<=A[i]<=10^9 for all i
* */
import java.util.*;

class MaximumKSum {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int queries[] = new int[q];

        for (int i = 0; i < q; i++) {
            queries[i] = sc.nextInt();

        }

        ArrayList<Long> res = maximumKSum(n, q, arr, queries);

        for (long j : res) {
            System.out.println(j);
        }

    }

    static ArrayList<Long> maximumKSum(int n, int q, int arr[], int queries[]) {
        Arrays.sort(arr);
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            stack.push(arr[i]);
        }
        int i=0;
        while(!stack.isEmpty()){
            arr[i] = stack.pop();
            i++;
        }
        ArrayList<Long> arrayList = new ArrayList<>();
        for(i=0;i<q;i++){
            long sum=0;
            for(int j=0;j<queries[i];j++){
                sum += arr[j];
            }
            arrayList.add(sum);
        }
        return arrayList;
    }
}

