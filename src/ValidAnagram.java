import java.io.*;
import java.util.*;

public class ValidAnagram {
    public boolean validAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        else{
            char[] arrS = s.toLowerCase().toCharArray();
            char[] arrT = t.toLowerCase().toCharArray();
            int sum1=0,sum2=0;
            for(char c1:arrS){
                sum1 += (int)c1;
            }
            for(char c2:arrT){
                sum2 += (int)c2;
            }
            if(sum1==sum2){
                return true;
            }
            else
                return false;
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        String t = in.readLine();

        boolean result = new ValidAnagram().validAnagram(s, t);
        System.out.print(String.valueOf(result));
    }
}