/*
* Implement Count sort on given string
* Problem Description
A string S is given consisting of lowercase alphabetical characters only.
* You need to return a sorted string using Count Sort.

Input format
First line will contain a single integer n representing size of the given string.

Second line will contain a single string S of size n.

Output format
Output the string in a single line.

Sample Input 1
10

abcdeedcba

Sample Output 1
aabbccddee

Constraints
1<=n<=10^6

String S will contain lowercase alphabetical characters only
* */
import java.util.*;

class CountSort {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s = sc.next();

        String res = countSort(n, s);

        System.out.println(res);

    }

    static String countSort(int n, String s) {
        char[] result = new char[s.length()];
        char[] inputCharArr = s.toCharArray();
        int[] count = new int[26];
        for(int i=0;i<n;i++){
            ++count[inputCharArr[i]-97];
        }
        for(int i=1;i<=25;i++){
            count[i] += count[i-1];
        }
        for(int i=n-1;i>=0;i--){
            result[--count[inputCharArr[i]-97]] = inputCharArr[i];
        }
        StringBuffer resultStringBuffer = new StringBuffer();
        for(int i=0;i<n;i++){
            resultStringBuffer.append(result[i]);
        }
        return resultStringBuffer.toString();
    }
}
