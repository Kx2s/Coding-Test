import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        long ans = 1;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N-2; i++) {
            int T = Integer.parseInt(st.nextToken());
            ans = ans * T / gcd(ans, T);
        }
        System.out.println(ans);
    }

    public static long gcd (long a, long b) {
        long h = Math.max(a, b);
        long l = Math.min(a, b);

        while (l != 0) {
            long tmp = h%l;
            h = l;
            l = tmp;
        }
        return h;
    }
}