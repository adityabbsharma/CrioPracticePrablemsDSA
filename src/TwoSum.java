import java.io.*;
import java.util.*;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
//        int[] twoS = new int[2];
//        for(int i=0;i< nums.length-1;i++){
//            for (int j=i+1;j< nums.length;j++){
//                if(nums[i]+nums[j] == target){
//                    twoS[0] = i;
//                    twoS[1] = j;
//                    break;
//                }
//
//            }
//        }
//        return twoS;
        int[] twoS = new int[2];
        HashMap<Integer,Integer> hMap = new HashMap<>();
        HashMap<Integer,Integer> hMap2 = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hMap.containsKey(nums[i]))
                hMap2.put(nums[i],i);
            if(!hMap.containsKey(nums[i]))
                hMap.put(nums[i],i);
        }
        int lPointer=0,rPointer= nums.length-1;
        int resFirstIndex=0,resSecondIndex=0;
        Arrays.sort(nums);
        while(lPointer<rPointer){
            if((nums[lPointer]+nums[rPointer])>target)
                rPointer--;
            if((nums[lPointer]+nums[rPointer])<target)
                lPointer++;
            if((nums[lPointer]+nums[rPointer])==target){
                if(nums[lPointer]==nums[rPointer]){
                    resFirstIndex = hMap.get(nums[lPointer]);
                    resSecondIndex = hMap2.get(nums[rPointer]);
                    break;
                }
                else{
                    resFirstIndex = hMap.get(nums[lPointer]);
                    resSecondIndex = hMap.get(nums[rPointer]);
                    break;
                }
            }
        }
        if(resFirstIndex<resSecondIndex){
            twoS[0] = resFirstIndex;
            twoS[1] = resSecondIndex;
        }
        else{
            twoS[0] = resSecondIndex;
            twoS[1] = resFirstIndex;
        }
        return twoS;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[scanner.nextInt()];
        for (int i = 0; i < numbers.length; i++)
            numbers[i] = scanner.nextInt();
        int target = scanner.nextInt();
        scanner.close();

        int[] complements = new TwoSum().twoSum(numbers, target);
        System.out.print(complements[0] + " " + complements[1]);
    }
}