/*
* Find largest subarray with sum 0
* Problem Description
Given an integer array, find the largest subarray with sum 0 .
* If there is more than one subarray with the largest length, return the subarray with the lowest
* starting index.

If there is no such sub-array print -1.

Input format
There are 2 lines of input.

First line contains an integer N.

Next line consists of N integers, the values of the array.

Output format
Print the elements of the sub-array with spaces which have the largest length and sum of elements equal to zero.

Sample Input 1
6

2 3 1 -4 0 6

Sample Output 1
3 1 -4 0

Explanation
The largest subarray with sum zero is (3, 1, -4, 0)

Constraints
1 <= N <= 10^5

-10^4 <= arr[i] <= 10^4
* */
import java.util.*;

class LargestSubarraySumZero {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        ArrayList<Integer> res = largestSubarraySumZero(n, arr);

        for (int j : res)
            System.out.print(j + " ");

    }

    static ArrayList<Integer> largestSubarraySumZero(int n, int arr[]) {
        //--------------- Largest subarray with sum 0 -First Approach
        // ----------modified except 2 performance test cases rest tests passing
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        HashMap<Integer,Integer> hMap = new HashMap<>();
//        int[] prefixSum = new int[n];
//        int allElementsZeroCheck=0;
//        for(int i=0;i<n;i++){
//            if(arr[i]==0){
//                hMap.put(i,1);
//            }
//            if(i==0)
//                prefixSum[i] = arr[i];
//            else{
//                prefixSum[i] = prefixSum[i-1] + arr[i];
//                //System.out.println("prefixSum[i]="+prefixSum[i]+" at i="+i);
//            }
//            if(prefixSum[i]==0){
//                if(hMap.containsKey(0) && hMap.get(0)<(i+1)){
//                    hMap.put(0,i+1);
//                }
//                else if(!hMap.containsKey(0)){
//                    hMap.put(0,i+1);
//                }
//
//            }
//            if(arr[i]!=0)
//                allElementsZeroCheck =1;
//        }
//        if(hMap.containsKey(0)){
//            if(hMap.get(0)==n){
//                for(int i=0;i<n;i++){
//                    arrayList.add(arr[i]);
//                }
//                return arrayList;
//            }
//        }
//
//
//        if(allElementsZeroCheck==1){
//            for(int i=1;i<n;i++){
//                for(int j=0;j<n-1-i;j++){
//                    int sum = prefixSum[n-1-j] - prefixSum[i-1] ;
//                    //System.out.println("sum="+sum);
//                    if(sum==0){
//                        if(hMap.containsKey(i) && hMap.get(i)>(n-i-j)){
//                            continue;
//                        }
//                        hMap.put(i,n-i-j);
//                    }
//                }
//            }
//            //System.out.println(hMap);
//            int maxLength=0;
//            for(Integer key: hMap.keySet()){
//                if(maxLength<hMap.get(key))
//                    maxLength = hMap.get(key);
//            }
//            int minIndex=-1;
//            for(Integer key: hMap.keySet()){
//                if(hMap.get(key)==maxLength){
//                    if(minIndex<key){
//                        minIndex = key;
//                    }
//                }
//            }
//            for(int i=minIndex;i<minIndex+maxLength;i++){
//                arrayList.add(arr[i]);
//            }
//            if(arrayList.size()==0){
//                arrayList.add(-1);
//                return arrayList;
//            }
//            return arrayList;
//        }
//        else{
//            for(int i=0;i<n;i++){
//                arrayList.add(arr[i]);
//            }
//            return arrayList;
//        }
       // ------- second approach
        ArrayList<Integer> arrayList = new ArrayList<>();
        int[] prefixSum = new int[n];
        int allElementsZeroCheck=0;
        for(int i=0;i<n;i++){
            if(i==0)
                prefixSum[i] = arr[i];
            else{
                prefixSum[i] = prefixSum[i-1] + arr[i];
            }
            //System.out.println(prefixSum[i]);
            if(arr[i]!=0)
                allElementsZeroCheck =1;
        }
        if(allElementsZeroCheck==0){
            for(int i=0;i<n;i++){
                arrayList.add(arr[i]);
            }
            return arrayList;
        }

        HashSet<Integer> prefixSumSet = new HashSet<>();
        HashMap<Integer,Integer> mapOfIndexToLength = new HashMap<>();
        int minIndex=Integer.MAX_VALUE,maxLength=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(!mapOfIndexToLength.containsKey(prefixSum[i])){
                mapOfIndexToLength.put(prefixSum[i],i);
            }
            else{
                int startIndex = mapOfIndexToLength.get(prefixSum[i]);
                int lengthOfSubArray = i - startIndex;
                if(lengthOfSubArray>maxLength){
                    maxLength = lengthOfSubArray;
                    minIndex = startIndex+1;
                }
            }
        }
        if(minIndex==Integer.MAX_VALUE){
            for(int i=0;i<n;i++){
                if(arr[i]==0){
                    arrayList.add(arr[i]);
                    return arrayList;
                }
            }
            arrayList.add(-1);
            return arrayList;
        }

        for(int i=minIndex;i<minIndex+maxLength;i++){
            arrayList.add(arr[i]);
        }
        return arrayList;

    }
}
