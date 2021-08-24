/*
* Find the Kth smallest element in a matrix
* Problem Description
Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.


Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Input format
First line contains two integers. N, denoting the size of the square matrix and K where we have to find the Kth Smallest element.

Next N lines contain N integers each denoting the elements of the matrix.

Output format
Single containing one integer denoting the Kth smallest element.

Sample Input 1
3 8

1 5 9

10 11 13

12 13 15

Sample Output 1
13

Explanation 1
If written in non-decreasing order, elements are,

1 5 9 10 11 12 13 13 15

Hence, 8th smallest element is 13.

Constraints
1<=N<=1000

0<=Ai<=10^9

1<=K<=N^2
* */
import java.util.*;


class KthSmallestElementInMatrix{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<ArrayList<Integer>>Matrix = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer>row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(sc.nextInt());
            }
            Matrix.add(row);
        }
        int ans = kthSmallestElementInMatrix(Matrix,k);
        System.out.print(ans);
    }

    static int kthSmallestElementInMatrix(List<ArrayList<Integer>>Matrix, int k){
        int low=Matrix.get(0).get(0),high = Matrix.get(Matrix.size()-1).get(Matrix.size()-1);
        int ans=0;
        while(low<=high){
            int mid = low + (high-low)/2;
            int count = countAllElementsSmallerThan(Matrix,mid);
            if(count>=k){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }

    static int countAllElementsSmallerThan(List<ArrayList<Integer>>Matrix, int mid){
        int count=0;
        Iterator<Integer> itr;
        for(int i=0;i<Matrix.size();i++){
            itr = Matrix.get(i).iterator();
            while(itr.hasNext()){
                int temp = itr.next();
                if(temp<=mid){
                    count++;
                }
            }
        }
        return count;
    }

}

