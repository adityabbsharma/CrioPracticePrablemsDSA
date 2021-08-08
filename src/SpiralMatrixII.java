
import java.util.*;

class SpiralMatrixII {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result[][] = spiralMatrixII(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] spiralMatrixII(int p) {
        int[][] sprArr = new int[p][p];
        int k=0,l=0,m=p,n=p;
        int temp =0,i=0;
        while(k<m && l<n){
            for( i=l;i<n;++i){
                sprArr[k][i] = ++temp;
            }
            k++;
            for( i=k; i<m;++i){
//                if(i==k)
//                    temp = sprArr[k-1][n-1];
                sprArr[i][n-1] = ++temp;
            }
            n--;
            if(k<m){
                for( i=n-1;i>=l;--i){
                    sprArr[m-1][i] = ++temp;
                    //System.out.println("sprArr[n-1][i]"+sprArr[n-1][i]+"n="+n+"i="+i);
                }
                m--;
            }
            if(l<n){
                for( i=m-1;i>=k;--i){
                    sprArr[i][l] = ++temp;
                }
                l++;
            }
            //System.out.println("n="+n+"k="+k+"l="+l);

        }
        return sprArr;
    }
}
