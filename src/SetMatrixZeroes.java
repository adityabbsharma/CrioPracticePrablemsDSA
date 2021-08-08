import java.io.*;
import java.util.*;

class SetMatrixZeroes {
    public void setMatrixZeroes(int[][] matrix) {
        int mSizeCol = matrix[0].length;
        int mSizeRow = matrix.length;
        int[][] zeroedMat = new int[mSizeRow][mSizeCol];
        ArrayList<Integer> zeroRows = new ArrayList<>();
        ArrayList<Integer> zeroCols = new ArrayList<>();
        for(int i=0;i<mSizeRow;i++){
            for(int j=0;j<mSizeCol;j++){
                if(matrix[i][j]==0){
                    zeroRows.add(i);
                    zeroCols.add(j);
                }
            }
        }
        for(Integer i:zeroRows){
            for(int j=0;j<mSizeCol;j++){
                matrix[i][j] =0;
            }
        }
        for(Integer c:zeroCols){
            for(int r=0;r<mSizeRow;r++){
                matrix[r][c] =0;
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int[][] matrix = new int[n][m];

        for(int i = 0 ; i < n ; ++i) {
            for(int j = 0 ; j < m ; ++j) {
                matrix[i][j] = in.nextInt();
            }
        }

        in.close();
        new SetMatrixZeroes().setMatrixZeroes(matrix);

        for(int i = 0 ; i < n ; ++i) {
            for(int j = 0 ; j < m ; ++j) {
                System.out.print(matrix[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }
    }
}