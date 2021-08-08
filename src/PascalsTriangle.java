import java.io.*;
import java.util.*;

public class PascalsTriangle {
    public List<List<Integer>> pascalsTriangle(int numRows) {
        List<List<Integer>> finalList = new ArrayList<>();
        int rows = 0;
            List<Integer> newList1 = new ArrayList<>();
            newList1.add(1);
            finalList.add(newList1);
            rows++;
            if(numRows==1)
                return finalList;

            List<Integer> newList2 = new ArrayList<>();
            newList2.add(1);

            //List<Integer> newList2 = new ArrayList<>();
            newList2.add(1);
            finalList.add(newList2);
            rows++;
            if(numRows==2)
                return finalList;

        for(int i=rows;i<numRows;i++)
        {
            List<Integer> newList = new ArrayList<>();
            for(int j=0;j<i;j++){
                if(j==0){
                    newList.add(1);
                }
                else{
                    //System.out.println(i);
                    newList.add(finalList.get(i-1).get(j-1) + finalList.get(i-1).get(j)) ;
                }
            }
            newList.add(1);
            finalList.add(newList);
        }
        return finalList;


//        if(numRows>0){
//            int powerOfEleven = 0;
//            while(powerOfEleven<numRows){
//                int powerOfElevenNo = (int)Math.pow((int)11,(int)powerOfEleven);
//                Stack<Integer> stack = new Stack<>();
//                int num = powerOfElevenNo;
//                List<Integer> newList = new ArrayList<>();
//                while(num!=0){
//                    stack.push(num%10);
//                    num = num / 10;
//                }
//                while(!stack.isEmpty()){
//                    newList.add(stack.pop());
//                }
//                finalList.add(newList);
//                powerOfEleven++;
//            }
//            return finalList;
//        }
//        else
//            return null;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int numRows = scanner.nextInt();
        scanner.close();

        List<List<Integer>> result = new PascalsTriangle().pascalsTriangle(numRows);
        for (List<Integer> row : result) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
