//https://www.notion.so/dcc890433be844008c2999401cfd2f57
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int max = 100000000;
        long[] fac = new long[13];
        fac[1] = 1;
        for (int i = 2; i < 13; i++)
            fac[i] = fac[i - 1] * i;

        int C = Integer.parseInt(br.readLine());

        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());

            String S = st.nextToken();
            int N = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            double limit = (double) (L * max) /T;

            switch(S) {
                case "O(N^3)":
                    limit /= N;
                case "O(N^2)":
                    limit /= N;
                    break;
                case "O(2^N)":
                    int cnt = 0;
                    int num = 1;
                    while (num < limit) {
                        num *= 2;
                        cnt++;
                    }
                    limit = --cnt;
                    break;
                case "O(N!)":
                    int idx = fac.length;
                    while (fac[--idx] >= limit) {
                    }
                    limit = idx;
                    break;
            }
            sb.append(N<=limit? "May Pass.":"TLE!").append("\n");
        }
        System.out.println(sb);
    }
}