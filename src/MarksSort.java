/*
* Sorting structures
* Problem Description
You are given a list of marks over 5 subjects scored by n students. You need to sort the student by following rules.

The student whose sum of marks will be highest must come at the top of the leaderboard.

Students whose total sum of marks are the same will be sorted alphabetically ascending by name.

In all other cases, student with lesser id will come before in the leaderboard

Input format
First line will contain a single integer n number of students.

Next n lines will contain space separated unique integer Id, string S name of the student followed by 5 integers marks scored out of 100.

Output format
Print space separated list of sorted ids of the student in a single line

Sample Input 1
3

1 Alan 45 56 21 32 74

2 Fabien 95 94 93 92 91

3 Gamora 85 65 54 65 76

Sample Output 1
2 3 1

Explanation 1
Fabien has the most marks obtained and then Gamora and followed by Alan

Constraints
1<=n<=50000

1<=|S|<=10

Name of the Student will be in alphabetically lowercase characters.

1<=Marks[i]<=100

1<=Student id<=10^7

Student id will be unique for each student
* */
import java.util.*;

class Student {
    int id;
    String name;
    int marks[] = new int[5];

    public Student(int id, String name, int marks[]) {
        this.id = id;
        this.name = name;

        for (int i = 0; i < 5; i++) {
            this.marks[i] = marks[i];
        }
    }
}

class MarksSort {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Student arr[] = new Student[n];

        for (int i = 0; i < n; i++) {

            int id = sc.nextInt();
            String name = sc.next();
            int marks[] = new int[5];

            for (int j = 0; j < 5; j++)
                marks[j] = sc.nextInt();
            arr[i] = new Student(id, name, marks);
        }

        int res[] = marksSort(n, arr);

        for (int j : res) {
            System.out.print(j + " ");
        }
    }

    static int[] marksSort(int n, Student arr[]) {
        ArrayList<Student> arrayList = new ArrayList<>();
        for(int i=0;i<n;i++){
            arrayList.add(arr[i]);
        }
        Collections.sort(arrayList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int sumOfMarkso1 = 0,sumOfMarkso2 =0;
                for(int i=0;i<o1.marks.length;i++){
                    sumOfMarkso1 += o1.marks[i];
                }
                for(int i=0;i<o2.marks.length;i++){
                    sumOfMarkso2 += o2.marks[i];
                }
                if(sumOfMarkso1>sumOfMarkso2)
                    return 1;
                else if(sumOfMarkso1<sumOfMarkso2)
                    return -1;
                else{
                    if(o1.name.compareTo(o2.name)>0)
                        return -1;
                    else if(o1.name.compareTo(o2.name)<0)
                        return 1;
                    else {
                        return o1.id>o2.id ? -1: 1;
                    }
                }
            }
        });
        int[] returnIntArr = new int[n];
        for(int i=0;i<n;i++){
            returnIntArr[i] = arrayList.get(n-1-i).id;
        }
        return returnIntArr;
    }
}
