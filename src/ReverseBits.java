/*
* Reverse the bits of a given integer
* Problem Description
Reverse the bits of a given 32 bits unsigned integer.

Input format
First line contains the number of test cases.

Each line contains a 32 bit unsigned integer.

Output format
Output the Reversed unsigned integer.

Sample Input 1
1

43261596

Sample Output 1
964176192

Explanation 1
The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 whose binary representation is 00111001011110000010100101000000.


Constraints
1 <= T <= 10^5

0 <= N <= 2^32-1
* */
import java.util.*;


class ReverseBits{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();

        while(t-->0){
            long n = sc.nextLong();
            long ans = reverseBits(n);
            System.out.println(ans);
        }
    }

    static long reverseBits(long n){
        long newN=0;
        // 00000010100101000001111010011100
        //
        int i=0;
        while(i<32){
            System.out.println("original no is= ");
            bin(n);
            newN<<=1;
            System.out.println();
            System.out.println("reversed before xor =");
            bin(newN);
            if((int)(n&1) == 1){
                newN ^= 1;
            }
            n>>=1;
            System.out.println();
            System.out.println("reversed after xor =");
            bin(newN);
            System.out.println();
            i++;
        }
        return newN;
    }
    static void bin(long n)
    {
        long i;
        System.out.print("0");
        for (i = 1 << 30; i > 0; i = i / 2)
        {
            if((n & i) != 0)
            {
                System.out.print("1");
            }
            else
            {
                System.out.print("0");
            }
        }
    }
}
