/*
* Sort array with string elements
* Problem Description
Given an array, where integers are written as strings, sort the array and return it, with the
* elements still being strings.

Note that the number of digits in each element may go up to 10^6.

Input format
There are 2 lines of input.

First line will contain a single integer n, the size of array.

Second line will contain n space separated integers.

Output format
Return n space separated integers in a single line

Sample Input 1
5

3 30 1 124 54644

Sample Output 1
1 3 30 124 54644

Constraints
1<=n<=2 x 10^5

1<=Number of digits in each string<=10^6

1<=Total Count of digits of all strings<=10^6

There’ll be no leading zeros in any of the strings
* */
import java.util.*;

class NumSort {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String arr[] = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        String sortedArray[] = numSort(n, arr);

        for (String num : sortedArray) {
            System.out.print(num + " ");
        }

    }

    static String[] numSort(int n, String[] arr) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(arr));
        Collections.sort(arrayList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()==o2.length()){
                    if(o1.compareTo(o2)==0)
                        return 0;
                    else if(o1.compareTo(o2)>0)
                        return 1;
                    else
                        return -1;
                }
                else if(o1.length()>o2.length())
                    return 1;
                else
                    return -1;
            }
        });
        String[] resultArr = new String[n];
        for(int i=0;i<n;i++){
            resultArr[i] = arrayList.get(i);
        }
        return resultArr;
    }
}
