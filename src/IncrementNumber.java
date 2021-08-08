import java.util.*;


class IncrementNumber{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];

        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(sc.next());
        }

        int incArr[] = incrementNumber(n, arr);

        for(int i=0;i<incArr.length;i++) {
            System.out.print(incArr[i]);
        }
    }

    static int[] incrementNumber(int n, int arr[]){
        int[] newArr = new int[n+1];
        int sum=0,carry=0;
        if(arr[n-1]==9){
            newArr[0] = 0;
            carry=1;
        }
        else{
            newArr[0] = arr[n-1] + 1;
        }
        for(int i=1;i<n;i++){
            if(arr[n-1-i]!=9){
                newArr[i] = arr[n-1-i] + carry;
                carry = 0;
            }
            else if(arr[n-1-i]==9 && carry==1){
                newArr[i] = 0;
                carry = 1;
            }
            else{
                newArr[i] = arr[n-1-i];
                carry = 0;
            }
        }

        if(carry==1){
            int[] newArr2 = new int[n+1];
            newArr[n] = 1;
            for(int i=0;i<n+1;i++){
                newArr2[i] = newArr[n-i];
            }
            return newArr2;
        }
        else{
            int[] newArr2 = new int[n];
            for(int i=0;i<n;i++){
                newArr2[i] = newArr[n-1-i];
            }
            return newArr2;
        }

    }
}
