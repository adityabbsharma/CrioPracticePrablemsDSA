import java.io.*;
import java.util.*;

public class RotateImage {
    public void rotateImage(int[][] matrix) {
        int mSize = matrix.length;
        int[][] rotatedMat = new int[mSize][mSize];
        int index2=0;
        for(int i=0;i<mSize;i++){
            int index = mSize-1;
            for(int j=0;j<mSize;j++){
                rotatedMat[i][j] = matrix[index--][index2];
            }
            index2++;
        }
        for(int i=0;i<mSize;i++){
            for(int j=0;j<mSize;j++){
                matrix[i][j] = rotatedMat[i][j];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int matrixSize = scanner.nextInt();
        int[][] matrix = new int[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; ++i) {
            for (int j = 0; j < matrixSize; ++j) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        scanner.close();

        new RotateImage().rotateImage(matrix);
        for (int i = 0; i < matrixSize; ++i) {
            for (int j = 0; j < matrixSize; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
