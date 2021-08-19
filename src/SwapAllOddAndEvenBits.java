/*
*Swap all the Odd and Even bits of an integer
* Problem Description
Given an unsigned integer N, swap all odd bits with even bits. Every even position bit is swapped with the adjacent bit on the right side and every odd position bit is swapped with adjacent on the left side. Assume a 32 bit integer.

Input format
N which represents an unsigned integer.

Output format
Single output integer after the algorithm has successfully swapped bits of the input.

Constraints
0 <= N <= 2147483647

Sample Input 1
22

Sample Output 1
41

Explanation 1
The given number is 22 (00010110), it should be converted to 41 (00101001).

Sample Input 2
13

Sample Output 2
14

Explanation 2
The given number is 13 (00001101), it should be converted to 14 (00001110).
* */
import java.io.*;
import java.util.*;

class SwapAllOddAndEvenBits {

    // Complete the function below
    public long swapBits(long n) {
        long odd = 0x55555555;
        long even = 0xAAAAAAAA;
        long odds = n & odd;
        long evens = n & even;
        odds<<=1;
        evens>>=1;
        n = odds | evens;
        return n;
//        String string = Long.toBinaryString(n);
//        System.out.println(string);
//        return n;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        scanner.close();
        long result = new SwapAllOddAndEvenBits().swapBits(n);
        System.out.println(result);
    }
}
