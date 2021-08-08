import java.io.*;
import java.util.*;
import java.lang.Math;
public class  PermutationPalindrome {

    public static int isPermutationPalindrome(String s ) {
        int size = s.length();
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for(int i=0;i<size;i++){
            if(hashMap.containsKey(s.charAt(i))){
                int repeatVal = hashMap.get(s.charAt(i));
                hashMap.put(s.charAt(i),repeatVal+1);
            }
            else
                hashMap.put(s.charAt(i),1);
        }
        if(size % 2 == 1){
            int noOfOdds=0;
            for(char c: hashMap.keySet()){
                if(hashMap.get(c)%2 ==1)
                    noOfOdds++;
            }
            if(noOfOdds==1){
                return 1;
            }
            else
                return -1;
        }
        else{
            int noOfOdds=0;
            for(char c: hashMap.keySet()){
                if(hashMap.get(c)%2 ==1)
                    noOfOdds++;
            }
            if(noOfOdds==0){
                return 1;
            }
            else
                return -1;
        }
    }
    public static void  main (String args []) {

        Scanner sc =  new  Scanner (System.in);
        int t = 1;
        t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            t--;
            String s = new String();
            s = sc.next();

            int flag = isPermutationPalindrome(s);
            if (flag == 1) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        }
    }

}
