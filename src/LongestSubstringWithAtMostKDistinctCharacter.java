/*
*Problem Description
Given a string, find the length of the longest substring that contains at most K distinct characters.

Note:

Uppercase and Lowercase characters should be considered as different characters.

There can be numbers and special characters as well.

Input format
There are 2 lines of input.

First-line contains two space-separated integers representing the value of N and K.

The next line contains the string S of length N.

Output format
The length of the longest substring T that contains at most K distinct characters.

Constraints
1 <= N <= 10^5

0 <= K <= 256

Sample Input 1
5 3

abacd

Sample Output 1
4

Explanation 1
The longest substring that has 3 distinct characters, "abac", is of length 4.

Sample Input 2
6 3

Xyyzya

Sample Output 2
5

Explanation
There are 2 substrings, "Xyyzy" and “yyzya” which are the longest ones having 3 distinct characters and
* their length is 5.
* input
6 3
abbcba
* output is 6
*  */
import java.util.*;

// Implement your solution here
class LongestSubstringWithAtMostKDistinctCharacter {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k==1)
            return 1;
        HashMap<Character,Integer> hMap = new HashMap<>();
        char[] charArr = s.toCharArray();
        int n= charArr.length;
        int i=0,j,ans=0;
        for(j=0;j<n;j++){
//            char charAti = charArr[i];
//            int freq=0;
//            while(i<j && hMap.size()>=k && !hMap.containsKey(charArr[j]) && hMap.containsKey(charAti)){
//                ans = Math.max(ans,j-i);
//                freq = hMap.get(charAti);
//                hMap.put(charAti,--freq);
//                System.out.println("freq="+freq);
//                for(Character c:hMap.keySet())
//                    System.out.println("c= "+c+" value = "+hMap.get(c));
//                i++;
//                if(freq==0)
//                    hMap.remove(charAti);
//            }
//            if(hMap.containsKey(charArr[j])){
//                freq = hMap.get(charArr[j]);
//                hMap.put(charArr[j],freq+1);
//            }
//            else{
//                hMap.put(charArr[j],1);
//            }
//            j++;
//            ans = Math.max(ans,j-i);
//        }
//        ans = Math.max(ans,j-i);
//        return ans;
            int freq=0;
            while(hMap.size()>k ){
                char charAti = charArr[i];
                freq = hMap.get(charAti);
                hMap.put(charAti,--freq);
                if(freq==0)
                    hMap.remove(charAti);
                i++;
            }
            if(hMap.containsKey(charArr[j])){
                freq = hMap.get(charArr[j]);
                hMap.put(charArr[j],freq+1);
            }
            else{
                hMap.put(charArr[j],1);
            }

            ans = Math.max(ans,j-i+1);
        }
        //ans = Math.max(ans,j-i);
        return ans;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        scanner.close();

        int result = new LongestSubstringWithAtMostKDistinctCharacter().lengthOfLongestSubstringKDistinct(s,k);
        System.out.println(result);
    }
}

/*
* import java.util.*;

// Implement your solution here
class LongestSubstringWithAtMostKDistinctCharacter {

      public int lengthOfLongestSubstringKDistinct(String s, int k) {

        // substring char frequency hashmap
        Map<Character, Integer> distinct_chars_map = new HashMap<>();
        // sliding window left and right pointers
        int window_start_ptr = 0, window_end_ptr = 0, max_window_len = 0;

        for (window_end_ptr = 0; window_end_ptr < s.length(); window_end_ptr++) {
            char last_char = s.charAt(window_end_ptr);
            // expand window to the right
            // increment count of last character in our window
            distinct_chars_map.put(last_char, distinct_chars_map.getOrDefault(last_char, 0) + 1);

            // if number of unique characters in current window
            // exceeds k we need to shrink the window
            while (distinct_chars_map.size() > k){
                char first_char = s.charAt(window_start_ptr);
                distinct_chars_map.put(first_char, distinct_chars_map.get(first_char) - 1);
                // remove a character from the current window only if all instances
                // of the character are no longer in our window
                if(distinct_chars_map.get(first_char) == 0){
                    distinct_chars_map.remove(first_char);
                }
                window_start_ptr++;
            }

            // window_end_ptr - window_start_ptr + 1 = length of the current substring
            max_window_len = Math.max(max_window_len , window_end_ptr - window_start_ptr + 1);
        }
        return max_window_len;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        scanner.close();

        int result = new LongestSubstringWithAtMostKDistinctCharacter().lengthOfLongestSubstringKDistinct(s,k);
        System.out.println(result);
    }
}

*
* */