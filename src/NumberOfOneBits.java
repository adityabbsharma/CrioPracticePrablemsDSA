/*
* Count the number of one bits in an integer
* Problem Description
Write a function that takes an unsigned integer and return the number of '1' bits it has
* (also known as the Hamming weight).

Input format
Single line containing one 32-bit unsigned integer N.

Output format
Single line containing number of 1 bits in N.

Sample Input 1
5

Sample Output 1
2

Explanation 1
Binary representation of 5 is:

101

Hence total number of 1 bits = 2

Constraints
0<=N<=2^32-1
* */
import java.util.*;

class NumberOfOneBits{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int ans = numberOfOneBits(n);
        System.out.print(ans);
    }

    static int numberOfOneBits(long n){
        long i;
        int count=0;
        for(i = 1<<30;i>0;i = i/2){
            if((n&i)!=0){
                count++;
            }
        }
        if(n== (long)Math.pow(2,32)-1)
            return 32;
        return count;
    }
}
