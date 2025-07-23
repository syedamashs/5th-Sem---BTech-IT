import java.util.*;

public class mulinv {

    public static int mulinv(int ele,int mod){

        int a = mod,b = ele;
        int t1=0,t2=1;

        while(a>1){
            int q = a/b;
            int r = a%b;

            a = b;
            b =r;

            int t = t1 - q*t2;
            t1 = t2;
            t2=t;
        }

        if(a!=1) return 0;

        if(t1<0) t1+=mod;
        return t1;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Number:");
        int number = sc.nextInt();
        int ans = mulinv(number,26);

        if(ans==0) System.out.print("No multiplicative Inverse not exists!!");
        else System.out.print("Multiplicative Inverse: "+ans);
    }
}
