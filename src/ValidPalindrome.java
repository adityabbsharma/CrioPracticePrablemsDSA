/*
* Confirm if a given string is a palindrome
* Problem Description
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note:

For the purpose of this problem, we define empty string as valid palindrome.

Input format
A single line that contains the string S.

Output format
Print "true"(without quotes) if it is valid Palindrome "false"(without quotes) otherwise.

Sample Input 1
A man, a plan, a canal: Panama

Sample Output 1
true

Explanation 1
The given string is palindrome when considering only alphanumeric characters.

Sample Input 2
race a car

Sample Output 2
false

Explanation 2
The given string is not a palindrome when considering alphanumeric characters.

Constraints
1 <= length(S) <= 1000
* */
import java.io.*;
import java.util.*;

public class ValidPalindrome {
    // Implement your solution by completing the below function
    public String isPalindrome(String s) {
        StringBuffer str = new StringBuffer();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
                str.append(c);
        }
        String s1 = str.toString();
        String s2 = s1.toLowerCase();
        Queue<Character> q = new LinkedList<Character>();
        int n = s2.length();
        for(int i=0;i<n/2;i++){
            q.add(s2.charAt(i));
        }
        int palindCheck =0;
        if(n%2==1){
            for(int j=n-1;j>n/2;j--){
                if(q.remove() != s2.charAt(j)){
                    palindCheck++;
                }
            }
            if(palindCheck>0){
                return "false";
            }
            else
                return "true";
        }
        else{
            for(int j=n-1;j>=n/2;j--){
                if(q.remove() != s2.charAt(j)){
                    palindCheck++;
                }
            }
            if(palindCheck>0){
                return "false";
            }
            else
                return "true";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = in.readLine();

        String result = new ValidPalindrome().isPalindrome(line);
        System.out.print(result);
    }
}