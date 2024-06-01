import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] a, b;
        //거꾸로 뒤집고     123 -> 321
        a = new StringBuffer(sc.next()).reverse().toString().toCharArray();
        b = new StringBuffer(sc.next()).reverse().toString().toCharArray();

        int count = 0;
        int up = 0;
        char [] result = new char[(a.length > b.length ? a.length : b.length) + 2];

        while (a.length > count || b.length > count) {
            int ta = 0, tb = 0;
            if (a.length > count)
                ta = a[count] - '0';
            if (b.length > count)
                tb = b[count] - '0';
            int t = ta + tb + up;
            
            result[count++] = (char)(48 + t%10);
            
            up = t>=10 ? 1 : 0;
        }
        if (up != 0) {
            result[count] = (char)(48 + up);
        }
        System.out.println(new StringBuffer(new String(result)).reverse().toString().trim());
    }
}
