import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = 0;
        long sum = 0;

        long N = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            a += Integer.parseInt(st.nextToken());
            sum += Integer.parseInt(st.nextToken());
        }
        sum -= B*N;

        if (a == 0)
            System.out.println("EZPZ");
        else if (sum%a == 0)
            System.out.println(sum/a);
        else {
            if (a < 0){
                a *= -1;
                sum *= -1;
            }

            long tmp = Math.abs(gcd(a, sum));
            System.out.println(sum/tmp + "/" + a/tmp);
        }
    }

    public static long gcd(long a, long b){
        return a%b == 0 ? b : gcd(b, a%b);
    }
}