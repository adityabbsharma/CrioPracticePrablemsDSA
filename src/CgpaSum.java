/*
* Find the CGPA
* Problem Description
Given the credit points for 5 subjects and the grade points scored by the students in each subject, you need to find out how many pairs of students have their sum of CGPA as 10.


Students are represented with their roll numbers and the CGPA is taken as the floor value after calculating it from the formula given.


Formula for calculating CGPA = sum_of(grade points scored in ith subject * ith subject credit points) / sum_of(ith subject credit points).
Input format
First line contains an integer N - Number of students.


Second line contains 5 space separated integers - Each subject's credit points.
Next N lines, each containing 6 space separated integers - roll no of the student, grade points scored in 5 subjects by that student.

Output format
Print the count of student pairs whose CGPA sum is equal to 10.

Sample Input 1
3
2 3 3 4 4
1 9 8 6 5 7
2 5 3 6 7 8
3 7 6 2 3 5
3 <-- number of students

2 3 3 4 4 <-- subject's credit points

1 9 8 6 5 7 <-- 1st student's grade points

2 5 3 6 7 8 <-- 2nd student's grade points

3 7 6 2 3 5 <-- 3rd student's grade points

Sample Output 1
2

Explanation
CGPA of roll no. 1 is (92 + 83 + 63 + 54 + 7*4) / (2+3+3+4+4) = 108/16 = 6 (floor value).

CGPA of roll no. 2 is (52 + 33 + 63 + 74 + 8*4) / (2+3+3+4+4) = 97/16 = 6 (floor value).

CGPA of roll no. 3 is (72 + 63 + 23 + 34 + 5*4) / (2+3+3+4+4) = 70/16 = 4 (floor value).

There are 2 pairs of students whose sum of CGPA is equal to 10 i.e. (1 & 3) and (2 & 3).

Constraints
1 <= N <= 10^5

1 <= subject credit points <= 5

1 <= roll no <= N

0 <= grade points scored <= 10

Hints
You might need to make use of prefix sum to store the total points of the student while calculating the CGPA.

Notice the return type of the function that you’re given - and ensure you declare variables for holding the sum accordingly.
* */
import java.util.*;

class CgpaSum {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Integer> subjects = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            subjects.add(sc.nextInt());

        ArrayList<ArrayList<Integer>> students = new ArrayList<ArrayList<Integer>>(n);

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> data = new ArrayList<>();
            for (int j = 0; j < 6; j++) {
                int x = sc.nextInt();
                data.add(x);
            }
            students.add(data);
        }

        long result = cgpaSum(n, subjects, students);

        System.out.println(result);
    }

    static long cgpaSum(int n, ArrayList<Integer> subjects, ArrayList<ArrayList<Integer>> students) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
       // ArrayList<Integer> cgpaList = new ArrayList<>();
        int sumOfCreditPoints= 0;
        for(int i=0;i<subjects.size();i++){
            sumOfCreditPoints += subjects.get(i);
        }
        for(int i=0;i<n;i++){
            int rollNo = students.get(i).get(0);
            int sumOfGradePoints = students.get(i).get(1)*subjects.get(0)+students.get(i).get(2)*subjects.get(1)+
                    students.get(i).get(3)*subjects.get(2)+students.get(i).get(4)*subjects.get(3)+
                    students.get(i).get(5)*subjects.get(4);
            int cgpa = (sumOfGradePoints/sumOfCreditPoints);
            if(!hashMap.containsKey(cgpa))
                hashMap.put(cgpa,1);
            else{
                int freq = hashMap.get(cgpa);
                hashMap.put(cgpa,freq+1);
            }
            //cgpaList.add((sumOfGradePoints/sumOfCreditPoints));
            //System.out.println(cgpaList.get(i));
        }
        System.out.println(hashMap);
        long pairOfSum=0;
//        for(Integer key: hashMap.keySet()){
//            int cgpa = hashMap.get(key);
//            if(hashMap.containsValue(10-cgpa))
//                pairOfSum++;
//        }
//        if(pairOfSum%2 == 1)
//            return pairOfSum/2 + 1;
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                if(i!=j && (cgpaList.get(i)+cgpaList.get(j) == 10)){
//                    pairOfSum++;
//                    //break;
//                }
//            }
//        }
        for(Integer key:hashMap.keySet()){
            if(hashMap.containsKey(10-key)){
                //int freq = hashMap.get(10-key);
                pairOfSum += (hashMap.get(key) * hashMap.get(10-key));
            }
        }
        //if(pairOfSum%2 == 1)
          //  return pairOfSum/2 + 1;
        return pairOfSum/2;
    }
}
