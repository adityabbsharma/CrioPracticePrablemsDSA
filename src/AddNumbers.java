import java.util.*;


class AddNumbers{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            A.add(sc.nextInt());
        }
        for (int i = 0; i < m; i++) {
            B.add(sc.nextInt());
        }
        List<Integer> result = addNumbers(n, m, A, B);
        for (Integer x : result) {
            System.out.print(x);
        }
    }

    static List<Integer> addNumbers(int n, int m, List<Integer> A, List<Integer> B){
//        int sumA = 0,tensA=A.size()-1;
//        for(Integer i:A){
//            sumA +=(int)Math.pow((int)10,(int)tensA) * i;
//            tensA--;
//        }
//        int sumB = 0,tensB=B.size()-1;
//        for(Integer j:B){
//            sumB +=(int)Math.pow((int)10,(int)tensB) * j;
//            tensB--;
//        }
//        int sum = sumA +sumB;
//        Stack<Integer> stack = new Stack<>();
//        int num = sum;
//        List<Integer> newList = new ArrayList<>();
//        if(num==0){
//            newList.add(0);
//            return newList;
//        }
//        while(num!=0){
//            stack.push(num%10);
//            num = num / 10;
//        }
//        while(!stack.isEmpty()){
//            newList.add(stack.pop());
//        }
//        return newList;
        int[] a = new int[n];
        int[] b = new int[m];
        int p=n-1,q=m-1;
        for(Integer i: A){
            System.out.println("i="+i);
            a[p] = i;
            p--;
        }
        for(Integer j: B){
            b[q] = j;
            q--;
        }
        int[] aDash;
        int[] bDash;
        if(n>m){
            aDash = a;
            bDash = b;
        }
        else{
            aDash = b;
            bDash = a;
        }
        System.out.println("aDash[0]="+aDash[0]+"aDash[1]="+aDash[1]);
        int[] sum = new int[aDash.length+1];
        int carry =0;
        for(int i=0;i < bDash.length;i++){
            int temp = aDash[i] +bDash[i] + carry;
            if(temp>9){
                sum[i] = temp-10;
                carry =1;
            }
            else{
                sum[i] = temp;
                carry = 0;
            }
        }
        for(int i=bDash.length;i<aDash.length;i++){
            int temp = aDash[i] + carry;
            if(temp>9){
                sum[i] = temp-10;
                carry =1;
            }
            else{
                sum[i] = temp;
                carry = 0;
            }
        }
        List<Integer> list = new ArrayList<>();
        if(carry==1){
            list.add(1);
            for(int i=aDash.length-1;i>=0;i--){
                list.add(sum[i]);
            }
        }
        else{
            for(int i=aDash.length-1;i>=0;i--){
                list.add(sum[i]);
            }
        }
        return list;

    }
}
